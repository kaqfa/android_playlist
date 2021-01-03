package info.fahri.playlistmusic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.room.Room;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class FormInputLagu extends AppCompatActivity {

    EditText edtJudul, edtArtis, edtTahun, edtLink;
    Spinner spnGenre;
    private LaguViewModel laguViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_input_lagu);

        edtJudul = findViewById(R.id.edt_judul);
        edtArtis = findViewById(R.id.edt_artis);
        edtTahun = findViewById(R.id.edt_tahun);
        edtLink = findViewById(R.id.edt_link);
        spnGenre = findViewById(R.id.spn_genre);
        ArrayAdapter spnAdapter = ArrayAdapter.createFromResource(this, R.array.genres_array,
                android.R.layout.simple_spinner_item);
        spnAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnGenre.setAdapter(spnAdapter);
    }

    public void saveData(View v){
        String judul = edtJudul.getText().toString();
        String artis = edtArtis.getText().toString();
        int tahun = Integer.parseInt(edtTahun.getText().toString());
        String link = edtLink.getText().toString();
        String genre = spnGenre.getSelectedItem().toString();

        final Lagu lagu = new Lagu(judul, artis, tahun, genre, link);

        laguViewModel = new ViewModelProvider(this).get(LaguViewModel.class);
        laguViewModel.insert(lagu);
        Log.d("list_lagu", "insert lagu baru - "+lagu.judul);
        finish();
    }
}
