package ECP.R.services.servicesdata;

import ECP.R.tables.tablesdata.StudentProfile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<StudentProfile, String> {
    public StudentProfile findByUsername(String username);
    public StudentProfile findByPassword(String password);
}
