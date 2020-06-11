package Constants;

public class Constants {

    public String baseUrl = "https://reqres.in/";
    public String endpointGetUsers = "api/users?page=2";
    public String endpointCreateUsers = "api/users";
    public String endpointCreateUsers2 = "api/unknown/449";
    public String createUserBody = "{\"name\": \"morpheus\", \"job\": \"leader\"}";

    public static ThreadLocal<String> threadResponse = new ThreadLocal<String>();

    public static String getResponse()
    {
        return threadResponse.get();
    }

    public static void setResponse(String response)
    {
        threadResponse.set(response);
    }
}
