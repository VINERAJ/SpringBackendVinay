package com.nighthawk.spring_portfolio.mvc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import com.nighthawk.spring_portfolio.mvc.jokes.Jokes;
import com.nighthawk.spring_portfolio.mvc.jokes.JokesJpaRepository;
import com.nighthawk.spring_portfolio.mvc.person.Person;
import com.nighthawk.spring_portfolio.mvc.person.PersonJpaRepository;

import java.util.List;

@Component // Scans Application for ModelInit Bean, this detects CommandLineRunner
public class ModelInit {  
    @Autowired JokesJpaRepository jokesRepo;
    @Autowired PersonJpaRepository personRepo;

    @Bean
    CommandLineRunner run() {  // The run() method will be executed after the application starts
        return args -> {

            // Joke database is populated with starting jokes
            String[] jokesArray = Jokes.init();
            for (String joke : jokesArray) {
                List<Jokes> jokeFound = jokesRepo.findByJokeIgnoreCase(joke);  // JPA lookup
                if (jokeFound.size() == 0)
                    jokesRepo.save(new Jokes(null, joke, 0, 0)); //JPA save
            }

            // Joke database is populated with starting jokes
            Person[] personArray = Person.init();
            for (Person person : personArray) {
                List<Person> personFound = personRepo.findByNameContainingIgnoreCaseOrEmailContainingIgnoreCase(person.getName(), person.getEmail());  // JPA lookup
                if (personFound.size() == 0) {
                    Person p = new Person(person.getEmail(), person.getPassword(), person.getName(), person.getDob());
                    personRepo.save(p);
                }
            }

        };
    }
}

