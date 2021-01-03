package info.fahri.playlistmusic.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "lagu")
public class Lagu implements Serializable {

    @PrimaryKey(autoGenerate = true)
    public int uid;
    @ColumnInfo
    public String judul;
    @ColumnInfo
    public String artis;
    @ColumnInfo
    public int tahun;
    @ColumnInfo
    public String genre;
    @ColumnInfo
    public String link;

    public Lagu(String judul, String artis, int tahun, String genre, String link) {
        this.judul = judul;
        this.artis = artis;
        this.tahun = tahun;
        this.genre = genre;
        this.link = link;
    }

    @Override
    public String toString() {
        return this.judul+" : "+this.artis;
    }
}
