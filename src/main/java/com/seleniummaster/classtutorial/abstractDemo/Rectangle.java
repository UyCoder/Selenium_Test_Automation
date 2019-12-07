package com.seleniummaster.classtutorial.abstractDemo;

public class Rectangle extends GraphicObject {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println(String.format("I draw a rectangle %d by %d", width, height));
    }

    @Override
    void draw(int r) {

    }

    @Override
    void resize() {
        System.out.println("I resize the rectangle");
    }


    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(5, 6);
        rectangle.draw();
        rectangle.resize();
        rectangle.moveTo(300,400);
    }
}

