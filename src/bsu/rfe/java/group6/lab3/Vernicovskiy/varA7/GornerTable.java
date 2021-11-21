package bsu.rfe.java.group6.lab3.Vernicovskiy.varA7;

import javax.swing.table.AbstractTableModel;

public class GornerTabel extends AbstractTableModel {

    private double from;
    private double to;
    private double step;
    private Double[] coefficient;

    public GornerTabel(double from, double to, double step, Double[] coefficient) {
        this.from = from;
        this.to = to;
        this.step = step;
        this.coefficient = coefficient;
    }
    @Override
    public int getRowCount() {
        return new Double(Math.ceil((to-from)/step)).intValue()+1;
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        double x = from + step * rowIndex;

        switch (columnIndex) {


            case 0: return x;

            case 1: {
                double result = 0.0;
                int i = 0;

                int k = coefficient.length - 1;

                while (i < k) {
                    result = result * x + this.coefficient[k];

                    k--;
                }
                return result;
            }
                case 2:{
                double result = 0.0;
                int i = coefficient.length-1;

                int k = 0;

                while (i >= k) {
                    result = result * x + coefficient[k];

                    k++;
                }
                return result;
            }
            default: {

                double result1 = 0.0;
                int i1 = 0;

                int k1 = coefficient.length - 1;

                while (i1 < k1) {
                    result1 = result1 * x + this.coefficient[k1];

                    k1--;

                }
                double result = 0.0;
                int i = coefficient.length - 1;

                int k = 0;

                while (i >= k) {
                    result = result * x + coefficient[k];

                    k++;
                }
                return Math.abs(result - result1);


            }


        }
    }



    public String getColumnName(int col) {
        switch (col) {
            case 0:

                return "Значение X";
            case 1:

                return "Значение многочлена";
            default:

                return "Целая часть чётная";

        }
    }
    public Class<?> getColumnClass(int col) {

        return Double.class;
    }


}
