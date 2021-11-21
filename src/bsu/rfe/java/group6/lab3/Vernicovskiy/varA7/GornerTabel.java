package bsu.rfe.java.group6.lab3.Vernicovskiy.varA7;

import javax.swing.table.AbstractTableModel;



 public class GornerTabel extends AbstractTableModel {
    private double from;
    private double to;
    private double step;
    private Double [] coefficient;

    public GornerTabel (double from, double to, double step, Double[] coefficient )
    {
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
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        double x = from + step * rowIndex;

        switch (columnIndex) {
            case 0:
                return x;
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

            default: {
                double result = 0.0;
                int i = 0;

                int k = coefficient.length - 1;

                while (i < k) {
                    result = result * x + this.coefficient[k];

                    k--;

                }

                if ((int) result % 2 == 0)
                    return "+";
                else return " " ;
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
if (col ==2) return String.class;
else
        return Double.class;
    }

    public double getFrom() {
        return from;
    }

    public double getTo() {
        return to;
    }

    public double getStep() {
        return step;
    }
}