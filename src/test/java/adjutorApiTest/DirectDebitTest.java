package adjutorApiTest;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.PayloadBuilder;

import java.util.Map;

public class DirectDebitTest extends Base {

    @Test
    @Parameters({"url", "api_token"})
    public void getAllBanksTest(String url, String api_token) {
        String endpoint = url + "direct-debit/banks";
        Map<String, Object> response =
                PayloadBuilder.readPayloadFromResponseAsObject(RequestBuilder.queryRequest(api_token, endpoint, "100", "1", "ASC").asString());
        Assert.assertEquals(response.get("message"), "Successful");
    }

    @Test
    @Parameters({"url", "api_token"})
    public void getDetailsOfABankTest(String url, String api_token) {
        String endpoint = url + "direct-debit/banks/" + "1";
        Map<String, Object> response =
                PayloadBuilder.readPayloadFromResponseAsObject(RequestBuilder.request(api_token, endpoint).asString());
        Assert.assertEquals(response.get("message"), "Successful");
    }
}
