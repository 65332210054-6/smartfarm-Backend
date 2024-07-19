package ECP.R.tables;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.reflect.Array;
import java.util.List;

@Data
@Document("Vegetable_profile")
public class VegetableProfile {
    @Id
    private String id;
    private String name;
    private String runtime;
    private String tem;
    private String hum;

    private String humG;  //ความชื้นในดิน
    private String waterLevel;   //pH ในดิน
    private String ph;      //pH น้ำ
    private List<String> time;


}
