package org.pankaj.demo.repo;

import org.pankaj.demo.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByName(String name);
}
