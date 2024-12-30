package adjutorApiTest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import org.testng.Assert;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class RequestBuilder {

    public static RequestSpecification requestSpecification(String api_token) {
        return given()
                .header("Authorization", "Bearer " + api_token)
                .when();
    }

    public static RequestSpecification requestSpecification(String api_token, String limit,
                                                            String page,
                                                            String sort_dir) {
        return given()
                .header("Authorization", "Bearer " + api_token)
                .queryParam("limit", limit)
                .queryParam("page", page)
                .queryParam("sort_dir", sort_dir);
    }

    public static RequestSpecification koloRequestSpecification(String api_token,
                                                                String response_type,
                                                                String client_id,
                                                                String redirect_uri, String scope) {
        return given()
                .header("Authorization", "Bearer " + api_token)
                .queryParam("response_type", response_type)
                .queryParam("client_id", client_id)
                .queryParam("redirect_uri", redirect_uri)
                .queryParam("scope", scope);
    }

    public static RequestSpecification requestSpecification(String api_token,
                                                            Map<String, Object> payload) {
        return given()
                .header("Authorization", "Bearer " + api_token)
                .contentType(ContentType.JSON).when().body(payload);
    }

    public static Response request(String api_token, String endpoint, Map<String, Object> payload
            , String method) {
        RequestSpecification reqBody = requestSpecification(api_token, payload);
        QueryableRequestSpecification requestObj = SpecificationQuerier.query(reqBody);
        Reporter.testInfo("Request Body");
        Reporter.requestPayloadInfo(requestObj);
        Response resp;
        if(method == "POST") {
            resp = reqBody.post(endpoint);
        }else {
            resp = reqBody.put(endpoint);
        }
        Assert.assertEquals(resp.getStatusCode(), 200);
        Response response = resp.then().assertThat().statusCode(200).extract().response();
        Reporter.testInfo("Response Body");
        Reporter.responsePayloadInfo(response);
        return response;
    }

    public static Response queryRequest(String api_token, String endpoint, String limit,
                                        String page,
                                        String sort_dir) {
        RequestSpecification reqBody = requestSpecification(api_token, limit, page, sort_dir);
        Response resp = reqBody.get(endpoint);
        Assert.assertEquals(resp.getStatusCode(), 200);
        Response response = resp.then().assertThat().statusCode(200).extract().response();
        Reporter.testInfo("Response Body");
        Reporter.responsePayloadInfo(response);
        return response;
    }

    public static Response queryRequest(String api_token, String endpoint, String response_type,
                                    String client_id,
                                    String redirect_uri, String scope) {
        RequestSpecification reqBody = koloRequestSpecification(api_token, response_type, client_id,
                redirect_uri, scope);
        Response resp = reqBody.get(endpoint);
        Assert.assertEquals(resp.getStatusCode(), 200);
        Response response = resp.then().assertThat().statusCode(200).extract().response();
        Reporter.testInfo("Response Body");
        Reporter.responsePayloadInfo(response);
        return response;
    }

    public static Response request(String api_token, String endpoint) {
        RequestSpecification reqBody = requestSpecification(api_token);
        Response resp = reqBody.get(endpoint);
        Assert.assertEquals(resp.getStatusCode(), 200);
        Response response = resp.then().assertThat().statusCode(200).extract().response();
        Reporter.testInfo("Response Body");
        Reporter.responsePayloadInfo(response);
        return response;
    }

    public static Response advancedRequest(String api_token, String endpoint) {
        RequestSpecification reqBody = requestSpecification(api_token);
        Response resp = reqBody.get(endpoint);
        Assert.assertEquals(resp.getStatusCode(), 200);
        Response response = resp.then().assertThat().statusCode(200).extract().response();
        Reporter.testInfo("Response Body");
        Reporter.responsePayloadInfo(response);
        return response;
    }

    public static String authToken(String api_token, String endpoint, Map<String, Object> payload) {
        RequestSpecification reqBody = requestSpecification(api_token, payload);
        return reqBody.post(endpoint).getHeader("Authorization");
    }

}
