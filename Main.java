public class Main {
    public static void main(String[] args) {
        float entropia = 0;
        Verificator verificar = new Verificator();
        String input = new String(verificar.validateString());
        Password password = new Password(input, "0");      //Password tendrá una contraseña y su etiqueta. "0" porque está sin clasificar
        Password[] dividedPasswords = AlgoritmoDividirSubcadenasYCalcularEntropia.dividirSubcadenas(password);
        dividedPasswords = AlgoritmoDividirSubcadenasYCalcularEntropia.calcularEntropias(dividedPasswords);
        for(int i = 0; i<dividedPasswords.length; i++){
           System.out.println(dividedPasswords[i].password + "\t" + dividedPasswords[i].entropia);
           entropia += dividedPasswords[i].entropia;
        }
        System.out.println("Entropia total: " + entropia);

        System.out.println("¿Desea que se le sugiera una nueva contraseña o generar una nueva?\n" +
                            "1) Nueva contraseña\n" +
                            "2) Sugerencia\n" + 
                            "3) Terminar programa");
        int j = 5;
        while(j>3) j = verificar.int_greater_zero();
        switch(j){
            case 1: 
                Generate_new_password newPassword = new Generate_new_password(password.password);
                newPassword.Caracteristics();
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
                return;
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
                System.out.println("Entropia total: " + entropia);
                return;
            case 3: return;
        }
    }
}
