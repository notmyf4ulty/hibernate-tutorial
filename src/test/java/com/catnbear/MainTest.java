package com.catnbear;

import com.catnbear.utlilities.database.FiltersList;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class MainTest {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(FiltersList.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println("Tests finished with " + (result.wasSuccessful() ? "success" : "failure") + ".");
    }
} 