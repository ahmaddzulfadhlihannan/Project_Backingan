import java.util.Random;
import java.util.Scanner;

public class TITIP {
    // Fungsi Scanner
    private static Scanner sc = new Scanner(System.in);

    //Fungsi acak
    private static Random acak = new Random();

    // Fungsi Variabel Data Karyawan
    private static String userKaryawan[] = new String[30];
    private static String passKaryawan[] = new String[30];

    // Fungsi Variabel Membership
    private static int jumlahPelanggan = 0, maxMembership = 12;
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

    //Fungsi Variabel Pengaturan Stok
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
        int menu, menuLaporan, menuBooking, menuStok;
        String hariKetentuanDiskon;
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
            System.out.println("Aplikasi salon");
            System.out.println("Login karyawan");
            userKaryawan[i] = sc.next();
            System.out.println("Masukkan password");
            passKaryawan[i] = sc.next();
            System.out.println("===============");

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
                System.out.println("Login gagal. Coba lagi.");
                i--;
                continue;
            }
            // Input Hari Diskon
            System.out.println("Hari ketentuan Diskon");
            for (int ac = 0; ac < hariDiskon.length; ac++) {
                System.out.println((ac + 1) + ". " + hariDiskon[ac]);
            }
            System.out.println("Masukkan nomor hari : ");
            inputHariDiskon = sc.nextInt();
            hariKetentuanDiskon = hariDiskon[inputHariDiskon - 1];

            // Input Stock Hari ini
            System.out.println("Input Stok Hari ke-" + (i + 1));
            System.out.println("Stok Sampo");
            stokSampo[i] = sc.nextInt();
            System.out.println("Stok Make Up");
            stokMakeUp[i] = sc.nextInt();

            // Menu utama
            do {
                System.out.println("=================================================");
                System.out.println("Selamat datang di aplikasi salon hari ke-" + (i + 1));
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
                System.out.println("=================================================");
                kembaliKeMenu = false;

                switch (menu) {
                    case 1:
                        fiturUtamaPembayaran(i);
                        break;

                    case 2:
                        menuMembership();
                        break;

                    case 3:
                        do {
                            // Laporan penjualan
                            System.out.println("Menu");
                            System.out.println("1. Laporan penjualan hari ini");
                            System.out.println("2. Laporan penjualan bulan ini (per 30 hari)");
                            System.out.println("0. Keluar");
                            System.out.println("Pilih menu");
                            menuLaporan = sc.nextInt();

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
                                    System.out.println("Pilihan tidak valid. Silakan pilih menu yang sesuai.");
                                    break;
                            }
                        } while (menuLaporan != 0);

                        if (kembaliKeMenu) {
                            kembaliKeMenu = false;
                        }
                        break;

                    case 4:
                        // Booking
                        do {
                            System.out.println("Menu booking:");
                            System.out.println("1. Daftar booking");
                            System.out.println("2. List pelanggan booking");
                            System.out.println("3. Tandai pelanggan");
                            System.out.println("0. Keluar");
                            menuBooking = sc.nextInt();

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
                                    break;
                            }
                        } while (menuBooking != 0);

                        if (kembaliKeMenu) {
                            kembaliKeMenu = false;
                        }
                        break;
                    case 5:
                        // Sistem pembayaran
                        prosesSistemPembayaran(sc);
                        break;

                    case 6:
                        // Ketentuan diskon
                        tampilkanKetentuanDiskon(sc);
                        break;
                    case 7:
                        do {
                            System.out.println("Pengaturan stok");
                            System.out.println("1. Lihat stok");
                            System.out.println("2. Update stok hari ini");
                            System.out.println("3. History stok 30 hari");
                            System.out.println("0. Keluar");
                            menuStok = sc.nextInt();

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

                                default:
                                    break;
                            }
                        } while (menuStok != 0);

                        if (kembaliKeMenu) {
                            kembaliKeMenu = false;
                        }
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

    //FITUR 1 TRANSAKSI DAN CETAK STRUK
    //Fungsi menambah dan menghitung item
    private static void fiturUtamaPembayaran(int hariKe) {
        int nomorItem[] = new int[100], jumlah[] = new int[100];
        double harga[] = new double[100], hitungHargaAsli[] = new double[100], totalHarga = 0;
        int j = 0;
        System.out.println("=====Fitur utama pembayaran=====");
        System.out.println("List jenis pelayanan :");
        for (int k = 0; k < namaJenisPelayanan.length; k++) {
            System.out.println((k + 1) + ". " + namaJenisPelayanan[k] + " - Rp" + hargaJenisPelayanan[k]);
        }
        System.out.println(
                "Masukkan 0 pada Nomor item untuk mengakhiri transaksi dan menghitung total pembelian");

        do {
            System.out.print("Nomor item : ");
            nomorItem[j] = sc.nextInt();
            if (nomorItem[j] == 0 || nomorItem[j] > (namaJenisPelayanan.length)) {
                break;
            }
            System.out.print("Jumlah: ");
            jumlah[j] = sc.nextInt();
            harga[j] = hargaJenisPelayanan[nomorItem[j] - 1] * jumlah[j];
            hitungHargaAsli[j] = hargaAsli[nomorItem[j] - 1] * jumlah[j];
            totalHarga += harga[j];
            if (nomorItem[j] == 1) {
                penjualanPotong[hariKe] += harga[j];
            } else if (nomorItem[j] == 2) {
                penjualanRias[hariKe] += harga[j];
            } else if (nomorItem[j] == 3) {
                penjualanPaket[hariKe] += harga[j];
            } else if (nomorItem[j] == 4) {
                penjualanMembership[hariKe] += harga[j];
            }
            penjualanHarian[hariKe] += harga[j];
            penghasilanBulanan += harga[j];
            totalHargaAsliHarian[hariKe] += hitungHargaAsli[j];
            j++;
        } while (nomorItem[j - 1] != 0);

        System.out.println("Total Harga: Rp" + totalHarga);

        double diskon;
        if (totalHarga >= 300000) {
            diskon = diskonHari[inputHariDiskon - 1][2];
        } else if (totalHarga >= 200000) {
            diskon = diskonHari[inputHariDiskon - 1][1];
        } else if (totalHarga >= 100000) {
            diskon = diskonHari[inputHariDiskon - 1][0];
        } else {
            diskon = 0;
        }

        double bayar = totalHarga - (totalHarga * diskon);
        double jumlahDiskon = (totalHarga * diskon);
        potonganDiskonHarian[hariKe] += jumlahDiskon;
        System.out.println("Total Bayar setelah diskon: Rp" + bayar);

        System.out.print("Uang diterima: Rp");
        double uangDiterima = sc.nextDouble();

        System.out.println("Cetak struk? (y/t)");
        String cetakStruk = sc.next();

        if (cetakStruk.equalsIgnoreCase("y")) {
            cetakStrukBelanjaan(hariKe, nomorItem, jumlah, harga, totalHarga, diskon, bayar, uangDiterima);
        }
    }
    //Fungsi cetak struk
    private static void cetakStrukBelanjaan(int hariKe, int[] nomorItem, int[] jumlah, double[] harga, double totalHarga,
            double diskon, double bayar, double uangDiterima) {
        System.out.println("Struk belanjaan");
        System.out.println("Kasir : " + userKaryawan);
        for (int k = 0; k < nomorItem.length; k++) {
            if (nomorItem[k] == 0) {
                break;
            }
            System.out.println("Item: " + namaJenisPelayanan[nomorItem[k] - 1]);
            System.out.println("Jumlah: " + jumlah[k]);
            System.out.println("Harga: Rp" + harga[k]);
            System.out.println("====================");
        }
        System.out.println("Total Harga: Rp" + totalHarga);
        System.out.println("Diskon: Rp" + (totalHarga * diskon));
        System.out.println("Total Bayar: Rp" + bayar);
        System.out.println("Uang Diterima: Rp" + uangDiterima);
        System.out.println("Uang Kembalian: Rp" + (uangDiterima - bayar));
    }

    // FITUR 2 MEMBERSHIP
    //Menu Membership
    private static void menuMembership() {
        int menuMembership;
        boolean kembaliKeMenu = false;

        do {
            // Fitur Membership
            System.out.println("Menu membership");
            System.out.println("1. Pendaftaran pelanggan membership");
            System.out.println("2. Cek nomor membership pelanggan & Benerfit");
            System.out.println("3. List daftar pelanggan membership");
            System.out.println("0. Keluar");
            menuMembership = sc.nextInt();

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
                    System.out.println("Pilihan tidak valid. Silakan pilih menu yang sesuai.");
                    break;
            }
        } while (menuMembership != 0);

        if (kembaliKeMenu) {
            kembaliKeMenu = false;
        }
    }
    // Fungsi pendaftaran pelanggan membership
    private static void pendaftaranPelangganMembership(Random acak, int jumlahPelanggan, String[] namaPelanggan,
            String[] nomorMember, int maxMembership) {

        if (jumlahPelanggan >= maxMembership) {
            System.out.println("Maaf, membership bulan ini sudah terisi semua.");
            return;
        }

        System.out.println("Pendaftaran Pelanggan Membership");
        System.out.print("Nama Pelanggan: ");
        String nama = sc.next();
        boolean namaSudahTerdaftar = false;

        for (int n = 0; n < jumlahPelanggan; n++) {
            if (nama.equals(namaPelanggan[n])) {
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

            namaPelanggan[jumlahPelanggan] = nama;
            nomorMember[jumlahPelanggan] = nomorMemberBaru.toString();
            System.out.println("Pendaftaran berhasil!\n");
            System.out.println("Nama Pelanggan : " + namaPelanggan[jumlahPelanggan]);
            System.out.println("Nomor Member : " + nomorMember[jumlahPelanggan]);
            jumlahPelanggan++;
        } else {
            System.out.println("Nama pelanggan sudah terdaftar");
        }

    }

    // Fungsi cek nomor membership dan benefit
    private static void cekNomorMembership() {
        System.out.println("Cek nomor membership");
        System.out.println("Masukkan nomor membership");
        String cariNomorMembership = sc.next();
        boolean nomorTerdaftar = false;

        for (int p = 0; p < jumlahPelanggan; p++) {
            if (cariNomorMembership.equals(nomorMember[p])) {
                System.out.println("Nama : " + namaPelanggan[p]);
                System.out.println("Nomor member : " + nomorMember[p]);
                System.out.println("Nomor terdaftar sebagai membership");

                // Panggil fungsi untuk memberikan pelayanan ekstra
                pelayananExtra(p);

                nomorTerdaftar = true;
                break;
            }
        }
        if (!nomorTerdaftar) {
            System.out.println("Nomor tidak terdaftar sebagai membership");
        }
    }

    // Fungsi benefit pelanggan membership
    private static void pelayananExtra(int indexPelanggan) {
        System.out.println("=================================");
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
        System.out.println("=================================");
    }

    // Fungsi untuk menampilkan list daftar pelanggan membership
    private static void tampilkanListPelangganMembership() {
        System.out.println("List daftar pelanggan membership");
        for (int l = 0; l < jumlahPelanggan; l++) {
            System.out.println("Pelanggan ke-" + (l + 1));
            System.out.println("Nama: " + namaPelanggan[l]);
            System.out.println("Nomor Member: " + nomorMember[l]);
            System.out.println("--------------------");
        }
    }

    // FITUR 3 LAPORAN PENJUALAN
    // Fungsi laporan hari ini
    private static void laporanPenjualanHariIni(int hariKe) {
        System.out.println("Laporan penjualan hari ini");
        System.out.println("Hari ke-" + (hariKe + 1));
        System.out.println("Kasir yang bertanggung jawab : " + (userKaryawan[hariKe]));
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
        System.out.println("Laporan penjualan bulan ini (per 30 hari)");
        for (int p = 0; p <= i; p++) {
            System.out.println("Hari ke-" + (p + 1));
            System.out.println("Kasir yang bertanggung jawab : " + (userKaryawan[p]));
            System.out.println("Penghasilan pelayanan potong : " + (penjualanPotong[p]));
            System.out.println("Penghasilan pelayanan rias : " + (penjualanRias[p]));
            System.out.println("Penghasilan paket peayanan potong dan rias : " + (penjualanPaket[p]));
            System.out.println("Penghasilan membership : " + (penjualanMembership[p]));
            System.out.println("Total penghasilan : " + penjualanHarian[p]);
            System.out.println("Penghasilan bersih : " + (totalHargaAsliHarian[p]));
            System.out.println("Jumlah potongan diskon harian : " + (potonganDiskonHarian[p]));
        }
        System.out.println("Penghasilan bulanan : " + penghasilanBulanan);
    }

    // FITUR 4 BOOKING
    // Fungsi datar booking pelanggan
    private static void daftarBookingPelanggan() {
        System.out.println("Daftar booking");
        System.out.println("Masukkan nama : ");
        namaBooking[jumlahBooking] = sc.next();
        System.out.println("Booking hari ini jam (format : 00.00) : ");
        jamBooking[jumlahBooking] = sc.next();
        jumlahBooking++;
    }

    // Fungsi list pelanggan booking
    private static void listPelangganBooking() {
        System.out.println("List pelanggan booking");
        for (int jb = 0; jb < jumlahBooking; jb++) {
            System.out.println("Nama : " + namaBooking[jb]);
            System.out.println("Booking jam : " + jamBooking[jb]);
        }
    }

    // Fungsi tandai pelanggan booking
    private static void tandaiPelanggan() {
        System.out.println("Tandai pelanggan");
        System.out.println("Masukkan nama pelanggan yang sudah dilayani: ");
        String namaPelanggan = sc.next();

        // Cari nama
        int cariNama = cariNamaPelangganBooking(namaPelanggan);

        // Tandai pelanggan jika ditemukan
        if (cariNama != -1) {
            System.out.println("Pelanggan " + namaPelanggan + " sudah dilayani.");

            hapusPelangganBooking(cariNama);

            System.out.println("Pelanggan telah ditandai dan dihapus dari daftar booking.");
        } else {
            System.out.println("Pelanggan dengan nama " + namaPelanggan + " tidak ditemukan.");
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
            System.out.println("Sistem Pembayaran : ");
            System.out.println("1. Tunai");
            System.out.println("2. Bank transfer");
            System.out.println("0. Keluar");
            menuSistemPembayaran = sc.nextInt();

            switch (menuSistemPembayaran) {
                case 1:
                    System.out.println("Bayarkan ke kasir");
                    break;
                case 2:
                    System.out.println("BLI 2323234545457878");
                    System.out.println("BMI 7654123456789865");
                    System.out.println("Konfirmasi dana masuk");
                    double bankTransfer = sc.nextDouble();
                    penjualanHarian[i] += bankTransfer;
                    penghasilanBulanan += bankTransfer;
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
        System.out.println("Ketentuan diskon hari ini, Hari : " + hariDiskon[inputHariDiskon - 1]);
        System.out.println("Minimal Pembelian : ");
        System.out.println("Rp. 100 RB keatas | Diskon : " + (diskonHari[inputHariDiskon - 1][0]));
        System.out.println("Rp. 200 RB keatas | Diskon : " + (diskonHari[inputHariDiskon - 1][1]));
        System.out.println("Rp. 300 RB keatas | Diskon : " + (diskonHari[inputHariDiskon - 1][2]));
    }

    //FITUR 7 PENGATURAN STOK
    //Fungsi menampilkan stok hari ini
    private static void lihatStok(int hariKe) {
        // Lihat stok
        System.out.println("Stok hari ini, hari ke-" + (hariKe + 1));
        System.out.println("Stok Sampo : " + stokSampo[hariKe]);
        System.out.println("Stok Make Up : " + stokMakeUp[hariKe]);
    }
    //Fungsi update stok hari ini
    private static void updateStokHariIni(int hariKe) {
        // Update stok hari ini
        System.out.println("Update stok hari ini");
        System.out.println("Stok Sampo : ");
        stokSampo[hariKe] = sc.nextInt();
        System.out.println("Stok Make Up : ");
        stokMakeUp[hariKe] = sc.nextInt();
    }
    //Fungsi history stok 30 hari
    private static void historyStok30Hari(int hariKe) {
        // History stok 30 hari
        System.out.println("History stok 30 hari");
        for (int ad = 0; ad <= hariKe; ad++) {
            System.out.println("====================");
            System.out.println("Stok hari ke-" + (ad + 1));
            System.out.println("Stok Sampo : " + stokSampo[ad]);
            System.out.println("Stok Make Up : " + stokMakeUp[ad]);
            System.out.println("====================");
        }
    }

}