package adjutorApiTest;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.PayloadBuilder;

import java.util.Map;

public class ValidationTest extends Base {

    @Test
    @Parameters({"url", "env", "bvn", "api_token"})
    public void initializeBvnContentTest(String url, String env, String bvn, String api_token) {
        String endpoint = url + "verification/bvn/" + bvn;
        Map<String, Object> payload =
                (Map<String, Object>) PayloadBuilder.readPayloadFromFile(env).get("initializeBvnConsent");
        Map<String, Object> response =
                PayloadBuilder.readPayloadFromResponseAsObject(RequestBuilder.request(api_token,
                        endpoint, payload, "POST").asString());
        Assert.assertEquals(response.get("message"), "Please provide OTP sent to contact");
    }

    @Test
    @Parameters({"url", "env", "bvn", "api_token"})
    public void completeConsentAndGetBvnDetailsTest(String url, String env, String bvn, String api_token) {
        String endpoint = url + "verification/bvn/" + bvn;
        Map<String, Object> payload =
                (Map<String, Object>) PayloadBuilder.readPayloadFromFile(env).get("completeConsentAndGenerateBvnDetails");

        Map<String, Object> response =
                PayloadBuilder.readPayloadFromResponseAsObject(RequestBuilder.request(api_token,
                        endpoint, payload, "PUT").asString());
        Assert.assertEquals(response.get("message"), "Successful");
    }
}
