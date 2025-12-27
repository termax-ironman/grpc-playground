package com.udemy.sec03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lec04Composition {
    private static final Logger LOG = LoggerFactory.getLogger(Lec04Composition.class);
    public static void main(String[] args) {
        var address1 = address.newBuilder()
                .setCity("London")
                .setState("UK")
                .setStreet("Baker Street")
                .build();
        var student1 = student.newBuilder()
                .setAddr(address1)
                .setId(1)
                .setName("Mrinal")
                .build();
        var school = com.udemy.sec03.school.newBuilder()
                .setAddr(address1.toBuilder().setStreet("123 School Street").build())
                .setId(1)
                .setName("Hindu School")
                .build();
        LOG.info("{}", student1);
        LOG.info("{}", school);
        LOG.info("{}", address1);
    }
}
