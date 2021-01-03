## Aplikasi Playlist Lagu
### Studi Kasus Lokal DB dengan SQLite

---

Aplikasi playlist lagu ini digunakan untuk studi kasus pembuatan aplikasi android dengan memanfaatkan database lokal SQLite.

Ada tiga versi source code yang disediakan yaitu:

- Starter: versi source code kerangka aplikasi dengan menyediakan koding tampilan saja
- Simple: versi source code aplikasi lengkap dengan cara koneksi basis data sederhana, tidak terlalu bagus untuk pengembangan aplikasi dan maintenance, tapi cukup untuk memahami dasar SQLite di Android
- Full: versi source code aplikasi lengkap dengan koneksi basis data yang lebih baik. Sedikit susah dipahami karena ada beberapa komponen tambahan, namun mengikuti best practice yang direkomendasikan saat ini

Masing-masing versi tersimpan di masing-masing branch.

Pada branch ini versi yang ditampilkan adalah versi Full.

### Versi Full:

Versi full merupakan aplikasi studi kasus yang sudah jadi, dapat di-compile dan dijalankan dengan baik.

Step by step pembuatan versi full ini meliputi:

- Dimulai dari pull versi starter yang berisi activity dan layout yang diperlukan.
- Menambahkan dependency Android Room, ViewModel, serta penggunaan Java 1.8 pada build.gradle
- Mengubah model menjadi entity
- Membuat DAO untuk model
- Membuat AppDatabase untuk koneksi DB
- Membuat repository untuk fleksibilitas sumber data
- Membuat viewmodel untuk memisahkan data dari Activity / Fragment
- Koneksi dan mengambil data pada MainActivity
- Tambah data pada FormInputLagu
- Menghapus data pada DetailLaguActvity
