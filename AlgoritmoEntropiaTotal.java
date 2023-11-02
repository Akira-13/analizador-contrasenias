public class AlgoritmoEntropiaTotal extends LeetCombinaciones implements Total_caracters{
    int subContComun(Cadena subComun){
        //Lee la lista de contraseñas más comunes para comparar si la subcadena aparece en la lista
        //Es la que toma prioridad. Cualquier hacker pasará por esta lista antes de probar fechas, secuencias, etc.
    }

    int subFecha(Cadena subFecha){
        //Fechas en diversos formatos, como 5/12/2002, 5/12/2002, 5-12-2002, 5122002
    }

    int subAño(Cadena subAño){
        //Estaba pensando en considerar los años del 1500 al 2030, para considerar cualquier fecha importante que 
        //el hacker pueda pensar
    } 

//En estos 3 casos iniciales se consideran las secuencias de caracteres l33t y el uso alternado de minusculas y mayusculas
//Por cada reemplazo que se use, se agrega 1 al numero de caracteres en el diccionario

    int subSecuencia(Cadena subSecuencia){
        //Secuencias del tipo 123456, asdfg, etc.
        //Facilmente pueden hallarse iterando sobre la lista de caracteres ASCII
    }

    int subRepeticion(Cadena subRepeticion){
        //tipo "aaaaa" "111111" etc.
        //Igualmente, se puede usar la lista de caracteres ASCII
    }

    int subBruteForce(Cadena subBruteForce){
        //Cualquier subcadena que no sea ninguna de las anteriores caerá acá.
        //Se usa la fórmula de entropía de siempre.
    }
}
