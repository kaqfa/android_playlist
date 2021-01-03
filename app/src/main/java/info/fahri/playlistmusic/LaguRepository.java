package info.fahri.playlistmusic;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class LaguRepository {

    private LaguDAO laguDAO;
    private LiveData<List<Lagu>> semuaLagu;

    LaguRepository(Application application){
        AppDatabase db = AppDatabase.getDatabase(application);
        laguDAO = db.laguDAO();
        semuaLagu = laguDAO.getAllLagu();
    }

    LiveData<List<Lagu>> getSemuaLagu(){
        return semuaLagu;
    }

    void insert(Lagu lagu){
        AppDatabase.dbWriter.execute(() -> {
            laguDAO.insertLagu(lagu);
        });
    }

    void delete(Lagu lagu){
        AppDatabase.dbWriter.execute(() -> {
            laguDAO.deleteLagu(lagu);
        });
    }
}
