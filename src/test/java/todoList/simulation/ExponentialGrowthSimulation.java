package todoList.simulation;

import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import todoList.config.BaseHelpers;
import todoList.scenarios.ToDoListScenarios;

import static io.gatling.javaapi.core.CoreDsl.incrementUsersPerSec;

public class ExponentialGrowthSimulation extends Simulation {
    private final ScenarioBuilder scn = new ToDoListScenarios().scnFullToDoList();
    
    {
        setUp(
            scn.injectOpen(
                    incrementUsersPerSec(Math.toDegrees(Math. exp(1.0)))
                            .times(10)
                            .eachLevelLasting(10)
                            .startingFrom(0))
        ).protocols(new BaseHelpers().httpProtocol);
    }
}
