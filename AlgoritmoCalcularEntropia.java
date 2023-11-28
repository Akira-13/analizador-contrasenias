//Se calcula la entropía de cada Password según su tipo
//Para simplificar cálculos estadísticos, se asume que el hacker sabe 1) de qué tipo será la subcadena y 2) la longitud de la subcadena
//Es decir, se subestima la seguridad de la contraseña al asumir que el hacker ya  sabe de antemano qué tipo de contraseña será
//El hacker ya sabrá que la contraseña es de tipo "Común + Secuencia + Común" o "Fecha + Común + Fuerza Bruta", etc.
//Esto llevará a calcular una entropía global menor, lo cual será mejor para el usuario. Mejor mostrar una entropía menor y preferir mayor seguridad
//a mostrar una mayor y que dé una ilusión de seguridad
public class AlgoritmoCalcularEntropia implements Constantes{
    static float entropiaDictionary(Password password){
        /*
        *Es llamado "Dictionary" para represntar que este caso es el de un ataque de diccionario
        *Como este código solo reconoce contraseñas comunes, solo se considera ese caso.
        *No es nada especial. Primero reconoce cuántas alteraciones tiene, el cual es el número a partir de la segunda cifra en 
        *el campo "flag" de Password.
        *Luego, calcula la entropía del siguiente modo: El pool de datos es el de 10000 contraseñas MÁS las alteraciones que tiene la contraseña
        *Esto es porque, claramente qw3rtY (una contraseña común con alteraciones) y "qwerty" son diferentes.
        *Pero un hacker puede iterar entre todas las posibles alteraciones de una contraseña común para llegar a la combinación que 
        *un usuario use.
        *Entonces, cada alteración se considera como si se creara una contraseña diferente y agrega en 1 al pool de datos de 10000 contraseñas
        *Luego, la longitud es 1 porque, gracias al algoritmo de dividirSubcadenas, solo se recibe UNA contraseña común. 
        */
        int alts = Integer.parseInt(password.flag.substring(1));
        return Utils.calcularEntropia(10000+alts, 1);
    }

    static float entropiaFecha(Password password){
        /*
        *Se calcula la entropía según el año en el que caiga la fecha
        *El pool de datos es obviamente el número de días en el rango de años
        *Se considera el rango de 2000 a 2029 arbitrariamente. Usualmente las contraseñas tendrán una fecha de nacimiento o 
        *fecha importante en la vida, así que se asumen que serán las más comunes y tendrán un pool más pequeño.
        *Luego se considera el rango de 1000 a 2029 si se usan años menores a 2000. 
        */
        int formatType = Integer.parseInt(password.flag.substring(1));
        String[] formats = {"ddMMyy", "ddMMyyyy", "dd/MM/yy", "dd/MM/yyyy", "dd-MM-yy", "dd-MM-yyyy"};
        int yearIndex = formats[formatType].indexOf('y');
        String year = password.password.substring(yearIndex);
        if((formatType == 0 || formatType == 2 || formatType == 4) && year.charAt(0) >= '0' && year.charAt(0) < '3'){
            return Utils.calcularEntropia(10593 , 1); //2000 a 2029
        }
        else if((formatType == 1 || formatType == 3 || formatType == 5) && year.charAt(0) == '2'){
            return Utils.calcularEntropia(10593, 1); //ditto para formato de año en 4 cifras
        }
        else if((formatType == 0 || formatType == 2 || formatType == 4) && year.charAt(0) >= '3'){
            return Utils.calcularEntropia(375835, 1); //Si el año empieza desde los 30 en adelante, se considera desde los años 1000 hasta 2029
        }
        return Utils.calcularEntropia(375835, 1); //ditto para formato de años en 4 cifras
    }

    static float entropiaAño(Password password){
        /*
        *igual que el anterior, solo se consideran años
        */
        int año = Integer.parseInt(password.password);
        if(año>=2000){
            return Utils.calcularEntropia(25, 1);
        }
        return Utils.calcularEntropia(1000, 1);
    }

