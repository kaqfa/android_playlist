package info.fahri.playlistmusic;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import info.fahri.playlistmusic.adapter.PlayListAdapter;
import info.fahri.playlistmusic.database.AppDatabase;
import info.fahri.playlistmusic.database.Lagu;

public class ActivityMain extends AppCompatActivity {

    ArrayList<Lagu> list_lagu;
    RecyclerView recListLagu;
    PlayListAdapter adapter;

    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recListLagu = findViewById(R.id.rec_list_lagu);

        db = AppDatabase.getDatabase(getApplicationContext());

        list_lagu = new ArrayList<>();

        adapter = new PlayListAdapter(list_lagu);
        recListLagu.setAdapter(adapter);
        recListLagu.setLayoutManager(new LinearLayoutManager(this));

        db.laguDAO().getAllLagu().observe(this, playlist -> {
            list_lagu.clear();
            list_lagu.addAll(playlist);
            adapter.notifyDataSetChanged();
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), ActivityInputLagu.class));
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}