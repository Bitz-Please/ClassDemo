
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;


/**
 *  Overwrites the normal IntegerTypeAdapter for GSON. This will
 *  allow GSON to interpret empty strings as 0. Fixes the 
 *  NumberFormatException during JSON object creation.
 * @author Timothy
 */
public class IntegerTypeAdapter extends TypeAdapter<Number> {
    
    
    /**
     * Writer of the JSON
     * @param jsonWriter the jsonWriter to write this integer value
     * @param number the number to write
     * @throws IOException if the number is null exception is thrown
     */
    @Override
    public void write(JsonWriter jsonWriter, Number number) throws IOException {
        if (number == null) {
            jsonWriter.nullValue();
            return;
        }
        jsonWriter.value(number);
    }

    /**
     * The is the json reader for integers
     * @param jsonReader the jsonReader object
     * @return The read integer from the json
     * @throws IOException if the next is formatted incorrectly
     */
    @Override
    public Number read(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }

        try {
            String value = jsonReader.nextString();
            if ("".equals(value)) {
                return 0;
            }
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new JsonSyntaxException(e);
        }
    }
}
