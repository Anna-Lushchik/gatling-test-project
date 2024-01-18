package todoList.simulation;

import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import todoList.config.BaseHelpers;
import todoList.scenarios.ToDoListScenarios;

import static io.gatling.javaapi.core.CoreDsl.constantUsersPerSec;
import static io.gatling.javaapi.core.CoreDsl.nothingFor;
import static io.gatling.javaapi.core.CoreDsl.rampUsers;
import static io.gatling.javaapi.core.OpenInjectionStep.atOnceUsers;

public class RandomSimulation extends Simulation {
    private final ScenarioBuilder scn = new ToDoListScenarios().scnFullToDoList();
    
    {
        setUp(
            scn.injectOpen(
                nothingFor(this.getRandomNumber(1, 30)),
                atOnceUsers(this.getRandomNumber(1, 30)),
                rampUsers(this.getRandomNumber(1, 30)).during(this.getRandomNumber(1, 30)),
                constantUsersPerSec(this.getRandomNumber(1, 30)).during(this.getRandomNumber(1, 30)),
                nothingFor(this.getRandomNumber(1, 30)),
                rampUsers(this.getRandomNumber(1, 30)).during(this.getRandomNumber(1, 30)))
        ).protocols(new BaseHelpers().httpProtocol);
    }
    
    private int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
