package ecuacioncuadratica;
import java.util.Scanner;
public class ecuacioncuadratica {
	private double a;
	private double b;
	private double c;

	public ecuacioncuadratica(double a, double b, double c) {
		this.a=a;
		this.b=b;
		this.c=c;
	}
	public double getDiscriminante() {
        return (b * b) - (4 * a * c);
    }

    public double getRaiz1() {
        double disc = getDiscriminante();
        if (disc < 0) {
            return 0; 
        }
        return (-b + Math.sqrt(disc)) / (2 * a);
    }

    public double getRaiz2() {
        double disc = getDiscriminante();
        if (disc < 0) {
            return 0; 
        }
        return (-b - Math.sqrt(disc)) / (2 * a);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese a, b, c: ");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();

        ecuacioncuadratica eq = new ecuacioncuadratica(a, b, c);

        double discriminante = eq.getDiscriminante();

        if (discriminante > 0) {
            System.out.println("Raíz 1 = " + eq.getRaiz1());
            System.out.println("Raíz 2 = " + eq.getRaiz2());
        } else if (discriminante == 0) {
            System.out.println("Única raíz = " + eq.getRaiz1());
        } else {
            System.out.println("La ecuación no tiene raíces reales");
        }

        sc.close();
    }
	
}
