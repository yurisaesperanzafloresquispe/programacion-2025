package abcdearchivos;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;

public class Consultorio {
    private String consultas, medicos;

    private ArrayList<Consulta> listaConsultas = new ArrayList<>();
    private ArrayList<Medico> listaMedicos = new ArrayList<>();

    public Consultorio(String consultas, String medicos) {
        this.consultas = consultas;
        this.medicos = medicos;

        cargarConsultas();
        cargarMedicos();
    }

    Consultorio() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void cargarConsultas() {
        try {
            Reader r = new FileReader(consultas);
            listaConsultas = new Gson().fromJson(r,
                    new TypeToken<ArrayList<Consulta>>(){}.getType());
            if(listaConsultas == null) listaConsultas = new ArrayList<>();
            r.close();
        } catch (Exception e) {
            listaConsultas = new ArrayList<>();
        }
    }

    private void cargarMedicos() {
        try {
            Reader r = new FileReader(medicos);
            listaMedicos = new Gson().fromJson(r,
                    new TypeToken<ArrayList<Medico>>(){}.getType());
            if(listaMedicos == null) listaMedicos = new ArrayList<>();
            r.close();
        } catch (Exception e) {
            listaMedicos = new ArrayList<>();
        }
    }

    private void grabarConsultas() {
        try {
            FileWriter w = new FileWriter(consultas);
            new Gson().toJson(listaConsultas, w);
            w.close();
        } catch (Exception e){
            System.out.println("ERROR AL GRABAR CONSULTAS: "+e);
        }
    }

    private void grabarMedicos() {
        try {
            FileWriter w = new FileWriter(medicos);
            new Gson().toJson(listaMedicos, w);
            w.close();
        } catch (Exception e){
            System.out.println("ERROR AL GRABAR MEDICOS: "+e);
        }
    }

    public void altaMedico(Medico m){
        listaMedicos.add(m);
        grabarMedicos();
    }

    public void altaConsulta(Consulta c){
        listaConsultas.add(c);
        grabarConsultas();
    }

    public void bajaMedico(String nombre, String apellido){
        int idEliminar = -1;

        for(Medico m : listaMedicos){
            if(m.getNombreMed().equalsIgnoreCase(nombre) &&
               m.getApellidoMed().equalsIgnoreCase(apellido)){
                idEliminar = m.getIdMed();
            }
        }

        // elimina médico
        listaMedicos.removeIf(m -> m.getIdMed() == idEliminar);
        grabarMedicos();

        // elimina consultas
        listaConsultas.removeIf(c -> c.getIdMed() == idEliminar);
        grabarConsultas();
    }

    public void cambiarFechaEspecial(int nuevoDia){
        for(Consulta c : listaConsultas){
            if(c.getMes().equalsIgnoreCase("diciembre")){
                if(c.getDias() == 25 || c.getDias() == 31){
                    c.setDias(nuevoDia);
                }
            }
        }
        grabarConsultas();
    }

    public void pacientesCumple(int dia, String mes){
        System.out.println("PACIENTES ATENDIDOS EN TU CUMPLEAÑOS:");
        for(Consulta c : listaConsultas){
            if(c.getDias() == dia && c.getMes().equalsIgnoreCase(mes)){
                System.out.println(c.getNombrePaciente()+" "+c.getApellidoPaciente());
            }
        }
    }

    void cambiarDiasEspeciales(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}


    
    
