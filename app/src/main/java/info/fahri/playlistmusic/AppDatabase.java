package info.fahri.playlistmusic;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Lagu.class}, version = 3, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract LaguDAO laguDAO();

    private static volatile AppDatabase INSTANCE;
    static final ExecutorService dbWriter = Executors.newFixedThreadPool(4);

    static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "word_database")
                            .addCallback(dbCallback).build();
                }
            }
        }
        return INSTANCE;
    }

    // opsional, hanya jika ingin punya prepopulated data aja
    private static AppDatabase.Callback dbCallback = new AppDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            dbWriter.execute(() -> {
                LaguDAO laguDAO = INSTANCE.laguDAO();
                laguDAO.insertLagu(
                        new Lagu("Tak Sengaja", "Dewi", 1995,
                                "Pop", "https://youtube.com"),
                        new Lagu("Bujangan", "Om ir", 1992,
                                "Pop", "https://youtube.com")
                );
            });
        }
    };
}
