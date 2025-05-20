package ifellow.rickandmorty.api;

import ifellow.rickandmorty.dto.Character;
import ifellow.rickandmorty.dto.Episode;
import io.restassured.response.ValidatableResponse;

import java.net.URL;
import java.util.List;

import static io.restassured.RestAssured.*;

import io.restassured.common.mapper.TypeRef;

public class EpisodeAPI extends BaseAPI {

    private static final String ENDPOINT = "/episode";

    public List<Episode> getEpisodes(String name) {
        ValidatableResponse validatableResponse = given().queryParam("name", name)
                .when().get(ENDPOINT)
                .then();
        return validatableResponse.extract().as(new TypeRef<List<Episode>>() {
        });
    }

    public Episode getEpisodeByURL(URL url) {
        return given()
                .when()
                .get(url)
                .then().extract().as(Episode.class);
    }


}
