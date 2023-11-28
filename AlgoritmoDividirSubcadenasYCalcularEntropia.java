import java.util.LinkedList;

public class AlgoritmoDividirSubcadenasYCalcularEntropia{
    final static int CATEGORIASENTROPIA = 5;
    final static int FLAGSMAX = 3;
        /*
        *Este algoritmo divide una cadena dada en subcadenas según su tipo de contraseña
        *La idea es que verifica si tiene subcadenas sin clasificar al inicio de un LinkedList en cada iteración
        *Si es que la primera está sin clasificar, la analiza, clasifica alguna subcadena que tenga y la coloca al final
        *Las subcadenas restantes de esa subcadena son colocadas al inicio nuevamente.

        *Por ejemplo. Empezamos con abcdeQwerty.
        *Esta entra al LinkedList sin clasificar
        *Como encuentra una subcadena al inicio sin clasificar, empieza el ciclo
        *Reconoce que la cadena "abcdeQwerty" tiene la contraseña común Qwerty, la quita de "abcdeQwerty" y la coloca al final con su categoría
        *"abcde" es colocada al inicio sin clasificar.
        *Reconoce que "abcde" está sin clasificar, empieza nuevamente.
        *Termina cuando ya no hayan cadenas al inicio sin clasificar
        
        *Tomar en cuenta la clase "Password", que es solo la contraseña como String y su clasificación como String también
        *También almacena entropía, pero solo es necesario en el cálculo de entropía.
        *En primer lugar, se crea un LinkedList de Password y se agrega como primer elemento a la contraseña ingresada
        *Esta contraseña será de tipo "0", sin clasificar.
        *Luego, se crea una matriz A que almacenará el índice que retorna cada método de AlgoritmoReconocerSubcadenas
        *La contraseña será pasada por cada método. Si se encuentra alguna subcadena como Contraseña Común o Secuencia, se guarda 
        *El índice en la matriz A. Si no, solo tiene -1
        *Continua más abajo
        */
    static Password[] dividirSubcadenas(Password password){
        LinkedList<Password> passwords = new LinkedList<>();
        passwords.add(password);   
        int[][]A = new int[CATEGORIASENTROPIA][];
        for(int i=0; i<CATEGORIASENTROPIA; i++){
            A[i] = new int[FLAGSMAX];
        }
        while(passwords.peek().flag == "0"){        
            //FOR DEBUGGING
        /*     int k = 0;
        for (Password item : passwords) {
            System.out.println("///////////" + k +"///////////");
            k++;
            System.out.println(item.password);
            System.out.println(item.flag);
            System.out.println(item.flag.charAt(0));
        }
            //FOR DEBUGGING
            */
            boolean isBrute=true;
            int type = 0;
            int beginIndex = 0, endIndex = 0;
            Password cadenaAnalizarRaw = passwords.remove();
            String cadenaAnalizar = cadenaAnalizarRaw.password;
            A[0] = AlgoritmoReconocerSubcadenas.subContComun(cadenaAnalizar);
            A[1] = AlgoritmoReconocerSubcadenas.subFecha(cadenaAnalizar);
            A[2] = AlgoritmoReconocerSubcadenas.subAño(cadenaAnalizar);
            A[3] = AlgoritmoReconocerSubcadenas.subSecuencia(cadenaAnalizar);
            A[4] = AlgoritmoReconocerSubcadenas.subRepeticion(cadenaAnalizar);
            int longestSize=0, longestIndex=0;
            for(int i=0; i<CATEGORIASENTROPIA; i++){
                if(A[i][0] != -1){
                    if(A[i][1]-A[i][0]>longestSize) {
                    longestSize = A[i][1]-A[i][0];
                    longestIndex = i; 
                    isBrute = false;
                    }
                }
            }
            /*
            *Una vez se tienen los índices, se buscan los que representen la subcadena más larga. O sea, los que tengan mayor diferencia
            *Si se encuentra una subcadena de tipo Contraseña Común pero esta está contenida en una contraseña del tipo Secuencia, se dará 
            *prioridad a Secuencia por ser más larga.
            *Lo más probable, sin embargo, es que Contraseña Común tenga prioridad en la mayoría de casos.
            */
            type = longestIndex+1;   
            /*
            *El tipo de contraseña está represntado por un número. La primera cifra indicará de qué tipo es del 1 al 6, la segunda para el caso de
            *Contraseña Común indica las alteraciones l33t y mayus-minus, y para fechas indica qué formato de fecha usa. Esto será importante 
            *para el cálculo de entropía.
            */
            beginIndex = A[longestIndex][0]; endIndex = A[longestIndex][1];       
            if(isBrute){
                type = 6;
                beginIndex = 0; endIndex = cadenaAnalizar.length()-1;
            }
            //Si la contraseña no encaja en ninguna categoría (Matriz A llena de -1), significa que la contraseña pasada es de tipo fuerza bruta y 
            //el tipo guardado es 6
            
        /*  System.out.println("+++++++++++++++++");
            System.out.println(type);
            System.out.println(beginIndex);
            System.out.println(endIndex);
            System.out.println(A[longestIndex][2]);
            */

            
            String subCadena = cadenaAnalizar.substring(beginIndex, endIndex+1);
            if(subCadena == "") continue;
            String stringType = Integer.toString(type);
            if(isBrute || subCadena == cadenaAnalizar){
                    if(type == 1 || type == 2){
                        stringType += Integer.toString(A[longestIndex][2]);
                    }
                Password subPassword = new Password(cadenaAnalizar, stringType);
                passwords.addLast(subPassword);
                continue;
            }
            if(type == 1 || type == 2){
                stringType += Integer.toString(A[longestIndex][2]);
            }

            Password subPassword = new Password(subCadena, stringType);
            String resto1 = cadenaAnalizar.substring(0, beginIndex);
            String resto2 = cadenaAnalizar.substring(endIndex+1);
            if(resto1 != ""){
                Password resto1Password = new Password(resto1, "0");
                passwords.addFirst(resto1Password);
            }
            if(resto2 != ""){
                Password resto2Password = new Password(resto2, "0");
                passwords.addFirst(resto2Password);
            }
            passwords.addLast(subPassword);
            /*
            *El código de arriba crea un nuevo objeto Password con la nueva subcadena reconocida y su tipo
            *Esta subcadena será colocada al final del LinkedList. Tiene varios ifs y else porque uhh mi cerebro no daba para nada elegante en ese momento
            *Tan solo crea la subcadena según varios casos en los que su tipo existe pero es una cadena vacía o cosas así
            *Además, las subcadenas restantes son agregadas al inicio del LinkedList con tipo "0" (sin clasificar).
            *Con subcadenas restantes me refiero a que si, por ejemplo, de una cadena de longitud 10 se reconoce una contraseña común en los índices
            *4 y 8, las subcadenas del 0 al 3 y del 9 al 10 serán las restantes.
            */
        }
        Password[] subpasswordsArray = new Password[passwords.size()]; 
        int m = 0;
        for(Password subPassword : passwords){
            subpasswordsArray[m] = new Password(subPassword.password, subPassword.flag);
            m++;
        }

        //El LinkedList se pasa a un array de Passwords ya clasificados. Es lo que todo este método retorna.
        //En pocas palabras: Todo este algoritmo agarra una contraseña, la subdivide, la clasifica y la retorna 
        return subpasswordsArray;
    }

