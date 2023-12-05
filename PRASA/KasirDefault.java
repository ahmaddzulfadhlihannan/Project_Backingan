import java.util.Random;
import java.util.Scanner;

public class KasirDefault {
    // Fungsi Scanner
    private static Scanner sc = new Scanner(System.in);

    // Fungsi acak
    private static Random acak = new Random();

    // Fungsi Variabel Data Karyawan
    private static String userKaryawan[] = new String[30];
    private static String passKaryawan[] = new String[30];

    // Fungsi Variabel Membership
    private static int jumlahPelanggan = 0; 
    private static int maxMembership = 12;
    private static String[] namaPelanggan = new String[maxMembership];
    private static String[] nomorMember = new String[maxMembership];

    // Fungsi Variabel Laporan Penjualan
    private static double penjualanPotong[] = new double[30];
    private static double penjualanRias[] = new double[30];
    private static double penjualanPaket[] = new double[30];
    private static double penjualanMembership[] = new double[30];
    private static double potonganDiskonHarian[] = new double[30];
    private static double totalHargaAsliHarian[] = new double[30];

    // Fungsi Variabel Booking
    private static String namaBooking[] = new String[30];
    private static String jamBooking[] = new String[30];
    private static int jumlahBooking = 0;

    // Fungsi Variabel Ketentuan Diskon
    private static String hariDiskon[] = { "Hari Biasa", "Hari Kemerdekaan", "Tahun Baru", "Ramadhan", "Lebaran" };
    private static double diskonHari[][] = { { 0, 0, 0.05 }, { 0.08, 0.17, 0.20 }, { 0.03, 0.07, 0.10 },
            { 0.05, 0.08, 0.11 }, { 0.02, 0.05, 0.09 } };
    private static int inputHariDiskon;
    private static double penghasilanBulanan = 0;
    private static int i;

    // Fungsi Variabel Pengaturan Stok
    private static int stokSampo[] = new int[30];
    private static int stokMakeUp[] = new int[30];

    // Fungsi Variabel Pilihan Menu
    private static boolean kembaliKeMenu;

