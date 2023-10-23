package arquitectura_proyect;

public class Cadena {
    private int numberDigits, numberOfLower, numberOfUpper, numberOfSpec;
    private String chain;
    
    Cadena(String chain){
        this.chain = chain;
    }
    
    public int cadena_length(){
        return chain.length();
    }
    
    public char cadena_getter(int index){
        if (index >= 0 && index < chain.length()) {
            return chain.charAt(index);
        }
        throw new IndexOutOfBoundsException("El índice se encuentra fuera de rango, ingrese otro valor");
    }
    
    public int howManyDigits(){
        for(int i = 0; i < chain.length(); i++){
            if( 47 < (int)chain.charAt(i) && (int)chain.charAt(i)< 58){
                numberDigits++;
            }
        }
        return numberDigits;
    }
    
    public int howManyUpper(){
        for(int i = 0; i < chain.length(); i++){
            if( 64 < (int)chain.charAt(i) && (int)chain.charAt(i)< 91){
                numberOfUpper++;
            }
        }
        return numberOfUpper;
    }
    
    public int howManyLower(){
        for(int i = 0; i < chain.length(); i++){
            if( 96 < (int)chain.charAt(i) && (int)chain.charAt(i) < 123){
                numberOfLower++;
            }
        }
        return numberOfLower;
    }
    
    public int howManySpec(){
        for(int i = 0; i < chain.length(); i++){
            if( (0 <= (int)chain.charAt(i) && (int)chain.charAt(i) <= 46) || (58 <= (int)chain.charAt(i) && (int)chain.charAt(i) <= 64) || (91 <= (int)chain.charAt(i) && (int)chain.charAt(i) <= 96) || (123 <= (int)chain.charAt(i) && (int)chain.charAt(i) <= 255)){
                numberOfSpec++;
            }
        }
        return numberOfSpec;
    }
    
    public boolean hasDigits(){
        for(int i = 0; i < chain.length(); i++){
            if( 47 < (int)chain.charAt(i) && (int)chain.charAt(i)< 58){
                return true;
            }
        }
        return false;
    }
    
    public boolean hasUpper(){
        for(int i = 0; i < chain.length(); i++){
            if( 64 < (int)chain.charAt(i) && (int)chain.charAt(i)< 91){
                return true;
            }
        }
        return false;
    }
    
    public boolean hasLower(){
        for(int i = 0; i < chain.length(); i++){
            if( 96 < (int)chain.charAt(i) && (int)chain.charAt(i) < 123){
                return true;
            }
        }
        return false;
    }
    
    public boolean hasSpec(){
        for(int i = 0; i < chain.length(); i++){
            if( (0 <= (int)chain.charAt(i) && (int)chain.charAt(i) <= 46) || (58 <= (int)chain.charAt(i) && (int)chain.charAt(i) <= 64) || (91 <= (int)chain.charAt(i) && (int)chain.charAt(i) <= 96) || (123 <= (int)chain.charAt(i) && (int)chain.charAt(i) <= 255)){
                return true;
            }
        }
        return false;
    }
    
}
