package ECP.R.services;

import ECP.R.tables.TemAndHumProfile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TemAndHumRepository extends MongoRepository<TemAndHumProfile, String> {
    public TemAndHumProfile findByName (String name);
    public TemAndHumProfile deleteByName (String name);


}