    // Fungsi Variabel Penjualan
    private static double penjualanHarian[] = new double[30];
    private static String namaJenisPelayanan[] = { "Potong", "Rias", "Paket potong rias", "Daftar membership" };
    private static double hargaAsli[] = { 10000, 20000, 30000, 60000 };
    private static double hargaJenisPelayanan[] = { 15000, 25000, 36000, 65000 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Inisialisasi variabel dan array
        String dataUserKaryawan[] = { "albedo", "ainz", "demiurge", "cocytus", "shaltear", "sebas" };
        String dataPassKaryawan[] = { "ainssama", "diamlah", "subarashi", "ojisan", "dearinsaka", "tuanku" };
        int menu;
        String hariKetentuanDiskon = "";
        boolean kembaliKeLogin = false;

        // Loop untuk setiap hari kerja
        for (i = 0; i < penjualanHarian.length; i++) {
            // Inisialisasi nilai array
            penjualanHarian[i] = 0;
            penjualanPotong[i] = 0;
            penjualanRias[i] = 0;
            penjualanPaket[i] = 0;
            potonganDiskonHarian[i] = 0;

            // Login karyawan
            System.out.println("========== APLIKASI KASIR ==========");
            System.out.println("Selamat datang di Aplikasi Kasir Salon!");
            System.out.println("Silakan LOGIN untuk mengakses fitur.");
            System.out.print("Username: ");
            userKaryawan[i] = sc.next();
            System.out.print("Password: ");
            passKaryawan[i] = sc.next();
            System.out.println("====================================");

            // Validasi login
            boolean loginSukses = false;
            for (int karyawanKasir = 0; karyawanKasir < dataUserKaryawan.length; karyawanKasir++) {
                if (userKaryawan[i].equals(dataUserKaryawan[karyawanKasir])
                        && passKaryawan[i].equals(dataPassKaryawan[karyawanKasir])) {
                    loginSukses = true;
                    break;
                }
            }

            // Jika login gagal, ulangi loop login
            if (!loginSukses) {
                System.out.println("Login gagal. Username atau password tidak valid.");
                System.out.println("Pastikan Anda memasukkan informasi dengan benar.");
                System.out.println("Silakan coba lagi.");
                System.out.println("===============================================");
                i--;
                continue;
            }

            // Input Hari Diskon
            boolean inputHariValid = false;
            do {
                System.out.println("===============================================");
                System.out.println("HARI DENGAN KETENTUAN DISKON");
                System.out.println("===============================================");
                for (int ac = 0; ac < hariDiskon.length; ac++) {
                    System.out.println((ac + 1) + ". " + hariDiskon[ac]);
                }

                System.out.print("Masukkan nomor hari untuk ketentuan diskon: ");
                inputHariDiskon = sc.nextInt();

                // Validasi nomor hari yang dimasukkan
                if (inputHariDiskon >= 1 && inputHariDiskon <= hariDiskon.length) {
                    hariKetentuanDiskon = hariDiskon[inputHariDiskon - 1];
                    System.out.println("Anda memilih hari: " + hariKetentuanDiskon);
                    inputHariValid = true;
                } else {
                    System.out.println("Nomor hari tidak valid. Harap masukkan nomor yang sesuai.");
                }

            } while (!inputHariValid);

            System.out.println("===============================================");
            System.out.println("INPUT STOK HARI KE-" + (i + 1));
            System.out.println("===============================================");
            System.out.print("Stok Sampo (bilangan bulat): ");
            stokSampo[i] = sc.nextInt();
            System.out.print("Stok Make Up (bilangan bulat): ");
            stokMakeUp[i] = sc.nextInt();
            System.out.println("===============================================");

            // Menu utama
            do {
                System.out.println("===============================================");
                System.out.println("SELAMAT DATANG DI APLIKASI SALON HARI KE-" + (i + 1));
                System.out.println("Menu Kasir Hari : " + hariKetentuanDiskon);
                System.out.println("1. Fitur utama pembayaran dan struk");
                System.out.println("2. Membership");
                System.out.println("3. Laporan penjualan");
                System.out.println("4. Booking");
                System.out.println("5. Sistem pembayaran");
                System.out.println("6. Ketentuan diskon");
                System.out.println("7. Stok hari ini");
                System.out.println("0. Keluar");
                System.out.println("Pilih menu");
                menu = sc.nextInt();
                System.out.println("===============================================");
                kembaliKeMenu = false;

                switch (menu) {
                    case 1:
                        fiturUtamaPembayaran(i);
                        break;

                    case 2:
                        menuMembership();
                        break;

                    case 3:
                        menuLaporan();
                        break;

                    case 4:
                        menuBooking();
                        break;
                    case 5:
                        prosesSistemPembayaran(sc);
                        break;

                    case 6:
                        tampilkanKetentuanDiskon(sc);
                        break;
                    case 7:
                        menuPengaturanStok();
                        break;
                    case 0:
                        // Keluar dari aplikasi
                        kembaliKeLogin = true;
                        break;

                    default:
                        System.out.println("Pilihan tidak valid. Silakan pilih menu yang sesuai.");
                        break;
                }
            } while (menu != 0);

            // Jika kembali ke login, reset nilai kembaliKeLogin
            if (kembaliKeLogin) {
                kembaliKeLogin = false;
            }
        }
        sc.close();
    }

