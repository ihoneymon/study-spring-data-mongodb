package io.honeymon.study.mongodb.core.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.Arrays;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataMongoTest
class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    void testSave() {
        Person person = new Person("honeymon", 39);

        personRepository.save(person);

        assertThat(person.getId()).isNotNull();
    }

    @Test
    void testSaveAll() {
        Person person1 = new Person("honeymon", 39);
        Person person2 = new Person("batman", 39);
        Person person3 = new Person("joker", 39);

        personRepository.saveAll(Arrays.asList(person1, person2, person3));

        assertThat(personRepository.findAll()).hasSize(3);
    }

    @Test
    void testFindByName() {
        Person person1 = new Person("honeymon", 39);
        Person person2 = new Person("batman", 39);
        Person person3 = new Person("joker", 39);

        personRepository.saveAll(Arrays.asList(person1, person2, person3));

        Optional<Person> findPerson = personRepository.findByName("honeymon");

        assertThat(findPerson.isPresent()).isTrue();
    }
}