package com.smallscholar.代码随想录;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/27 19:27
 * @describe ...
 */
public class Test extends Father{

    public static void main(String[] args) {
        int a = 2, b = -1, c = 3, d = 1;

        // A = a + bi
        ComplexNumber A = new ComplexNumber(a, b);

        // B = c + di
        ComplexNumber B = new ComplexNumber(c, d);

        // A / B
        ComplexNumber C = A.divide(B);

        System.out.printf("%.2f%.2fi%n", C.getReal(), C.getImaginary());
    }
}

class ComplexNumber {
    private double real;
    private double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public ComplexNumber divide(ComplexNumber other) {
        double denominator = other.real * other.real + other.imaginary * other.imaginary;
        double e = (real * other.real + imaginary * other.imaginary) / denominator;
        double f = (imaginary * other.real - real * other.imaginary) / denominator;
        return new ComplexNumber(e, f);
    }

}
