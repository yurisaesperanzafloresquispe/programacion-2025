package examen2;
import java.util.ArrayList;

public class MiTeleferico {
    private ArrayList<Linea> lineas;
    private float cantidadIngreso;

    public MiTeleferico() {
        lineas = new ArrayList<>();
    }

    public void agregarLinea(Linea linea) {
        lineas.add(linea);
    }

    public void agregarPersonaFila(Persona p, String colorLinea) {
        for (Linea l : lineas) {
            if (l.getColor().equals(colorLinea)) {
                l.agregarPersona(p);
            }
        }
    }

    public boolean agregarCabina(String colorLinea, int nro) {
        for (Linea l : lineas) {
            if (l.getColor().equals(colorLinea)) {
                l.agregarCabinas(nro);
                return true;
            }
        }
        return false;
    }

    public Linea lineaConMasIngresoRegular() {
        Linea mayor = null;
        float max = 0;

        for (Linea l : lineas) {
            float ing = l.calcularIngreso();
            if (ing > max) {
                max = ing;
                mayor = l;
            }
        }
        return mayor;
    }

    public boolean todasValidas() {
        for (Linea l : lineas) {
            if (!l.todasLasCabinasValidas()) return false;
        }
        return true;
    }
}
