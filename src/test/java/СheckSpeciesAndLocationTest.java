import ifellow.rickandmorty.api.CharacterAPI;
import ifellow.rickandmorty.dto.Character;
import ifellow.rickandmorty.dto.Episode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class СheckSpeciesAndLocationTest {
    CharacterAPI characterAPI = new CharacterAPI();

    @Test
    public void checkSpeciesAndLocationTest() {
        Character mortySmith = characterAPI.getMortySmith();
        Episode episode = mortySmith.getLastEpisode();
        Character lastCharacter = episode.getLastCharacter();
        Assertions.assertEquals(lastCharacter.species, mortySmith.species);
        Assertions.assertNotEquals(lastCharacter.location.url, mortySmith.location.url);
    }
}
