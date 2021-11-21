package bsu.rfe.java.group6.lab3.Vernicovskiy.varA7;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;

public class GornerTableCellRenderer implements TableCellRenderer {
    private JLabel label = new JLabel();
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
        panel.add (label);

    }
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        String formattedDouble = formatter.format(value);
        label.setText(formattedDouble);
        if (column==1 && scan!=null && scan.equals(formattedDouble)) {

            panel.setBackground(Color.RED);
        } else {

            panel.setBackground(Color.WHITE);
        }
        return panel;

    }
    public void setScan(String scan) {
        this.scan = scan;
    }
}