package bsu.rfe.java.group6.lab3.Vernicovskiy.varA7;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;

public class GornerTableCellRenderer implements TableCellRenderer {
    private JLabel label = new JLabel(" ");
    private JPanel panel = new JPanel();
    private String scan = null;
    private DecimalFormat formatter =  (DecimalFormat) NumberFormat.getInstance();
    public GornerTableCellRenderer ()
    {

        formatter.setMaximumFractionDigits(6);
        formatter.setGroupingUsed(false);
        DecimalFormatSymbols a = formatter.getDecimalFormatSymbols();
        a.setDecimalSeparator('.');
        formatter.setDecimalFormatSymbols(a);
        label.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.add (label);
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));

    }
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        String formattedDouble = formatter.format(value);
        label.setText(formattedDouble);
        if ((column + row) % 2 == 1)
        {
            label.setForeground(Color.WHITE);
            panel.setBackground(Color.BLACK);
        }
        else
        {

            label.setForeground(Color.black);
            panel.setBackground(Color.WHITE);
        }



        if (column== 1 && scan!=null && scan.equals(formattedDouble)) {

            panel.setBackground(Color.RED);
        }
        return panel;

    }
    public void setScan(String scan) {
        this.scan = scan;
    }
}