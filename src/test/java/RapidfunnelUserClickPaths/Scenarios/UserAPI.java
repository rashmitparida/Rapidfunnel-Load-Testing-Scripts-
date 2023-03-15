package RapidfunnelUserClickPaths.Scenarios;

import io.gatling.javaapi.core.ChainBuilder;
import io.gatling.javaapi.core.FeederBuilder;

import static io.gatling.javaapi.core.CoreDsl.csv;
import static io.gatling.javaapi.core.CoreDsl.exec;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

public class UserAPI {

    private static final FeederBuilder<String> UserFeeder =
            csv("data/UserDetails.csv").circular();
    public static ChainBuilder Login =
            exec(
                    http("Login as a User")
                            .get("v2/user-login")
                            .check(status().not(404))
            );

}
