package ECP.R.services.servicesdata;

import ECP.R.tables.tablesdata.UserProfile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserProfileRepository extends MongoRepository<UserProfile, String> {
    public UserProfile findByUsername(String username);
    public UserProfile findByUsernameAndPassword(String username, String password);
}
