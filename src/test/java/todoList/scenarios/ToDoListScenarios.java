package todoList.scenarios;

import io.gatling.javaapi.core.ScenarioBuilder;

import static io.gatling.javaapi.core.CoreDsl.RawFileBody;
import static io.gatling.javaapi.core.CoreDsl.StringBody;
import static io.gatling.javaapi.core.CoreDsl.scenario;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

import todoList.config.BaseHelpers;

public class ToDoListScenarios {
    
    public ScenarioBuilder scnFullToDoList() {
        return scenario("FullToDoList")
                .exec(
                        http("All todo list")
                            .get("")
                            .check(status().is(200)),
                        BaseHelpers.thinkTimer(),
                        http("Get todo item with ID 1")
                            .get("/1")
                            .check(status().is(200)),
                        BaseHelpers.thinkTimer(),
                        http("Add todo list")
                            .post("")
                            .body(RawFileBody("PostToDoListData.json")).asJson()
                            .check(status().is(201)),
                        BaseHelpers.thinkTimer(),
                        http("Update todo item with ID 2")
                            .put("/2")
                            .body(StringBody("{\"text\":\"Take out the trash\",\"id\":2,\"priority\":1}")).asJson()
                            .check(status().is(200)),
                        BaseHelpers.thinkTimer(),
                        http("Delete todo item with ID 4")
                            .delete("/3")
                            .check(status().is(204)));
    }
    
    public ScenarioBuilder scnGetAllToDoList() {
        return scenario("GetAllToDoList")
                .exec(http("All todo list").get("")
                                           .check(status().is(200)));
    }
}
