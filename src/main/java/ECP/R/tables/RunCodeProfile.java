package ECP.R.tables;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document("RunCode_Profile")
public class RunCodeProfile {
    private String id;
    private String project; // ch1
    private String name;    // ชื้อผัก
    private String runtime; //เวลาทำงาน
    private String tem;     //อุณหภูมิในอากาศ
    private String hum;     //ความชื้นในอากาศ

    private String humG;  //ความชื้นในดิน
    private String waterLevel;   //pH ในดิน
    private String ph;      //pH น้ำ
    private List<String> time;
}
