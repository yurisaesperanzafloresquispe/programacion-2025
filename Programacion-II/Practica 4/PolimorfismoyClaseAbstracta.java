public abstract class Empleado {
    protected String nombre;

    public Empleado() {
        this.nombre = "";
    }

    public String getNombre() {
        return nombre;
    }

    public abstract double CalcularSalarioMensual();

    public String toString() {
        return "Empleado: " + nombre;
    }
}
public class EmpleadoTiempoCompleto extends Empleado {
    private double salarioAnual;

    public EmpleadoTiempoCompleto(String nombre, double salarioAnual) {
        this.nombre = nombre;
        this.salarioAnual = salarioAnual;
    }

    public double CalcularSalarioMensual() {
        return salarioAnual / 12;
    }

    public String toString() {
        return "Empleado: " + nombre + " | Salario Anual: " + salarioAnual +
               " | Salario Mensual: " + CalcularSalarioMensual();
    }
}

public class EmpleadoTiempoHorario extends Empleado  {
    private double horasTrabajadas;
    private double tarifaPorHora;

    public EmpleadoTiempoHorario(String nombre, double horasTrabajadas, double tarifaPorHora) {
        this.nombre = nombre;
        this.horasTrabajadas = horasTrabajadas;
        this.tarifaPorHora = tarifaPorHora;
    }
    public double CalcularSalarioMensual() {
        return horasTrabajadas * tarifaPorHora;
    }
    public String toString() {
        return "Empleado: " + nombre + " | Horas: " + horasTrabajadas +
               " | Tarifa: " + tarifaPorHora +
               " | Salario Mensual: " + CalcularSalarioMensual();
    }
}
public class TestEmpleado {
    public static void main(String[] args) {
        Empleado[] empleados = new Empleado[5];

        empleados[0] = new EmpleadoTiempoCompleto("Juan", 24000);
        empleados[1] = new EmpleadoTiempoCompleto("Ana", 36000);
        empleados[2] = new EmpleadoTiempoCompleto("Luis", 48000);
        empleados[3] = new EmpleadoTiempoHorario("Pedro", 160, 10);
        empleados[4] = new EmpleadoTiempoHorario("Maria", 120, 12);

        System.out.println("--- Lista de empleados ---");
        for (Empleado e : empleados) {
            System.out.println(e.getNombre() + " → Salario Mensual: " + e.CalcularSalarioMensual());
        }

        System.out.println("\n--- Detalles completos ---");
        for (Empleado e : empleados) {
            System.out.println(e);
        }
    }
}
