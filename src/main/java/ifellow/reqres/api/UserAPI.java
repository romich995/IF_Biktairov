package ifellow.reqres.api;

import ifellow.reqres.dto.UserGet;
import ifellow.reqres.dto.UserPost;
import io.restassured.http.Header;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;

public class UserAPI extends BaseAPI {
    private static final String ENDPOINT = "/users";

    public ValidatableResponse createUser(UserPost userPost) {
        return given()
                .header("x-api-key", "reqres-free-v1")
                .body(userPost)
                .when()
                .post(ENDPOINT)
                .then();
    }
}
