package abcdearchivos;
import java.io.Serializable;

class Medico implements Serializable {
    private int idMed;
    private String nombreMed;
    private String apellidoMed;
    private int aniosExperiencia;

    public Medico(int idMed, String nombreMed, String apellidoMed, int aniosExperiencia) {
        this.idMed = idMed;
        this.nombreMed = nombreMed;
        this.apellidoMed = apellidoMed;
        this.aniosExperiencia = aniosExperiencia;
    }

    public int getIdMed() { 
        return idMed; 
    }
    
    public String getNombreMed() { 
        return nombreMed; 
    }
    
    public String getApellidoMed() { 
        return apellidoMed; 
    }
    
    public int getAniosExperiencia() { 
        return aniosExperiencia; 
    }

    public void setIdMed(int idMed) { 
        this.idMed = idMed; 
    }
    
    @Override
    public String toString() {
        return "ID: " + idMed + ", Nombre: " + nombreMed + " " + apellidoMed + ", Experiencia: " + aniosExperiencia + " años";
    }
}
