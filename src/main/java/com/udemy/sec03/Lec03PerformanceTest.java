package com.udemy.sec03;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.InvalidProtocolBufferException;
import com.udemy.service.sec03.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lec03PerformanceTest {
    private static final Logger log = LoggerFactory.getLogger(Lec03PerformanceTest.class);
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) {
        var protoObject = Person.newBuilder()
                .setLastNamme("Chanda")
                .setAge(27)
                .setBalance(-1000)
                .setEmployeed(false)
                .setEmail("mrinal.chanda@gmail.com")
                .setSalary(10)
                .setBankAccountNumber(212121782329L)
                .build();
        var jsonObject = new JsonObject("Chanda",27,-1000,false,"mrinal.chanda@gmail.com",10,212121782329L);
        log.info("proto lenth: {}",protoObject.toByteArray().length);
        try {
            log.info("json lentgh: {}", objectMapper.writeValueAsBytes(jsonObject).length);
        }catch (Exception e){
            throw new RuntimeException(e);

        }

        for(int i = 0;i < 5;i++) {
            runTest("json: ", () -> json(jsonObject));
            runTest("proto: ", () -> proto(protoObject));
        }
    }
    public static void proto(Person person) {
        try {
            var bytes = person.toByteArray();
            Person.parseFrom(bytes);
        } catch (InvalidProtocolBufferException e) {
            throw new RuntimeException(e);
        }
    }

    public static void json(JsonObject person) {
        try {
            var bytes = objectMapper.writeValueAsBytes(person);
            objectMapper.readValue(bytes, JsonObject.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void runTest(String testName, Runnable runnable) {
        var start = System.currentTimeMillis();
        for(int i =0;i < 5_000_000;i++) {
            runnable.run();
        }
        var end = System.currentTimeMillis();
        log.info("{} runs in {} ms", testName, end - start);
    }
}