    // FITUR 1 TRANSAKSI DAN CETAK STRUK
    // Fungsi menambah dan menghitung item
    private static void fiturUtamaPembayaran(int hariKe) {
        int nomorItem[] = new int[100], jumlah[] = new int[100];
        double harga[] = new double[100], totalHarga = 0;
        int j = 0;

        System.out.println("=====Fitur utama pembayaran=====");
        System.out.println("List jenis pelayanan :");

        for (int k = 0; k < namaJenisPelayanan.length; k++) {
            System.out.printf("%d. %-20s - Rp%.2f%n", (k + 1), namaJenisPelayanan[k], hargaJenisPelayanan[k]);
        }

        System.out.println("Masukkan 0 pada Nomor item untuk mengakhiri transaksi dan menghitung total pembelian");

        do {
            System.out.print("Nomor item : ");
            nomorItem[j] = sc.nextInt();

            if (nomorItem[j] == 0 || nomorItem[j] > namaJenisPelayanan.length) {
                break;
            }

            System.out.print("Jumlah: ");
            jumlah[j] = sc.nextInt();
            harga[j] = hargaJenisPelayanan[nomorItem[j] - 1] * jumlah[j];
            totalHarga += harga[j];

            switch (nomorItem[j]) {
                case 1:
                    penjualanPotong[hariKe] += harga[j];
                    break;
                case 2:
                    penjualanRias[hariKe] += harga[j];
                    break;
                case 3:
                    penjualanPaket[hariKe] += harga[j];
                    break;
                case 4:
                    penjualanMembership[hariKe] += harga[j];
                    break;
            }

            penjualanHarian[hariKe] += harga[j];
            penghasilanBulanan += harga[j];
            totalHargaAsliHarian[hariKe] += hargaAsli[nomorItem[j] - 1] * jumlah[j];
            j++;
        } while (nomorItem[j - 1] != 0);

        System.out.printf("Total Harga: Rp%.2f%n", totalHarga);

        double diskon = 0;

        if (totalHarga >= 300000) {
            diskon = diskonHari[inputHariDiskon - 1][2];
        } else if (totalHarga >= 200000) {
            diskon = diskonHari[inputHariDiskon - 1][1];
        } else if (totalHarga >= 100000) {
            diskon = diskonHari[inputHariDiskon - 1][0];
        }

        double bayar = totalHarga - (totalHarga * diskon);
        potonganDiskonHarian[hariKe] += totalHarga * diskon;

        System.out.printf("Total Bayar setelah diskon: Rp%.2f%n", bayar);

        System.out.print("Uang diterima: Rp");
        double uangDiterima = sc.nextDouble();

        System.out.println("Cetak struk? (y/t)");
        String cetakStruk = sc.next();

        if (cetakStruk.equalsIgnoreCase("y")) {
            cetakStrukBelanjaan(hariKe, nomorItem, jumlah, harga, totalHarga, diskon, bayar, uangDiterima);
        }
    }

    // Fungsi cetak struk
    private static void cetakStrukBelanjaan(int hariKe, int[] nomorItem, int[] jumlah, double[] harga,
            double totalHarga,
            double diskon, double bayar, double uangDiterima) {
        System.out.println("===============================================");
        System.out.println("Struk belanjaan");
        System.out.println("Kasir : " + userKaryawan[i]);

        // Header
        System.out.printf("%-20s%-10s%-10s%n", "Item", "Jumlah", "Harga");
        System.out.println("===============================================");

        // Item details
        for (int k = 0; k < nomorItem.length; k++) {
            if (nomorItem[k] == 0) {
                break;
            }

            System.out.printf("%-20s%-10dRp%-10.2f%n", namaJenisPelayanan[nomorItem[k] - 1], jumlah[k], harga[k]);
        }

        System.out.println("===============================================");
        System.out.printf("%-20s%-10sRp%-10.2f%n", "Total Harga:", "", totalHarga);
        System.out.printf("%-20s%-10sRp%-10.2f%n", "Diskon:", "", totalHarga * diskon);
        System.out.printf("%-20s%-10sRp%-10.2f%n", "Total Bayar:", "", bayar);
        System.out.printf("%-20s%-10sRp%-10.2f%n", "Uang Diterima:", "", uangDiterima);
        System.out.printf("%-20s%-10sRp%-10.2f%n", "Uang Kembalian:", "", uangDiterima - bayar);
        System.out.println("===============================================");
    }

    // FITUR 2 MEMBERSHIP
    // Menu Membership
    private static void menuMembership() {
        int menuMembership;
        boolean kembaliKeMenu = false;

        do {
            // Fitur Membership
            System.out.println("===============================================");
            System.out.println("MENU MEMBERSHIP");
            System.out.println("===============================================");
            System.out.println("1. Pendaftaran pelanggan membership");
            System.out.println("2. Cek nomor membership pelanggan & Benerfit");
            System.out.println("3. List daftar pelanggan membership");
            System.out.println("0. Keluar");
            menuMembership = sc.nextInt();
            System.out.println("===============================================");

            switch (menuMembership) {
                case 1:
                    pendaftaranPelangganMembership(acak, jumlahPelanggan, namaPelanggan, nomorMember, maxMembership);
                    break;

                case 2:
                    cekNomorMembership();
                    break;

                case 3:
                    tampilkanListPelangganMembership();
                    break;

                case 0:
                    kembaliKeMenu = true;
                    break;

                default:
                    System.out.println("===============================================");
                    System.out.println("Pilihan tidak valid. Silakan pilih menu yang sesuai.");
                    System.out.println("===============================================");
                    break;
            }
        } while (menuMembership != 0);

        if (kembaliKeMenu) {
            kembaliKeMenu = false;
        }
    }

