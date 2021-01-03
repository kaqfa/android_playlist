package info.fahri.playlistmusic;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class LaguViewModel extends AndroidViewModel {

    private LaguRepository repository;
    private final LiveData<List<Lagu>> semuaLagu;

    public LaguViewModel(@NonNull Application application) {
        super(application);
        repository = new LaguRepository(application);
        semuaLagu = repository.getSemuaLagu();
    }

    LiveData<List<Lagu>> getSemuaLagu(){
        return semuaLagu;
    }

    public void insert(Lagu lagu){
        repository.insert(lagu);
    }
}
