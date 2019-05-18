package myapp.selectos.temas.chico.pet_friend;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class MascotaAdatador extends RecyclerView.Adapter<MascotaAdatador.MascotaViewHolder> {

    private ArrayList<MascotaDatos> mascotaDatos;

    public MascotaAdatador(ArrayList<MascotaDatos> mascotaDatos)
    {
        this.mascotaDatos = mascotaDatos;
    }


    public static class MascotaViewHolder extends RecyclerView.ViewHolder
    {
        public ImageView imvPet;
        public TextView txtNaPet;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imvPet = itemView.findViewById(R.id.imvPet);
            txtNaPet = itemView.findViewById(R.id.txtNamePet);
        }
    }



    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_mypets,viewGroup,false);
        MascotaViewHolder mvh = new MascotaViewHolder(v);
        return  mvh;
    }

    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder mascotaViewHolder, int i) {

        MascotaDatos currentItem = mascotaDatos.get(i);

        mascotaViewHolder.imvPet.setImageResource(currentItem.getImvFoto());
        mascotaViewHolder.txtNaPet.setText(currentItem.getNamePet());
    }

    @Override
    public int getItemCount() {
        return mascotaDatos.size();
    }
}
