package com.udemy.sec02;

import com.udemy.service.sec02.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ProtoDemo1 {

    private static final Logger log = LoggerFactory.getLogger(ProtoDemo1.class);

    public static void main(String[] args) {

        //create person2

        Person person1 = createPerson();
        Person person2 = createPerson();

        log.info("equals method: {}", person1.equals(person2));
        log.info("== : {}",person1 ==  person2);

        //mutable ?? no

        //compare
        Person person3 = person1.toBuilder().setName("Baba").build();
        log.info("equals method: {}", person1.equals(person3));
        log.info("== : {}",person1 ==  person3);

        //null?
        Person person4 = person3.toBuilder().clearAge().build();
        log.info("{}", person4);



    }

    private static Person createPerson() {
        return Person.newBuilder()
                .setName("Mukul")
                .setAge(64)
                .build();
    }
}
