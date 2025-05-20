package ifellow.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class JsonFromResources {
    public static <T> T readJson(String filenameInResource, Class<T> tClass) {
        ObjectMapper mapper = new ObjectMapper();

        try (InputStream is = JsonFromResources.class
                .getClassLoader()
                .getResourceAsStream(filenameInResource)) {

            if (is == null) throw new FileNotFoundException();

            T obj = mapper.readValue(is, tClass);
            is.close();
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
