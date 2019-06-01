package myapp.selectos.temas.chico.pet_friend;


public class MascotaDatos {

    private String nombre;
    private String peso;
    private String fechaNacimiento;
    private String raza;
    //private int Foto;
    private String size;
    private String direcVet;
    private String fechaVet;
    private String horaVet;
    private String fechaVac;
    private String horaVac;
    private String direcVac;
    private String horaComer;
    private String horaBathing;

    public MascotaDatos(String nombre, String peso, String fechaNacimiento, String raza, String size, String direcVet, String fechaVet, String horaVet, String fechaVac, String horaVac, String direcVac, String horaComer, String horaBathing) {
        this.setNombre(nombre);
        this.setPeso(peso);
        this.setFechaNacimiento(fechaNacimiento);
        this.setRaza(raza);
        this.setSize(size);
        this.setDirecVet(direcVet);
        this.setFechaVet(fechaVet);
        this.setHoraVet(horaVet);
        this.setFechaVac(fechaVac);
        this.setHoraVac(horaVac);
        this.setDirecVac(direcVac);
        this.setHoraComer(horaComer);
        this.setHoraBathing(horaBathing);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDirecVet() {
        return direcVet;
    }

    public void setDirecVet(String direcVet) {
        this.direcVet = direcVet;
    }

    public String getFechaVet() {
        return fechaVet;
    }

    public void setFechaVet(String fechaVet) {
        this.fechaVet = fechaVet;
    }

    public String getHoraVet() {
        return horaVet;
    }

    public void setHoraVet(String horaVet) {
        this.horaVet = horaVet;
    }

    public String getFechaVac() {
        return fechaVac;
    }

    public void setFechaVac(String fechaVac) {
        this.fechaVac = fechaVac;
    }

    public String getHoraVac() {
        return horaVac;
    }

    public void setHoraVac(String horaVac) {
        this.horaVac = horaVac;
    }

    public String getDirecVac() {
        return direcVac;
    }

    public void setDirecVac(String direcVac) {
        this.direcVac = direcVac;
    }

    public String getHoraComer() {
        return horaComer;
    }

    public void setHoraComer(String horaComer) {
        this.horaComer = horaComer;
    }

    public String getHoraBathing() {
        return horaBathing;
    }

    public void setHoraBathing(String horaBathing) {
        this.horaBathing = horaBathing;
    }
}