    // Fungsi pendaftaran pelanggan membership
    private static void pendaftaranPelangganMembership(Random acak, int jumlahKustomer, String[] namaPelangganArray,
        String[] nomorMemberArray, int maxMembership) {

    if (jumlahPelanggan >= maxMembership) {
        System.out.println("===============================================");
        System.out.println("Maaf, membership bulan ini sudah terisi semua.");
        return;
    }
    System.out.println("===============================================");
    System.out.println("Pendaftaran Pelanggan Membership");
    System.out.println("===============================================");
    System.out.print("Nama Pelanggan: ");
    String nama = sc.next();
    boolean namaSudahTerdaftar = false;

    for (int n = 0; n < jumlahPelanggan; n++) {
        if (nama.equals(namaPelangganArray[n])) {
            namaSudahTerdaftar = true;
            break;
        }
    }

    if (!namaSudahTerdaftar) {
        // Generate nomor member secara acak
        String karakter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder nomorMemberBaru = new StringBuilder();

        for (int o = 0; o < 8; o++) {
            int index = acak.nextInt(karakter.length());
            nomorMemberBaru.append(karakter.charAt(index));
        }

        namaPelangganArray[jumlahPelanggan] = nama;
        nomorMemberArray[jumlahPelanggan] = nomorMemberBaru.toString();
        System.out.println("===============================================");
        System.out.println("Pendaftaran berhasil!\n");
        System.out.println("===============================================");
        System.out.println("Nama Pelanggan : " + namaPelangganArray[jumlahPelanggan]);
        System.out.println("Nomor Member : " + nomorMemberArray[jumlahPelanggan]);
        System.out.println("===============================================");
        jumlahPelanggan++;
    } else {
        System.out.println("===============================================");
        System.out.println("Nama pelanggan sudah terdaftar");
        System.out.println("===============================================");
    }

}


    // Fungsi cek nomor membership dan benefit
    private static void cekNomorMembership() {
        System.out.println("===============================================");
        System.out.println("Cek nomor membership");
        System.out.println("===============================================");
        System.out.println("Masukkan nomor membership");
        String cariNomorMembership = sc.next();
        boolean nomorTerdaftar = false;

        for (int p = 0; p < maxMembership; p++) {
            if (cariNomorMembership.equals(nomorMember[p])) {
                System.out.println("===============================================");
                System.out.println("Nama : " + namaPelanggan[p]);
                System.out.println("Nomor member : " + nomorMember[p]);
                System.out.println("Nomor terdaftar sebagai membership");

                // Panggil fungsi untuk memberikan pelayanan ekstra
                pelayananExtra(p);
                System.out.println("===============================================");

                nomorTerdaftar = true;
                break;
            }

        }
        if (!nomorTerdaftar) {
            System.out.println("===============================================");
            System.out.println("Nomor tidak terdaftar sebagai membership");
        }
    }

    // Fungsi benefit pelanggan membership
    private static void pelayananExtra(int indexPelanggan) {
        System.out.println("===============================================");
        System.out.println("Benefit Pelanggan membership : ");
        System.out.println("1. Ruangan VIP");
        System.out.println("2. Free Wifi dan Akses Internet");
        System.out.println("Ditambah pelayanan extra random :");

        // Pelayanan extra
        String[] pelayananExtra = { "Pijat kepala", "Keramas", "Rendam kaki air hangat", "Potong kuku" };

        // Acak indeks pelayanan extra
        Random random = new Random();
        int indeksAcak = random.nextInt(pelayananExtra.length);

        // Tampilkan pelayanan extra yang diacak
        System.out.println("1. " + pelayananExtra[indeksAcak]);
    }

    // Fungsi untuk menampilkan list daftar pelanggan membership
    private static void tampilkanListPelangganMembership() {
        System.out.println("List daftar pelanggan membership");
        System.out.printf("%-15s %-15s %-20s\n", "Pelanggan ke", "Nama", "Nomor Member");
        System.out.println("===============================================");
        for (int l = 0; l < jumlahPelanggan; l++) {
            System.out.printf("%-15d %-15s %-20s\n", (l + 1), namaPelanggan[l], nomorMember[l]);
        }
        System.out.println("===============================================");
    }

