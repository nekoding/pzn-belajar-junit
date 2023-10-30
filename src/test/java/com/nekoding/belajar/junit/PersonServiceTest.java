package com.nekoding.belajar.junit;

import com.nekoding.belajar.junit.data.Person;
import com.nekoding.belajar.junit.repositories.PersonRepository;
import com.nekoding.belajar.junit.services.PersonService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@Execution(ExecutionMode.CONCURRENT)
@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    private PersonService personService;

    @BeforeEach
    public void setUp() {
        this.personService = new PersonService(personRepository);
    }

    @Test
    public void testPersonIsNotFound() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> personService.get(1));
    }

    @Test
    public void testPersonSuccess() {
        Mockito.when(personRepository.find(1)).thenReturn(new Person("Enggar", 20));

        var result = personService.get(1);
        Assertions.assertEquals("Enggar", result.getName());
        Assertions.assertEquals(20, result.getAge());
    }
}
