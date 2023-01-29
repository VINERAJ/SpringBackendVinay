package com.nighthawk.spring_portfolio.mvc.note;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteJpaRepository extends JpaRepository<Note, Long> {
}

