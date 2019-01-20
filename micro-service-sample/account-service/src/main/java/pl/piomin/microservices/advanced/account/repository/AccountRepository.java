package pl.piomin.microservices.advanced.account.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.piomin.microservices.advanced.account.model.Account;

import java.util.List;

@Repository
public interface AccountRepository extends MongoRepository<Account, String> {

    public Account findByNumber(String number);
    public List<Account> findByCustomerId(String customerId);
    
}
