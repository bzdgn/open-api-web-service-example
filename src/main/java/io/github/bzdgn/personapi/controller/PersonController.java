package io.github.bzdgn.personapi.controller;

import io.github.bzdgn.open_api_web_service_example.model.Person;
import io.github.bzdgn.open_api_web_service_example.service.PersonApi;
import io.github.bzdgn.personapi.service.PersonService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class PersonController implements PersonApi {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public ResponseEntity<Person> getPerson(@PathVariable("id") Integer id) {
        Person person = this.personService.getPerson(id);

        return person == null ? ResponseEntity.status(HttpStatus.NOT_FOUND).body(null) : ResponseEntity.ok(person);
    }

    @Override
    public ResponseEntity<List<Person>> getPersons() {

        List<Person> persons = this.personService.getPersons();

        return ResponseEntity.ok(persons);
    }

    @Override
    public ResponseEntity<Person> addPerson(
            @Valid @RequestBody Person person) {

        return ResponseEntity.status(HttpStatus.CREATED).body(this.personService.addPerson(person));
    }

}
