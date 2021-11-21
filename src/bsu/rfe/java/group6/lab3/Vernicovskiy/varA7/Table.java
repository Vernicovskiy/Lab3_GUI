package bsu.rfe.java.group6.lab3.Vernicovskiy.varA7 ;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Table  extends JFrame {

    private  static final int WIDTH = 300;
    private  static final int HEIGHT = 400;
    private Double[] coefficients;
    private JFileChooser fileChooser = null;
    public Table ()
    {
        super ("Table");
        setSize(WIDTH,HEIGHT);

        Toolkit kit = Toolkit.getDefaultToolkit();
        setLocation( (kit.getScreenSize().width - WIDTH) / 2, (kit.getScreenSize().height - HEIGHT)/2) ;
        Container cont = getContentPane();
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu filename = new JMenu("Файл");
        JMenu tabl = new JMenu("Таблица");
        // JMenu information = new JMenu("Справка");
        Action information = new AbstractAction("Справка") {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(Table.this,
                        "Прорамму выполнил: Верниковский  Виктор \n Группа: 6", "Справка",
                        JOptionPane.INFORMATION_MESSAGE);

            }
        };
        menuBar.add(filename);
        filename.add (information);
        


    }





}