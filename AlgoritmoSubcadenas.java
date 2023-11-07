//Busca la partición de subcadenas con la menor entropía posible.
//Buscará primero las entradas que pertenezcan a las contraseñas más comunes
//Luego, pasará por los demás tipos de subcadenas para ver si son fechas, años, secuencias o repeticiones
//Por descarte, cualquier subcadena que no sea de estos tipos será de tipo "Brute Force"

//La entropía total de la contraseña será la suma de las entropías de las subcadenas
//La razón de esto es que la entropía es el logaritmo en base dos del número
//de intentos. Cada hacker iterará por todas las posibles combinaciones de tipo "palabra", luego "palabra-palabra", 
//luego "palabra-BruteForce", y así. Entonces, se multiplican los numeros de intentos en cada combinación, por principio de multiplicación
//Si se aplica logaritmo en base 2 a esta multiplicación de intentos, se obtiene la suma de las entropías de las subcadenas!
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class AlgoritmoSubcadenas{    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Cadena contra = new Cadena(sc.nextLine());
        int[] A = AlgoritmoReconocerSubcadenas.subContComun(contra);
        String subc = contra.return_cadena().substring(A[0], A[1]+1);
        HashMap<Integer, String> subcs = new HashMap<>();
        subcs.put(1,subc);
        for(Map.Entry sub : subcs.entrySet()){
            System.out.println(sub.getKey() + " " + sub.getValue());
        }
        sc.close();
    }
}    