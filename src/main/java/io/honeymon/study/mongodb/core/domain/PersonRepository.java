package io.honeymon.study.mongodb.core.domain;

import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PersonRepository extends CrudRepository<Person, ObjectId> {
    Optional<Person> findByName(String name);
}
