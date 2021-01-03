package info.fahri.playlistmusic.database;

import java.io.Serializable;

public class Lagu implements Serializable {

    public int uid;
    public String judul;
    public String artis;
    public int tahun;
    public String genre;
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
