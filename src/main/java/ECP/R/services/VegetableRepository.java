package ECP.R.services;

import ECP.R.tables.VegetableProfile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VegetableRepository extends MongoRepository<VegetableProfile, String> {
    public VegetableProfile findByName (String name);
    public VegetableProfile deleteByName (String name);
    Boolean  existsByName (String name);


}
