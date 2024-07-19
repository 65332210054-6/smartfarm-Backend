package ECP.R.tables;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("TemAndHum")
public class TemAndHumProfile {
    private String id;
    private String tem;    //อุณหภูมิในอากาศ
    private String hum;    //ความชื้นในอากาศ
    private String bh1750; //ความเข้มแสง
    private String pH;     //pH น้ำ
    private String level;  //ระดับน้ำ

    private String ec;    //ค่านำไฟฟ้า  หรือ EC
    private String pHG;   //pH ในดิน
    private String temG;  //อุณหภูมิในดิน
    private String humG;  //ความชื้นในดิน

    private String name;

}
