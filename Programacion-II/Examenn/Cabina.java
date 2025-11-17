package examen2;
import java.util.ArrayList;

public class Cabina {
    private int nroCabina;
    private ArrayList<Persona> personasAbordo;

    public Cabina(int nroCabina) {
        this.nroCabina = nroCabina;
        personasAbordo = new ArrayList<>();
    }

    public boolean agregarPersona(Persona p) {
        float pesoTotal = pesoActual() + p.getPeso();

        if (personasAbordo.size() >= 10 || pesoTotal > 850) {
            return false;
        }

        personasAbordo.add(p);
        return true;
    }

    public float pesoActual() {
        float suma = 0;
        for (Persona p : personasAbordo) suma += p.getPeso();
        return suma;
    }

    public boolean cumpleReglas() {
        return personasAbordo.size() <= 10 && pesoActual() <= 850;
    }
    public int getNroCabina() {
        return nroCabina;
    }
    public ArrayList<Persona> getPersonas() {
        return personasAbordo;
    }


}
