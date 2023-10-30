package com.nekoding.belajar.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.concurrent.TimeUnit;

@Execution(ExecutionMode.CONCURRENT)
public class ConcurrentTest {

    @Test
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    public void testCase1() throws InterruptedException {
        Thread.sleep(2_000);
        Assertions.assertTrue(true);
    }

    @Test
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    public void testCase2() throws InterruptedException {
        Thread.sleep(2_000);
        Assertions.assertTrue(true);
    }

    @Test
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    public void testCase3() throws InterruptedException {
        Thread.sleep(2_000);
        Assertions.assertTrue(true);
    }
}
