package sample;


import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    @FXML
    Spinner<Integer> matriceOneRows;

    @FXML
    Spinner<Integer> matriceTwoRows;

    @FXML
    Spinner<Integer> matriceOneColumns;

    @FXML
    Spinner<Integer> matriceTwoColumns;


    @FXML
    private TextArea matriceOne;

    @FXML
    private TextArea matriceTwo;

    @FXML
    private TextArea results;

    public void initialize() {


        System.out.println();
    }

    public void plus() {
        double[][] matrix1 = arraySign(matriceOneRows, matriceOneColumns, matriceOne);
        double[][] matrix2 = arraySign(matriceTwoRows, matriceTwoColumns, matriceTwo);

        results.setText(matrixRead(Matrix.add(matrix1,matrix2)));

    }

    public void minus() {
        double[][] matrix1 = arraySign(matriceOneRows, matriceOneColumns, matriceOne);
        double[][] matrix2 = arraySign(matriceTwoRows, matriceTwoColumns, matriceTwo);



        results.setText( matrixRead(Matrix.subtract(matrix1,matrix2)));
    }

    public void times() {
        double[][] matrix1 = arraySign(matriceOneRows, matriceOneColumns, matriceOne);
        double[][] matrix2 = arraySign(matriceTwoRows, matriceTwoColumns, matriceTwo);

        results.setText( matrixRead(Matrix.multiply(matrix1,matrix2)));
    }

    public void square() {
        double[][] matrix1 = arraySign(matriceOneRows, matriceOneColumns, matriceOne);

        results.setText(matrixRead(Matrix.multiply(matrix1,matrix1)));
    }

    public static double[][] arraySign(Spinner<Integer> matrixRows, Spinner<Integer> matrixColumns, TextArea matrixContent) {
        StringBuilder nums = new StringBuilder();
        nums.append(matrixContent);
        String content = nums.toString();
        double matrix[][] = new double[matrixRows.getValue()][matrixColumns.getValue()];


        nums = new StringBuilder();
        nums.append(matrixContent.getText().trim());

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
            if (columnNumber * matrixRows.getValue() - counter == 0) {
                columnNumber++;
                indexHolder = 0;
            }

        }

        return matrix;
    }

    public static String matrixRead(double[][] matrix){
        StringBuilder s = new StringBuilder();
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                System.out.println(i);
                System.out.println(j);
                System.out.println(matrix[i][j]);
                s.append(matrix[i][j] + "\t" + "|" + "\t");
            }
            s.append("\n");
        }
        return s.toString(); }
}

