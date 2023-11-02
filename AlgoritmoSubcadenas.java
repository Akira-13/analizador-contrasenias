//Busca la partición de subcadenas con la menor entropía posible.
//Buscará primero las entradas que pertenezcan a las contraseñas más comunes
//Luego, pasará por los demás tipos de subcadenas para ver si son fechas, años, secuencias o repeticiones
//Por descarte, cualquier subcadena que no sea de estos tipos será de tipo "Brute Force"

//La entropía total de la contraseña será la suma de las entropías de las subcadenas
//La razón de esto (por si el profesor pregunta) es que la entropía es el logaritmo en base dos del número
//de intentos. Cada hacker iterará por todas las posibles combinaciones de tipo "palabra", luego "palabra-palabra", 
//luego "palabra-BruteForce", y así. Entonces, se multiplican los numeros de intentos en cada combinación, por principio de multiplicación
//Si se aplica logaritmo en base 2 a esta multiplicación de intentos, se obtiene la suma de las entropías de las subcadenas!
public class Subcadenas{    
    public static void main(String[] args){

    }    
}

