package arquitectura_proyect;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class Procesor_csv {
    private static final String RUTA_ARCHIVO = "C:\\Cursos\\Java\\Fundamentos\\Entropy_password\\src\\main\\java\\arquitectura_proyect\\10000passwords.csv";
    
    public static boolean Is_on_csv(String password){
        try {
            Reader reader = Files.newBufferedReader(Paths.get(RUTA_ARCHIVO));
            CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT);
            for(CSVRecord registro : parser){
                String linea = registro.get(0);
                if(linea.equals(password)){
                    return true;
                }
            }
            return false;
        } catch (IOException ex) {
            Logger.getLogger(Procesor_csv.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
