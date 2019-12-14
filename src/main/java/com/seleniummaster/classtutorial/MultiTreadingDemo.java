package com.seleniummaster.classtutorial;


public class MultiTreadingDemo {
    public static void main(String[] args) {
        GreetingPrinting g1 = new GreetingPrinting(" Hello test automation");
        GreetingPrinting g2 = new GreetingPrinting(" Java multi threading is fun");
        GreetingPrinting g3 = new GreetingPrinting(" united coder SDET learing");
        GreetingPrinting g4 = new GreetingPrinting(" We learned...");
        Thread thread1 = new Thread(g1);
        System.out.println("Thread ID " + thread1.getId());
        System.out.println("Thread Name " + thread1.getName());
        Thread thread2 = new Thread(g2);
        System.out.println("Thread ID " + thread2.getId());
        System.out.println("Thread Name " + thread2.getName());
        Thread thread3 = new Thread(g3);
        System.out.println("Thread ID " + thread3.getId());
        System.out.println("Thread Name " + thread3.getName());
        Thread thread4 = new Thread(g4);
        System.out.println("Thread ID " + thread4.getId());
        System.out.println("Thread Name " + thread4.getName());
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
