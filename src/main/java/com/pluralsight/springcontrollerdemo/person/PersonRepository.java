package com.pluralsight.springcontrollerdemo.person;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findByAgeGreaterThanEqual(int minAge);
//    List<Person> findByName(String name);
//
//    @SQL("select * from person")
//    List<Person> getAllPeeps();
}
