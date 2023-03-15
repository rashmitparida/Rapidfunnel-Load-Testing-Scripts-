package RapidfunnelUserClickPaths.Simulation;

import io.gatling.javaapi.core.ChainBuilder;
import java.time.Duration;
import RapidfunnelUserClickPaths.Scenarios.*;
import static io.gatling.javaapi.core.CoreDsl.*;

public class UserJourney_Contacts {

    private static final Duration LOW_PAUSE = Duration.ofMillis(1000);
    private static final Duration HIGH_PAUSE = Duration.ofMillis(3000);

    public static ChainBuilder CasualVisit =
                     exec(UserAPI.Login)
                    .pause(HIGH_PAUSE)
                    .exec(DashboardAPI.LoadDashboardScreen)
                    .pause(LOW_PAUSE, HIGH_PAUSE)
                    .exec(DashboardAPI.NavigateToResourceScreen)
                    .pause(HIGH_PAUSE)
                    .exec(CloseApp.Close);


    public static ChainBuilder UserAddsSingleContact =
                     exec(UserAPI.Login)
                    .pause(HIGH_PAUSE)
                    .exec(DashboardAPI.LoadDashboardScreen)
                    .pause(LOW_PAUSE)
                    .exec(ContactsAPI.AddContact)
                    .pause(LOW_PAUSE, HIGH_PAUSE)
                    .exec(CloseApp.Close);

    public static ChainBuilder UserAddsMultipleContact =
                     exec(UserAPI.Login)
                    .pause(HIGH_PAUSE)
                    .exec(DashboardAPI.LoadDashboardScreen)
                    .pause(HIGH_PAUSE)
                    .exec(ContactsAPI.AddContact)
                    .pause(LOW_PAUSE, HIGH_PAUSE)
                    .exec(DashboardAPI.LoadDashboardScreen)
                    .pause(HIGH_PAUSE)
                             .repeat(5).on(exec(ContactsAPI.AddContact)
                                     .pause(LOW_PAUSE,HIGH_PAUSE)
                                     .exec(DashboardAPI.LoadDashboardScreen)
                                     .pause(HIGH_PAUSE)
                                     .exec(DashboardAPI.NavigateToResourceScreen)
                                     .pause(HIGH_PAUSE))
                    .exec(CloseApp.Close);
}