    // FITUR 3 LAPORAN PENJUALAN
    // Fungsi Menu Laporan
    private static void menuLaporan() {
        int menuLaporan;
        boolean kembaliKeMenu = false;

        do {
            // Laporan penjualan
            System.out.println("===============================================");
            System.out.println("MENU LAPORAN PENJUALAN");
            System.out.println("===============================================");
            System.out.println("1. Laporan penjualan hari ini");
            System.out.println("2. Laporan penjualan bulan ini (per 30 hari)");
            System.out.println("0. Keluar");
            System.out.println("Pilih menu");
            menuLaporan = sc.nextInt();
            System.out.println("===============================================");

            switch (menuLaporan) {
                case 1:
                    laporanPenjualanHariIni(i);
                    break;

                case 2:
                    laporanPenjualanBulanIni(i);
                    break;

                case 0:
                    kembaliKeMenu = true;
                    break;

                default:
                    System.out.println("===============================================");
                    System.out.println("Pilihan tidak valid. Silakan pilih menu yang sesuai.");
                    System.out.println("===============================================");
                    break;
            }
        } while (menuLaporan != 0);

        if (kembaliKeMenu) {
            kembaliKeMenu = false;
        }
    }

    // Fungsi laporan hari ini
    private static void laporanPenjualanHariIni(int hariKe) {
        System.out.println("===============================================");
        System.out.println("LAPORAN PENJUALAN HARI INI");
        System.out.println("Hari ke-" + (hariKe + 1));
        System.out.println("Kasir yang bertanggung jawab : " + (userKaryawan[hariKe]));
        System.out.println("===============================================");
        System.out.println("Penghasilan pelayanan potong : " + (penjualanPotong[hariKe]));
        System.out.println("Penghasilan pelayanan rias : " + (penjualanRias[hariKe]));
        System.out.println("Penghasilan paket peayanan potong dan rias : " + (penjualanPaket[hariKe]));
        System.out.println("Penghasilan membership : " + (penjualanMembership[hariKe]));
        System.out.println("Total penghasilan : " + penjualanHarian[hariKe]);
        System.out.println("Penghasilan bersih : " + (totalHargaAsliHarian[hariKe]));
        System.out.println("Jumlah potongan diskon harian : " + (potonganDiskonHarian[hariKe]));
    }

    // Fungsi laporan bulan ini
    private static void laporanPenjualanBulanIni(int hariKe) {
        System.out.println("===============================================");
        System.out.println("Laporan penjualan bulan ini (per 30 hari)");
        for (int p = 0; p <= i; p++) {
            System.out.println("===============================================");
            System.out.println("Hari ke-" + (p + 1));
            System.out.println("Kasir yang bertanggung jawab : " + (userKaryawan[p]));
            System.out.println("===============================================");
            System.out.println("Penghasilan pelayanan potong : " + (penjualanPotong[p]));
            System.out.println("Penghasilan pelayanan rias : " + (penjualanRias[p]));
            System.out.println("Penghasilan paket peayanan potong dan rias : " + (penjualanPaket[p]));
            System.out.println("Penghasilan membership : " + (penjualanMembership[p]));
            System.out.println("Total penghasilan : " + penjualanHarian[p]);
            System.out.println("Penghasilan bersih : " + (totalHargaAsliHarian[p]));
            System.out.println("Jumlah potongan diskon harian : " + (potonganDiskonHarian[p]));
        }
        System.out.println("===============================================");
        System.out.println("Penghasilan bulanan : " + penghasilanBulanan);
        System.out.println("===============================================");
    }

