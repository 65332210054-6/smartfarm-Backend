package ECP.R.tables.tablesdata;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Student_profile")
public class StudentProfile {
    private String username;
    private String password;
}
