package adjutorApiTest;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.PayloadBuilder;

import java.util.Map;

public class OperationalServicesTest extends Base {

    @Test
    @Parameters({"url", "api_token"})
    public void getAdjutorServicePricingTest(String url, String api_token) {
        String endpoint = url + "profile/pricing";
        Map<String, Object> response =
                PayloadBuilder.readPayloadFromResponseAsObject(RequestBuilder.request(api_token, endpoint).asString());
        Assert.assertEquals(response.get("message"), "Successful");
    }

    @Test
    @Parameters({"url", "api_token"})
    public void getWalletTest(String url, String api_token) {
        String endpoint = url + "profile/wallet";
        Map<String, Object> response =
                PayloadBuilder.readPayloadFromResponseAsObject(RequestBuilder.request(api_token, endpoint).asString());
        Assert.assertEquals(response.get("message"), "Successful");
    }
}
