public class Cadena implements Total_caracters{
    private int length, numberDigits = 0, numberOfLower = 0, numberOfUpper = 0, numberOfSpec = 0;
    private boolean digitsExist, lowerExist, upperExist, specExist;
    private double entropia;
    private int intentos;
    private int segundos;
    private float minutos;
    private String chain;
    
    Cadena(String chain){
        this.chain = chain;
        length = chain.length();
        
        for(int i = 0; i < length; i++){
            if( 47 < (int)chain.charAt(i) && (int)chain.charAt(i)< 58){
                numberDigits++;
            }
        }
        
        for(int i = 0; i < length; i++){
            if( (64 < (int)chain.charAt(i) && (int)chain.charAt(i) < 91) || ((int)chain.charAt(i) == 209)){        //Considera "Ñ"
                numberOfUpper++;
            }
        }
        
        for(int i = 0; i < length; i++){
            if( (96 < (int)chain.charAt(i) && (int)chain.charAt(i) < 123) || ((int)chain.charAt(i) == 241) ){         //Considera "ñ"
                numberOfLower++;
            }
        }
        
        for(int i = 0; i < length; i++){
            if( (32 <= (int)chain.charAt(i) && (int)chain.charAt(i) <= 47) || (58 <= (int)chain.charAt(i) && (int)chain.charAt(i) <= 64) || (91 <= (int)chain.charAt(i) && (int)chain.charAt(i) <= 96) || (123 <= (int)chain.charAt(i) && (int)chain.charAt(i) <= 126)){
                numberOfSpec++;
            }
        }

        digitsExist = numberDigits > 0;
        upperExist = numberOfUpper > 0;
        lowerExist = numberOfLower > 0;
        specExist = numberOfSpec > 0;
    }
    
    public String return_cadena(){
        return chain;
    }
    
    public int cadena_length(){
        return length;
    }
    
    public char cadena_getter(int index){
        if (index >= 0 && index < length) {
            return chain.charAt(index);
        }
        throw new IndexOutOfBoundsException("El índice se encuentra fuera de rango, ingrese otro valor");
    }
    

    public void Report(){
        System.out.println("Su contraseña contiene en total " + length + " caracteres, de los que se pueden hallar: ");
        System.out.println(numberDigits + " números");
        System.out.println(numberOfLower + " minúsculas");
        System.out.println(numberOfUpper + " mayúsculas");
        System.out.println(numberOfSpec + " caracteres especiales");
    }
    
    public void Calculate_Entropy(int adicional){
        int dictionary = 0;
        dictionary += adicional;                //Dependiendo de si haya caracteres l33t o mayusculas, añade 1 al diccionario per caracter
        if(digitsExist) dictionary += TOTALDIGITS;
        if(lowerExist) dictionary += TOTALLOWER;
        if(upperExist) dictionary += TOTALUPPER;
        if(specExist) dictionary += TOTALSPEC;
        entropia = (double)length * ((Math.log(dictionary) / BASE2));
    }

    public void Calculate_Average_Attempts(){
        intentos = (int)Math.ceil(Math.pow(2.0,entropia-1));
    }

    public void Calculate_Time_Per_Million(){
        segundos = (int)Math.ceil(intentos/1.0e6);
        minutos = segundos/60;
    }
    
    @Override
    public String toString(){
        return "La contraseña dada posee una entropía de " + entropia + "\n" +
                "La contraseña requiere en promedio " + intentos + " para ser vulnerada."+"\n"+
                "A un millón de intentos por segundo, requiere "+ segundos + " segundo(s)" + 
                "o " + minutos + "minuto(s)";
        
    }
}
