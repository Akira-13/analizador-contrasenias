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
                entropia = 0;
                Password suggestionPassword = new Password(Sugestions_passwords.newSuggestion(password.password), "0");
                Password[] suggestionDivided = AlgoritmoDividirSubcadenasYCalcularEntropia.dividirSubcadenas(suggestionPassword);
                suggestionDivided = AlgoritmoDividirSubcadenasYCalcularEntropia.calcularEntropias(suggestionDivided);
                System.out.print("Nueva contraseña: ");
                for(int i = 0; i<suggestionDivided.length; i++){
                    System.out.print(suggestionDivided[i].password);
                    entropia += suggestionDivided[i].entropia;
                }
                System.out.println();
                System.out.println("Entropia total: " + entropia);
                j=-1;
            case 3: j=-1;
        }
    }
}