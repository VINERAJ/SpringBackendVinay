package com.nighthawk.spring_portfolio.mvc.person;

import org.springframework.data.jpa.repository.JpaRepository;

public interface  RoleJpaRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
