package sample;

import javafx.scene.control.Spinner;

import java.awt.*;
import java.util.List;

public class TestMain {

    public static double[][] arraySign(Integer matrixRows, Integer matrixColumns, String matrixContent) {
        StringBuilder nums = new StringBuilder();
        nums.append(matrixContent);
        String content = nums.toString();
        double matrix[][] = new double[matrixRows][matrixColumns];


        nums = new StringBuilder();
        nums.append(matrixContent.trim());

        content = nums.toString();

        List<Double> list;
        list = Matrix.getNumbers(content);
        int counter = 0;
        int indexHolder = 0;
        int columnNumber = 1;
        for (double vars : list) {
            counter++;
            matrix[columnNumber - 1][indexHolder] = vars;
            indexHolder++;
            if (columnNumber * matrixColumns - counter == 0) {
                columnNumber++;
                indexHolder = 0;
            }

        }

        return matrix;
    }


    public static void main(String[] args) {
        String s = "2 3 4 1 -2 3, -32";

        Controller.matrixRead(arraySign(2,3,s));
        Matrix.getNumbers(s);
    }
}





