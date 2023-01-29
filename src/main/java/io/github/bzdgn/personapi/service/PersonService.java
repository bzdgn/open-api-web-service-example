package io.github.bzdgn.personapi.service;

import io.github.bzdgn.open_api_web_service_example.model.Person;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Service;

/*
 * Trivial implementation
 */
@Service
public class PersonService {

    private List<Person> persons = new ArrayList<>();

    public List<Person> getPersons() {
        return Collections.unmodifiableList(this.persons);
    }

    public Person getPerson(Integer id) {
        return this.persons.stream()
                .filter(person -> person.getId() == id)
                .findAny()
                .orElse(null);
    }

    public Person addPerson(Person person) {
        this.persons.add(person);

        return person;
    }

}
