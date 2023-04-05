package hubspotformsimulation;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;

import java.util.concurrent.ThreadLocalRandom;

import java.util.Arrays;

public class HubspotHostedFormSimulation extends Simulation {
  int NUMBER_OF_TESTS = 1;
  int PERIOD_TO_SPREAD_TESTS_OVER_IN_SECONDS = 1;
  ChainBuilder submit = exec(
                          http("Form")
                            .get("/1JFQbjrblSeCcRLwUvqqLEAebia9")
                            .check(status().is(200))) // Check that the response status is 200
                          .exec(
                            http("Submit")
                              .post("/1JFQbjrblSeCcRLwUvqqLEAebia9")
                              .formParam("company-input", "Test 2")
                              .formParam("email-input", "TestEmail@gmail.com")
                              .formParam("state-input", "Alabama")
                              .formParam("hs_lead_status-input-1", "NEW")
                              .multivaluedFormParam("tags-input-1", Arrays.asList("ex-entrepreneur"))
                              .check(status().is(200)))
                              .exitHereIfFailed();

  HttpProtocolBuilder httpProtocol =
    http.baseUrl("https://share.hsforms.com")
      .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
      .acceptLanguageHeader("en-US,en;q=0.5")
      .acceptEncodingHeader("gzip, deflate")
      .userAgentHeader(
          "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0"
      );

  ScenarioBuilder users = scenario("PerformanceTesting").exec(submit);

  {
    setUp(
      users.injectOpen(rampUsers(NUMBER_OF_TESTS).during(PERIOD_TO_SPREAD_TESTS_OVER_IN_SECONDS))
    ).protocols(httpProtocol);
  }
}
