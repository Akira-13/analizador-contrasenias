public class AlgoritmoCalcularEntropia implements Constantes{
    static float entropiaDictionary(Password password){
        int alts = Integer.parseInt(password.flag.substring(1));
        return Utils.calcularEntropia(10000+alts, 1);
    }

    static float entropiaFecha(Password password){
        int formatType = Integer.parseInt(password.flag.substring(1));
        String[] formats = {"ddMMyy", "ddMMyyyy", "dd/MM/yy", "dd/MM/yyyy", "dd-MM-yy", "dd-MM-yyyy"};
        int yearIndex = formats[formatType].indexOf('y');
        String year = password.password.substring(yearIndex);
        if((formatType == 0 || formatType == 2 || formatType == 4) && year.charAt(0) >= '0' && year.charAt(0) < '3'){
            return Utils.calcularEntropia(10593 , 1); //2000 a 2029
        }
        else if((formatType == 1 || formatType == 3 || formatType == 5) && year.charAt(0) == '2'){
            return Utils.calcularEntropia(10593, 1); //ditto
        }
        else if((formatType == 0 || formatType == 2 || formatType == 4) && year.charAt(0) >= '3'){
            return Utils.calcularEntropia(375835, 1); //Si el año empieza desde los 30 en adelante, se considera desde los años 1000 hasta 2029
        }
        return Utils.calcularEntropia(375835, 1); //ditto para formato de años en 4 cifras
    }

    static float entropiaAño(Password password){
        int año = Integer.parseInt(password.password);
        if(año>=2000){
            return Utils.calcularEntropia(25, 1);
        }
        return Utils.calcularEntropia(1000, 1);
    }

    static float entropiaSecuencia(Password password){
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
