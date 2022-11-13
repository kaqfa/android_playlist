package info.fahri.playlistmusic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import info.fahri.playlistmusic.database.Lagu;

public class ActivityDetailLagu extends AppCompatActivity {

    TextView txtJudul, txtArtis, txtGenre;
    Lagu lagu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_lagu);
        txtJudul = findViewById(R.id.txt_detail_judul);
        txtArtis = findViewById(R.id.txt_detail_artis);
        txtGenre = findViewById(R.id.txt_detail_genre);

        Intent it = getIntent();
        lagu = (Lagu) it.getSerializableExtra("lagu");
        txtJudul.setText(lagu.judul+"("+lagu.tahun+")");
        txtArtis.setText(lagu.artis);
        txtGenre.setText(lagu.genre);
    }

    public void toYoutube(View v){
        Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse(lagu.link));
        startActivity(it);
    }

    public void delete(View v){
        Log.d("list_lagu", "hapus lagu: "+lagu.judul);
        finish();
    }
}