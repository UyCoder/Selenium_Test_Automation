package com.seleniummaster.classtutorial.packagea;

public class SubClassDemo {
    public static void main(String[] args) {
        SubClassDemo subClassDemo=new SubClassDemo();
        SubClassDemo.InnerClassA classA=subClassDemo.new InnerClassA(); //little bit complicated
        System.out.println(classA.addTwoNumbers(5, 10));
        int result=InnerClassB.multiplyTwoNumber(10, 5);
        System.out.println(result);
    }

    //subClass with no modifier
    class InnerClassA{
        private int addTwoNumbers(int a, int b){
            return a+b;
        }
    }

    //define a static class
    static class InnerClassB{
        private static int multiplyTwoNumber(int x, int y) {
            return x*y;
        }
    }

}
