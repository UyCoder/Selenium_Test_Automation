package com.seleniummaster.basic.homework;

import javax.swing.*;

public class JFrame_HelloWorld {
    public static void main(String[] args) {
        System.out.println("ئەسسالام ئەلەيكۇم");
        JFrame f=new JFrame("كۇنۇپكا");
        JButton b=new JButton("بۇ يەرنى بېسىڭ");
        b.setBounds(50,100,95,30);
        f.add(b);
        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);
    }
}


