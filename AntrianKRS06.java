public class AntrianKRS06 {
    MahasiswaKRS06[] data;
    int front;
    int rear;
    int size;
    int max;
    int totalDiproses;

    public AntrianKRS06(int max) {
        this.max = max;
        this.data = new MahasiswaKRS06[max];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
        this.totalDiproses = 0;
    }
    public boolean IsEmpty () {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }
    public boolean IsFull() {
        if (size == max) {
            return true;
        } else {
            return false;
        }
    }
    public void tambahAntrian(MahasiswaKRS06 mhs) {
        if (IsFull()) {
            System.out.println("Antrian penuh.");
            return;
        }
        rear = (rear + 1) % max;
        data[rear] = mhs;
        size++;
        System.out.println(mhs.nama + " berhasil masuk ke antrian.");
    }
    public void prosesKRS() {
        if (size < 2) {
            System.out.println("Antrian kurang dari 2, belum bisa proses KRS.");
            return;
        }
        System.out.println("Memproses KRS untuk 2 mahasiswa:");
        for (int i = 0; i < 2; i++) {
            MahasiswaKRS06 mhs = data[front];
            mhs.tampilkanData();
            front = (front + 1) % max;
            size--;
            totalDiproses++;
        }
    }
    public void tampilkanSemua() {
        if (IsEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }
        System.out.println("Daftar Mahasiswa dalam Antrian:");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % max;
            System.out.print((i + 1) + ". ");
            data[index].tampilkanData();
        }
    }
    public void tampilkan2Terdepan() {
        if (size < 2) {
            System.out.println("Antrian kurang dari 2.");
        } else {
            System.out.println("2 Mahasiswa Terdepan:");
            for (int i = 0; i < 2; i++) {
                int index = (front + i) % max;
                data[index].tampilkanData();
            }
        }
    }
    public void tampilkanAkhir() {
        if (IsEmpty()) {
            System.out.println("Antrian kosong.");
        } else {
            System.out.println("Mahasiswa paling akhir:");
            data[rear].tampilkanData();
        }
    }
    public void jumlahAntrian() {
        System.out.println("Jumlah dalam antrian: " + size);
    }
    public void jumlahSudahDiproses() {
        System.out.println("Jumlah yang sudah diproses: " + totalDiproses);
    }
    public void kosongkanAntrian() {
        front = 0;
        rear = -1;
        size = 0;
        System.out.println("Antrian berhasil dikosongkan.");
    }
}
