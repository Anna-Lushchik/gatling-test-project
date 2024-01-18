package todoList.config;

import io.gatling.javaapi.core.ChainBuilder;
import io.gatling.javaapi.http.HttpProtocolBuilder;

import static io.gatling.javaapi.core.CoreDsl.pause;
import static io.gatling.javaapi.http.HttpDsl.http;

public class BaseHelpers {
   
    public HttpProtocolBuilder httpProtocol = http
            .baseUrl("http://localhost:5050/api/ToDoList")
            .inferHtmlResources()
            .acceptHeader("application/json")
            .acceptEncodingHeader("gzip, deflate, br")
            .acceptLanguageHeader("ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7")
            .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");
    
    public static ChainBuilder thinkTimer(){
        return pause(2, 50);
    }
}
