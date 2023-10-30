package com.nekoding.belajar.junit.repositories;

import com.nekoding.belajar.junit.data.Person;

public interface PersonRepository {

    public Person find(Integer id);
}
