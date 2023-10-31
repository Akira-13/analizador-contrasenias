package arquitectura_proyect;

public class Entropy_password implements Total_caracters {
    static Verificator ver = new Verificator();
    
    public static void main(String[] args){
        boolean OnCsv, validator, finisher;
        
        System.out.print("Hola y bienvenido al analizador de contraseñas, por favor ingrese su contraseña: ");
        Cadena password = new Cadena(ver.validateString());
        password.Report();
        password.Calculate_Entropy();
        password.Calculate_Average_Attempts();
        password.Calculate_Time_Per_Million();
        System.out.println(password);
        
        OnCsv = Procesor_csv.Is_on_csv(password.return_cadena());
        if(OnCsv){
            System.out.println("Su contraseña se encuentra entre las 10 000 contraseñas más comunes del internet, ¿desea un cambio? (y/n)");
            validator = ver.Y_or_N();
        }else{
            System.out.println("El programa cuenta con una opcion de sugeridos en base a la contraseña dada, ¿desea un cambio?");
            validator = ver.Y_or_N();
        }
        
        while(true){
            if(validator){
                Generate_new_password new_password = new Generate_new_password(password.return_cadena());
                new_password.Caracteristics();
                new_password.generateNewPassword();
                System.out.println(new_password);
                System.out.println("¿Desea realizar nuevamente el proceso de generación?");
                finisher = ver.Y_or_N();
                if(!finisher){
                    System.out.println("Gracias por usar el analizador de contraseñas");
                    break;
                }
            }else{
                System.out.println("Gracias por usar el analizador de contraseñas");
                break;
            }
        }
    }    
}
