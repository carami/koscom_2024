package com.example.eventexam.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class AsyncTestService {
    private final GetOneService getOneService;
    private final GetTwoService getTwoService;

    @Autowired
    @Qualifier("taskExecutor")
    private Executor taskExecutor;

    public String executeWithoutAsync(){
        long start = System.nanoTime();
        String value1 = getOneService.getOne();
        String value2 = getTwoService.getTwo();
        long end = System.nanoTime();

        System.out.println("value1 : " + value1);
        System.out.println("value2 : " + value2);

        String str = "executeWithoutAsync 걸린 시간 : " + formatNanoseconds(end - start);
        System.out.println(str);

        return str;

    }

    public String executeWithCompletableFuture() {
        long start = System.nanoTime();

        CompletableFuture<String> value1Future = CompletableFuture.supplyAsync(() -> getOneService.getOne(), taskExecutor);
        CompletableFuture<String> value2Future = CompletableFuture.supplyAsync(() -> getTwoService.getTwo(), taskExecutor);

        CompletableFuture.allOf(value1Future, value2Future).join();

        String value1 = value1Future.join();
        String value2 = value2Future.join();

        System.out.println("value1 : " + value1);
        System.out.println("value2 : " + value2);

        long end = System.nanoTime();
        String str = "executeWithAsync 걸린 시간 : " + formatNanoseconds(end - start);
        System.out.println(str);

        return str;
    }

    public String executeWithAsync() {
        long start = System.nanoTime();

        Future<String> value1Future = getOneService.getAsyncOne();
        Future<String> value2Future = getTwoService.getAsyncTwo();

        while (!value1Future.isDone() || !value2Future.isDone()) {
            // value1Future와 value2Future가 모두 완료될 때까지 기다립니다.
            //System.out.print(".");
        }

        try {
            String value1 = value1Future.get();
            String value2 = value2Future.get();

            System.out.println("value1 : " + value1);
            System.out.println("value2 : " + value2);
        }catch(Exception ex){
            ex.printStackTrace();
        }

        long end = System.nanoTime();
        String str = "executeWithAsync 걸린 시간 : " + formatNanoseconds(end - start);
        System.out.println(str);

        return str;
    }

    private String formatNanoseconds(long nanoSeconds) {
        long hours = TimeUnit.NANOSECONDS.toHours(nanoSeconds);
        long minutes = TimeUnit.NANOSECONDS.toMinutes(nanoSeconds) % 60;
        long seconds = TimeUnit.NANOSECONDS.toSeconds(nanoSeconds) % 60;
        long millis = TimeUnit.NANOSECONDS.toMillis(nanoSeconds) % 1000;
        long micros = TimeUnit.NANOSECONDS.toMicros(nanoSeconds) % 1000;

        return String.format("%02d:%02d:%02d.%03d,%03d", hours, minutes, seconds, millis, micros);
    }
}
