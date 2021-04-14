package com.dick.repository.secondary;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dick.model.User;

/**
 * @author neo
 */
public interface SecondaryRepository extends MongoRepository<User, String> {}
