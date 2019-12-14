package com.seleniummaster.classtutorial;

public class MultiThradDemo2 {
    public static void main(String[] args) {
        GoogleMultiThreadSearch search1 = new GoogleMultiThreadSearch("New york");
        GoogleMultiThreadSearch search2 = new GoogleMultiThreadSearch("Washington DC");
        GoogleMultiThreadSearch search3 = new GoogleMultiThreadSearch("London");
        Runnable target;
        //define each thread
        Thread browser1 = new Thread(search1,"Browser1");
        Thread browser2 = new Thread(search2,"Browser2");
        Thread browser3 = new Thread(search3,"Browser3");
        // execute the thread
        browser1.start();
        browser2.start();
        browser3.start();
    }
}
