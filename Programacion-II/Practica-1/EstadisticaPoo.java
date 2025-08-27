package estadistica;
import java.util.Scanner;
public class estadistica1 {
	 
    private double[] datos;

    public estadistica1(double[] datos) {
        this.datos = datos;
    }

    public double promedio() {
        double suma = 0;
        for (double num : datos) {
            suma += num;
        }
        return suma / datos.length;
    }

    public double desviacion() {
        double prom = promedio();
        double suma = 0;
        for (double num : datos) {
            suma += Math.pow(num - prom, 2);
        }
        return Math.sqrt(suma / (datos.length - 1));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] numeros = new double[10];

        System.out.println("Ingrese 10 números:");
        for (int i = 0; i < 10; i++) {
            numeros[i] = sc.nextDouble();
        }

        estadistica1 est = new estadistica1(numeros);

        System.out.printf("El promedio es %.2f\n", est.promedio());
        System.out.printf("La desviación estándar es %.5f\n", est.desviacion());

        sc.close();
    }
}
