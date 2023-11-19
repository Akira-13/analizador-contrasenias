public class Password {
    String password;
    String flag;
    float entropia;

    Password(){
        password = "";
        flag = "0";
        entropia = 0;
    }
    Password(String password){
        this.password = password;
        flag = "0";
        entropia = 0;
    }
    Password(String password, String flag){
        this.password = password;
        this.flag = flag;
        entropia = 0;
    }
    Password(String password, float entropia){
        this.password = password;
        flag = "0";
        this.entropia = entropia;
    }
}
