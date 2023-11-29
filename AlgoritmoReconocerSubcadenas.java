import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
//Esta colección de algoritmos se dedican a reconocer subcadenas en una cadena dada
//Cada uno retorna el indice inicial, final y alguna característica adicional (solo importante para contraseñas comunes y fechas)
//En caso no se reconozca la subcadena en algún tipo, retorna -1 como índices
//Las de fuerza bruta no entran aquí porque simplemente no son reconocibles. Cuando una subcadena retorne -1 para cada tipo método, significa que
//es una fuerza bruta.

class AlgoritmoReconocerSubcadenas extends Utils{ 
    static int[] subContComun(String subComun){
        /*
        *Esta función solo reconoce si alguna subcadena se encuentra en la lista de 10000 contraseñas comunes
        *Sin embargo, para hacerlo más interesante, también reconoce si la subcadena tiene combinaciones l33t o mayusculas y minusculas
        *Es decir, si en la lista solo está "qwerty" y la contraseña es "qw3rTy", el algoritmo lo reconoce con la ayuda del método l33tMayusToMins
        *La función retorna los índices en donde inicia y termina la subcadena y el número de alteraciones l33t y mayus-minus
        *Para contar las alteraciones, está el método countDiff
        */
        int[] A ={-1,-1,-1};
        try (BufferedReader reader = new BufferedReader(new FileReader("10000passwords.csv"))) {
            String line, purePassword, pureLine;
            purePassword = Utils.l33tMayusToMinus(subComun);        //Paso los caracteres l33t a alfabeticos
            String longestString = "";
            String passwordFound ="";
            while ((line = reader.readLine()) != null) {
                pureLine = Utils.l33tMayusToMinus(line);
                if(purePassword.contains(pureLine) && pureLine.length()>longestString.length()){
                    longestString = pureLine;
                    passwordFound = line;
                }
            }
            if(longestString == "") return A;
            int startIndex = purePassword.indexOf(longestString);
            int endIndex = startIndex + longestString.length()-1;
            A[0] = startIndex; A[1] = endIndex;
            A[2] = Utils.countDiff(subComun.substring(startIndex, endIndex+1), passwordFound);
            return A;
        } catch (IOException e) {e.printStackTrace();}
        return A;
    }

    static int[] subFecha(String subFecha){
         /*
        *Esta función reconoce fechas en diversos formatos. En particular, los especificados en el arreglo formats
        *"regex" almacena el código que indica qué fechas buscar. Es fácil de leer, "d{x}" indica números de x cifras, | es el OR lógico
        *y los signos - y / son los mismos.
        *Pattern "compila" este código y Matcher busca el patrón compilado en la cadena subFecha
        *Itera por cada formato de fecha hasta que concuerde con alguno de ellos. Botará "ParseException" si no concuerda y tan solo
        *sigue con el siguiente formato
        *Retorna indice inicial y final de la subcadena y qué formato utiliza. Es importante guardar el formato a la hora de calcular la entropía.
        */
        int[] A ={-1,-1, -1};
        String regex = "\\d{2}\\d{2}\\d{2}|\\d{2}\\d{2}\\d{4}|\\d{2}/\\d{2}/\\d{2}|\\d{2}/\\d{2}/\\d{4}|\\d{2}-\\d{2}-\\d{2}|\\d{2}-\\d{2}-\\d{4}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(subFecha);
     
        String[] formats = {"ddMMyy", "ddMMyyyy", "dd/MM/yy", "dd/MM/yyyy", "dd-MM-yy", "dd-MM-yyyy"};
        SimpleDateFormat[] sdfs = new SimpleDateFormat[formats.length];
        for (int i = 0; i < formats.length; i++) {
            sdfs[i] = new SimpleDateFormat(formats[i]);
            sdfs[i].setLenient(false);
        }
        
        int counter = 0;
        while (matcher.find()) {
            String dateStr = matcher.group();
            for (SimpleDateFormat sdf : sdfs) {
                try {
                    sdf.parse(dateStr);         //Botará ParseException si no concuerda con el formato de fecha
                    int startIndex = subFecha.indexOf(dateStr);
                    int endIndex = startIndex + dateStr.length()-1;
                    A[0] = startIndex; A[1] = endIndex; A[2] = counter;     //Guardará cuál formato está usando
                    return A;
                } catch (ParseException e) {                    counter++;}
            }
        }
        return A;
     }

    static int[] subAño(String subAño){
         /*
        *Igual que el anterior, solo busca años entre 2030 y 1000. Considero hasta el año 2030 arbitrariamente.
        *Las personas usan años o fechas significativas en su vida: Un cumpleaños, una fecha de nacimiento, algo así.
        *Considerar un año más allá del 2030 sería poco probable y raro. Quizá requiera ser actualizado en el año 2050?
        */
        int A[] = {-1,-1, 0};
        String regex = "\\d{4}";
        Matcher matcher = Pattern.compile(regex).matcher(subAño);
        while(matcher.find()){
            int year = Integer.parseInt(matcher.group());
            if(year<=2030 && year>=1000){
                int startIndex = subAño.indexOf(matcher.group());
                int endIndex = startIndex + matcher.group().length()-1;
                A[0] = startIndex; A[1] = endIndex;
                return A;
            }
        }
        return A;
    } 
//A partir de aquí, las funcione solo retornan el indice inicial y final de la subcadena
//El "0" al final de cada arreglo A es irrelevante

    static int[] subSecuencia(String subSecuencia){        
    /*Encuentra secuencias de tipo "abcde", "aceg", "1234"
    *Limitación: No reconoce "ñ". Su código ASCII está alejado del alfabeto y es difícil implementarlo con magia. Mea culpa.
    */
        int A[] = {-1,-1, 0};
        for(int i=0; i<subSecuencia.length()-1; i++){
            int j=1;                    //Contador de caracteres
            char baseChar = subSecuencia.charAt(i);
            char nextChar = subSecuencia.charAt(i+j);
            int diff = nextChar-baseChar;
            if(diff==0) continue;       //Si son los mismos caracteres, puede que se trate de una repetición
            j++;
            while(i+j<subSecuencia.length()){
                char next1Char = subSecuencia.charAt(i+j);
                if(next1Char-nextChar==diff){
                    nextChar = next1Char;
                    j++;
                    continue;
                }
                break;
            }
            if(j==2){return A;}         //Una subsecuencia deberá de ser de más de dos caracteres para que sea relevante
            int startIndex = i;
            int endIndex = i+j-1;
            A[0] = startIndex; A[1] = endIndex;
            return A;
        }
        return A;                       //Ninguna subcadena sigue una subsecuencia
    }


    static int[] subRepeticion(String subRepeticion){
    /*
    *Ditto. Detecta repeticiones tipo "aaaa", "11111", "#####".
    */
        int A[] = {-1,-1, 0};
        int j=1;                    //Contador de caracteres    
        for(int i=0; i<subRepeticion.length()-1; i++){
            char baseChar = subRepeticion.charAt(i);
            char nextChar = subRepeticion.charAt(i+j);
            if(baseChar!=nextChar){ j=1; continue;}
            j++;
            while(baseChar==nextChar && i+j<subRepeticion.length()){
                baseChar = nextChar;
                nextChar = subRepeticion.charAt(i+j);
                j++;
            }
            j--;
            int startIndex = i;
            int endIndex = i+j;
            A[0] = startIndex; A[1] = endIndex;
            return A;  
        }
        return A;
    }
}
