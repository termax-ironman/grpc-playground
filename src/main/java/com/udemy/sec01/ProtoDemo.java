package com.udemy.sec01;

import com.udemy.service.sec01.PersonOuterClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProtoDemo {

    private static final Logger log = LoggerFactory.getLogger(ProtoDemo.class);

    public static void main(String[] args) {
        var person = PersonOuterClass.Person.newBuilder()
                .setName("Mrinal")
                .setAge(27)
                .build();
        log.info("{}", person);
    }

}
