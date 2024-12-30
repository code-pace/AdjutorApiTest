package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.Map;

public class PayloadBuilder {

    static File setFilePath(String env, String json) {
        String dir = env.equalsIgnoreCase("staging")
                ? "/stagingData/"+json+".json" : env.equalsIgnoreCase("production")
                ? "/productionData/"+json+".json" : null;
        return new File(System.getProperty("user.dir"), "src/test" + dir);
    }

    public static Map<String, Object> readPayloadFromFile(String env) {
        Map<String, Object> payload = null;
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            payload = objectMapper.readValue(setFilePath(env, "data"), new TypeReference<Map<String, Object>>(){});
        }catch (Exception je) {
            je.printStackTrace();
        }
        return payload;
    }

    public static Map<String, Object> readPayloadFromResponseAsObject(String response) {
        Map<String, Object> payload = null;
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            payload = objectMapper.readValue(response, new TypeReference<Map<String, Object>>(){});
        }catch (Exception je) {
            je.printStackTrace();
        }
        return payload;
    }

    public static void saveNewJsonData(Map<String, Object> payload, String env) {
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(setFilePath(env,"data"), payload);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


}
