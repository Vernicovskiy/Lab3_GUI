package bsu.rfe.java.group6.lab3.Vernicovskiy.varA7;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        Double [] coefficients = new Double[5];
        for (int k = 0; k < 5; k++) coefficients[k] = Double.valueOf(k);
        //  System.out.println(coefficients[3]);
        Table a = new Table(coefficients);
        a.setVisible(true);
        a.pack();
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



    }
}