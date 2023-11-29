package group1.main;

import java.util.Random;

public class Generate_new_password extends Password{
    static Random ran = new Random();
    private int newLength;
    private boolean haveDigits, haveLower, haveUpper, haveSpec;
    private String newPassword;
    
    Generate_new_password(String password, int newLength, boolean haveDigits, boolean haveLower, boolean haveUpper, boolean haveSpec){
        super(password);
        this.newLength = newLength;
        this.haveDigits = haveDigits;
        this.haveLower = haveLower;
        this.haveUpper = haveUpper;
        this.haveSpec = haveSpec; 
    }    
    
    public void generateNewPassword(){
        char[] chPass = super.password.toCharArray();
        char[] newPass = new char[newLength];
        int cont0 = 0, cont1 = 0, j = 0;
        int[] bin = new int [newLength];
        
        for(int i = 0; i < newLength; i++){
            if(cont1 < (newLength - super.password.length()) && cont0 < super.password.length()){
                bin[i] = ran.nextInt(2);
                if(bin[i] == 1){
                    cont1++;
                }else if(bin[i] == 0){
                    cont0++;
                }
            }else if (cont1 >= newLength - super.password.length()){
                bin[i] = 0;
            }else if (cont0 >= super.password.length()){
                bin[i] = 1;
            }
        }
        
        for(int i = 0; i < newLength; i++){
            if(bin[i] == 0){
                newPass[i] = chPass[j];
                j++;
            }else{
                newPass[i] = (char)nuevo_caracter();
            }
        }
        
        newPassword = new String(newPass);
    }
    
    private int nuevo_caracter(){ //por el momento mantener hasta consultar con akira sobre los caracteres especiales
        while(true){
            int index = ran.nextInt(4);
            switch(index){
                case 0:
                    if(haveSpec){
                        return ran.nextInt(4) + 35;
                    }
                case 1:
                    if(haveDigits){
                        return ran.nextInt(10) + 48;
                    }
                case 2:
                    if(haveUpper){
                        return ran.nextInt(26) + 65;
                    }
                case 3:
                    if(haveLower){
                        return ran.nextInt(26) + 97;
                    }
            }
        }    
    }
    
    @Override
    public String toString(){
        return "Su nueva contraseña es la siguiente: " + newPassword;
    }
 
    public String getNewPassword(){
        return newPassword; 
    }
}