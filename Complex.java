import java.util.*;

public class Complex {
	private float real, imaginary;
	Complex() {
		real = 0;
		imaginary = 0;
	}
	Complex(float a, float b) {
		real = a;
		imaginary = b;
	}
	public float get_real() {
		return real;
	}
	public float get_imaginary() {
		return imaginary;
	}
	public void set_complex_number(float a, float b) {
		real = a;
		imaginary = b;
	}
	public void print() {
		String new_real, new_imaginary;
		if (real%1 == 0) {
			new_real = String.format("%.0f", real);
		}
		else {
			new_real = String.format("%.2f", real);
		}
		if (imaginary%1 == 0) {
			new_imaginary = String.format("%.0f", imaginary);
		}
		else {
			new_imaginary = String.format("%.2f", imaginary);
		}
		if (imaginary < 0) {
			System.out.print(new_real+""+new_imaginary+"i");
		}
		else if (imaginary > 0){
			System.out.print(new_real+"+"+new_imaginary+"i");
		}
		else {
			System.out.print(new_real);
		}
	}
	public Complex sum(Complex z2) {
		Complex z = new Complex(this.real + z2.real, this.imaginary + z2.imaginary);
		return z;
	}
	public Complex diff(Complex z2) {
		Complex z = new Complex(this.real - z2.real, this.imaginary - z2.imaginary);
		return z;
	}
	public Complex multiplication(Complex z2) {
		float new_real = this.real * z2.real - this.imaginary * z2.imaginary;
		float new_imaginary = this.imaginary * z2.real + this.real * z2.imaginary;
		Complex z = new Complex(new_real, new_imaginary);
		return z;
	}
	public Complex division(Complex z2) {
		Complex z3 = new Complex(z2.real, z2.imaginary * (-1));
		float new_real = this.real * z3.real - this.imaginary * z3.imaginary;
		float new_imaginary = this.imaginary * z3.real + this.real * z3.imaginary;
		float denominator = (z2.real * z2.real) + (z2.imaginary * z2.imaginary);
		Complex z = new Complex(new_real / denominator, new_imaginary / denominator);
		return z;
	}
}
