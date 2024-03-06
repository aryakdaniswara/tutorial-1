link: https://aryakdaniswara-e-shop123.koyeb.app/

# Modul 1
## Reflection 1

- Setelah melakukan pembelajaran dan mengerjakan modul ini, saya menjadi lebih sadar dengan 'kebiasaan koding' saya. Saya jadi belajar untuk membuat nama variabel dengan jelas sehingga tidak perlu diperjelas dengan comment lagi.
- Saya menjadi lebih berhati-hati dengan pembuatan comment. Komentar seharusnya tidak 'harus' menjelaskan kode yang saya buat. Kode yang saya buatlah yang harusnya lebih bersih dan mudah dibaca tanpa memerlukan komen penjelas yang banyak.
- Saya lebih memperhatikan dengan fungsi yang saya buat. Fungsi yang saya buat harusnya  melakukan 1 tugas saja dan lebih sederhana. Saya jadi lebih memperhatikan pembuatan fungsi sederhana dibandingkan fungsi yang besar dan kompleks.
- Saya merasa kode yang saya buat masih memiiki beberapa kesalahan dan kelemahan terutama di bagian error checking. Saya merasa belum menyeluruh dalam menanggapi error yang bisa terjadi sehingga mungkin ada kasus yang belum ada error checkingnya. Menurut saya, untuk memenuhi kekurangan ini, perlu kemampuan untuk lebih kreatif tentang error yang bisa terjadi. Saya berharap dapat menjadi lebih familiar dan dapat menanggapi error dengan lebih baik lagi.

## Reflection 2
- Setelah membuat unit test, saya merasa lebih percaya diri dengan kode yang saya buat. Kode saya sudah mencover test yang telah dibuat. Saya merasa jumlah unit test yang dibuat kurang signifikan dibandingkan dengan apa yang unit test uji. Jika kita memiliki banyak unit test, tapi tidak menguji secara menyeluruh, maka bisa saja ada bagian yang belum teruji.
- Jika code coverage mencapai 100%, tidak berarti kode yang kita buat bebas dari bugs atau error. Hal ini bisa terjadi jika test yang kita buat tidak merepresentasikan kondisi yang akan ditemui oleh kode ini di dunia nyata.
- Saya merasa menggunakan set up yang serupa dengan test sebelumnya memerlukan kehati-hatian. Alasannya adalah test seharusnya kecil dan memang terfokus pada suatu bagian. Tes tersebut harusnya memverifikasi suatu fungsionalitas saja sehingga dapat lebih mudah dipahami ketika gagal.
- Jika kita menggunakan kode duplikat, saya rasa praktik ini kurang efisien dan clean karena akan sulit untuk menjaga kodenya ketika terjadi error. Errornya dapat terjadi di berbagai tempat sekaligus dan mengharuskan kita untuk mengecek semua kemunculan kode duplikat kita.
- Saya rasa untuk memperbaiki permasalahan ini kita dapat membuat base class yang memiliki setup prosedur, yang mungkin akan kita gunakan lagi. Kita juga harus tetap menjaga agar unit test yang kita buat memang kecil dan terfokus. Terakhir, kita jangan lupa untuk membuat kode dengan nama yang deskriptif dan menggunakan komen seperluny, bukan menggunakan komen untuk mengkompensasi kode yang tidak clean

# Modul 2
## Refleksi
- Setelah saya melakukan exercise ini, saya menemukan beberapa masalah pada kode saya. Saya menemukan bahwa kode yang saya buat memiliki access modifier yang kurang tepat. Saya memperbaikinya dengan mengubahnya ke acces modifier yang benar, seperti paa public yang seharusnya default dan lain-lain. Beberapa import yang saya gunakan juga tidak terpakai sehingga saya remove. Saya juga menemukan kekurangan pada tes yang buat karena belum menguji 100%. Saya memperbaiki nya dengan melihat bagian mana yang belum kena coverage dan melengkapinya hingga coverage bisa 100%. Hal ini membuat saya lebih aware tentang test yang saya buat karena bisa jadi hanya menguji "benarnya saja" tapi tidak menguji kasus di mana kode saya seharusnya gagal dan menghandle gagal tersebut.
- Menurut saya penerapan CI/CD workflow yang saya gunakan sudah sesuai dengan prinsip Continuous Deployment. Salah satunya adalah karena Github sudah akan otomatis menjalankan pengecekan melalui workflow yang sudah saya buat di ci.yml. Selanjutnya, pengecekan kebersihan juka dilakukan secara otomatis melalui scorecard dan sonarcloud. Prinsip ini juga sudah dijalankan ketika saya menggunakan Paas yang dapat memperbarui perubahan yang saya buat, sehingga sudah sesuai dengan prinsip CI/CD. Oleh karena itu, saya merasa prinsip CI/CD sudah diterapkan sehingga semua proses dapat berlangsung secara otomatis ketika ada push atau pull.

