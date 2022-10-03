package prac5;
import java.lang.reflect.Member;

public class MatrixTester {
    public static void main(String[] args){
        double[][] arr1 = {{1,2}, {3,4}};
        double[][] arr2 = {{4,3}, {2,1}};
        Matrix m1 = new Matrix(2,2, arr1);
        Matrix m2 = new Matrix(2,2, arr2);
        System.out.println(m1.sum(m2));
        System.out.println(m1.mult(m2));
        System.out.println(m2.numMult(3));
    }
}

class Matrix{
    private int n, m;
    public double[][] matrix;

    Matrix(int n, int m, double[][] matrix){
        this.n = n;
        this.m = m;
        this.matrix = matrix;
    }
    Matrix(int n, int m){
        this.n = n;
        this.m = m;
        this.matrix = new double[n][m];
        for (int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                this.matrix[i][j] = 0;
            }
        }
    }
    public Matrix sum(Matrix m2){
        Matrix new_matrix = new Matrix(this.n, this.m);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                new_matrix.matrix[i][j] = this.matrix[i][j] + m2.matrix[i][j];
            }
        }
        return new_matrix;
    }

    public Matrix mult(Matrix m2){
        Matrix new_matrix = new Matrix(this.n, m2.n);
        for (int i=0; i<new_matrix.m; i++)
            for (int j=0; j< new_matrix.n; j++)
                for (int k=0; k<this.matrix[0].length; k++)
                    new_matrix.matrix[i][j] += this.matrix[i][k] * m2.matrix[k][j];
        return new_matrix;
    }

    public Matrix numMult(double num){
        Matrix new_matrix = new Matrix(this.n, this.m);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                new_matrix.matrix[i][j] = this.matrix[i][j] * num;
            }
        }
        return new_matrix;
    }

    @Override
    public String toString(){
        String m = "";
        for(int i=0; i<this.n;i++){
            for(int j=0;j<this.m;j++){
                m += (" " + this.matrix[i][j]);
            }
            m+="\n";
        }
        return m;
    }
}
