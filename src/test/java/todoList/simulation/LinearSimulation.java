package todoList.simulation;

import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import todoList.config.BaseHelpers;
import todoList.scenarios.ToDoListScenarios;

import static io.gatling.javaapi.core.CoreDsl.incrementUsersPerSec;

public class LinearSimulation extends Simulation {
    private final ScenarioBuilder scn = new ToDoListScenarios().scnFullToDoList();
    
    {
        setUp(
            scn.injectOpen(
                incrementUsersPerSec(5)
                    .times(10)
                    .eachLevelLasting(10)
                    .startingFrom(5))
        ).protocols(new BaseHelpers().httpProtocol);
    }
}
