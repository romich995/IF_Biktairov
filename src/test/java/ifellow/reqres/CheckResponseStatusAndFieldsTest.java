package ifellow.reqres;

import ifellow.reqres.api.UserAPI;
import ifellow.reqres.dto.UserFile;
import ifellow.reqres.dto.UserGet;
import ifellow.reqres.dto.UserPost;
import ifellow.util.JsonFromResources;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class CheckResponseStatusAndFieldsTest {

    UserAPI userAPI = new UserAPI();

    @Test
    public void checkResponseStatusAndFieldsTest() {
        UserFile userFile = JsonFromResources.readJson("data.json", UserFile.class);
        userFile.setName("Tomato");
        UserPost userPost = new UserPost();
        userPost.setName(userFile.getName());
        userPost.setJob("Eat maket");

        ValidatableResponse validatableResponse = userAPI.createUser(userPost);
        validatableResponse.statusCode(201);

        UserGet userGet = validatableResponse.extract().as(UserGet.class);
        Assertions.assertEquals("Tomato", userGet.name);
        Assertions.assertEquals("Eat maket", userGet.job);


    }
}
