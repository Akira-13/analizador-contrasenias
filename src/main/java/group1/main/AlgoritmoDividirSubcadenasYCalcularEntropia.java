package group1.main;

/*
Busca la partición de subcadenas con la menor entropía posible.
*Buscará primero las entradas que pertenezcan a las contraseñas más comunes
*Luego, pasará por los demás tipos de subcadenas para ver si son fechas, años, secuencias o repeticiones
*Por descarte, cualquier subcadena que no sea de estos tipos será de tipo "Brute Force"

*Empieza con las subcadenas de contraseñas comunes. Luego fechas, luego años, luego secuencias y repeticiones.
*Cuando reconozca una de estas, la separa y la guarda en un LinkedList con una etqiueta.
*los años, secuencias y repeticiones son guardadas con las etiquetas 3, 4 y  5 respectivamente.
*6 indica brute force y es el que es por defecto cuando no encaja en ninguna otra categoría
*Las contraseñas comunes tienen una etiqueta de dos numeros. El primero siempre es 1, el segundo indica el numero de alternancias
*l33t y mayus y minus
*Igualmente con las fechas, solo que indica qué formato de fecha usa para que sea más fácil calcular su entropía

*!! La entropía total de la contraseña será la suma de las entropías de las subcadenas !!
*La razón de esto es que la entropía es el logaritmo en base dos del número de intentos. 
*El hacker iterará por todas las posibles combinaciones de tipo "palabra", luego "palabra-palabra", 
*luego "palabra-BruteForce", y así. Entonces, se multiplican los numeros de intentos en cada combinación, por principio de multiplicación
*Si se aplica logaritmo en base 2 a esta multiplicación de intentos, se obtiene la suma de las entropías de las subcadenas!

*Por supuesto, esto asume que el hacker ya sabe de antemano qué patrón se está usando. Esto es conveniente, ya que se
*subestima la seguridad de la contraseña de esta forma.
*...Además, no somos data scientist para modelar qué contraseñas son más comunes que otras y usar la fórmula de entropía en cada una.24/
*/

import java.util.LinkedList;

public class AlgoritmoDividirSubcadenasYCalcularEntropia{
    final static int CATEGORIASENTROPIA = 5;
    final static int FLAGSMAX = 3;
    //DIVIDE
    static Password[] dividirSubcadenas(Password password){
        LinkedList<Password> passwords = new LinkedList<>();
        passwords.add(password);   
        int[][]A = new int[CATEGORIASENTROPIA][];
        for(int i=0; i<CATEGORIASENTROPIA; i++){
            A[i] = new int[FLAGSMAX];
        }
        while(passwords.peek().flag == "0"){        
            /*Todo este algoritmo subdivide la contraseña y las clasifica según su tipo
            *Se detiene cuando deje de encontrar contraseñas sin clasificar
            *Las contraseñas sin clasificar siempre se colocan primero
            *Las que ya están clasificadas al final
            */
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
            type = longestIndex+1;
            beginIndex = A[longestIndex][0]; endIndex = A[longestIndex][1];       
            if(isBrute){
                type = 6;
                beginIndex = 0; endIndex = cadenaAnalizar.length()-1;
            }
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
        }
        Password[] subpasswordsArray = new Password[passwords.size()]; 
        int m = 0;
        for(Password subPassword : passwords){
            subpasswordsArray[m] = new Password(subPassword.password, subPassword.flag);
            m++;
        }


        return subpasswordsArray;
    }

    //SUMA
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
