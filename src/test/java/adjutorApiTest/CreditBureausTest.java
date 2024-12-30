package adjutorApiTest;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.PayloadBuilder;

import java.util.Map;

public class CreditBureausTest extends Base {
    @Test
    @Parameters({"url", "bvn", "api_token"})
    public void getCreditReportFromCrcCreditBureauTest(String url, String bvn, String api_token) {
        String endpoint = url + "creditbureaus/crc/" + bvn;
        Map<String, Object> response =
                PayloadBuilder.readPayloadFromResponseAsObject(RequestBuilder.request(api_token, endpoint).asString());
        Assert.assertEquals(response.get("message"), "Successful");
    }

    @Test
    @Parameters({"url", "bvn", "api_token"})
    public void getCreditReportFromFirstCreditBureauTest(String url, String bvn, String api_token) {
        String endpoint = url + "creditbureaus/firstcentral/" + bvn;
        Map<String, Object> response =
                PayloadBuilder.readPayloadFromResponseAsObject(RequestBuilder.request(api_token, endpoint).asString());
        Assert.assertEquals(response.get("message"), "Successful");
    }
}
