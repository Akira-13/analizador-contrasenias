import java.util.TreeMap;
public class Utils {
    static final int TOTALDIGITS = 10;
    static final int TOTALLOWER = 27;
    static final int TOTALUPPER = 27;
    static final int TOTALSPEC = 33;
    static final double BASE2 = Math.log(2.0);
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
        String cadenaNorm = cadena;
        for(int i=0; i < cadenaNorm.length(); i++){
            if(leet.containsKey(cadena.charAt(i))){
                cadenaNorm.replace(cadenaNorm.charAt(i), leet.get(cadenaNorm.charAt(i)));
            }
        }
        cadenaNorm.toLowerCase();
        return cadenaNorm;
    }
    static int countDiff(String cadena1, String cadena2){
        int count = 0;
        for(int i=0; i<cadena1.length(); i++){
            if(cadena1.charAt(i) == cadena2.charAt(i)){
                count++;
            }
        }
        return count;
    }
    static double calcularEntropia(int diccionario, int longitud, int adicional){
        double entropia;
        entropia = longitud*((Math.log(diccionario + adicional) / BASE2));
        return entropia;
    }
}