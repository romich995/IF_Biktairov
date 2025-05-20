package ifellow.rickandmorty.api;

import ifellow.rickandmorty.dto.Character;

import javax.swing.text.html.HTMLDocument;
import java.net.URL;

import static io.restassured.RestAssured.*;


public class CharacterAPI extends BaseAPI {
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
