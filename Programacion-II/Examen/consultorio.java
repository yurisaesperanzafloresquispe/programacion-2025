
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale; 

public class Consultorio {
    private static final String ARCHIVO_MEDICOS = "medicos.json";
    private static final String ARCHIVO_CONSULTAS = "consultas.json";
    private Gson g = new Gson();

    private <T> List<T> leerTodos(String nombreArchivo, Type tipoLista) {
        try (FileReader reader = new FileReader(nombreArchivo)) {
            List<T> lista = g.fromJson(reader, tipoLista);
            return lista != null ? lista : new ArrayList<>();
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    private <T> void sobreescribirArchivo(List<T> lista, String nombreArchivo) {
        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            g.toJson(lista, writer);
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + nombreArchivo + " - " + e.getMessage());
        }
    }

    public void altaMedico(Medico m) {
        Type type = new TypeToken<List<Medico>>() {}.getType();
        List<Medico> medicos = leerTodos(ARCHIVO_MEDICOS, type);
        medicos.add(m);
        sobreescribirArchivo(medicos, ARCHIVO_MEDICOS);
        System.out.println("Médico " + m.getApellidoMed() + " dado de alta.");
    }

    public void altaConsulta(Consulta c) {
        Type type = new TypeToken<List<Consulta>>() {}.getType();
        List<Consulta> consultas = leerTodos(ARCHIVO_CONSULTAS, type);
        consultas.add(c);
        sobreescribirArchivo(consultas, ARCHIVO_CONSULTAS);
        System.out.println("Consulta para CI " + c.getCi() + " dada de alta.");
    }

    public void bajaMedicoYConsultas(String nombre, String apellido) {
        Type medType = new TypeToken<List<Medico>>() {}.getType();
        List<Medico> medicos = leerTodos(ARCHIVO_MEDICOS, medType);
        int idMedicoABorrar = -1;
        List<Medico> medicosFiltrados = new ArrayList<>();
        for (Medico m : medicos) {
            if (m.getNombreMed().equalsIgnoreCase(nombre) && m.getApellidoMed().equalsIgnoreCase(apellido)) {
                idMedicoABorrar = m.getIdMed();
                System.out.println("🗑️ Médico " + nombre + " " + apellido + " marcado para baja (ID: " + idMedicoABorrar + ").");
            } else {
                medicosFiltrados.add(m);
            }
        }
        sobreescribirArchivo(medicosFiltrados, ARCHIVO_MEDICOS);
        // borra Consultas
        if (idMedicoABorrar != -1) {
            Type conType = new TypeToken<List<Consulta>>() {}.getType();
            List<Consulta> consultas = leerTodos(ARCHIVO_CONSULTAS, conType);
            List<Consulta> consultasFiltradas = new ArrayList<>();
            int consultasEliminadas = 0;
            
            for (Consulta c : consultas) {
                if (c.getIdMed() == idMedicoABorrar) {
                    consultasEliminadas++;
                } else {
                    consultasFiltradas.add(c);
                }
            }
            sobreescribirArchivo(consultasFiltradas, ARCHIVO_CONSULTAS);
            System.out.println("Se eliminaron " + consultasEliminadas + " consultas asociadas.");
        } else {
            System.out.println("Médico no encontrado. No se eliminaron consultas.");
        }
    }

    public void modificarDiaConsulta(int nuevoDia) {
        Type conType = new TypeToken<List<Consulta>>() {}.getType();
        List<Consulta> consultas = leerTodos(ARCHIVO_CONSULTAS, conType); 
        int modificadas = 0;

        for (Consulta c : consultas) {
            String mesMinusculas = c.getMes().toLowerCase(Locale.ROOT);
            boolean esNavidad = c.getDia() == 25 && mesMinusculas.equals("diciembre");
            boolean esAnioNuevo = c.getDia() == 1 && mesMinusculas.equals("enero");

            if (esNavidad || esAnioNuevo) {
                c.setDia(nuevoDia);
                modificadas++;
            }
        }
        sobreescribirArchivo(consultas, ARCHIVO_CONSULTAS); 
        System.out.println("🔄 " + modificadas + " consultas de Navidad/Año Nuevo actualizadas al día " + nuevoDia + ".");
    }
   
    public void mostrarPacientesPorDia(int dia, String mes, int anio) {
        Type conType = new TypeToken<List<Consulta>>() {}.getType();
        List<Consulta> consultas = leerTodos(ARCHIVO_CONSULTAS, conType);

        System.out.println("\n--- Pacientes atendidos el " + dia + "/" + mes + "/" + anio + " ---");
        boolean encontrado = false;
        String mesBuscado = mes.toLowerCase(Locale.ROOT);
        for (Consulta c : consultas) {
            if (c.getDia() == dia && c.getMes().toLowerCase(Locale.ROOT).equals(mesBuscado) && c.getAnio() == anio) {
                System.out.println("   CI: " + c.getCi() + " | Paciente: " + c.getNombrePaciente() + " " + c.getApellidoPaciente());
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("   No se encontraron pacientes para esta fecha.");
        }
        System.out.println("----------------------------------------------");
    }
}
