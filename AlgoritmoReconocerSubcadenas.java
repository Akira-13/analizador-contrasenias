import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

class AlgoritmoReconocerSubcadenas extends Utils{ 
    static int[] subContComun(String subComun){
        int[] A ={-1,-1,-1};
        try (BufferedReader reader = new BufferedReader(new FileReader("10000passwords.csv"))) {
            String line, purePassword, pureLine;
            purePassword = Utils.l33tMayusToMinus(subComun);        //Paso los caracteres l33t a alfabeticos
            String longestString = "";
            while ((line = reader.readLine()) != null) {
                pureLine = Utils.l33tMayusToMinus(line);
                if(purePassword.contains(pureLine) && pureLine.length()>longestString.length()){
                    longestString = pureLine;
                }
            }
            if(longestString == "") return A;
            int startIndex = purePassword.indexOf(longestString);
            int endIndex = startIndex + longestString.length()-1;
            A[0] = startIndex; A[1] = endIndex;
            A[2] = Utils.countDiff(subComun.substring(startIndex, endIndex+1), longestString);
            return A;
        } catch (IOException e) {e.printStackTrace();}
        return A;
    }

    static int[] subFecha(String subFecha){
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
        int A[] = {-1,-1, 0};
        String regex = "\\bd{4}\\b";
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


    static int[] subSecuencia(String subSecuencia){        
    //Limitación: No incluye ñ. La subsecuencia "mñop" no será detectada, por ejemplo.
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