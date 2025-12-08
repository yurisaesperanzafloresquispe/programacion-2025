package abcdearchivos;

public class Medico {
    private int idMed, aniosExperiencia;
    private String nombreMed, ApellidoMed;

    public Medico(int idMed, int aniosExperiencia, String nombreMed, String ApellidoMed) {
        this.idMed = idMed;
        this.aniosExperiencia = aniosExperiencia;
        this.nombreMed = nombreMed;
        this.ApellidoMed = ApellidoMed;
    }

    public Medico() {}

    public int getIdMed(){ return idMed; }
    public String getNombreMed(){ return nombreMed; }
    public String getApellidoMed(){ return ApellidoMed; }
}

