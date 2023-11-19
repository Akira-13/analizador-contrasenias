import java.util.Scanner;

public class Algoritmo{
    static final double base2 = Math.log(2.0);
    public static void main(String[] args){
        double entropia;
        int intentos;
        int diccionario=0;
        int segundosXMillon;
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese la cadena a analizar: ");
        Cadena password = new Cadena();
        password.cadena = sc.nextLine();
        for(int i=0; i<password.cadena.length(); i++){
            if(Character.isDigit(password.cadena.charAt(i)) && password.hasNums){
                diccionario=+password.nums;
                password.hasNums=false;
            }
            else if(Character.isUpperCase(password.cadena.charAt(i)) && password.hasAbcMay){
                diccionario=+password.abcMay;
                password.hasAbcMay=false;
            }
            else if(Character.isLowerCase(password.cadena.charAt(i)) && password.hasAbcMin){
                diccionario=+password.abcMin;
                password.hasAbcMin=false;
            }
            else if((!Character.isLowerCase(password.cadena.charAt(i)) && !Character.isUpperCase(password.cadena.charAt(i)) && !Character.isDigit(password.cadena.charAt(i))) && password.hasSpec){
                diccionario=+password.spec;
                password.hasSpec=false;
            }
        }
        System.out.println(diccionario);        
        entropia = (Math.log(diccionario) / base2)*password.cadena.length();
        intentos = (int)Math.ceil(Math.pow(2.0, entropia-1));
        segundosXMillon = intentos/10000000;
        System.out.println("La cadena tiene " + entropia + " bits de entropia.");
        System.out.println("En promedio requeriría " + intentos + " intentos para ser desbloqueada a fuerza bruta.");
        System.out.println("A un billón de intentos por segundo, requeriría " + segundosXMillon + " segundo(s) para desbloquear o " 
                            + (float)segundosXMillon/60.0 + " minuto(s).");
    }    
}

class Cadena{
    final int abcMin = 27;
    final int abcMay = 27;
    final int nums = 10;
    final int spec = 33;
    boolean hasAbcMay=true;
    boolean hasAbcMin=true;
    boolean hasNums=true;
    boolean hasSpec=true;
    String cadena;
}


// MODIFICADO

import java.util.Scanner;
import java.math.BigInteger;
public class Algoritmo{
    static final double base2 = Math.log(2.0);
    public static void main(String[] args){
        double entropia;
        int diccionario=0;
        /*int intentos;
        int segundosXMillon;*/
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese la cadena a analizar: ");
        Cadena password = new Cadena();
        password.cadena = sc.nextLine();
        for(int i=0; i<password.cadena.length(); i++){
            if(Character.isDigit(password.cadena.charAt(i)) && password.hasNums){
                diccionario+=password.nums;
                password.hasNums=false;
            }
            else if(Character.isUpperCase(password.cadena.charAt(i)) && password.hasAbcMay){
                diccionario+=password.abcMay;
                password.hasAbcMay=false;
            }
            else if(Character.isLowerCase(password.cadena.charAt(i)) && password.hasAbcMin){
                diccionario+=password.abcMin;
                password.hasAbcMin=false;
            }
            else if((!Character.isLowerCase(password.cadena.charAt(i)) && !Character.isUpperCase(password.cadena.charAt(i)) && !Character.isDigit(password.cadena.charAt(i))) && password.hasSpec){
                diccionario+=password.spec;
                password.hasSpec=false;
            }
        }
        System.out.println(diccionario);        
        entropia = (Math.log(diccionario) / base2)*password.cadena.length();
        /*intentos = (int)Math.ceil(Math.pow(2.0, entropia-1));
        segundosXMillon = intentos/10000000;*/

        BigInteger two = BigInteger.valueOf(2);
        BigInteger intentos = two.pow((int) Math.ceil(entropia - 1));
        BigInteger segundosXMillon = intentos.divide(BigInteger.valueOf(10000000));

        System.out.println("La cadena tiene " + entropia + " bits de entropia.");
        System.out.println("En promedio requeriría " + intentos + " intentos para ser desbloqueada a fuerza bruta.");
        System.out.println("A un billón de intentos por segundo, requeriría " + segundosXMillon + " segundo(s) para desbloquear o " 
                            /*+ (float)segundosXMillon/60.0 + " minuto(s)."*/);
    }    
}

class Cadena{
    final int abcMin = 27;
    final int abcMay = 27;
    final int nums = 10;
    final int spec = 33;
    boolean hasAbcMay=true;
    boolean hasAbcMin=true;
    boolean hasNums=true;
    boolean hasSpec=true;
    String cadena;
}
