import java.util.Scanner;
import java.util.Random;

class Sugestions_passwords {
    static Scanner sc = new Scanner(System.in);
    static Random ran = new Random();
    static String newSuggestion(String password) {
        int t = password.length();
        int cont1 = 0, cont0 = 0, j = 0;
        int q = t + ((t/2)+1);
        
        char[] ch_password = password.toCharArray();
        char[] new_password = new char [q];
        int[] ver = new int [q]; 
        
        for(int i = 0; i < q; i++){
            if(cont1 < ((t/2) +1) && cont0 < t){
                ver[i] = ran.nextInt(2);
                if(ver[i] == 1){
                    cont1++;
                }else if(ver[i] == 0){
                    cont0++;
                }
            }else if (cont1 >= ((t/2) + 1 )){
                ver[i] = 0;
            }else if (cont0 >= t){
                ver[i] = 1;
            }
        }
        
        for(int i = 0; i < q; i++){
            if(ver[i] == 0){
                new_password[i] = ch_password[j];
                j++;
            }else{
                new_password[i] = (char)nuevo_caracter();
            }
        }
        return new String(new_password);
    }
    
    static int nuevo_caracter(){
        int index = ran.nextInt(4);
        switch (index) {
            case 0:
                return ran.nextInt(4) + 35;
            case 1:
                return ran.nextInt(10) + 48;
            case 2:
                return ran.nextInt(27) + 64;
            case 3:
                return ran.nextInt(26) + 97;
        }
        return 0;
    } 
}
