package adjutorApiTest;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.PayloadBuilder;

import java.util.Map;

public class DataForLendersTest extends Base {

    @Test
    @Parameters({"url", "api_token"})
    public void optionsTest(String url, String api_token) {
        String endpoint = url + "data/options";
        Map<String, Object> response =
                PayloadBuilder.readPayloadFromResponseAsObject(RequestBuilder.request(api_token, endpoint).asString());
        Assert.assertEquals(response.get("success"), true);
    }

    @Test
    @Parameters({"url", "api_token"})
    public void usersTest(String url, String api_token) {
        String endpoint = url + "data/users";
        Map<String, Object> response =
                PayloadBuilder.readPayloadFromResponseAsObject(RequestBuilder.request(api_token, endpoint).asString());
        Assert.assertEquals(response.get("success"), true);
    }
}
