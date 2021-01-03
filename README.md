## Aplikasi Playlist Lagu
### Studi Kasus Lokal DB dengan SQLite

---

Aplikasi playlist lagu ini digunakan untuk studi kasus pembuatan aplikasi android dengan memanfaatkan database lokal SQLite.

Ada tiga versi source code yang disediakan yaitu:

- Starter: versi source code kerangka aplikasi dengan menyediakan koding tampilan saja
- Simple: versi source code aplikasi lengkap dengan cara koneksi basis data sederhana, tidak terlalu bagus untuk pengembangan aplikasi dan maintenance, tapi cukup untuk memahami dasar SQLite di Android
- Full: versi source code aplikasi lengkap dengan koneksi basis data yang lebih baik. Sedikit susah dipahami karena ada beberapa komponen tambahan, namun mengikuti best practice yang direkomendasikan saat ini

Masing-masing versi tersimpan di masing-masing branch.

Pada branch ini versi yang ditampilkan adalah versi Simple.

### Versi Simple:

Versi simple merupakan aplikasi jadi dari studi kasus penggunaan lokal database SQLite dengan kebutuhan minimum aplikasi.

Pada studi kasus ini kita menggunakan Android Room Database yang merupakan wrapper dari SQLite dengan tanpa mempertimbangan multi thread dan View Model.

Untuk kebutuhan real world application mungkin cara ini tidak terlalu direkomendasikan, namun sebagai dasar memahami cara pembuatan aplikasi android dengan basis data lokal, cara ini sudah cukup bagus.

Step by step pembuatan versi simple ini meliputi:

- Dimulai dari pull versi starter yang berisi activity dan layout yang diperlukan.
- Menambahkan dependency Android Room, ViewModel, serta penggunaan Java 1.8 pada build.gradle
- Mengubah model menjadi entity
- Membuat DAO untuk model
- Membuat AppDatabase untuk koneksi DB
- Koneksi dan mengambil data pada MainActivity
- Tambah data pada FormInputLagu
- Menghapus data pada DetailLaguActvity