# Modul 3
## Refleksi
Saya merasa sudah menerapkan semua prinsip SOLID pada kode yang telah dibuat, baik dengan memperbaiki, atau dari penulisannya yang sudah sesuai dengan prinsip tersebut.
- Single Responsibility Principle (SRP): Prinsip ini diterapkan dengan adanya pemisahan pada class existing Product dengan class baru Car. Prinsip ini dibuat sehingga suatu class hanya akan mempunya 1 responsibility saja pada fungsionalitas.
- Open/Closed Principle (OCP): Saya merasa prinsip ini sudah dijalankan dnegan penerapan interface pada service dan pada inherintance Car pada Product. Hal ini memungkinan untuk pengembangan yang dapat menambah fungsionalitas baru tanpa merubah source code awalnya.
- Liskov Substitution Principle (LSP): Saya merasa prinsip ini sudah saya terapkan dengan adanya inheritance dari Car pada Product, yang sesuai juga dengan kontraknya sehingga Car tidak perlu menambahkan lagi attributes yang sudah ada pada Products.
- Interface Segregation Principle (ISP): Saya merasa prinsip ini sudah dijalankan dengan melihat bagian Service saya yang memiliki 2 bagian interface pada Car dan Products. Hal ini membagi interface menjadi konsep yang lebih kecil dan tidak langsung besar begitu saja.
- Dependency Inversion Principle (DIP):  Prinsip ini sudah saya jalankan dengan mengubah dependency dari CarRepository yang awalnya bergantung pada CarServiceImpl yang merupakan detail implmentasinya menjadi bergantung pada CarService yang merupakan interface nya

Keuntungan Menerapkan Prinsip-prinsip SOLID:
- Kode Lebih Mudah Dimengerti:
Dengan menerapkan prinsip-prinsip SOLID, struktur kode akan lebih terorganisir dan terstruktur. Ini membuatnya lebih mudah dipahami oleh pengembang baru dan anggota tim lainnya.
Contoh: Memisahkan kelas-kelas menjadi unit-unit yang terisolasi sesuai dengan fungsinya masing-masing, membuat alur logika program lebih jelas dan mudah dipahami.

- Kode Lebih Mudah Diperbaiki dan Dimodifikasi:
Kode yang dibuat dengan memperhatikan prinsip-prinsip SOLID memiliki tingkat kohesi yang tinggi, sehingga perubahan atau perbaikan dapat dilakukan dengan lebih mudah tanpa menyebabkan efek samping pada bagian-bagian lain dari sistem.
Contoh: Jika terdapat kesalahan pada fitur tertentu, perubahan dapat dilakukan pada kelas yang bertanggung jawab terhadap fitur tersebut tanpa harus memodifikasi kelas-kelas lain yang tidak terkait.

- Fleksibilitas dan Skalabilitas yang Lebih Baik:
Prinsip-prinsip SOLID mempromosikan desain yang lebih fleksibel dan dapat diubah. Ini memungkinkan pengembang untuk menyesuaikan aplikasi dengan lebih baik terhadap perubahan kebutuhan bisnis atau teknologi.
Contoh: Dengan menggunakan pola desain seperti Dependency Injection, aplikasi menjadi lebih mudah untuk disesuaikan dengan integrasi komponen baru atau penggantian komponen yang ada.

- Memfasilitasi Pengujian (Testing) yang Lebih Mudah:
Desain yang baik sesuai dengan prinsip-prinsip SOLID memungkinkan untuk pengujian yang lebih efektif. Kode yang terpisah dan terisolasi dengan baik lebih mudah untuk diuji secara unit dan diuji otomatis.
Contoh: Pengujian unit dapat dilakukan dengan lebih mudah karena kelas-kelas memiliki tanggung jawab yang terdefinisi dengan jelas dan dependensi yang terisolasi.

Kerugian Tidak Menerapkan Prinsip-prinsip SOLID:

- Kode Sulit Dimengerti dan Dipelihara:
Tanpa prinsip-prinsip SOLID, kode cenderung menjadi sulit dimengerti karena struktur dan tanggung jawabnya tidak terorganisir dengan baik. Ini menyebabkan kesulitan dalam pemeliharaan dan pembaruan kode.
Contoh: Jika logika bisnis tersebar di berbagai bagian aplikasi tanpa struktur yang jelas, mengidentifikasi dan memperbaiki bug akan menjadi tantangan.

- Keharusan Perubahan Berantai (Ripple Effect):
Ketika perubahan dilakukan pada satu bagian kode, hal ini seringkali memengaruhi bagian-bagian lainnya yang saling tergantung. Tanpa SOLID, perubahan kecil pun sering kali memerlukan perubahan yang lebih besar.
Contoh: Ketika mengubah struktur database, tanpa SOLID, hal ini mungkin memerlukan perubahan besar-besaran pada kode aplikasi yang bergantung pada struktur database tersebut.

