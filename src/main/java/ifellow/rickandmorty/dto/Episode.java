package ifellow.rickandmorty.dto;

import ifellow.rickandmorty.api.CharacterAPI;
import lombok.Data;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;

@Data
public class Episode {
    public int id;
    public String name;
    public String air_date;
    public String episode;
    public ArrayList<URL> characters;
    public String url;
    public Date created;

    public Character getLastCharacter() {
        if (!characters.isEmpty()) {
            URL url = characters.get(characters.size() - 1);
            return new CharacterAPI().getCharacterByURL(url);

        }
        return null;
    }


}
