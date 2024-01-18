package todoList.simulation;

import io.gatling.javaapi.core.CoreDsl;
import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import todoList.config.BaseHelpers;
import todoList.scenarios.ToDoListScenarios;

public class StressSimulation extends Simulation {
    private final ScenarioBuilder scn = new ToDoListScenarios().scnGetAllToDoList();
    
    {
        setUp(
            scn.injectOpen(CoreDsl.constantUsersPerSec(50).during(300))
        ).protocols(new BaseHelpers().httpProtocol);
    }
}
