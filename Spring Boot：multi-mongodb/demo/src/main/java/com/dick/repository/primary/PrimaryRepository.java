package com.dick.repository.primary;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dick.model.User;

/**
 * @author neo
 */
public interface PrimaryRepository extends MongoRepository<User, String> {}
