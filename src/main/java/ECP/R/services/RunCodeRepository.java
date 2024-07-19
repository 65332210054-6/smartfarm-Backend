package ECP.R.services;

import ECP.R.tables.RunCodeProfile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RunCodeRepository extends MongoRepository<RunCodeProfile, String> {
    public RunCodeProfile findByName (String name);
    public RunCodeProfile findByProject (String project);

}
