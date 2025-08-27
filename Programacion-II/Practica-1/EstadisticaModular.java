package estadistica;
import java.util.Scanner;
public class EstadisticaModular {
	public static double promedio(double[] datos) {
        double suma = 0;
        for (double num : datos) {
            suma += num;
        }
        return suma / datos.length;
    }
    public static double desviacion(double[] datos) {
        double prom = promedio(datos);
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

        System.out.printf("El promedio es %.2f\n", promedio(numeros));
        System.out.printf("La desviación estándar es %.5f\n", desviacion(numeros));

        sc.close();
    }
}
