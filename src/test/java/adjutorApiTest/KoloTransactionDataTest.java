package adjutorApiTest;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.PayloadBuilder;

import java.util.Map;

public class KoloTransactionDataTest {
    @Test
    @Parameters({"koloUrl", "api_token"})
    public void initializeAuthTest(String koloUrl, String api_token) {
        String endpoint = koloUrl + "data-share";
        RequestBuilder.queryRequest(api_token, endpoint, "code", "your_client_id", "redirect_uri",
                "transaction:list transaction:view");
    }

    @Test
    @Parameters({"url", "env", "api_token"})
    public void exchangeCodeTest(String url, String env, String api_token) {
        String endpoint = url + "kolo/auth";
        Map<String, Object> payload =
                (Map<String, Object>) PayloadBuilder.readPayloadFromFile(env).get("exchangeCode");
        RequestBuilder.request(api_token, endpoint, payload, "POST");
    }
}
