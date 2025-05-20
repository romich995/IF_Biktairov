package ifellow.reqres.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserGet {
    public String name;
    public String job;
    public String id;
    public Date createdAt;
}
