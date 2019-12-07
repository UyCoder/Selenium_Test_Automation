package com.seleniummaster.classtutorial.abstractDemo;

public class Circle extends GraphicObject {
    private int r;


    @Override
    void draw(int r) {
        System.out.println("I draw a circle with radius"+this.r);

    }

    @Override
    void resize() {
        System.out.println("I resize the circle");
    }

    @Override
    protected void draw() {

    }

    public static void main(String[] args) {
        //GraphicObject graphicObject = new GraphicObject();
        Circle circle1 = new Circle();
        circle1.x = 10;
        circle1.y = 50;
        circle1.r = 5;
        circle1.draw(5);
        circle1.moveTo(100, 400);
        circle1.resize();
    }
}