    // FITUR 4 BOOKING
    // Fungsi Menu Booking
    private static void menuBooking() {
        int menuBooking;
        boolean kembaliKeMenu = false;

        do {
            System.out.println("===============================================");
            System.out.println("MENU BOOKING :");
            System.out.println("===============================================");
            System.out.println("1. Daftar booking");
            System.out.println("2. List pelanggan booking");
            System.out.println("3. Tandai pelanggan");
            System.out.println("0. Keluar");
            menuBooking = sc.nextInt();
            System.out.println("===============================================");

            switch (menuBooking) {
                case 1:
                    daftarBookingPelanggan();
                    break;
                case 2:
                    listPelangganBooking();
                    break;
                case 3:
                    tandaiPelanggan();
                    break;
                case 0:
                    kembaliKeMenu = true;
                    break;
                default:
                    System.out.println("===============================================");
                    System.out.println("Pilihan tidak valid. Silakan pilih menu yang sesuai.");
                    System.out.println("===============================================");
                    break;
            }
        } while (menuBooking != 0);

        if (kembaliKeMenu) {
            kembaliKeMenu = false;
        }
    }

    // Fungsi datar booking pelanggan
    private static void daftarBookingPelanggan() {
        System.out.println("===============================================");
        System.out.println("DAFTAR BOOKING");
        System.out.println("===============================================");
        System.out.println("Masukkan nama : ");
        namaBooking[jumlahBooking] = sc.next();
        System.out.println("Booking hari ini jam (format : 00.00) : ");
        System.out.println("===============================================");
        jamBooking[jumlahBooking] = sc.next();
        jumlahBooking++;
    }

    // Fungsi list pelanggan booking
    private static void listPelangganBooking() {
        System.out.println("===============================================");
        System.out.println("LIST PELANGGAN BOOKING");
        System.out.println("===============================================");
        System.out.printf("%-15s %-20s\n", "Nama", "Booking jam");
        for (int jb = 0; jb < jumlahBooking; jb++) {
            System.out.printf("%-15s %-20s\n", namaBooking[jb], jamBooking[jb]);
        }
        System.out.println("===============================================");
    }

    // Fungsi tandai pelanggan booking
    private static void tandaiPelanggan() {
        System.out.println("===============================================");
        System.out.println("TANDAI PELANGGAN");
        System.out.println("===============================================");
        System.out.println("Masukkan nama pelanggan yang sudah dilayani: ");
        String namaPelanggan = sc.next();

        // Cari nama
        int cariNama = cariNamaPelangganBooking(namaPelanggan);

        // Tandai pelanggan jika ditemukan
        if (cariNama != -1) {
            System.out.println("Pelanggan " + namaPelanggan + " sudah dilayani.");

            hapusPelangganBooking(cariNama);
            System.out.println("===============================================");
            System.out.println("Pelanggan telah ditandai dan dihapus dari daftar booking.");
            System.out.println("===============================================");
        } else {
            System.out.println("===============================================");
            System.out.println("Pelanggan dengan nama " + namaPelanggan + " tidak ditemukan.");
            System.out.println("===============================================");
        }
    }

    private static int cariNamaPelangganBooking(String namaPelanggan) {
        for (int ab = 0; ab < jumlahBooking; ab++) {
            if (namaBooking[ab].equalsIgnoreCase(namaPelanggan)) {
                return ab;
            }
        }
        return -1;
    }

    private static void hapusPelangganBooking(int indeksPelanggan) {
        for (int ac = indeksPelanggan; ac < jumlahBooking - 1; ac++) {
            namaBooking[ac] = namaBooking[ac + 1];
            jamBooking[ac] = jamBooking[ac + 1];
        }
        // Geser pelanggan setelahnya ke posisi array sebelumnya
        for (int ac = indeksPelanggan; ac < jumlahBooking - 1; ac++) {
            namaBooking[ac] = namaBooking[ac + 1];
            jamBooking[ac] = jamBooking[ac + 1];
        }

        jumlahBooking--;
    }

    // FITUR 5 SISTEM PEMBAYARAN
    // Fungsi untuk proses sistem pembayaran
    private static void prosesSistemPembayaran(Scanner sc) {
        int menuSistemPembayaran;

        do {
            System.out.println("===============================================");
            System.out.println("MENU SISTEM PEMABAYARAN");
            System.out.println("===============================================");
            System.out.println("1. Tunai");
            System.out.println("2. Bank transfer");
            System.out.println("0. Keluar");
            menuSistemPembayaran = sc.nextInt();
            System.out.println("===============================================");

            switch (menuSistemPembayaran) {
                case 1:
                    System.out.println("===============================================");
                    System.out.println("Bayarkan ke kasir");
                    System.out.println("===============================================");
                    break;
                case 2:
                    System.out.println("===============================================");
                    System.out.println("BLI 2323234545457878");
                    System.out.println("BMI 7654123456789865");
                    System.out.println("===============================================");
                    System.out.println("Konfirmasi dana masuk");
                    double bankTransfer = sc.nextDouble();
                    penjualanHarian[i] += bankTransfer;
                    penghasilanBulanan += bankTransfer;
                    System.out.println("===============================================");
                    break;

                case 0:
                    kembaliKeMenu = true;
                    break;

                default:
                    break;
            }

        } while (menuSistemPembayaran != 0);

        if (kembaliKeMenu) {
            kembaliKeMenu = false;
        }
    }

