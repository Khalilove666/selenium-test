import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class EnvReader {
    public static Map<String, String> readEnv(String filePath) {
        Map<String, String> envMap = new HashMap<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Skip empty lines and lines starting with '#'
                if (line.trim().isEmpty() || line.trim().startsWith("#")) {
                    continue;
                }
                
                String[] parts = line.split("=", 2);
                if (parts.length == 2) {
                    String key = parts[0].trim();
                    String value = parts[1].trim();
                    envMap.put(key, value);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return envMap;
    }
}