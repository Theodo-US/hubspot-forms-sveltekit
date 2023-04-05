package hubspotformsimulation;

import java.time.Duration;
import java.util.*;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;
import io.gatling.javaapi.jdbc.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;
import static io.gatling.javaapi.jdbc.JdbcDsl.*;

public class RecordedSimulation extends Simulation {

  {
    HttpProtocolBuilder httpProtocol = http
      .baseUrl("https://forms.hsforms.com")
      .inferHtmlResources()
    ;
    
    Map<CharSequence, String> headers_0 = new HashMap<>();
    headers_0.put("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7");
    headers_0.put("accept-encoding", "gzip, deflate, br");
    headers_0.put("accept-language", "en-US,en;q=0.9");
    headers_0.put("sec-ch-ua", "Google Chrome\";v=\"111\", \"Not(A:Brand\";v=\"8\", \"Chromium\";v=\"111");
    headers_0.put("sec-ch-ua-mobile", "?0");
    headers_0.put("sec-ch-ua-platform", "macOS");
    headers_0.put("sec-fetch-dest", "document");
    headers_0.put("sec-fetch-mode", "navigate");
    headers_0.put("sec-fetch-site", "cross-site");
    headers_0.put("sec-fetch-user", "?1");
    headers_0.put("upgrade-insecure-requests", "1");
    headers_0.put("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/111.0.0.0 Safari/537.36");
    
    Map<CharSequence, String> headers_2 = new HashMap<>();
    headers_2.put("accept", "*/*");
    headers_2.put("accept-encoding", "gzip, deflate, br");
    headers_2.put("accept-language", "en-US,en;q=0.9");
    headers_2.put("sec-ch-ua", "Google Chrome\";v=\"111\", \"Not(A:Brand\";v=\"8\", \"Chromium\";v=\"111");
    headers_2.put("sec-ch-ua-mobile", "?0");
    headers_2.put("sec-ch-ua-platform", "macOS");
    headers_2.put("sec-fetch-dest", "script");
    headers_2.put("sec-fetch-mode", "no-cors");
    headers_2.put("sec-fetch-site", "cross-site");
    headers_2.put("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/111.0.0.0 Safari/537.36");
    
    Map<CharSequence, String> headers_6 = new HashMap<>();
    headers_6.put("accept", "*/*");
    headers_6.put("accept-encoding", "gzip, deflate, br");
    headers_6.put("accept-language", "en-US,en;q=0.9");
    headers_6.put("origin", "https://share.hsforms.com");
    headers_6.put("sec-ch-ua", "Google Chrome\";v=\"111\", \"Not(A:Brand\";v=\"8\", \"Chromium\";v=\"111");
    headers_6.put("sec-ch-ua-mobile", "?0");
    headers_6.put("sec-ch-ua-platform", "macOS");
    headers_6.put("sec-fetch-dest", "script");
    headers_6.put("sec-fetch-mode", "cors");
    headers_6.put("sec-fetch-site", "cross-site");
    headers_6.put("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/111.0.0.0 Safari/537.36");
    
    Map<CharSequence, String> headers_8 = new HashMap<>();
    headers_8.put("accept", "application/json, text/plain, */*");
    headers_8.put("accept-encoding", "gzip, deflate, br");
    headers_8.put("accept-language", "en-US,en;q=0.9");
    headers_8.put("origin", "https://share.hsforms.com");
    headers_8.put("sec-ch-ua", "Google Chrome\";v=\"111\", \"Not(A:Brand\";v=\"8\", \"Chromium\";v=\"111");
    headers_8.put("sec-ch-ua-mobile", "?0");
    headers_8.put("sec-ch-ua-platform", "macOS");
    headers_8.put("sec-fetch-dest", "empty");
    headers_8.put("sec-fetch-mode", "cors");
    headers_8.put("sec-fetch-site", "cross-site");
    headers_8.put("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/111.0.0.0 Safari/537.36");
    
