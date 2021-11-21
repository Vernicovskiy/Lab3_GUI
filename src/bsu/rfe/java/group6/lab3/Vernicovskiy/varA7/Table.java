package bsu.rfe.java.group6.lab3.Vernicovskiy.varA7 ;

import javax.swing.*;
import java.awt.*;

public class Table  extends JFrame {

    private  static final int WIDTH = 300;
    private  static final int HEIGHT = 400;

    public Table ()
    {
        super ("Table");
        setSize(WIDTH,HEIGHT);

        Toolkit kit = Toolkit.getDefaultToolkit();
        setLocation( (kit.getScreenSize().width - WIDTH) / 2, (kit.getScreenSize().height - HEIGHT)/2) ;

    }





}