    // FITUR 6 KETENTUAN DISKON
    // Fungsi untuk menampilkan ketentuan diskon
    private static void tampilkanKetentuanDiskon(Scanner sc) {
        System.out.println("===============================================");
        System.out.println("KETENTUAN DISKON HARI INI\nHari : " + hariDiskon[inputHariDiskon - 1]);
        System.out.println("===============================================");
        System.out.println("Minimal Pembelian dan Diskon");
        System.out.println("===============================================");
        System.out.printf("%-20s %-15s\n", "Minimal Pembelian", "Diskon");
        System.out.printf("%-20s %-15s\n", "Rp. 100 RB keatas", diskonHari[inputHariDiskon - 1][0] + "%");
        System.out.printf("%-20s %-15s\n", "Rp. 200 RB keatas", diskonHari[inputHariDiskon - 1][1] + "%");
        System.out.printf("%-20s %-15s\n", "Rp. 300 RB keatas", diskonHari[inputHariDiskon - 1][2] + "%");
        System.out.println("===============================================");

    }

    // FITUR 7 PENGATURAN STOK
    // Fungsi Menu Stok
    private static void menuPengaturanStok() {
        int menuStok;
        boolean kembaliKeMenu = false;

        do {
            System.out.println("===============================================");
            System.out.println("PENGATURAN STOK");
            System.out.println("===============================================");
            System.out.println("1. Lihat stok hari ini");
            System.out.println("2. Update stok hari ini");
            System.out.println("3. History stok 30 hari");
            System.out.println("0. Keluar");
            menuStok = sc.nextInt();
            System.out.println("===============================================");

            switch (menuStok) {
                case 1:
                    lihatStok(i);
                    break;
                case 2:
                    updateStokHariIni(i);
                    break;
                case 3:
                    historyStok30Hari(i);
                    break;
                case 0:
                    kembaliKeMenu = true;
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih menu yang sesuai.");
                    break;
            }
        } while (menuStok != 0);

        if (kembaliKeMenu) {
            kembaliKeMenu = false;
        }
    }

    // Fungsi menampilkan stok hari ini
    private static void lihatStok(int hariKe) {
        // Lihat stok
        System.out.println("===============================================");
        System.out.println("STOK HARI INI\n Hari ke-" + (hariKe + 1));
        System.out.println("===============================================");
        System.out.println("Stok Sampo : " + stokSampo[hariKe]);
        System.out.println("Stok Make Up : " + stokMakeUp[hariKe]);
        System.out.println("===============================================");
    }

    // Fungsi update stok hari ini
    private static void updateStokHariIni(int hariKe) {
        // Update stok hari ini
        System.out.println("===============================================");
        System.out.println("UPDATE STOK HARI INI");
        System.out.println("===============================================");
        System.out.println("Stok Sampo : ");
        stokSampo[hariKe] = sc.nextInt();
        System.out.println("Stok Make Up : ");
        stokMakeUp[hariKe] = sc.nextInt();
    }

    // Fungsi history stok 30 hari
    private static void historyStok30Hari(int hariKe) {
        // History stok 30 hari
        System.out.println("===============================================");
        System.out.println("History Stok 30 Hari");
        System.out.println("===============================================");
        System.out.printf("%-20s %-15s %-15s\n", "Hari Ke", "Stok Sampo", "Stok Make Up");
        for (int ad = 0; ad <= hariKe; ad++) {
            System.out.println("===============================================");
            System.out.printf("%-20d %-15d %-15d\n", (ad + 1), stokSampo[ad], stokMakeUp[ad]);
            System.out.println("===============================================");
        }

    }

}