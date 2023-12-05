 import java.util.Random;
import java.util.Scanner;

public class KasirApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random acak = new Random();

        // Inisialisasi variabel dan array
        int stokSampo[] = new int[30];
        int stokMakeUp[] = new int[30];
        double penjualanHarian[] = new double[30];
        double penjualanPotong[] = new double[30];
        double penjualanRias[] = new double[30];
        double penjualanPaket[] = new double[30];
        double potonganDiskonHarian[] = new double[30];
        double totalHargaAsliHarian[] = new double[30];
        String userKaryawan[] = new String[30];
        String passKaryawan[] = new String[30];
        String namaBooking[] = new String[30];
        String jamBooking[] = new String[30];
        String dataUserKaryawan[] = { "albedo", "ainz", "demiurge", "cocytus", "shaltear", "sebas" };
        String dataPassKaryawan[] = { "ainssama", "diamlah", "subarashi", "ojisan", "dearinsaka", "tuanku" };
        String namaJenisPelayanan[] = { "Potong", "Rias", "Paket potong rias", "Daftar membership" };
        String hariDiskon[] = {"Hari Biasa","Hari Kemerdekaan", "Tahun Baru", "Ramadhan", "Lebaran"};
        double diskonHari[][] = {{0, 0, 0.05}, {0.08, 0.17, 0.20}, {0.03, 0.07, 0.10}, {0.05, 0.08, 0.11}, {0.02, 0.05, 0.09}};
        double hargaAsli[] = { 10000, 20000, 30000, 60000 };
        double hargaJenisPelayanan[] = { 15000, 25000, 36000, 65000 };
        int menu, menuMembership, menuLaporan, menuBooking, menuSistemPembayaran, menuStok, maxMembership = 12;
        String[] namaPelanggan = new String[maxMembership];
        String[] nomorMember = new String[maxMembership];
        int jumlahPelanggan = 0, jumlahLaporan = 0;
        String hariKetentuanDiskon;
        double penghasilanBulanan = 0;
        boolean kembaliKeLogin = false;

        // Loop untuk setiap hari kerja
        for (int i = 0; i < penjualanHarian.length; i++) {
            // Inisialisasi nilai array
            penjualanHarian[i] = 0;
            penjualanPotong[i] = 0;
            penjualanRias[i] = 0;
            penjualanPaket[i] = 0;
            potonganDiskonHarian[i] = 0;
            int jumlahBooking = 0;

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
            int inputHariDiskon = sc.nextInt();
            hariKetentuanDiskon = hariDiskon[inputHariDiskon-1];

            //Input Stock Hari ini
            System.out.println("Input Stok Hari ke-" + (i+1));
            System.out.println("Stok Sampo");
            stokSampo[i] = sc.nextInt();
            System.out.println("Stok Make Up");
            stokMakeUp[i] = sc.nextInt();


            // Menu utama
            do {
                System.out.println("=================================================");
                System.out.println("Selamat datang di aplikasi salon hari ke-" + (i+1));
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
                boolean kembaliKeMenu = false;

                switch (menu) {
                    case 1:
                        // Fitur utama pembayaran dan struk
                        int nomorItem[] = new int[100], jumlah[] = new int[100];
                        double harga[] = new double[100], hitungHargaAsli[] = new double[100], totalHarga = 0;
                        int j = 0;
                        System.out.println("=====Fitur utama pembayaran=====");
                        System.out.println("List jenis pelayanan :");
                        for (int k = 0; k < namaJenisPelayanan.length; k++) {
                            System.out
                                    .println((k + 1) + ". " + namaJenisPelayanan[k] + " - Rp" + hargaJenisPelayanan[k]);
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
                                penjualanPotong[i] += harga[j];
                            } else if (nomorItem[j] == 2) {
                                penjualanRias[i] += harga[j];
                            } else if (nomorItem[j] == 3) {
                                penjualanPaket[i] += harga[j];
                            }
                            penjualanHarian[i] += totalHarga;
                            penghasilanBulanan += totalHarga;
                            totalHargaAsliHarian[i] += hitungHargaAsli[j];
                            j++;
                        } while (nomorItem[j - 1] != 0);

                        System.out.println("Total Harga: Rp" + totalHarga);

                        double diskon;
                        if (totalHarga >= 300000) {
                            diskon = diskonHari[inputHariDiskon-1][2];
                        } else if (totalHarga >= 200000) {
                            diskon = diskonHari[inputHariDiskon-1][1];
                        } else if (totalHarga >= 100000) {
                            diskon = diskonHari[inputHariDiskon-1][0];
                        } else {
                            diskon = 0;
                        }

                        double bayar = totalHarga - (totalHarga * diskon);
                        double jumlahDiskon = (totalHarga * diskon);
                        potonganDiskonHarian[i] += jumlahDiskon;
                        System.out.println("Total Bayar setelah diskon: Rp" + bayar);

                        System.out.print("Uang diterima: Rp");
                        double uangDiterima = sc.nextDouble();

                        System.out.println("Cetak struk? (y/t)");
                        String cetakStruk = sc.next();

                        if (cetakStruk.equalsIgnoreCase("y")) {
                            System.out.println("Struk belanjaan");
                            System.out.println("Kasir : " + userKaryawan);
                            for (int k = 0; k < j; k++) {
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
                        break;

                    case 2:
                        do {
                            // Fitur Membership
                            System.out.println("Menu membership");
                            System.out.println("1. Pendaftaran pelanggan membership");
                            System.out.println("2. Cek nomor membership pelanggan");
                            System.out.println("3. List daftar pelanggan membership");
                            System.out.println("0. Keluar");
                            menuMembership = sc.nextInt();

                            switch (menuMembership) {
                                case 1:
                                    if (jumlahPelanggan >= maxMembership) {
                                        System.out.println("Maaf, membership bulan ini sudah terisi semua.");
                                        break;
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
                                        break;
                                    } else {
                                        System.out.println("Nama pelanggan sudah terdaftar");
                                    }
                                    break;

                                case 2:
                                    System.out.println("Cek nomor membership");
                                    System.out.println("Masukkan nomor membership");
                                    String cariNomorMembership = sc.next();
                                    boolean nomorTerdaftar = false;
                                    for (int p = 0; p < jumlahPelanggan; p++) {
                                        if (cariNomorMembership.equals(nomorMember[p])) {
                                            System.out.println("Nama : " + namaPelanggan[p]);
                                            System.out.println("Nomor member : " + nomorMember[p]);
                                            System.out.println("Nomor terdaftar sebagai membership");
                                            pelayananExtra(p);
                                            nomorTerdaftar = true;
                                            break;
                                        }
                                    }
                                    if (!nomorTerdaftar) {
                                        System.out.println("Nomor tidak terdaftar sebagai membership");
                                    }
                                    break;

                                case 3:
                                    System.out.println("List daftar pelanggan membership");
                                    for (int l = 0; l < jumlahPelanggan; l++) {
                                        System.out.println("Pelanggan ke-" + (l + 1));
                                        System.out.println("Nama: " + namaPelanggan[l]);
                                        System.out.println("Nomor Member: " + nomorMember[l]);
                                        System.out.println("--------------------");
                                    }

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
                                    System.out.println("Laporan penjualan hari ini");
                                    System.out.println("Hari ke-" + (i + 1));
                                    System.out.println("Kasir yang bertanggung jawab : " + (userKaryawan[i]));
                                    System.out.println("Penghasilan pelayanan potong : " + (penjualanPotong[i]));
                                    System.out.println("Penghasilan pelayanan rias : " + (penjualanRias[i]));
                                    System.out.println(
                                            "Penghasilan paket peayanan potong dan rias : " + (penjualanPaket[i]));
                                    System.out.println("Total penghasilan : " + penjualanHarian[i]);
                                    System.out.println("Penghasilan bersih : " + (totalHargaAsliHarian[i]));
                                    System.out.println("Jumlah potongan diskon harian : " + (potonganDiskonHarian[i]));
                                    break;

                                case 2:
                                    System.out.println("Laporan penjualan bulan ini (per 30 hari)");
                                    for (int p = 0; p <= jumlahLaporan; p++) {
                                        System.out.println("Hari ke-" + (p + 1));
                                        System.out.println("Kasir yang bertanggung jawab : " + (userKaryawan[p]));
                                        System.out.println("Penghasilan pelayanan potong : " + (penjualanPotong[p]));
                                        System.out.println("Penghasilan pelayanan rias : " + (penjualanRias[p]));
                                        System.out.println(
                                                "Penghasilan paket peayanan potong dan rias : " + (penjualanPaket[p]));
                                        System.out.println("Total penghasilan : " + penjualanHarian[p]);
                                        System.out.println("Penghasilan bersih : " + (totalHargaAsliHarian[p]));
                                        System.out.println(
                                                "Jumlah potongan diskon harian : " + (potonganDiskonHarian[p]));
                                    }
                                    System.out.println("Penghasilan bulanan : " + penghasilanBulanan);
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
                                    System.out.println("Daftar booking");
                                    System.out.println("Masukkan nama : ");
                                    namaBooking[jumlahBooking] = sc.next();
                                    System.out.println("Booking hari ini jam (format : 00.00) : ");
                                    jamBooking[jumlahBooking] = sc.next();
                                    jumlahBooking++;
                                    break;
                                case 2:
                                    System.out.println("List pelanggan booking");
                                    for (int jb = 0; jb < jumlahBooking; jb++) {
                                        System.out.println("Nama : " + namaBooking[jb]);
                                        System.out.println("Booking jam : " + jamBooking[jb]);
                                    }
                                    break;
                                case 3:
                                    System.out.println("Tandai pelanggan");
                                    System.out.println("Masukkan nama pelanggan yang sudah dilayani: ");
                                    String namaPelangganSelesai = sc.next();

                                    // Cari indeks pelanggan yang sesuai
                                    int indeksPelangganSelesai = -1;
                                    for (int ab = 0; ab < jumlahBooking; ab++) {
                                        if (namaBooking[ab].equalsIgnoreCase(namaPelangganSelesai)) {
                                            indeksPelangganSelesai = ab;
                                            break;
                                        }
                                    }

                                    // Tandai pelanggan jika ditemukan
                                    if (indeksPelangganSelesai != -1) {
                                        System.out.println("Pelanggan " + namaPelangganSelesai + " sudah dilayani.");

                                        // Hapus nama dan jam booking pada indeks tersebut
                                        for (int ac = indeksPelangganSelesai; ac < jumlahBooking - 1; ac++) {
                                            namaBooking[ac] = namaBooking[ac + 1];
                                            jamBooking[ac] = jamBooking[ac + 1];
                                        }
                                        // Geser pelanggan setelahnya ke posisi array yang lebih rendah
                                        for (int ac = indeksPelangganSelesai; ac < jumlahBooking - 1; ac++) {
                                            namaBooking[ac] = namaBooking[ac + 1];
                                            jamBooking[ac] = jamBooking[ac + 1];
                                        }

                                        // Kurangi jumlahBooking
                                        jumlahBooking--;

                                        System.out.println("Pelanggan telah ditandai dan dihapus dari daftar booking.");
                                    } else {
                                        System.out.println(
                                                "Pelanggan dengan nama " + namaPelangganSelesai + " tidak ditemukan.");
                                    }
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
                        break;

                    case 6:
                    //Ketentuan diskon
                    System.out.println("Ketentuan diskon hari ini, Hari : " + hariDiskon[inputHariDiskon-1]);
                    System.out.println("Minimal Pembelian : ");
                    System.out.println("Rp. 300 RB keatas | Diskon : " + (diskonHari[inputHariDiskon-1][2]));
                    System.out.println("Rp. 200 RB keatas | Diskon : " + (diskonHari[inputHariDiskon-1][1]));
                    System.out.println("Rp. 100 RB keatas | Diskon : " + (diskonHari[inputHariDiskon-1][0]));
                    
                    break;
                    case 7:
                    do {
                        System.out.println("Pengaturan stok");
                        System.out.println("1. Lihat stok");
                        System.out.println("2. Update stok");
                        System.out.println("3. History stok 30 hari");
                        System.out.println("0. Keluar");
                        menuStok = sc.nextInt();

                        switch (menuStok) {
                            case 1:
                                // Lihat stok
                                System.out.println("Stok hari ini, hari ke-" + (i+1));
                                System.out.println("Stok Sampo : " + stokSampo[i]);
                                System.out.println("Stok Make Up : " + stokMakeUp[i]);
                                break;
                            case 2:
                                //Update stok
                                System.out.println("Update stok");
                                System.out.println("Stok Sampo : ");
                                stokSampo[i] = sc.nextInt();
                                System.out.println("Stok Make Up : ");
                                stokMakeUp[i] = sc.nextInt();
                            break;
                            case 3:
                                //History stok 30 hari
                                System.out.println("History stok 30 hari");
                                for (int ad = 0; ad <= i; ad++) {
                                    System.out.println("====================");
                                    System.out.println("Stok hari ke-" + (ad+1));
                                    System.out.println("Stok Sampo : " + stokSampo[ad]);
                                    System.out.println("Stok Make Up : " + stokMakeUp[ad]);
                                    System.out.println("====================");
                                }
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
                        jumlahLaporan++;
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

    //FUNGSI BENEFIT PELANGGAN MEMBERSHIP
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
    
}