    Map<CharSequence, String> headers_9 = new HashMap<>();
    headers_9.put("accept", "application/json, text/plain, */*");
    headers_9.put("accept-encoding", "gzip, deflate, br");
    headers_9.put("accept-language", "en-US,en;q=0.9");
    headers_9.put("origin", "https://share.hsforms.com");
    headers_9.put("sec-ch-ua", "Google Chrome\";v=\"111\", \"Not(A:Brand\";v=\"8\", \"Chromium\";v=\"111");
    headers_9.put("sec-ch-ua-mobile", "?0");
    headers_9.put("sec-ch-ua-platform", "macOS");
    headers_9.put("sec-fetch-dest", "empty");
    headers_9.put("sec-fetch-mode", "cors");
    headers_9.put("sec-fetch-site", "same-site");
    headers_9.put("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/111.0.0.0 Safari/537.36");
    
    Map<CharSequence, String> headers_10 = new HashMap<>();
    headers_10.put("accept", "image/avif,image/webp,image/apng,image/svg+xml,image/*,*/*;q=0.8");
    headers_10.put("accept-encoding", "gzip, deflate, br");
    headers_10.put("accept-language", "en-US,en;q=0.9");
    headers_10.put("sec-ch-ua", "Google Chrome\";v=\"111\", \"Not(A:Brand\";v=\"8\", \"Chromium\";v=\"111");
    headers_10.put("sec-ch-ua-mobile", "?0");
    headers_10.put("sec-ch-ua-platform", "macOS");
    headers_10.put("sec-fetch-dest", "image");
    headers_10.put("sec-fetch-mode", "no-cors");
    headers_10.put("sec-fetch-site", "cross-site");
    headers_10.put("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/111.0.0.0 Safari/537.36");
    
    Map<CharSequence, String> headers_11 = new HashMap<>();
    headers_11.put("accept", "image/avif,image/webp,image/apng,image/svg+xml,image/*,*/*;q=0.8");
    headers_11.put("accept-encoding", "gzip, deflate, br");
    headers_11.put("accept-language", "en-US,en;q=0.9");
    headers_11.put("sec-ch-ua", "Google Chrome\";v=\"111\", \"Not(A:Brand\";v=\"8\", \"Chromium\";v=\"111");
    headers_11.put("sec-ch-ua-mobile", "?0");
    headers_11.put("sec-ch-ua-platform", "macOS");
    headers_11.put("sec-fetch-dest", "image");
    headers_11.put("sec-fetch-mode", "no-cors");
    headers_11.put("sec-fetch-site", "same-site");
    headers_11.put("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/111.0.0.0 Safari/537.36");
    
    Map<CharSequence, String> headers_16 = new HashMap<>();
    headers_16.put("accept", "application/json, text/plain, */*");
    headers_16.put("accept-encoding", "gzip, deflate, br");
    headers_16.put("accept-language", "en-US,en;q=0.9");
    headers_16.put("content-type", "text/plain");
    headers_16.put("origin", "https://share.hsforms.com");
    headers_16.put("sec-ch-ua", "Google Chrome\";v=\"111\", \"Not(A:Brand\";v=\"8\", \"Chromium\";v=\"111");
    headers_16.put("sec-ch-ua-mobile", "?0");
    headers_16.put("sec-ch-ua-platform", "macOS");
    headers_16.put("sec-fetch-dest", "empty");
    headers_16.put("sec-fetch-mode", "cors");
    headers_16.put("sec-fetch-site", "same-site");
    headers_16.put("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/111.0.0.0 Safari/537.36");
    
    Map<CharSequence, String> headers_18 = new HashMap<>();
    headers_18.put("accept", "application/json, text/plain, */*");
    headers_18.put("accept-encoding", "gzip, deflate, br");
    headers_18.put("accept-language", "en-US,en;q=0.9");
    headers_18.put("content-type", "multipart/form-data; boundary=----WebKitFormBoundary3sMkAWnJlmBmTTYP");
    headers_18.put("origin", "https://share.hsforms.com");
    headers_18.put("sec-ch-ua", "Google Chrome\";v=\"111\", \"Not(A:Brand\";v=\"8\", \"Chromium\";v=\"111");
    headers_18.put("sec-ch-ua-mobile", "?0");
    headers_18.put("sec-ch-ua-platform", "macOS");
    headers_18.put("sec-fetch-dest", "empty");
    headers_18.put("sec-fetch-mode", "cors");
    headers_18.put("sec-fetch-site", "same-site");
    headers_18.put("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/111.0.0.0 Safari/537.36");
    
