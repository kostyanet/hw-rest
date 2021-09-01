package pojo;

import java.util.UUID;

public class Visit {
    public UUID id;
    public String name;
    public String date;
    public String city;

    public Visit() {
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
