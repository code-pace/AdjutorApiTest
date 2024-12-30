package adjutorApiTest;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.PayloadBuilder;

import java.util.Map;

public class EmbeddedLoanAndPaymentsTest extends Base {

    @Test
    @Parameters({"url", "api_token"})
    public void getLoanProductsTest(String url, String api_token) {
        String endpoint = url + "loans/products";
        Map<String, Object> response =
                PayloadBuilder.readPayloadFromResponseAsObject(RequestBuilder.request(api_token, endpoint).asString());
        Assert.assertEquals(response.get("message"), "Successful");
    }

    @Test
    @Parameters({"url", "env", "api_token"})
    public void initializeLoanApplicationTest(String url, String env, String api_token) {
        String endpoint = url + "loans/initialize";
        Map<String, Object> payload =
                (Map<String, Object>) PayloadBuilder.readPayloadFromFile(env).get("initializeLoanApp");
        Map<String, Object> response =
                PayloadBuilder.readPayloadFromResponseAsObject(RequestBuilder.request(api_token, endpoint, payload, "POST").asString());
        Assert.assertEquals(response.get("message"), "Successful");
    }
}
