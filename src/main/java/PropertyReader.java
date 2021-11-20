import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    // This constructor is private to prevent anyone from instantiate this class.
    private PropertyReader() {
    }

    public static Properties from(String path) throws IOException {
        FileInputStream stream = null;
        Properties properties = null;
        try {
            stream = new FileInputStream(path);
            properties = new Properties();
            properties.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (stream != null) stream.close();
        }
        return properties;
    }
}
