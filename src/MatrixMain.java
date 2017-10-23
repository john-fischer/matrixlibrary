

public class MatrixMain {

    
    public static void main(String[] args) {
        Matrix myMatrix1 = new Matrix(3, 2);
        Matrix myMatrix2 = new Matrix(2, 3);
        double[] ary = {1, 2, 3, 4, 5, 6};
        double[] ary2 = {2, 3, 4, 5, 6, 7};
        myMatrix1.matrix = ary;
        myMatrix2.matrix = ary2;
        myMatrix1.printMatrix();
        System.out.println();
        myMatrix1.dotProduct(myMatrix2).printMatrix();

        myMatrix2.printMatrix();
        System.out.println();
        Matrix myMatrix3 = new Matrix(3, 3);
        double[] ary3 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        double[] ary4 = {1, 2, 3, 4, 5, 6, 7, 8};
        Matrix myMatrix4 = new Matrix(4,2);
        myMatrix4.matrix = ary4;
        myMatrix3.matrix = ary3;
        myMatrix3.printMatrix();
        System.out.println();
        myMatrix3.transpose().printMatrix();
        myMatrix1.transpose().printMatrix();
        myMatrix4.transpose().printMatrix();
    }
}
