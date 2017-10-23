
public class Matrix {

    int rows, columns;
    int size = rows * columns;
    public double[] matrix = new double[size];

    Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        size = rows * columns;
        matrix = new double[size];
    }

    public void printMatrix() {
        int r = rows;
        int c = columns;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                // first entry
                if (i == 0 && j == 0) {
                    System.out.print("[" + matrix[i * c + j] + " ");
                } // very last entry
                else if (i == r - 1 && j == c - 1) {
                    System.out.println(matrix[i * c + j] + "]");
                } // last entry of each row
                else if (j == c - 1) {
                    System.out.println(matrix[i * c + j]);
                } else {
                    System.out.print(matrix[i * c + j] + " ");
                }
            }
        }
    }

    public Matrix scalarMult(double n) {
        for (int i = 0; i < size; i++) {
            matrix[i] *= n;
        }
        return this;
    }

    public double[] column(int n) {
        double[] column = new double[this.rows];
        for (int i = 0; i < rows; i++) {
            column[i] = matrix[i * columns + n];
        }
        return column;
    }

    static public double arrayMult(double[] a, double[] b) {
        double hi = 0;
        for (int i = 0; i < a.length; i++) {
            hi += a[i] * b[i];
        }
        return hi;
    }

    public double[] row(int n) {
        double[] row = new double[this.columns];
        for (int i = 0; i < columns; i++) {
            row[i] = matrix[i + (n * columns)];
        }
        return row;
    }

    public Matrix dotProduct(Matrix m2) {
        assert columns == m2.rows : "the columns of the primary input "
                + "matrix must"
                + "be equal to the rows of the secondary input matrix!";
        double[] currRow = new double[rows];
        double[] currCol = new double[m2.columns];
        Matrix dotMatrix = new Matrix(rows, m2.columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < m2.columns; j++) {
                currRow = row(i);
                currCol = m2.column(j);
                dotMatrix.matrix[(dotMatrix.columns * i) + j] = arrayMult(currRow, currCol);

            }

        }

        return dotMatrix;
    }

    public Matrix addition(Matrix m2) {
        assert this.columns == m2.columns && this.rows == m2.rows : 
                "the two matrices must have the same dimensions";
        Matrix additionMatrix = new Matrix(this.rows, this.columns);
        for (int i = 0; i < additionMatrix.size; i++) {
            additionMatrix.matrix[i] = this.matrix[i] + m2.matrix[i];
        }
        return additionMatrix;
    }

    public Matrix subtracion(Matrix m2) {
         assert columns == m2.columns && rows == m2.rows : 
                "the two matrices must have the same dimensions";
        Matrix subtractionMatrix = new Matrix(rows, columns);
        for (int i = 0; i < subtractionMatrix.size; i++) {
            subtractionMatrix.matrix[i] = matrix[i] - m2.matrix[i];
        }
        return subtractionMatrix;
    }
    
    public Matrix multiplication(Matrix m2) {
         assert columns == m2.columns && rows == m2.rows : 
                "the two matrices must have the same dimensions";
        Matrix multMatrix = new Matrix(rows, columns);
        for (int i = 0; i < multMatrix.size; i++) {
            multMatrix.matrix[i] = matrix[i] * m2.matrix[i];
        }
        return multMatrix;
    }
    public double getSize()
    {
        return size;
    }
    
    public Matrix transpose()
    {
        Matrix T = new Matrix(columns, rows);
        for(int i = 0; i < T.size - 1; ++i)
        {
            T.matrix[i] = matrix[i*columns % (size-1)];
        }
        T.matrix[size-1] = matrix[size-1];
        return T;
    }
}

