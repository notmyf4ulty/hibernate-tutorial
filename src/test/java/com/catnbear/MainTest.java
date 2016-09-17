package com.catnbear;

import com.catnbear.database.DataFilterTest;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class MainTest {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(DataFilterTest.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println("Tests finished with " + (result.wasSuccessful() ? "success" : "failure") + ".");
    }
} 