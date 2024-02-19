import java.util.*;

public class Matrix {
	private Complex [][] matrix;
	private int rows, columns;
	Matrix(int a, int b) {
		rows = a;
		columns = b;
		matrix = new Complex[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				matrix[i][j] = new Complex();
			}
		}
	}
    public void random_fill(int a) {
        Random r = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int real = (r.nextInt(41) - 20);
                int imaginary = 0;
                if (a == 1) {
                	imaginary = (r.nextInt(41) - 20);
                }
                matrix[i][j].set_complex_number(real, imaginary);
            }
        }
    }
    public void print_matrix() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("\t");
                matrix[i][j].print();
                System.out.print("\t");
            }
            System.out.println();
        }
        System.out.println();
    }
    public Matrix transpose() {
        Matrix transposed_matrix = new Matrix(columns, rows);
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
            	transposed_matrix.matrix[j][i] = this.matrix[i][j];
            }
        }
        return transposed_matrix;
    }
    public Matrix sum_mat(Matrix mat2) {
        if ((this.rows != mat2.rows) || (this.columns != mat2.columns)) {
            throw new IllegalArgumentException("The matrices should have the same size");
        }
        Matrix new_matrix = new Matrix(rows, columns);
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
            	new_matrix.matrix[i][j] = this.matrix[i][j].sum(mat2.matrix[i][j]);
            }
        }
        return new_matrix;
    }
    public Matrix diff_mat(Matrix mat2) {
        if ((this.rows != mat2.rows) || (this.columns != mat2.columns)) {
            throw new IllegalArgumentException("The matrices should have the same size");
        }
        Matrix new_matrix = new Matrix(rows, columns);
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
            	new_matrix.matrix[i][j] = this.matrix[i][j].diff(mat2.matrix[i][j]);
            }
        }
        return new_matrix;
    }
    public Matrix multiply(Matrix mat2) {
    	if (this.columns != mat2.rows) {
            throw new IllegalArgumentException("The matrices should be consistent");
    	}
    	Matrix new_matrix = new Matrix(this.rows, mat2.columns);
    	for (int i = 0; i < this.rows; i++) {
    		for (int j = 0; j < mat2.columns; j++) {
    			for (int k = 0; k < mat2.rows; k++) {
    				new_matrix.matrix[i][j] = new_matrix.matrix[i][j].sum(this.matrix[i][k].multiplication(mat2.matrix[k][j]));
    			}
    		}
    	}
    	return new_matrix;
    }
    public Complex det() {
    	if (this.rows != this.columns) {
    		throw new IllegalArgumentException("Rows and columns must be equal");
    	}
    	if (this.rows == 1) {
    		return this.matrix[0][0];
    	}
    	Complex det = new Complex();
    	for (int j = 0; j < this.columns; j++) {
    		if (j % 2 == 0) {
        		det = det.sum(this.minor(0, j).det().multiplication(this.matrix[0][j]));
    		}
    		else {
        		det = det.diff(this.minor(0, j).det().multiplication(this.matrix[0][j]));
    		}
    	}
    	return det;
    }
    public Matrix minor(int minor_row, int minor_column) {
    	Matrix minor_matrix = new Matrix((this.rows - 1), (this.columns - 1));
    	int x = 0;
    	int y = 0;
    	for (int i = 1; i < this.rows; i++) {
        	for (int j = 0; j < this.columns; j++) {
        		if (j != minor_column) {
       				minor_matrix.matrix[x][y] = this.matrix[i][j];
       				y++;
       			}
       		}
        	y = 0;
      		x++;
    	}
    	return minor_matrix;
    } 
}
