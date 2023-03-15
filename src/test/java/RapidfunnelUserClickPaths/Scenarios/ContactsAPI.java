package RapidfunnelUserClickPaths.Scenarios;

import io.gatling.javaapi.core.ChainBuilder;
import io.gatling.javaapi.core.FeederBuilder;
import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

public class ContactsAPI {

    private static final FeederBuilder<String> ContactFeeder =
            csv("data/ContactDetails.json").random();
    public static ChainBuilder AddContact=
            exec(
                    http("Add a Contact")
                            .get("v2/contacts")
                            .check(status().not(404))
            );

}