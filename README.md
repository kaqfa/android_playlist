## Aplikasi Playlist Lagu
### Studi Kasus Lokal DB dengan SQLite

---

Aplikasi playlist lagu ini digunakan untuk studi kasus pembuatan aplikasi android dengan memanfaatkan database lokal SQLite.

Ada tiga versi source code yang disediakan yaitu:

- Starter: versi source code kerangka aplikasi dengan menyediakan koding tampilan saja
- Simple: versi source code aplikasi lengkap dengan cara koneksi basis data sederhana, tidak terlalu bagus untuk pengembangan aplikasi dan maintenance, tapi cukup untuk memahami dasar SQLite di Android
- Full: versi source code aplikasi lengkap dengan koneksi basis data yang lebih baik. Sedikit susah dipahami karena ada beberapa komponen tambahan, namun mengikuti best practice yang direkomendasikan saat ini

Masing-masing versi tersimpan di masing-masing branch.

Pada branch ini versi yang ditampilkan adalah versi Starter.

### Versi Starter:

Versi starter adalah source code yang berisi tampilan aplikasi minimal dengan form dan RecyclerView tanpa basis data dan masih belum bisa melakukan operasi tulis pada list lagu.

Komponen yang telah disediakan pada versi starter ini adalah:

- ActivityMain yg dibuat dengan Basic Activity dengan ditambahi RecyclerView
- PlaylistAdapter, adapter untuk menampilkan list lagu pada RecyclerView
- Class Model Lagu, class representasi data lagu dan digunakan pada holder
- ActivityDetailLagu yang dibuat dengan Empty Activity
- ActivityInputLagu yang dibuat dengan Empty Activity

Untuk melengkapi versi starter ini dengan fitur databse, silahkan check pada branc Full atau branc Simpel