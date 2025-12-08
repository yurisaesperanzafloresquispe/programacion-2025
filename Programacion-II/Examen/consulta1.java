package abcdearchivos;

public class Consulta {
    private int ci, idMed, dias, anios;
    private String nombrePaciente, apellidoPaciente, mes;

    public Consulta(int ci, int idMed, int dias, int anios,
                     String nombrePaciente, String apellidoPaciente, String mes) {
        this.ci = ci;
        this.idMed = idMed;
        this.dias = dias;
        this.anios = anios;
        this.nombrePaciente = nombrePaciente;
        this.apellidoPaciente = apellidoPaciente;
        this.mes = mes;
    }

    public Consulta() {}

    public int getDias(){ return dias; }
    public void setDias(int d){ dias = d; }

    public int getIdMed(){ return idMed; }
    public String getMes(){ return mes; }

    public String getNombrePaciente(){ return nombrePaciente; }
    public String getApellidoPaciente(){ return apellidoPaciente; }
}
