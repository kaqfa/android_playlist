package info.fahri.playlistmusic.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Lagu.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract LaguDAO laguDAO();

    private static volatile AppDatabase INSTANCE;

    public static AppDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, "playlist_musik")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
//                    .addCallback(preCallback)
                    .build();
        }
        return INSTANCE;
    }

    // opsional, hanya jika ingin punya prepopulated data aja
    private static AppDatabase.Callback preCallback = new AppDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            LaguDAO laguDAO = INSTANCE.laguDAO();
            laguDAO.insert(
                    new Lagu("Memories", "Maroon 5", 2019,
                            "Pop", "https://youtu.be/SlPhMPnQ58k"),
                    new Lagu("Believer", "Imagine Dragons", 2017,
                            "Rock", "https://youtu.be/7wtfhZwyrcc"),
                    new Lagu("Hymn For The Weekend", "Coldplay", 2018,
                            "Pop", "https://youtu.be/YykjpeuMNEk")
            );
        }
    };
}
