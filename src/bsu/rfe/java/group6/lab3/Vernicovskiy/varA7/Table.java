package bsu.rfe.java.group6.lab3.Vernicovskiy.varA7 ;

import javax.swing.*;
import javax.swing.plaf.BorderUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Table  extends JFrame {

    private  static final int WIDTH = 500;
    private  static final int HEIGHT = 700;
    private Double[] coefficients;
    private JFileChooser fileChooser = null;
    private TextField textField_from = new TextField("", 5);
    private TextField textField_to = new TextField("", 5);
    private TextField textField_shag = new TextField("", 5);

    private  GornerTabel data;
    private GornerTableCellRenderer render = new GornerTableCellRenderer ();
    private JFileChooser file = null;


    public Table (Double [] coefficients)
    {
        super ("Table");
        setSize(WIDTH,HEIGHT);

        Toolkit kit = Toolkit.getDefaultToolkit();
        System.out.println(kit.getScreenSize().height );
        setLocation( (kit.getScreenSize().width - WIDTH) / 2, (kit.getScreenSize().height - HEIGHT)/2) ;
        Box cont = Box.createVerticalBox();
        getContentPane().add(cont, BorderLayout.NORTH);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu filename = new JMenu("Файл");
        JMenu tabl = new JMenu("Таблица");
        // JMenu information = new JMenu("Справка");
        Action information = new AbstractAction("Справка") {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel inf = new JPanel();
                JLabel fio = new JLabel("Программу реализовал: Верниковский Виктор - 6 группа");
                inf.add(fio);
                ImageIcon ic = new ImageIcon("D:\\Study\\Second Course\\Java\\Lab3\\Lab3_GUI\\src\\bsu\\rfe\\java\\group6\\lab3\\Vernicovskiy\\varA7\\Лицо.jpg");
                Image image = ic.getImage();
                BufferedImage imgur = new BufferedImage(200, 250, BufferedImage.TYPE_INT_ARGB);

                Graphics g = imgur.createGraphics();
                g.drawImage(image, 0,0,200,250, null);
                g.dispose();
                ic.setImage(imgur);
                JLabel img = new JLabel(ic);
                inf.add (img);

                JOptionPane.showMessageDialog(Table.this,
                        inf, "Справка",
                        JOptionPane.INFORMATION_MESSAGE);

            }
        };
        Action saveToText = new AbstractAction("Сохранить в файл") {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (file == null)
                {
                    file = new JFileChooser();

                    file.setCurrentDirectory(new File("D:\\Study\\Second Course\\Programming2\\Java\\Lab_rab3\\out\\production"));

                }
                if (file.showSaveDialog(Table.this) == JFileChooser.APPROVE_OPTION)
                    saveToTextFile(file.getSelectedFile(), coefficients);



            }
        };
        filename.add (saveToText);
        saveToText.setEnabled(false);
        menuBar.add(filename);
        menuBar.add (tabl);

        filename.add (information);
        Action find = new AbstractAction("Найти из диапазона") {
            @Override

            public void actionPerformed(ActionEvent e) {
                String str1;
                try{
                    str1 = JOptionPane.showInputDialog(Table.this, "Введите промежуток от - до через пробел",
                            "Поиск из диапазона", JOptionPane.QUESTION_MESSAGE);
                    String[] str = str1.split(" ");

                    render.setFrom(str[0]);
                    render.setTo(str[1]);
                    getContentPane().repaint();

                }
                catch (NumberFormatException ex)
                {

                    JOptionPane.showMessageDialog(Table.this, "Ошибка в формате записи числа с плавающей точкой",
                            "Ошибочный формат числа",  JOptionPane.WARNING_MESSAGE);

                }
            }
        };

        Action find2 = new AbstractAction("Найти значение") {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str;
                str = JOptionPane.showInputDialog(Table.this, "Введите значение",
                        "Поиск из диапазона", JOptionPane.QUESTION_MESSAGE);
                render.setScan(str);
                getContentPane().repaint();
            }
        };
        tabl.add(find);
        tabl.add(find2);
tabl.setEnabled(false);
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
        JButton clear = new JButton("Очистить");
        clear.setSize(10,10);
        butt.add (clear);

        cont.add (butt);
        cont.setPreferredSize(new Dimension(WIDTH, WIDTH));



        result.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Double from = Double.parseDouble(textField_from.getText());
                    Double to = Double.parseDouble(textField_to.getText());
                    Double shag = Double.parseDouble(textField_shag.getText());

                    data = new GornerTabel(from, to, shag, coefficients);
                    JTable table = new JTable(data);
                    table.setDefaultRenderer(Double.class, render);
                    table.setRowHeight(30);
                    Result.removeAll();
                    Result.add(new JScrollPane(table));
                    getContentPane().validate();
                    saveToText.setEnabled(true);
                    tabl.setEnabled(true);
                }
                catch(NumberFormatException ex) {
                    JOptionPane.showMessageDialog(Table.this,
                            "Ошибка в формате записи числа с плавающей точкой", "Ошибочный формат числа",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Result.removeAll();
                textField_from.setText(" ");
                textField_shag.setText(" ");
                textField_to.setText(" ");
                getContentPane().validate();
                saveToText.setEnabled(false);

            }
        });





    }
    protected void saveToTextFile(File selectedFile, Double [] coefficients ) {
        try {

            PrintStream out = new PrintStream(selectedFile);

            out.println("Результаты табулирования многочлена по схеме Горнера");
            out.print("Многочлен: ");
            for (int i=0; i< coefficients.length; i++) {
                out.print(coefficients[i] + "*X^" +
                        (coefficients.length-i-1));
                if (i!=coefficients.length-1)
                    out.print(" + ");
            }
            out.println("");
            out.println("Интервал от " + data.getFrom() + " до " +
                    data.getTo() + " с шагом " + data.getStep());
            out.println("====================================================");

            for (int i = 0; i<data.getRowCount(); i++) {
                out.println("Значение в точке " + data.getValueAt(i,0)
                        + " равно " + data.getValueAt(i,1));
            }

            out.close();
        } catch (FileNotFoundException e) {

        }
    }


}