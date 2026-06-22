package mobile.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import mobile.dto.TrainData;

import java.io.InputStream;

public class TrainDataReader {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static TrainData read() {
        try (InputStream is = TrainDataReader.class.getClassLoader()
                .getResourceAsStream("train.json")){
            if (is == null){
                throw new IllegalStateException("train.json не найден в resources");
            }
            return mapper.readValue(is, TrainData.class);
        }catch (Exception e){
            throw new RuntimeException("Ошибка чтения train.json", e);
        }
    }
}
