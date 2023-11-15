//Busca la partición de subcadenas con la menor entropía posible.
//Buscará primero las entradas que pertenezcan a las contraseñas más comunes
//Luego, pasará por los demás tipos de subcadenas para ver si son fechas, años, secuencias o repeticiones
//Por descarte, cualquier subcadena que no sea de estos tipos será de tipo "Brute Force"

//Empieza con las subcadenas de contraseñas comunes. Luego fechas, luego años, luego secuencias y repeticiones.
//Cuando reconozca una de estas, la separa y la guarda en un HashMap con su información.
//Las fechas, años, secuencias y repeticiones son guardadas con las etiquetas 2, 3, 4 y  5 respectivamente.
//6 indica brute force y es el que es por defecto cuando no encaja en ninguna otra categoría
//Las contraseñas comunes tienen una etiqueta de dos numeros. El primero siemrpe es 1, el segundo indica el numero de alternancias
//entre mayus y minus

//La entropía total de la contraseña será la suma de las entropías de las subcadenas
//La razón de esto es que la entropía es el logaritmo en base dos del número
//de intentos. Cada hacker iterará por todas las posibles combinaciones de tipo "palabra", luego "palabra-palabra", 
//luego "palabra-BruteForce", y así. Entonces, se multiplican los numeros de intentos en cada combinación, por principio de multiplicación
//Si se aplica logaritmo en base 2 a esta multiplicación de intentos, se obtiene la suma de las entropías de las subcadenas!
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class AlgoritmoSubcadenas{
    final static int CATEGORIASENTROPIA = 5;
    final static int FLAGSMAX = 3;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String contra = new String(sc.nextLine());
        HashMap<String, String> substrings = new HashMap<>();
        substrings.put("0", contra);
        int[][]A = new int[CATEGORIASENTROPIA][];
        boolean isBrute;
        while(substrings.containsKey("0")){ //Crea una clase de cadenas :,v y una LinkedList será mejor.
            int type = 0;
            String[] subContra = new String[2];
            for(Map.Entry entry : substrings.entrySet()){
                if(entry.getKey() == "0"){
                    String cadenaAnalizar = (String)entry.getValue();
                    A[0] = AlgoritmoReconocerSubcadenas.subContComun(cadenaAnalizar);
                    A[1] = AlgoritmoReconocerSubcadenas.subFecha(cadenaAnalizar);
                    A[2] = AlgoritmoReconocerSubcadenas.subAño(cadenaAnalizar);
                    A[3] = AlgoritmoReconocerSubcadenas.subSecuencia(cadenaAnalizar);
                    A[4] = AlgoritmoReconocerSubcadenas.subRepeticion(cadenaAnalizar);
                    isBrute = true;
                    for(int i=0; i<CATEGORIASENTROPIA; i++){
                        if(A[i][0] != -1 && i==0){
                            isBrute = false;
                            type = 10 + A[0][2];
                            break;
                        }
                        else if(A[i][0] == -1){
                            isBrute = false;
                            type = i+1;
                            break;
                        }
                    }
                    if(isBrute){
                        type = 6;
                    }
                    String subCadena = cadenaAnalizar.substring(A[type-1][0], A[type-1][1]);
                    subContra[0] = Integer.toString(type); subContra[1] = subCadena;
                }
            }       // uhghhhghh
            substrings.put(subContra[0], subContra[1]);
        }
        sc.close();
    }
}    