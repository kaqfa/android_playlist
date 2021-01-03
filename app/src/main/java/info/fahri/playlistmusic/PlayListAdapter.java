package info.fahri.playlistmusic;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PlayListAdapter extends RecyclerView.Adapter<PlayListAdapter.LaguViewHolder> {

    private List<Lagu> listLagu;

    public PlayListAdapter(List<Lagu> listLagu) {
        this.listLagu = listLagu;
    }

    @NonNull
    @Override
    public PlayListAdapter.LaguViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        LaguViewHolder holder = new LaguViewHolder(inflater.inflate(
                        R.layout.item_lagu_layout, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull PlayListAdapter.LaguViewHolder holder, int position) {
        Lagu lagu = listLagu.get(position);
        holder.txtJudul.setText(lagu.judul);
        holder.txtArtis.setText(lagu.artis);
        holder.laguItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = holder.itemView.getContext();
                Intent it = new Intent(context, DetailLaguActivity.class);
                it.putExtra("lagu", lagu);
                context.startActivity(it);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listLagu.size();
    }

    class LaguViewHolder extends RecyclerView.ViewHolder{
        TextView txtJudul, txtArtis;
        ConstraintLayout laguItem;

        public LaguViewHolder(@NonNull View itemView) {
            super(itemView);
            txtJudul = itemView.findViewById(R.id.txt_judul);
            txtArtis = itemView.findViewById(R.id.txt_artis);
            laguItem = itemView.findViewById(R.id.lagu_item);
        }
    }
}