    static float entropiaSecuencia(Password password){
        /*
        *Para las secuencias, solo es necesario reconocer qué caracter se usa primero
        *Si es una letra, puede seguir una secuencia dejande 1 letra, 2 letras, 3 letras, hasta 5. 
        *Considero hasta 5 letras de forma arbitraria. Es raro tener como contraseña una secuencia de letras dejando 6 letras entre cada una xd
        *Por lo tanto, el diccionario será el número de letras ASCII multiplicado por 5. O sea, el número de posibles primeras letras multiplicado por 
        *las posibles secuencias a formar a partir de esa letra
        *Lo mismo con números, solo que considero secuencias dejando 3 números.
        *La longitud es 1 porque, como se dijo al inicio, se asume que el hacker ya sabe la longitud de la cadena.
        */
        String string = password.password;
        int diccionario = 0;
        boolean isAlpha = false;
        if((string.toLowerCase().charAt(0) > 'a' && string.toLowerCase().charAt(0) < 'z')){
            diccionario = TOTALLOWER;
            isAlpha = true;
        }
        else {
            diccionario = TOTALDIGITS;
        }
        if(isAlpha){
            return Utils.calcularEntropia(diccionario*5, 1);
        }
        return Utils.calcularEntropia(diccionario*3,1);
    }
    
    static float entropiaRepeticion(Password password){
        /*
        *Igual que el anterior, solo que esta vez el hacker solo necesita saber con qué letra inicia la repetición de caracteres.
        */
        String string = password.password;
        int diccionario = 0;
        if((string.toLowerCase().charAt(0) > 'a' && string.toLowerCase().charAt(0) < 'z')){
            diccionario = TOTALLOWER;
        }
        else if (string.charAt(0)>'0' && string.charAt(0)<'9') {
            diccionario = TOTALDIGITS;
        }
        else{
            diccionario = TOTALSPEC;
        }
        return Utils.calcularEntropia(diccionario, 1);
    }
    
    static float entropiaBruteForce(String password){
        /*
        *Este es el cálculo de entropía puro.
        *Se reconoce si la subcadena tiene caracteres minusculas, maysculas, numeros o especiales y se suman al pool de datos
        *Ahora sí se toma en cuenta la longitud. Mientras más larga la cadena, más entropía.
        *El hacker puede saber la longitud de la cadena, pero de todos modos tendrá que iterar tomando en cuenta su longitud, lo cual afecta la entropía.
        */
        int length = password.length();
        int diccionario=0;
        boolean hasLower = false, hasUpper = false, hasNumber = false, hasSpec = false;
        for(int i = 0; i < length; i++){
            if( !hasNumber && 47 < (int)password.charAt(i) && (int)password.charAt(i)< 58){
                hasNumber = true;
                diccionario += TOTALDIGITS;
                continue;
            }
        }
        
        for(int i = 0; i < length; i++){
            if( !hasUpper && ((64 < (int)password.charAt(i) && (int)password.charAt(i) < 91) || ((int)password.charAt(i) == 209))){        //Considera "Ñ"
                hasUpper = true;
                diccionario += TOTALUPPER;
                continue;
            }
        }
        
        for(int i = 0; i < length; i++){
            if( !hasLower && ((96 < (int)password.charAt(i) && (int)password.charAt(i) < 123) || ((int)password.charAt(i) == 241))){         //Considera "ñ"
                hasUpper = true;
                diccionario += TOTALLOWER;
                continue;
            }
        }
        
        for(int i = 0; i < length; i++){
            if( !hasSpec && ((32 <= (int)password.charAt(i) && (int)password.charAt(i) <= 47) || (58 <= (int)password.charAt(i) && (int)password.charAt(i) <= 64) || (91 <= (int)password.charAt(i) && (int)password.charAt(i) <= 96) || (123 <= (int)password.charAt(i) && (int)password.charAt(i) <= 126))){
                hasSpec = true;
                diccionario += TOTALSPEC;
                continue;
            }
        }
        return Utils.calcularEntropia(diccionario, length);
    }
} 
