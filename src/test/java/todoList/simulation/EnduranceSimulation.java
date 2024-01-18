package todoList.simulation;

import io.gatling.javaapi.core.CoreDsl;
import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import todoList.config.BaseHelpers;
import todoList.scenarios.ToDoListScenarios;

public class EnduranceSimulation extends Simulation {
    private final ScenarioBuilder scn = new ToDoListScenarios().scnGetAllToDoList();
    
    {
        setUp(
                scn.injectOpen(CoreDsl.constantUsersPerSec(10).during(1800))
        ).protocols(new BaseHelpers().httpProtocol);
    }
}
