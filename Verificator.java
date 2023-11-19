package arquitectura_proyect;

import java.util.Scanner;

public class Verificator {
    static Scanner sc = new Scanner(System.in);
    public String validateString(){ 
        while(true){
            String newString = sc.nextLine();
            if("".equals(newString)){
                System.out.println("Por favor, ingrese un arreglo no vacío");
            }else{
                return newString;
            }
        }
    }
    
    public boolean Y_or_N(){
        while(true){
            String newString = sc.nextLine();
            if("y".equalsIgnoreCase(newString) || "n".equalsIgnoreCase(newString)){
                return "y".equalsIgnoreCase(newString);
            }else{
                System.out.println("Por favor, ingrese un arreglo adecuado");
            }
        }
    }
    
    public int int_greater_zero(){
        while(true){
            if(sc.hasNextInt()){
                int n_int = sc.nextInt();
                sc.nextLine();
                if(n_int < 0){
                    System.out.println("Por favor, ingrese un número mayor a 0");
                }else{
                    return n_int;
                }
            }else{
                System.out.println("Ingrese un valor que sea numérico");
                sc.nextLine();
            }
        }
    }
}
