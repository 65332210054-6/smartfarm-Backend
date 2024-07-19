package ECP.R.tables;

import lombok.Data;

import java.util.List;

@Data
public class Vegetable_profile_request {
    private String name;
    private String runtime;
    private String tem;
    private String hum;
    private String light;
    private String ph;
    private List<String> time;
}
