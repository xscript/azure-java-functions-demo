package com.microsoft.azure;

import com.microsoft.azure.serverless.functions.annotation.*;
import com.microsoft.azure.serverless.functions.annotation.HttpTrigger.AuthorizationLevel;

public class Demo {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    @FunctionName("httpTrigger")
    public String httpTriggerHandler(@HttpTrigger(name = "req", authLevel = AuthorizationLevel.ANONYMOUS) String req) {
        System.out.println("Hello HttpTrigger!");
        return "Hello " + req;
    }

    @FunctionName("queueTrigger")
    @QueueOutput(name = "$return", queueName = "q-out-2", connection = "conn")
    public String queueTriggerHandler(
            @QueueTrigger(name = "qIn", queueName = "q-in", connection = "conn") String qIn,
            @QueueOutput(name = "qOut", queueName = "q-out-1", connection = "conn") String qOut) {
        System.out.println("Hello QueueTrigger!");
        return "queueTrigger";
    }

    @FunctionName("timerTrigger")
    public void timerTriggerHandler(
            @TimerTrigger(name = "timerInfo", schedule = "0 0 12 * * ?") String timerInfo) {
        System.out.println("Hello TimerTrigger!");
    }
}
