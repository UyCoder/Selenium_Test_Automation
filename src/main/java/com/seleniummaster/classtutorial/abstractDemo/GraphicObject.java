package com.seleniummaster.classtutorial.abstractDemo;

public abstract class GraphicObject { // add abstract
    int x;
    int y;

    // define abstract method without implementation
    abstract void draw(int r);
    abstract void resize();

    //define a method with implementation
    public void moveTo(int newX, int newY ){
        System.out.println(String.format("The object is moved to a new location %d , %d", newX, newY));
    }

    protected abstract void draw();
}
