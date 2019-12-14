package com.seleniummaster.classtutorial;

import java.util.Date;

public class GreetingPrinting implements Runnable {
    private String message;

    public GreetingPrinting(String message) {
        this.message = message;
    }
    @Override
    public void run() {
        for (int i = 1; i < 5; i++) {
            Date now= new Date(); // to get current time
            System.out.println(now+message);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
