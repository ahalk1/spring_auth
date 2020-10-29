package edu.rit.auth.dao;

import edu.rit.auth.data.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<Users, String> {
    Users findByUserId(String userId);
    Users findByUsername(String username);
}
