package bsu.rfe.java.group6.lab3.Vernicovskiy.varA7 ;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Table  extends JFrame {

    private  static final int WIDTH = 700;
    private  static final int HEIGHT = 500;
    private Double[] coefficients;
    private JFileChooser fileChooser = null;
    private TextField textField_from = new TextField("", 5);
    private TextField textField_to = new TextField("", 5);
    private TextField textField_shag = new TextField("", 5);

    private  GornerTabel data;
    private GornerTableCellRenderer render = new GornerTableCellRenderer ();
    public Table (Double [] coefficients)
    {
        super ("Table");
        setSize(WIDTH,HEIGHT);

        Toolkit kit = Toolkit.getDefaultToolkit();
        setLocation( (kit.getScreenSize().width - WIDTH) / 2, (kit.getScreenSize().height - HEIGHT)/2) ;
        Container cont = getContentPane();
        cont.setLayout(new CardLayout());
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
        JLabel Label_From = new JLabel("х изменяется от: " );
        JLabel Label_To = new JLabel(" до ");
        JLabel Label_Shag = new JLabel(" с шагом ");
        JPanel Label_and_TextFiled_x = new JPanel();
        Label_and_TextFiled_x.add(Label_From);
        Label_and_TextFiled_x.add (textField_from);
        Label_and_TextFiled_x.add (Label_To);
        Label_and_TextFiled_x.add (textField_to);
        Label_and_TextFiled_x.add (Box.createHorizontalStrut(10));
        Label_and_TextFiled_x.add (Label_Shag);
        Label_and_TextFiled_x.add (textField_shag);
        Label_and_TextFiled_x.setLayout(new FlowLayout (FlowLayout.CENTER));
        cont.add (Label_and_TextFiled_x);
        JPanel Result = new JPanel();
        //  Result.setLayout(new FlowLayout(FlowLayout.));
        cont.add (Result);

        JButton result = new JButton("Вычислить");
        result.setSize(10,10);
        JPanel butt = new JPanel();
        butt.add (result);
        cont.add (butt);

        result.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Double from = Double.parseDouble(textField_from.getText());
                Double to = Double.parseDouble(textField_to.getText());
                Double shag = Double.parseDouble(textField_shag.getText());

                data = new GornerTabel(from, to, shag, coefficients);
                JTable table = new JTable(data);
                table.setDefaultRenderer(Double.class, render);
                table.setRowHeight(40);
                Result.removeAll();
                Result.add (new JScrollPane (table));
                getContentPane().validate();
                // Result.setLayout(new FlowLayout(FlowLayout.CENTER));
            }
        });
    }



    }





}