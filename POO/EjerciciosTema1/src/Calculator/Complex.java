package Calculator;

public class Complex {
    private double re;
    private double im;

    public Complex() {
        this.re = 0.0;
        this.im = 0.0;
    }

    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public void setRe(double re) {
        this.re = re;
    }

    public double getIm() {
        return im;
    }

    public void setIm(double im) {
        this.im = im;
    }

    public double modulus() {
        return Math.sqrt(Math.pow(re,2) + Math.pow(im, 2));
// return Math.hypot(re,im);
    }

    @Override
    public String toString() {
        return "Complex{" + "re=" + re + ", im=" + im + '}';
    }
}


