package info.fahri.playlistmusic;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface LaguDAO {

    @Query("select * from lagu order by judul asc")
    LiveData<List<Lagu>> getAllLagu();

    @Insert
    void insertLagu(Lagu... list_lagu);

    @Delete
    void deleteLagu(Lagu lagu);
}
