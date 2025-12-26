package com.udemy.sec03;

import com.udemy.service.sec03.Person;
import io.grpc.internal.LogExceptionRunnable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Lec01Serialization {
    private static final Logger log = LoggerFactory.getLogger(Lec01Scaler.class);
    private static final Path PATH = Path.of("Person.out");

    public static void main(String[] args) throws IOException {

        var person1 = Person.newBuilder()
                .setLastNamme("Chanda")
                .setAge(27)
                .setBalance(-1000)
                .setEmployeed(false)
                .setEmail("mrinal.chanda@gmail.com")
                .setSalary(10)
                .setBankAccountNumber(212121782329L)
                .build();
        serialize(person1);
        log.info("{}", deserialize());
        log.info("equals: {}", person1.equals(deserialize()));
        log.info("bytearray size: {}", person1.toByteArray().length);

    }
    public static void serialize(Person person) throws IOException {
        try(var stream = Files.newOutputStream(PATH)) {
            person.writeTo(stream);
        }
    }
    public static Person deserialize() throws IOException {

        try(var stream = Files.newInputStream(PATH)) {
            return Person.parseFrom(stream);
        }
    }
}
