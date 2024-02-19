import java.util.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Print the number of operation witch you would like to do:\n"
				+ "1)Do operations with complex numbers;\n"
				+ "2)Do operations with matrices.");
		int operation = scanner.nextInt();
		scanner.nextLine();
		switch(operation) {
			case 1: 
				System.out.println("Enter real and via enter imaginary parts of the first coplex number:");
				int real = scanner.nextInt();
				scanner.nextLine();
				int imaginary = scanner.nextInt();
				scanner.nextLine();
				Complex first_number = new Complex(real, imaginary);
				System.out.println("Enter real and via enter imaginary parts of the second coplex number:");
				real = scanner.nextInt();
				scanner.nextLine();
				imaginary = scanner.nextInt();
				scanner.nextLine();
				Complex second_number = new Complex(real, imaginary);
				System.out.println("Print the number of operation witch you would like to do:\n"
						+ "1)Sum of two complex numbers;\n"
						+ "2)Difference of two complex numbers;\n"
						+ "3)Multiplication of two complex numbers;\n"
						+ "4)Division of two complex numbers.");
				operation = scanner.nextInt();
				scanner.nextLine();
				switch(operation) {
					case 1:
						System.out.print("(");
						first_number.print();
						System.out.print(")+(");
						second_number.print();
						System.out.print(")=");
						first_number.sum(second_number).print();
						System.out.println();
						break;
					case 2:
						System.out.print("(");
						first_number.print();
						System.out.print(")-(");
						second_number.print();
						System.out.print(")=");
						first_number.diff(second_number).print();
						System.out.println();
						break;
					case 3:
						System.out.print("(");
						first_number.print();
						System.out.print(")*(");
						second_number.print();
						System.out.print(")=");
						first_number.multiplication(second_number).print();
						System.out.println();
						break;
					case 4:
						System.out.print("(");
						first_number.print();
						System.out.print(")/(");
						second_number.print();
						System.out.print(")=");
						first_number.division(second_number).print();
						System.out.println();
						break;
					default:
						throw new IllegalArgumentException("Unknown operation");
				}
				break;
			case 2:
				System.out.println("Print the number of type with witch you want to make matrices:\n"
						+ "1)Coplex numbers;\n"
						+ "2)Rational numbers.");
				int type = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Print the number of operation witch you would like to do:\n"
						+ "1)Sum of two matrices;\n"
						+ "2)Difference of two matrices;\n"
						+ "3)Multiplication of two matrices;\n"
						+ "4)Transposition;\n"
						+ "5)Finding determinant.");
				operation = scanner.nextInt();
				scanner.nextLine();
				int rows = 0;
				int columns = 0;
				switch(operation) {
					case 1:
						System.out.println("Enter the rows and via enter the columns of first matrix:");
						rows = scanner.nextInt();
						scanner.nextLine();
						columns = scanner.nextInt();
						scanner.nextLine();
						Matrix first_matrix_case1 = new Matrix(rows, columns);
						first_matrix_case1.random_fill(type);
						System.out.println("Enter the rows and via enter the columns of second matrix:");
						rows = scanner.nextInt();
						scanner.nextLine();
						columns = scanner.nextInt();
						scanner.nextLine();
						Matrix second_matrix_case1 = new Matrix(rows, columns);
						second_matrix_case1.random_fill(type);
						first_matrix_case1.print_matrix();
						System.out.println("+");
						second_matrix_case1.print_matrix();
						System.out.println("=");
						first_matrix_case1.sum_mat(second_matrix_case1).print_matrix();
						break;
					case 2:
						System.out.println("Enter the rows and via enter the columns of first matrix:");
						rows = scanner.nextInt();
						scanner.nextLine();
						columns = scanner.nextInt();
						scanner.nextLine();
						Matrix first_matrix_case2 = new Matrix(rows, columns);
						first_matrix_case2.random_fill(type);
						System.out.println("Enter the rows and via enter the columns of second matrix:");
						rows = scanner.nextInt();
						scanner.nextLine();
						columns = scanner.nextInt();
						scanner.nextLine();
						Matrix second_matrix_case2 = new Matrix(rows, columns);
						second_matrix_case2.random_fill(type);
						first_matrix_case2.print_matrix();
						System.out.println("-");
						second_matrix_case2.print_matrix();
						System.out.println("=");
						first_matrix_case2.diff_mat(second_matrix_case2).print_matrix();
						break;
					case 3:
						System.out.println("Enter the rows and via enter the columns of first matrix:");
						rows = scanner.nextInt();
						scanner.nextLine();
						columns = scanner.nextInt();
						scanner.nextLine();
						Matrix first_matrix_case3 = new Matrix(rows, columns);
						first_matrix_case3.random_fill(type);
						System.out.println("Enter the rows and via enter the columns of second matrix:");
						rows = scanner.nextInt();
						scanner.nextLine();
						columns = scanner.nextInt();
						scanner.nextLine();
						Matrix second_matrix_case3 = new Matrix(rows, columns);
						second_matrix_case3.random_fill(type);
						first_matrix_case3.print_matrix();
						System.out.println("*");
						second_matrix_case3.print_matrix();
						System.out.println("=");
						first_matrix_case3.multiply(second_matrix_case3).print_matrix();
						break;
					case 4:
						System.out.println("Enter the rows and via enter the columns of matrix:");
						rows = scanner.nextInt();
						scanner.nextLine();
						columns = scanner.nextInt();
						scanner.nextLine();
						Matrix matrix_case4 = new Matrix(rows, columns);
						matrix_case4.random_fill(type);
						matrix_case4.print_matrix();
						System.out.println("Transposed:");
						matrix_case4.transpose().print_matrix();
						break;
					case 5:
						System.out.println("Enter the rows and via enter the columns of matrix:");
						rows = scanner.nextInt();
						scanner.nextLine();
						columns = scanner.nextInt();
						scanner.nextLine();
						Matrix matrix_case5 = new Matrix(rows, columns);
						matrix_case5.random_fill(type);
						matrix_case5.print_matrix();
						System.out.print("Determinant: ");
						matrix_case5.det().print();
						break;
					default: 
						throw new IllegalArgumentException("Unknown operation");
				}
			default: break;
		}
		scanner.close();
	}

}
