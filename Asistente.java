import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
public class Asistente {
    void pedir_password(){
        Verificator verificar = new Verificator();
        String input = new String(verificar.validateString());
        Password pass = new Password(input);
        
        String[] alertas = {"Anio en su contraseña","Secuencia en su contraseña","Repeticiones en su contraseña"};
        Password[] problemas = AlgoritmoDividirSubcadenasYCalcularEntropia.dividirSubcadenas(pass);
        for(Password i:problemas){
            if(i.flag.length() == 1 && i.flag.charAt(0) != '6'){
                System.out.println(i.password + " PROBLEMA DE SEGURIDAD: " + alertas[Integer.parseInt(i.flag)- 3]);
                System.out.println();
            }
            if(i.flag.length() == 2){
                int valor1 = i.flag.charAt(0) -'0';
                int valor2 = i.flag.charAt(1) - '0';
                if(valor1 == 1){
                    System.out.println(i.password + " Es una contraseña común" + " Y tiene "+ valor2 + " alteraciones");
                    System.out.println();
                }
                else{
                    System.out.println(i.password + " Se encontro una fecha en su contrasena del tipo "+ valor2);
                    System.out.println();
                }

            }
        }

        //PARA IMPRIMIR
        float entropia = 0;
        Password password = pass;      //Password tendrá una contraseña y su etiqueta. "0" porque está sin clasificar
        System.out.println("Subcontrasenias y sus entropias");
        Password[] dividedPasswords = AlgoritmoDividirSubcadenasYCalcularEntropia.dividirSubcadenas(password);
        dividedPasswords = AlgoritmoDividirSubcadenasYCalcularEntropia.calcularEntropias(dividedPasswords);
        for(int i = 0; i<dividedPasswords.length; i++){
           System.out.println(dividedPasswords[i].password + "\t" + dividedPasswords[i].entropia);
           entropia += dividedPasswords[i].entropia;
        }
        System.out.println("Entropia total: " + entropia);

        System.out.print("¿Desea que se le sugiera una nueva contraseña o generar una nueva?\n" +
                            "1) Nueva contraseña\n" +
                            "2) Sugerencia\n" + 
                            "3) Terminar programa\n"+
                            "Ingrese opcion: ");
        int j = 5;
        while(j>3) j = verificar.int_greater_zero();
        switch(j){
            case 1: 
                Generate_new_password newPassword = new Generate_new_password(password.password);
                newPassword.Caracteristics();
                System.out.println("Su nueva contraseña y sus entropias");
                newPassword.generateNewPassword();
                System.out.println(newPassword);
                String generatedPassword = newPassword.getNewPassword();
                password = new Password(generatedPassword, "0");      //Password tendrá una contraseña y su etiqueta. "0" porque está sin clasificar
                dividedPasswords = AlgoritmoDividirSubcadenasYCalcularEntropia.dividirSubcadenas(password);
                dividedPasswords = AlgoritmoDividirSubcadenasYCalcularEntropia.calcularEntropias(dividedPasswords);
                entropia = 0;
                for(int i = 0; i<dividedPasswords.length; i++){
                    System.out.println(dividedPasswords[i].password + "\t" + dividedPasswords[i].entropia);
                    entropia += dividedPasswords[i].entropia;
                }
                System.out.println("Entropia total: " + entropia);
                j =-1;
            case 2:
                System.out.println("\t PROBLMEAS DE SEGURIDAD");
                for(Password i:problemas){
                    if(i.flag.length() == 1 && i.flag.charAt(0) != '6'){
                        System.out.println(i.password + " es un(a) "+alertas[Integer.parseInt(i.flag)- 3]);
                        System.out.println("Los años, secuencias y repeticiones son faciles de atacar.");
                    }
                    if(i.flag.length() == 2){
                        int valor1 = i.flag.charAt(0) -'0';
                        int valor2 = i.flag.charAt(1) - '0';
                        if(valor1 == 1){
                            System.out.println(i.password + " Es una contraseña común");
                            System.out.println("Esta subcadena se puede obtener en un diccionario.");
                        }
                        else{
                            System.out.println(i.password + "es una fecha");
                            System.out.println("Las fechas pueden ser atacadas con mayor facilidad, se sugiere cambiar la subcadena");
                        }
                    }
                }
                BigDecimal attemptsPerSecond = new BigDecimal(BigInteger.valueOf(1000000000));
                BigDecimal two = new BigDecimal(2);
                BigDecimal totalAttempts = two.pow((int)Math.round(entropia), MathContext.DECIMAL128);
                BigDecimal totalSeconds = totalAttempts.divide(attemptsPerSecond, MathContext.DECIMAL128);

                BigDecimal[] hours = totalSeconds.divideAndRemainder(BigDecimal.valueOf(3600));
                BigDecimal[] minutes = hours[1].divideAndRemainder(BigDecimal.valueOf(60));
                BigDecimal[] seconds = minutes[1].divideAndRemainder(BigDecimal.valueOf(1));
                System.out.println();
                System.out.println("Tiempo estimado: " + hours[0] + " horas, " + minutes[0] + " minutos, " + seconds[0] + " segundos");
                    case 3: j=-1;
                }
    }
}