    //SUMA
    /*
    *Con el arreglo generado del método anterior, con cada contraseña ya separada y clasificada, se procede a calcular las entropías de cada subcadena
    *Obviamente, hay una forma de calcular cada entropía según su tipo
    *Cada uno de estos se ve en AlgoritmoCalcularEntropia
    *Se retorna el arreglo con las entropías en cada uno ya calculada.
    */
    static Password[] calcularEntropias(Password[] subpasswords){
        for(int i = 0; i<subpasswords.length; i++){
            switch(subpasswords[i].flag.charAt(0)){
                case '1':
                    subpasswords[i].entropia = AlgoritmoCalcularEntropia.entropiaDictionary(subpasswords[i]);
                    break;
                case '2':
                    subpasswords[i].entropia = AlgoritmoCalcularEntropia.entropiaFecha(subpasswords[i]);
                    break;
                case '3':
                    subpasswords[i].entropia = AlgoritmoCalcularEntropia.entropiaAño(subpasswords[i]);
                    break;
                case '4':
                    subpasswords[i].entropia = AlgoritmoCalcularEntropia.entropiaSecuencia(subpasswords[i]);
                    break;
                case '5':
                    subpasswords[i].entropia = AlgoritmoCalcularEntropia.entropiaRepeticion(subpasswords[i]);
                    break;
                case '6':
                    subpasswords[i].entropia = AlgoritmoCalcularEntropia.entropiaBruteForce(subpasswords[i].password);
                    break;
            }
        }
        return subpasswords;
    }
}
