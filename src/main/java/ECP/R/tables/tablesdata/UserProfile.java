package ECP.R.tables.tablesdata;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("User_profile")
public class UserProfile {
    private String username;
    private String password;
}
