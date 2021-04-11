package helpers;

import org.apache.http.HttpStatus;

import java.net.MalformedURLException;
import java.net.URL;

import static io.restassured.RestAssured.given;
import static tests.TestBase.MAIN_CONFIG;


public class BrowserstackHelper {

    public static final String APP_AUTOMATE_SESSIONS = "https://api-cloud.browserstack.com/app-automate/sessions/";

    public static String getBrowserstackVideoUrl(String sessionId) {
        String video_url = given()
                .auth().basic(MAIN_CONFIG.browserstackUser(), MAIN_CONFIG.browserstackKey())
                .when()
                .get(APP_AUTOMATE_SESSIONS + sessionId +".json")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response()
                .path("automation_session.video_url");

        System.out.println("video_url: " + video_url);
        return video_url;
    }

    public static String getBSPublicLink(String sessionId){
        String publicUrl = given()
                .auth().basic(MAIN_CONFIG.browserstackUser(), MAIN_CONFIG.browserstackKey())
                .when()
                .get(APP_AUTOMATE_SESSIONS + sessionId +".json")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response()
                .path("automation_session.public_url");

        System.out.println("bs_public_url: " + publicUrl);
        System.out.println("bs_build_url: " + publicUrl.split("/sessions/")[0]);
        return publicUrl;
    }

    public static URL getBrowserstackUrl() {
        try {
            return new URL("http://hub.browserstack.com/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
