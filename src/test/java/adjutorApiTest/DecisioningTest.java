package adjutorApiTest;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.PayloadBuilder;

import java.util.Map;

public class DecisioningTest extends Base {
    @Test
    @Parameters({"url", "api_token"})
    public void getDecisionModelsTest(String url, String api_token) {
        String endpoint = url + "decisioning/models";
        Map<String, Object> response =
                PayloadBuilder.readPayloadFromResponseAsObject(RequestBuilder.request(api_token, endpoint).asString());
        Assert.assertEquals(response.get("message"), "Successful");
    }

    @Test
    @Parameters({"url", "api_token"})
    public void getDecisionModelDetailsTest(String url, String api_token) {
        String endpoint = url + "decisioning/models";
        String id =
                (String) PayloadBuilder.readPayloadFromResponseAsObject(RequestBuilder.advancedRequest(api_token, endpoint).asString()).get("id");
        String _endpoint = url + "decisioning/models" + id + "/settings";
        Map<String, Object> response =
                PayloadBuilder.readPayloadFromResponseAsObject(RequestBuilder.request(api_token,
                        _endpoint).asString());
        Assert.assertEquals(response.get("message"), "Successful");
    }

    @Test
    @Parameters({"url", "env", "api_token"})
    public void oraculiBorrowerScoringTest(String url, String env, String api_token) {
        String endpoint = url + "decisioning/models/" + "2355";
        Map<String, Object> payload =
                (Map<String, Object>) PayloadBuilder.readPayloadFromFile(env).get("oraculiBorrowerScoring");
        System.out.println(payload);
        Map<String, Object> response =
                PayloadBuilder.readPayloadFromResponseAsObject(RequestBuilder.request(api_token,
                        endpoint, payload, "POST").asString());
        Assert.assertEquals(response.get("message"), "Successful");
    }
}