    String uri01 = "https://forms.hscollectedforms.net/collected-forms/v1/config/json";
    
    String uri02 = "https://js.hs-banner.com/v2/24051537/banner.js";
    
    String uri04 = "https://js.hsforms.net/forms/embed/v3.js";
    
    String uri05 = "https://forms-na1.hsforms.com/embed/v3/counters.gif";
    
    String uri06 = "https://js.hsleadflows.net/leadflows.js";
    
    String uri07 = "https://track.hubspot.com/__ptq.gif";
    
    String uri08 = "https://js.hs-scripts.com/24051537.js";
    
    String uri09 = "https://share.hsforms.com";
    
    String uri10 = "https://js.hscollectedforms.net/collectedforms.js";
    
    String uri11 = "https://js.hs-analytics.net/analytics/1680704400000/24051537.js";

    ScenarioBuilder scn = scenario("RecordedSimulation")
      .exec(
        http("request_0")
          .get(uri09 + "/1JFQbjrblSeCcRLwUvqqLEAebia9")
          .headers(headers_0)
          .resources(
            http("request_1")
              .get(uri08),
            http("request_2")
              .get(uri04)
              .headers(headers_2),
            http("request_3")
              .get(uri10),
            http("request_4")
              .get(uri02),
            http("request_5")
              .get(uri11),
            http("request_6")
              .get(uri06)
              .headers(headers_6),
            http("request_7")
              .get(uri09 + "/favicon.ico"),
            http("request_8")
              .get(uri01 + "?portalId=24051537&utk=07fd97de31974fba614626121e954b62")
              .headers(headers_8),
            http("request_9")
              .get("/embed/v3/form/24051537/24541b8e-b6e5-49e0-9c44-bc14beaa8b10/json?hs_static_app=forms-embed&hs_static_app_version=1.2933&X-HubSpot-Static-App-Info=forms-embed-1.2933&hutk=07fd97de31974fba614626121e954b62")
              .headers(headers_9),
            http("request_10")
              .get(uri07 + "?k=1&sd=1512x982&cd=30-bit&cs=UTF-8&ln=en-us&bfp=862196976&v=1.1&a=24051537&ccu=https%3A%2F%2Fshare.hsforms.com%2F1JFQbjrblSeCcRLwUvqqLEAebia9&r=https%3A%2F%2Fapp.hubspot.com%2F&pu=https%3A%2F%2Fshare.hsforms.com%2F1JFQbjrblSeCcRLwUvqqLEAebia9&t=Form&cts=1680704518497&vi=07fd97de31974fba614626121e954b62&nc=false&u=251652889.07fd97de31974fba614626121e954b62.1680556558709.1680699973597.1680703145464.7&b=251652889.6.1680703145464&cc=15")
              .headers(headers_10),
            http("request_11")
              .get(uri05 + "?key=forms-embed-v3-DEFINITION_SUCCESS&count=1")
              .headers(headers_11),
            http("request_12")
              .get("/embed/v3/counters.gif?key=collected-forms-embed-js-form-bind&count=1")
              .headers(headers_11),
            http("request_13")
              .get(uri05 + "?key=forms-embed-v3-RENDER_SUCCESS&count=1")
              .headers(headers_11),
            http("request_14")
              .get(uri07 + "?k=15&fi=24541b8e-b6e5-49e0-9c44-bc14beaa8b10&fci=627d33f0-9cf8-4d16-9485-d9e31a1d1e03&ft=0&sd=1512x982&cd=30-bit&cs=UTF-8&ln=en-us&bfp=862196976&v=1.1&a=24051537&ccu=https%3A%2F%2Fshare.hsforms.com%2F1JFQbjrblSeCcRLwUvqqLEAebia9&r=https%3A%2F%2Fapp.hubspot.com%2F&pu=https%3A%2F%2Fshare.hsforms.com%2F1JFQbjrblSeCcRLwUvqqLEAebia9&t=Form&cts=1680704518555&vi=07fd97de31974fba614626121e954b62&nc=false&u=251652889.07fd97de31974fba614626121e954b62.1680556558709.1680699973597.1680703145464.7&b=251652889.6.1680703145464&cc=15")
              .headers(headers_10),
            http("request_15")
              .get(uri07 + "?k=17&fi=24541b8e-b6e5-49e0-9c44-bc14beaa8b10&fci=627d33f0-9cf8-4d16-9485-d9e31a1d1e03&ft=0&sd=1512x982&cd=30-bit&cs=UTF-8&ln=en-us&bfp=862196976&v=1.1&a=24051537&ccu=https%3A%2F%2Fshare.hsforms.com%2F1JFQbjrblSeCcRLwUvqqLEAebia9&r=https%3A%2F%2Fapp.hubspot.com%2F&pu=https%3A%2F%2Fshare.hsforms.com%2F1JFQbjrblSeCcRLwUvqqLEAebia9&t=Form&cts=1680704518556&vi=07fd97de31974fba614626121e954b62&nc=false&u=251652889.07fd97de31974fba614626121e954b62.1680556558709.1680699973597.1680703145464.7&b=251652889.6.1680703145464&cc=15")
              .headers(headers_10),
            http("request_16")
              .post("/emailcheck/v1/json-ext?hs_static_app=forms-embed&hs_static_app_version=1.2933&X-HubSpot-Static-App-Info=forms-embed-1.2933&portalId=24051537&formId=24541b8e-b6e5-49e0-9c44-bc14beaa8b10&includeFreemailSuggestions=true")
              .headers(headers_16)
              .body(StringBody("test@theodo.com")),
            http("request_17")
              .get(uri07 + "?k=18&fi=24541b8e-b6e5-49e0-9c44-bc14beaa8b10&fci=627d33f0-9cf8-4d16-9485-d9e31a1d1e03&ft=0&sd=1512x982&cd=30-bit&cs=UTF-8&ln=en-us&bfp=862196976&v=1.1&a=24051537&ccu=https%3A%2F%2Fshare.hsforms.com%2F1JFQbjrblSeCcRLwUvqqLEAebia9&r=https%3A%2F%2Fapp.hubspot.com%2F&pu=https%3A%2F%2Fshare.hsforms.com%2F1JFQbjrblSeCcRLwUvqqLEAebia9&t=Form&cts=1680704519760&vi=07fd97de31974fba614626121e954b62&nc=false&u=251652889.07fd97de31974fba614626121e954b62.1680556558709.1680699973597.1680703145464.7&b=251652889.6.1680703145464&cc=15")
              .headers(headers_10)
          )
      )
      .exec(
        http("request_18")
          .post("/submissions/v3/public/submit/formsnext/multipart/24051537/24541b8e-b6e5-49e0-9c44-bc14beaa8b10/json?hs_static_app=forms-embed&hs_static_app_version=1.2933&X-HubSpot-Static-App-Info=forms-embed-1.2933")
          .headers(headers_18)
          .body(RawFileBody("0018_request.json"))
          .resources(
            http("request_19")
              .get(uri05 + "?key=forms-embed-v3-SUBMISSION_SUCCESS&count=1")
              .headers(headers_11)
          )
      );

    int NUMBER_OF_TESTS = 100;
    int PERIOD_TO_SPREAD_TESTS_OVER_IN_SECONDS = 20;
	  setUp(scn.injectOpen(rampUsers(NUMBER_OF_TESTS).during(PERIOD_TO_SPREAD_TESTS_OVER_IN_SECONDS))).protocols(httpProtocol);
  }
}
