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
        public TextView txtvtiempocomer;
        public TextView txtvtiempobañar;
        public TextView txtvfechavet;
        public TextView txtvtiempovet;
        public TextView txtvDirecvet;
        public TextView txtvfechavac;
        public TextView txtvtiempovac;
        public TextView txtvDirecvac;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imvPet = itemView.findViewById(R.id.imvPet);
            txtNaPet = itemView.findViewById(R.id.txtNamePet);

            txtvtiempocomer= itemView.findViewById(R.id.txtvtiempocomer);
            txtvtiempobañar= itemView.findViewById(R.id.txtvtiempobañar);
            txtvfechavet= itemView.findViewById(R.id.txtvfechavet);
            txtvtiempovet= itemView.findViewById(R.id.txtvtiempovet);
            txtvDirecvet= itemView.findViewById(R.id.txtvDirecvet);
            txtvfechavac= itemView.findViewById(R.id.txtvfechavac);
            txtvtiempovac= itemView.findViewById(R.id.txtvtiempovac);
            txtvDirecvac= itemView.findViewById(R.id.txtvDirecvac);
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

        //ASOCIANDO ELEMENTOS DE MI CARDVIEW CON MI IMFORMACIÓN
        MascotaDatos currentItem = mascotaDatos.get(i);

        mascotaViewHolder.imvPet.setImageResource(R.drawable.catdog);
        mascotaViewHolder.txtNaPet.setText(currentItem.getNombre());
        mascotaViewHolder.txtvDirecvac.setText(currentItem.getDirecVac());
        mascotaViewHolder.txtvDirecvet.setText(currentItem.getDirecVet());
        mascotaViewHolder.txtvfechavac.setText(currentItem.getFechaVac());
        mascotaViewHolder.txtvfechavet.setText(currentItem.getFechaVet());
        mascotaViewHolder.txtvtiempobañar.setText(currentItem.getHoraBathing());
        mascotaViewHolder.txtvtiempocomer.setText(currentItem.getHoraComer());
    }

    @Override
    public int getItemCount() {
        return mascotaDatos.size();
    }
}
