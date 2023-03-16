package RapidfunnelUserClickPaths.Scenarios;

import io.gatling.javaapi.core.ChainBuilder;
import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;
public class CloseApp {
    public static ChainBuilder Close=
            exec(http("Close the app ")
                    .get(""));

}
