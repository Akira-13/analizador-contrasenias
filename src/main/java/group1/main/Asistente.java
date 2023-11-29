package group1.main;

import javax.swing.JTextArea;

public class Asistente {
    String inp;
    JTextArea text_area_results;
    
    Asistente(){};
    
    void pedir_password(){
        Password pass = new Password(inp);
        text_area_results.append("Se introdujo la siguiente contraseña: " + pass.password + "\n");
        String[] alertas = {" Año en su contraseña"," Secuencia en su contraseña"," Repeticiones en su contraseña"};
        Password[] problemas = AlgoritmoDividirSubcadenasYCalcularEntropia.dividirSubcadenas(pass);
        for(Password i:problemas){
            if(i.flag.length() == 1 && i.flag.charAt(0) != '6'){
                text_area_results.append("\nSe encontró la siguiente subcadena: " + i.password + ". \nProblemas de seguridad: " + alertas[Integer.parseInt(i.flag)- 3] + "\n");
            }
            if(i.flag.length() == 2){
                int valor1 = i.flag.charAt(0) -'0';
                int valor2 = i.flag.charAt(1) - '0';
                if(valor1 == 1){
                    text_area_results.append("\nSe encontró la siguiente subcadena: " + i.password + "\nEs una contraseña común y tiene " + valor2 + " alteraciones\n");
                }
                else{
                    text_area_results.append("\nSe encontró la siguiente subcadena: " + i.password + "\nSe encontro una fecha en su contrasena del tipo " + valor2 + "\n");
                }
            }
        }

        float entropia = 0;
        Password password = pass;      
        text_area_results.append("\nSubcontraseñas y sus entropias:\n");
        Password[] dividedPasswords = AlgoritmoDividirSubcadenasYCalcularEntropia.dividirSubcadenas(password);
        dividedPasswords = AlgoritmoDividirSubcadenasYCalcularEntropia.calcularEntropias(dividedPasswords);
        for (Password dividedPassword : dividedPasswords) {
            text_area_results.append("   - " + dividedPassword.password + ":\t" + dividedPassword.entropia + "\n");
            entropia += dividedPassword.entropia;
        }
        text_area_results.append("\nEntropia total: " + entropia + "\n");

        text_area_results.append("\nEn las siguientes opciones podrá encontrar otras opciones para la mejoría de su seguridad\n");
    }
    
    void Generate_new_pass(boolean hasNum, boolean hasLower, boolean hasUpper, boolean hasSpec, int newLenght){
        Generate_new_password newPassword = new Generate_new_password(inp, newLenght, hasNum, hasLower, hasUpper, hasSpec);
        text_area_results.append("\nA continuación se muestra su nueva contraseña junto a su nuevas entropías\n");
        newPassword.generateNewPassword();
        text_area_results.append(newPassword + "\n");
        String generatedPassword = newPassword.getNewPassword();
        Password password = new Password(generatedPassword, "0");      //Password tendrá una contraseña y su etiqueta. "0" porque está sin clasificar
        Password[] dividedPasswords = AlgoritmoDividirSubcadenasYCalcularEntropia.dividirSubcadenas(password);
        dividedPasswords = AlgoritmoDividirSubcadenasYCalcularEntropia.calcularEntropias(dividedPasswords);
        float new_entropia = 0;
        for (Password dividedPassword : dividedPasswords) {
            text_area_results.append("   - " + dividedPassword.password + "\t" + dividedPassword.entropia + "\n");
            new_entropia += dividedPassword.entropia;
        }
        text_area_results.append(" \nEntropia total: " + new_entropia + "\n");
    }
    
    
    //revisar con akira mañana y avisar sobre errores con lo del leet y ya acabar :3
    void Suggest_pass(boolean hasNum, boolean hasLower, boolean hasUpper, boolean hasSpec, int newLenght){
        float new_entropia = 0;
        Password suggestionPassword = new Password(Sugestions_passwords.newSuggestion(inp), "0");
        Password[] suggestionDivided = AlgoritmoDividirSubcadenasYCalcularEntropia.dividirSubcadenas(suggestionPassword);
            suggestionDivided = AlgoritmoDividirSubcadenasYCalcularEntropia.calcularEntropias(suggestionDivided);
            text_area_results.append("Nueva contraseña: \n");
        for(Password suggestionDivided1 : suggestionDivided) {
            text_area_results.append(suggestionDivided1.password + "\n");
            new_entropia += suggestionDivided1.entropia;
        }
        text_area_results.append("\n");
        text_area_results.append("Entropia total: " + new_entropia + "\n");
    };
}