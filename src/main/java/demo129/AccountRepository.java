package demo129;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;


public interface AccountRepository extends MongoRepository<AccountModel, Integer>{}