- Kerusakan Keamanan dan Stabilitas:
Kode yang tidak sesuai dengan prinsip-prinsip SOLID cenderung memiliki kelemahan keamanan yang lebih tinggi. Desain yang buruk bisa memunculkan kerentanan keamanan dan bug yang menyebabkan aplikasi tidak stabil.
Contoh: Kegagalan untuk memisahkan tanggung jawab secara jelas dapat menyebabkan masalah keamanan seperti kebocoran data atau serangan injeksi.

- Kode Sulit Diuji (Testing):
Ketika kode tidak dipisahkan dengan baik dan memiliki dependensi yang kuat antara satu sama lain, pengujian unit dan integrasi menjadi sulit dilakukan. Hal ini menyebabkan kesulitan dalam menemukan dan memperbaiki bug.
Contoh: Jika kelas-kelas memiliki ketergantungan langsung satu sama lain tanpa menggunakan konsep dependensi terbalik, maka pengujian unit menjadi tidak mungkin dilakukan dengan baik.

# Modul 4
## Refleksi
Dalam melakukan modul ini, saya merasa proses TDD cukup membantu saya. TDD mendorong fokus pada langkah-langkah kecil yang bertahap, yang dapat meningkatkan pemahaman dan pembelajaran selama proses pengembangan. Dengan menulis pengujian sebelum mengimplementasikan kode, pengembang mendapatkan pemahaman yang lebih jelas tentang persyaratan dan perilaku yang diinginkan.

TDD memang dapat meningkatkan kepercayaan diri pada basis kode. Karena pengujian ditulis sebelum kode, pengembang dapat memastikan bahwa perubahan yang mereka lakukan tidak menyebabkan kemunduran. Menjalankan pengujian secara rutin akan memberikan umpan balik secara instan, sehingga meningkatkan kepercayaan diri akan kebenaran kode.

TDD mendorong kode yang lebih mudah untuk di-refactor dan dipelihara. Karena pengujian bertindak sebagai jaring pengaman, pengembang dapat melakukan refactor dengan percaya diri, karena mengetahui bahwa jika mereka secara tidak sengaja merusak sesuatu, pengujian akan menangkapnya. Hal ini memfasilitasi kelincahan dalam menanggapi perubahan kebutuhan.

TDD dapat membantu meminimalkan cacat dengan menangkap masalah di awal proses pengembangan. Karena pengujian ditulis sebelum kode, pengembang lebih mungkin untuk mempertimbangkan kasus-kasus yang tidak terduga dan potensi jebakan, sehingga mengurangi kemungkinan cacat yang lolos.
Berdasarkan evaluasi ini, tampaknya alur kerja TDD yang digunakan dalam latihan ini memang berguna. Ini mendukung pembelajaran, meningkatkan kepercayaan diri, memfasilitasi perubahan, dan meminimalkan cacat. Namun, selalu ada ruang untuk perbaikan.

Akan tetapi, saya juga merasakan kesulitan ketika melakukan penerapan dari proses TDD. Saya khawatir tes awal yang saya buat kurang meneliti keseluruhan fitur, kurang merepresentasikan kondisi yang ingin diuji, atau membuat tes yang salah atau tidak tepat dari fitur yang saya inginkan. Hal ini menyebabkan saya harus mengoreksi kembali, tes yang saya buat dan memastikan ulang.

Dalam penulisan test yang sesuai dengan prinsip FIRST:
- Fast: Saya merasa prinsip ini sudah dijalankan dengan menerapkan test yang bisa langsung diujicobakan. Pengujian harus berjalan dengan cepat untuk memberikan umpan balik langsung kepada pengembang. Jika pengujian berjalan lambat, pengembang mungkin cenderung tidak akan sering menjalankannya.
- Independen: Saya telah memisahkan unit test dan functional test. Tes yang saya buat juga menguji suatu fungsi tertentu. Pengujian tidak boleh bergantung satu sama lain atau pada faktor eksternal. Hal ini memastikan bahwa kegagalan dalam satu pengujian tidak akan berantai dan pengujian dapat dijalankan dalam urutan apa pun.
- Repeatable: Test yang saya buat tentunya akan menghasilkan hasil yang sesuai dengan kode yang ada. Pengujian harus memberikan hasil yang sama secara konsisten, terlepas dari kapan dan di mana pengujian tersebut dijalankan. Hal ini memastikan keandalan dan membantu dalam melakukan debugging.
- Self Validate: Test yang telah saya buat langsung memverifikasi sesuai dengan kondisi yang ada sehingga prinsip ini terpenuhi. Pengujian harus menyatakan hasil lulus atau gagal yang jelas tanpa perlu interpretasi manual. Hal ini memungkinkan otomatisasi proses pengujian.
- Timely: Pada prinsip ini, awalnya saya membuat tes di akhir atau di tengah pembuatan fitur. Namun, setelah mengetahui TDD, saya mulai menerapkan untuk membuat tes di awal. Tes harus ditulis tepat waktu, idealnya sebelum kode implementasi. Hal ini memastikan bahwa proses pengembangan tetap fokus pada persyaratan dan perilaku yang diinginkan.
