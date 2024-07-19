package ECP.R.services;

import ECP.R.tables.PumpAndValveProfile;
import ECP.R.tables.TemAndHumProfile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PumpAndValveRepository extends MongoRepository<PumpAndValveProfile, String> {
    public PumpAndValveProfile findByName (String name);

}
