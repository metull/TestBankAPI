package Attachment;

import com.jayway.restassured.response.Headers;
import io.qameta.allure.Attachment;

import static Constants.Constants.getResponse;

public class AttachmentAllure {

    @Attachment(value = "Отправляемое тело запроса и заголовки", type = "application/json")
    private String getJsonRequest(String request) {
        System.out.println("Отправляемое тело запроса\n" + request);
        return request;
    }

    @Attachment(value = "Полученный ответ от сервера", type = "application/json")
    private String getJsonResponse(String response) {
        System.out.println("Полученный ответ от сервера\n" + response);
        return response;
    }

    public void requestFromAttach(Headers response, String body) {
        String result = "Request Headers: \r\n\t " + response;
        if (body != null) {
            result = result + "\nRequest Body: \r\n\t " + body;
        }
        getJsonRequest(result);
        getJsonResponse(getResponse());
    }
}
