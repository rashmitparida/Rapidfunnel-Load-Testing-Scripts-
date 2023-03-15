package RapidfunnelUserClickPaths;

import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;
import static io.gatling.javaapi.http.HttpDsl.*;
import RapidfunnelUserClickPaths.Simulation.*;

public class RapidFunnelSimulation extends Simulation{

    private static final String TEST_TYPE = System.getProperty("TEST_TYPE", "INSTANT_USERS");
    private static final String DOMAIN = "s1apiv2.rapidfunnel.com";

    private HttpProtocolBuilder httpProtocol = http
            .baseUrl("https://" +DOMAIN)
            .authorizationHeader("");
    {
        if (TEST_TYPE == "INSTANT_USERS") {
            setUp(TestPopulation.instantUsers).protocols(httpProtocol);
        } else if (TEST_TYPE == "RAMP_USERS") {
            setUp(TestPopulation.rampUsers).protocols(httpProtocol);
        } else if (TEST_TYPE == "COMPLEX_INJECTION") {
            setUp(TestPopulation.complexInjection).protocols(httpProtocol);
        } else if (TEST_TYPE == "CLOSED_MODEL") {
            setUp(TestPopulation.closedModel).protocols(httpProtocol);
        } else {
            setUp(TestPopulation.instantUsers).protocols(httpProtocol);
        }
    }
}
