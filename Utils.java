import java.util.TreeMap;
public class Utils implements Constantes {
    public static TreeMap<Character, Character> leet = new TreeMap<>();
    static{
        leet.put('4', 'a');
        leet.put('8', 'b');
        leet.put('3', 'e');
        leet.put('6', 'g');
        leet.put('1', 'i');
        leet.put('0', 'o');
        leet.put('5', 's');
        leet.put('7', 't');
    }
    static String l33tMayusToMinus(String cadena){
        StringBuilder cadenaNorm = new StringBuilder(cadena.toLowerCase());
        for(int i=0; i < cadenaNorm.length(); i++){
            if(leet.containsKey(cadenaNorm.charAt(i))){
                cadenaNorm.setCharAt(i, leet.get(cadenaNorm.charAt(i)));
            }
        }
        return cadenaNorm.toString();
    }
    
    static int countDiff(String cadena1, String cadena2){
        int count = 0;
        for(int i=0; i<cadena1.length(); i++){
            if(cadena1.charAt(i) != cadena2.charAt(i)){
                count++;
            }
        }
        return count;
    }
    static float calcularEntropia(int diccionario, int longitud){
        float entropia;
        entropia = (float)(longitud*((Math.log(diccionario) / BASE2)));
        return entropia;
    }
}