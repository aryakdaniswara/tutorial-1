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
- Setelah saya melakukan exercise ini, saya menemukan beberapa masalah pada kode saya. Saya menemukan bahwa kode yang saya buat memiliki access modifier yang kurang tepat. Saya memperbaikinya dengan mengubahnya ke acces modifier yang benar, seperti paa public yang seharusnya private dan lain-lain. Saya juga menemukan kekurangan pada tes yang buat karena belum menguji 100%. Saya memperbaiki nya dengan melihat bagian mana yang belum kena coverage dan melengkapinya hingga coverage bisa 100%. Hal ini membuat saya lebih aware tentang test yang saya buat karena bisa jadi hanya menguji "benarnya saja" tapi tidak menguji kasus di mana kode saya seharusnya gagal dan menghandle gagal tersebut.
- Menurut saya penerapan CI/CD workflow yang saya gunakan sudah sesuai dengan prinsip Continuous Deployment. Salah satunya adalah karena Github sudah akan otomatis menjalankan pengecekan melalui workflow yang sudah saya buat di ci.yml. Selanjutnya, pengecekan kebersihan juka dilakukan secara otomatis melalui scorecard dan sonarcloud. Prinsip ini juga sudah dijalankan ketika saya menggunakan Paas yang dapat memperbarui perubahan yang saya buat, sehingga sudah sesuai dengan prinsip CI/CD. Oleh karena itu, saya merasa prinsip CI/CD sudah diterapkan sehingga semua proses dapat berlangsung secara otomatis ketika ada push atau pull.
