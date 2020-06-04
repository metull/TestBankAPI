package BaseTest;

import Attachment.AttachmentAllure;
import SettersAndGetters.SettersAndGetters;
import com.jayway.restassured.response.Response;
import org.apache.http.HttpStatus;

import static SettersAndGetters.SettersAndGetters.setResponse;
import static com.jayway.restassured.RestAssured.expect;

public class ExampleRequest {

    private final static ExampleRequest instance = new ExampleRequest();
    private SettersAndGetters setAndGet = new SettersAndGetters();
    private AttachmentAllure attach = new AttachmentAllure();

    public static ExampleRequest getInstance() {
        return instance;
    }

    public Response response;

    public void startPOSTTest(int statusCode, String body, String endpoint) {
        response = expect()
                .statusCode(statusCode)
                .given()
                .that()
                .when()
                .body(body)
                .log().all()
                .post(setAndGet.baseUrl + endpoint);
        setResponse(response.getBody().asString());
        attach.requestFromAttach(response.getHeaders(), body);
    }

    public void startGETTest(String endpoint) {
        response = expect()
                .statusCode(HttpStatus.SC_OK)
                .given()
                .that()
                .when()
                .log().all()
                .get(setAndGet.baseUrl + endpoint);
        setResponse(response.getBody().asString());
        attach.requestFromAttach(response.getHeaders(), null);
    }
}
