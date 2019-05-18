package myapp.selectos.temas.chico.pet_friend;

import android.widget.ImageView;

public class MascotaDatos {

    private String namePet;
    private int imvFoto;


    public MascotaDatos(String namePet, int imvFoto) {
        this.namePet = namePet;
        this.imvFoto = imvFoto;
    }

    public String getNamePet() {
        return namePet;
    }

    public void setNamePet(String namePet) {
        this.namePet = namePet;
    }

    public int getImvFoto() {
        return imvFoto;
    }

    public void setImvFoto(int imvFoto) {
        this.imvFoto = imvFoto;
    }
}
