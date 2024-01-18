package todoList.simulation;

import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.core.*;

import static io.gatling.javaapi.core.CoreDsl.atOnceUsers;

import todoList.config.BaseHelpers;
import todoList.scenarios.ToDoListScenarios;

public class BasicLoadSimulation extends Simulation {
    private final ScenarioBuilder scn = new ToDoListScenarios().scnFullToDoList();
    
    {
        setUp(
            scn.injectOpen(atOnceUsers(1))
        ).protocols(new BaseHelpers().httpProtocol);
    }
}
