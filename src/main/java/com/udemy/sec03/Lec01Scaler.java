package com.udemy.sec03;

import com.udemy.service.sec03.Person;
import io.grpc.internal.LogExceptionRunnable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lec01Scaler {
    private static final Logger log = LoggerFactory.getLogger(Lec01Scaler.class);

    public static void main(String[] args) {

        Person person1 = Person.newBuilder()
                .setLastNamme("Chanda")
                .setAge(27)
                .setBalance(-1000)
                .setEmployeed(false)
                .setEmail("mrinal.chanda@gmail.com")
                .setSalary(10)
                .setBankAccountNumber(212121782329L)
                .build();
        log.info("{}", person1);
    }
}
