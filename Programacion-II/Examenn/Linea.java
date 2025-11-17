package examen2;
import java.util.ArrayList;

public class Linea {
    private String color;
    private ArrayList<Persona> filaPersona;
    private ArrayList<Cabina> cabinas;

    public Linea(String color) {
        this.color = color;
        filaPersona = new ArrayList<>();
        cabinas = new ArrayList<>();
    }
    public void agregarPersona(Persona p) {
        filaPersona.add(p);
    }

    public void agregarCabinas(int n) {
        for (int i = 1; i <= n; i++) {
            cabinas.add(new Cabina(i));
        }
    }

    public boolean agregarPersonaACabinaN(Persona p, int nroCabina) {
        for (Cabina c : cabinas) {
            if (c.getNroCabina() == nroCabina) {
                return c.agregarPersona(p); 
            }
        }
        return false; 
    }

    public boolean todasLasCabinasValidas() {
        for (Cabina c : cabinas) {
            if (!c.cumpleReglas()) {
                return false;
            }
        }
        return true;
    }

    public float calcularIngreso() {
        float ingreso = 0;

        for (Cabina c : cabinas) {
            for (Persona p : c.getPersonas()) {
                if (p.getEdad() < 25 || p.getEdad() > 60) {
                    ingreso += 1.5f; 
                } else {
                    ingreso += 3f;   
                }
            }
        }

        return ingreso;
    }

    public String getColor() {
        return color;
    }

    public ArrayList<Cabina> getCabinas() {
        return cabinas;
    }
}
