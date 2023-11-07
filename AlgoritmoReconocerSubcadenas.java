import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class AlgoritmoReconocerSubcadenas extends Utils implements Total_caracters{ 
//ToDo: Caracteres l33t y alternancias entre mayúsculas y minúsculas
        int A[] = {-1,-1};
    static int[] subContComun(Cadena subComun){
        int[] A ={-1,-1};
        try (BufferedReader reader = new BufferedReader(new FileReader("10000passwords.csv"))) {
            String line;
            String longestString = "";
            while ((line = reader.readLine()) != null) {
                if(subComun.return_cadena().contains(line) && line.length()>longestString.length()){
                    longestString = line;
                }
            }
            int startIndex = subComun.return_cadena().indexOf(longestString);
            int endIndex = startIndex + longestString.length()-1;
            A[0] = startIndex; A[1] = endIndex;
            return A;
        } catch (IOException e) {e.printStackTrace();}
        return A;
    }

    int[] subFecha(Cadena subFecha){
        int[] A ={-1,-1};
        String regex = "\\b(?:\\d{2}(?:(?:[-/]\\d{2}){1,2}(?:\\d{2}|\\d{4})|\\d{6}))\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(subFecha.return_cadena());
     
        String[] formats = {"ddMMyy", "ddMMyyyy", "dd/MM/yy", "dd/MM/yyyy", "dd-MM-yy", "dd-MM-yyyy"};
        SimpleDateFormat[] sdfs = new SimpleDateFormat[formats.length];
        for (int i = 0; i < formats.length; i++) {
            sdfs[i] = new SimpleDateFormat(formats[i]);
            sdfs[i].setLenient(false);
        }
     
        while (matcher.find()) {
            String dateStr = matcher.group();
            for (SimpleDateFormat sdf : sdfs) {
                try {
                    sdf.parse(dateStr);         //Botará ParseException si no concuerda con el formato de fecha
                    int startIndex = subFecha.return_cadena().indexOf(dateStr);
                    int endIndex = startIndex + dateStr.length()-1;
                    A[0] = startIndex; A[1] = endIndex;
                    return A;
                } catch (ParseException e) {/*Si no concuerda, continua al siguiente formato*/}
            }
        }
        return A;
     }

    int[] subAño(Cadena subAño){
        int A[] = {-1,-1};
        String regex = "\\bd{4}\\b";
        Matcher matcher = Pattern.compile(regex).matcher(subAño.return_cadena());
        while(matcher.find()){
            int year = Integer.parseInt(matcher.group());
            if(year<=2030 && year>=1000){
                int startIndex = subAño.return_cadena().indexOf(matcher.group());
                int endIndex = startIndex + matcher.group().length()-1;
                A[0] = startIndex; A[1] = endIndex;
                return A;
            }
        }
        return A;
    } 


    int[] subSecuencia(Cadena subSecuencia){        
    //ToDo: Caracteres l33t y alternancias entre mayúsculas y minúsculas
    //Limitación: No inlcuye ñ. La subsecuencia "mñop" no será detectada, por ejemplo. 
        int A[] = {-1,-1};
        for(int i=0; i<subSecuencia.cadena_length()-1; i++){
            int j=1;                    //Contador de caracteres
            char baseChar = subSecuencia.return_cadena().charAt(i);
            char nextChar = subSecuencia.return_cadena().charAt(i+j);
            int diff = baseChar-nextChar;
            if(diff==0) continue;       //Si son los mismos caracteres, puede que se trate de una subrepetición
            j++;
            while(i+j<subSecuencia.cadena_length()){
                char next1Char = subSecuencia.return_cadena().charAt(i+j);
                if(next1Char-nextChar==diff){
                    nextChar = next1Char;
                    j++;
                    continue;
                }
                else if()
                break;
            }
            if(j==2){return A;}         //Una subsecuencia deberá de ser de más de dos caracteres para que sea relevante
            int startIndex = i;
            int endIndex = i+j;
            A[0] = startIndex; A[1] = endIndex;
            return A;
        }
        return A;                       //Ninguna subcadena sigue una subsecuencia
    }


    int[] subRepeticion(Cadena subRepeticion){
        int A[] = {-1,-1};
        return A;
    }
}
