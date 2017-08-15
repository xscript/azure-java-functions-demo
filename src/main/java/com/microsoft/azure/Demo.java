package com.microsoft.azure;

import com.microsoft.azure.serverless.functions.annotation.*;

public class Demo {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    @FunctionName("httpTrigger")
    public String httpTriggerHandler(@HttpTrigger(name = "req") String req) {
        System.out.println("Hello HttpTrigger!");
        return "Bye";
    }

    @FunctionName("queueTrigger")
    @QueueOutput(name = "$return", queueName = "q-out-2", connection = "conn")
    public String queueTriggerHandler(
            @QueueTrigger(name = "qIn", queueName = "q-in", connection = "conn") String qIn,
            @QueueOutput(name = "qOut", queueName = "q-out-1", connection = "conn") String qOut) {
        System.out.println("Hello QueueTrigger!");
        return "Bye";
    }

    @FunctionName("timerTrigger")
    public void timerTriggerHandler(
            @TimerTrigger(name = "timerInfo", schedule = "0 0 12 * * ?", useMonitor = false) String timerInfo) {
        System.out.println("Hello TimerTrigger!");
    }
}
