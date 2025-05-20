package ifellow.rickandmorty.dto;

import ifellow.rickandmorty.api.EpisodeAPI;
import lombok.Data;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;

@Data
public class Character {
    public int id;
    public String name;
    public String status;
    public String species;
    public String type;
    public String gender;
    public Origin origin;
    public Location location;
    public String image;
    public ArrayList<URL> episode;
    public URL url;
    public Date created;

    public Episode getLastEpisode() {
        if (!episode.isEmpty()) {
            URL url = episode.get(episode.size() - 1);
            return new EpisodeAPI().getEpisodeByURL(url);
        }
        return null;
    }
}
