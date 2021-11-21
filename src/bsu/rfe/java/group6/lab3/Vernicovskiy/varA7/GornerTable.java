package bsu.rfe.java.group6.lab3.Vernicovskiy.varA7;

import javax.swing.table.AbstractTableModel;

public class GornerTabel extends AbstractTableModel {

    private double from;
    private double to;
    private double step;
    private double[] coefficient;

    public GornerTabel(double from, double to, double step, double[] coefficient) {
        this.from = from;
        this.to = to;
        this.step = step;
        this.coefficient = coefficient;
    }
    @Override
    public int getRowCount() {
        return new Double(Math.ceil((to-from)/step)).intValue() + 1;
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        double x = from + step * rowIndex;
        if (columnIndex == 0) return x;
        else {
            double result = 0.0;
            int i = 1;
            int y = -1; // Кол-во операций сложения и умножения
            int k = coefficient.length;

            while (i <= k)

            {
                result = result * x + (( k -1 ) * Math.pow(-1, (k - 1)));

                k--;
                y++;
            }
            return result;
        }
    }

    public String getColumnName(int col) {
        switch (col) {
            case 0:

                return "Значение X";
            default:

                return "Значение многочлена";
        }
    }
    public Class<?> getColumnClass(int col) {

        return Double.class;
    }


}
