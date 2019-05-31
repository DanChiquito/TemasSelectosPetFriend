package myapp.selectos.temas.chico.pet_friend;


public class MascotaDatos {

    private String Nombre;
    private int Peso;
    private String FechaNacimiento;
    private String Raza;
    private byte[] Foto;
    private String Tamaño;


    public MascotaDatos(String nombre, int peso, String fechaNacimiento, String raza, byte[] foto, String tamaño) {
        setNombre(nombre);
        setPeso(peso);
        setFechaNacimiento(fechaNacimiento);
        setRaza(raza);
        setFoto(foto);
        setTamaño(tamaño);
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getPeso() {
        return Peso;
    }

    public void setPeso(int peso) {
        Peso = peso;
    }

    public String getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        FechaNacimiento = fechaNacimiento;
    }

    public String getRaza() {
        return Raza;
    }

    public void setRaza(String raza) {
        Raza = raza;
    }

    public byte[] getFoto() {
        return Foto;
    }

    public void setFoto(byte[] foto) {
        Foto = foto;
    }

    public String getTamaño() {
        return Tamaño;
    }

    public void setTamaño(String tamaño) {
        Tamaño = tamaño;
    }
}
