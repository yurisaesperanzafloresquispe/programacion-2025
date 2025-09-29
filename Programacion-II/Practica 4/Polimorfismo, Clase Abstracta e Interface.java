public interface Coloreado {
    String comoColorear();
}
public abstract class Figura {
    protected String color;

    public Figura() {
        this.color = "blanco";
    }

    public Figura(String color) {
        this.color = color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
    public abstract double area();
    public abstract double perimetro();

    public String toString() {
        return "Color: " + color;
    }
}
public class Circulo extends Figura {
    private double radio;

    public Circulo() {
        this.radio = 1;
        this.color = "blanco";
    }
    public Circulo(double radio, String color) {
        this.radio = radio;
        this.color = color;
    }
    public double getRadio() {
        return radio;
    }
    public void setRadio(double radio) {
        this.radio = radio;
    }
    public double area() {
        return Math.PI * radio * radio;
    }
    public double perimetro() {
        return 2 * Math.PI * radio;
    }
    public String toString() {
        return "Circulo | Radio: " + radio + " | Color: " + color;
    }
}
public class Cuadrado extends Figura implements Coloreado {
    private double lado;

    public Cuadrado() {
        this.lado = 1;
        this.color = "blanco";
    }
    public Cuadrado(double lado, String color) {
        this.lado = lado;
        this.color = color;
    }
    public double getLado() {
        return lado;
    }
    public void setLado(double lado) {
        this.lado = lado;
    }
    public double area() {
        return lado * lado;
    }
    public double perimetro() {
        return 4 * lado;
    }
    public String comoColorear() {
        return "Colorear los cuatro lados";
    }
    public String toString() {
        return "Cuadrado | Lado: " + lado + " | Color: " + color;
    }
}
public class TestFigura {
    public static void main(String[] args) {
        Random r = new Random();
        Figura[] figuras = new Figura[5];
        String[] colores = {"Rojo", "Verde", "Amarillo"};

        for (int i = 0; i < figuras.length; i++) {
            int tipo = r.nextInt(2) + 1;
            String color = colores[r.nextInt(colores.length)];

            if (tipo == 1) {
                double lado = 1 + r.nextInt(10);
                figuras[i] = new Cuadrado(lado, color);
            } else {
                double radio = 1 + r.nextInt(10);
                figuras[i] = new Circulo(radio, color);
            }
        }

        for (Figura f : figuras) {
            System.out.println(f);
            System.out.println("Área: " + f.area());
            System.out.println("Perímetro: " + f.perimetro());
            if (f instanceof Coloreado) {
                System.out.println("Como colorear: " + ((Coloreado) f).comoColorear());
            }
            System.out.println("-----------------------");
        }
    }
}
