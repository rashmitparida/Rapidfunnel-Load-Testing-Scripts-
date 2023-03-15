package RapidfunnelUserClickPaths.Simulation;

import io.gatling.javaapi.core.Choice;
import io.gatling.javaapi.core.ScenarioBuilder;
import static io.gatling.javaapi.core.CoreDsl.*;
import java.time.Duration;
public class TestScenario {

    private static final Duration TEST_DURATION = Duration.ofSeconds(Integer.parseInt(System.getProperty("DURATION", "60")));
    public static ScenarioBuilder defaultLoadTest =
            scenario("Default Load Test")
                    .during(TEST_DURATION)
                    .on(
                            randomSwitch()
                                    .on(
                                            Choice.withWeight(60, exec(UserJourney_Contacts.CasualVisit)),
                                            Choice.withWeight(30, exec(UserJourney_Contacts.UserAddsSingleContact)),
                                            Choice.withWeight(10, exec(UserJourney_Contacts.UserAddsMultipleContact))
                                    )
                    );

    public static ScenarioBuilder MultipleContactsAddedLoadTest =
            scenario("High Purchase Load Test")
                    .during(TEST_DURATION)
                    .on(
                            randomSwitch()
                                    .on(
                                            Choice.withWeight(20, exec(UserJourney_Contacts.CasualVisit)),
                                            Choice.withWeight(30, exec(UserJourney_Contacts.UserAddsSingleContact)),
                                            Choice.withWeight(50, exec(UserJourney_Contacts.UserAddsMultipleContact))
                                    )
                    );
}
