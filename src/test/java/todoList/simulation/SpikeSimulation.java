package todoList.simulation;

import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import todoList.config.BaseHelpers;
import todoList.scenarios.ToDoListScenarios;

import static io.gatling.javaapi.core.CoreDsl.atOnceUsers;
import static io.gatling.javaapi.core.CoreDsl.constantUsersPerSec;
import static io.gatling.javaapi.core.CoreDsl.nothingFor;

public class SpikeSimulation extends Simulation {
    private final ScenarioBuilder scn = new ToDoListScenarios().scnFullToDoList();
    
    {
        setUp(
            scn.injectOpen(
                    atOnceUsers(50),
                    nothingFor(10),
                    constantUsersPerSec(20).during(60))
        ).protocols(new BaseHelpers().httpProtocol);
    }
}
