package adjutorApiTest;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.PayloadBuilder;

import java.util.Map;

public class CoreServicesTest {

    @Test
    @Parameters({"url", "env", "api_token"})
    public void createNewUserTest(String url, String env, String api_token) {
        String endpoint = url + "customers";
        Map<String, Object> payload =
                (Map<String, Object>) PayloadBuilder.readPayloadFromFile(env).get("createNewCustomer");
        RequestBuilder.request(api_token, endpoint, payload, "POST");
    }

    @Test
    @Parameters({"url", "api_token"})
    public void getAllCustomersTest(String url, String api_token) {
        String endpoint = url + "customers";
        RequestBuilder.request(api_token, endpoint);
    }
}
