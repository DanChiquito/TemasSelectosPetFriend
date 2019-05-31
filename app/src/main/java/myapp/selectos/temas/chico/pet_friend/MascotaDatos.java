package myapp.selectos.temas.chico.pet_friend;


import android.graphics.Bitmap;


public class MascotaDatos {

    private String Nombre;
    private int Peso;
    private String FechaNacimiento;
    private String Raza;
    private byte[] Foto;
    private String Tamaño;


    public MascotaDatos(String nombre, int peso, String fechaNacimiento, String raza, byte[] foto, String tamaño) {
        Nombre = nombre;
        Peso = peso;
        FechaNacimiento = fechaNacimiento;
        Raza = raza;
        Foto = foto;
        Tamaño = tamaño;
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

    public  byte[] getFoto() {
        return Foto;
    }

    public void setFoto( byte[] foto) {
        Foto = foto;
    }

    public String getTamaño() {
        return Tamaño;
    }

    public void setTamaño(String tamaño) {
        Tamaño = tamaño;
    }




}
