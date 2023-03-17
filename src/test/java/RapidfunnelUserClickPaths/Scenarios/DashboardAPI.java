package RapidfunnelUserClickPaths.Scenarios;

import io.gatling.javaapi.core.ChainBuilder;
import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

public class DashboardAPI {
    public static ChainBuilder LoadDashboardScreen=
            exec(
                    http("Add a Contact")
                            .get("v2/contacts")
                            .check(status().not(404))
            );
    public static ChainBuilder NavigateToResourceScreen=
            exec(
                    http("Load Resource list")
                            .get("")
            );
}
