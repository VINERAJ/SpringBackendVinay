package com.nighthawk.spring_portfolio.mvc.jokes;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JokesJpaRepository extends JpaRepository<Jokes, Long> {
    List<Jokes> findAllByOrderByJokeAsc();
    void save(String Joke);
    List<Jokes> findByJokeIgnoreCase(String name);
}
