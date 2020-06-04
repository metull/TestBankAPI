package Test;

import BaseTest.ExampleRequest;
import BaseTest.ExamplesParsingRequestBody;
import SettersAndGetters.SettersAndGetters;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Link;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static SettersAndGetters.SettersAndGetters.getResponse;

public class TestOnBeck {

    ExamplesParsingRequestBody parse = new ExamplesParsingRequestBody();
    SettersAndGetters setAndGet = new SettersAndGetters();

    @Link(name = "Запрос юзеров", url = "https://reqres.in/api/users?page=2")
    @Test(description = "Get users list")
    public void getUsers() throws IOException {
        ExampleRequest.getInstance().startGETTest(setAndGet.endpointGetUsers);
        Map map = new ObjectMapper().readValue(getResponse(), HashMap.class);

        if (!parse.recursiveObjectCheck(map)) throw new RuntimeException();
    }

    @Link(name = "Создание пользователя", url = "https://reqres.in/api/users")
    @Test(description = "Create user")
    public void createUser() {
        ExampleRequest.getInstance().startPOSTTest(HttpStatus.SC_CREATED, setAndGet.createUserBody, setAndGet.endpointCreateUsers);

        // Не понял что надо сравнить. В ответе на POST запрос "{\"name\": \"morpheus\", \"job\": \"leader\"}"
        // приходит {"id":"117","createdAt":"2020-06-04T10:26:15.131Z"}
    }
}
