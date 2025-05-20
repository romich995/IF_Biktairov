package ifellow.rickandmorty.api;

import ifellow.rickandmorty.dto.Character;

import java.net.URL;

import static io.restassured.RestAssured.*;


public class CharacterAPI extends BaseAPI {

    private static final String ENDPOINT = "/character";

    public Character getCharacterByURL(URL url) {
        return given()
                .when()
                .get(url)
                .then().extract().as(Character.class);
    }

    public Character getMortySmith() {
        return given()
                .when()
                .get("/character/2")
                .then()
                .extract()
                .as(Character.class);
    }
}
