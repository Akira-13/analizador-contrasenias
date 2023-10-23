package arquitectura_proyect;

import java.util.Scanner;

public class Entropy_password implements Total_caracters {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        double entropia;
        int intentos, diccionario=0, segundosXMillon, total;
        System.out.print("Ingrese la cadena a analizar: ");
        Cadena password = new Cadena(sc.nextLine());
        
        System.out.println("La cadena contiene: ");
        System.out.println(password.howManyDigits() + " números");
        System.out.println(password.howManyLower() + " minúsculas");
        System.out.println(password.howManyUpper() + " mayúsculas");
        System.out.println(password.howManySpec() + " caracteres especiales");
        
        System.out.println("Se procederá a calcular su entropía en base a los datos dados");
        total = password.howManyDigits() + password.howManyLower() + password.howManyUpper() + password.howManySpec();
        
        if(password.hasDigits())diccionario += TOTALDIGITS;
        if(password.hasLower())diccionario += TOTALLOWER;
        if(password.hasUpper())diccionario += TOTALUPPER;
        if(password.hasSpec())diccionario += TOTALSPEC;
        
        entropia = total * ((Math.log(diccionario) / BASE2));
        System.out.println("Se obtuvo la siguiente entropía: " + entropia);
        
    }    
}
