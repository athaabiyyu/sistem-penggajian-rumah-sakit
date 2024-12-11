import java.util.Scanner;
public class ProjectAkhir {
    static Scanner sc = new Scanner(System.in);

    static String tabel[][] = new String[1][4];
    static String profesi[] = {
        "Direktur","Manager", "Supervisor", "Dokter Spesialis", "Dokter Umum", "Dokter Gigi", "Dokter Gigi Spesialis", "Perawat", "Bidan", "Perawat Gigi", "Radiografer", "Analisis Kesehatan", "Fisioterapi", "Apoteker", "Tenaga Teknis Kefarmasian", "Ahli Gizi", "Rekam Medis", "Staf Duty Manajer", "Staf Kesehatan Lingkungan", "Maintenance", "Office Boy", "Satpam"
    };
    static String statusPegawai[] = {
        "Trainer", "Kontrak", "Full Timer"
    };
    static int gajiPokok[] = {
        50000000, 35250000, 4000000, 6000000, 6000000, 12000000, 13000000, 4500000, 3240000, 5000000, 9700000, 3250000, 4750000, 4500000, 3500000, 12000000, 1800000, 3000000, 2733000, 3500000, 1500000, 3100000
    };
    static String namaPegawai, noReferensi, pilihanProfesi, pilihanStatus, answerTunjangan, answerTunjangan2, loop;
    static int jamLembur, uangTransport = 100000, bpjsKesehatan = 115000, bpjsKetenagakerjaan = 85000;
    public static void main(String[] args) {
        do{
            identitasPegawai();
            outputIdentitasPegawai();
            gajiTrainer();
            gajiKontrakDanFullTimer();
            System.out.println("");
            System.out.print("Apakah Anda Ingin Mengulang Program (YA /  TIDAK) : ");
            loop = sc.next();
        } while(loop.equalsIgnoreCase("ya"));
        
        
    }
    static void identitasPegawai() {
        //input nama pegawai
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("\t\t\t\t\t\t\tPENGGAJIAN KARYAWAN");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
        System.out.print("Masukkan Nama Pegawai\t\t : ");
        namaPegawai = sc.nextLine();
        tabel[0][0] = namaPegawai;
        namaPegawai = sc.nextLine();
        tabel[0][0] = namaPegawai;

        //input no pegawai
        System.out.print("Masukkan Nomor Pegawai\t\t : ");
        noReferensi = sc.nextLine();
        tabel[0][1] = noReferensi;
        System.out.println("");
        //input pilihan jabatan
        for(int x = 0; x < profesi.length; x++) {
            System.out.println((x+1) + " " + profesi[x]);
        }
        System.out.println("");
        System.out.print("Pilih Profesi Pegawai (DALAM ANGKA) : ");
        pilihanProfesi = sc.nextLine();
        tabel[0][2] = pilihanProfesi;
        System.out.println("");
        
        //input pilihan status
        for(int y = 0; y < statusPegawai.length; y++ ) {
            System.out.println((y+1 + " " + statusPegawai[y]));
        }
        System.out.println("");
        System.out.print("Pilih Status Pegawai (DALAM ANGKA) : ");
        pilihanStatus = sc.nextLine();
        tabel[0][3] = pilihanStatus; 

        //input jam lembur pegawai
        System.out.print("Masukkan Jumlah Jam Lembur Pegawai : ");
        jamLembur = sc.nextInt();

        if(inputStatusPegawai() != 0 ) {
            
            //input tunjangan anak
            System.out.print("Apakah Pegawai Sudah Memiliki Anak ? (YA / TIDAK): ");
            answerTunjangan = sc.next();
       
            //input tunjangan suami/istri 
            System.out.print("Apakah Pegawai Sudah Menikah ? (SUDAH / BELUM): ");
            answerTunjangan2 = sc.next();
        }
        
       
    }
    static int inputJabatanPegawai() {
        int konversiPilihanProfesi = Integer.parseInt(pilihanProfesi);
        return konversiPilihanProfesi-1;
    }
    static int inputStatusPegawai() {
        int konversiPilihanStatus = Integer.parseInt(pilihanStatus);
        return konversiPilihanStatus-1;
    }
    static int bonusLembur() {
        int nominalBonusLembur;
        if(jamLembur >= 4 && inputStatusPegawai() != 0) {
            nominalBonusLembur = 125000;
        } else {
            nominalBonusLembur = 0;
        }
        return nominalBonusLembur;
    }
    static int tunjanganAnak() {
        double bonusTunjanganAnak;
        if(answerTunjangan.equalsIgnoreCase("YA")) {
            bonusTunjanganAnak = gajiPokok[inputJabatanPegawai()] * 0.1;
        } else {
            bonusTunjanganAnak = 0;
        }
        int konversiBonusTunjanganAnak = (int) bonusTunjanganAnak;
        return konversiBonusTunjanganAnak;
    }
    static int tunjanganSuamiIstri() {
        double bonusTunjanganSuamiIstri;
        if(answerTunjangan2.equalsIgnoreCase("SUDAH")) {
            bonusTunjanganSuamiIstri = gajiPokok[inputJabatanPegawai()] * 0.1;
        } else {
            bonusTunjanganSuamiIstri = 0;
        }
        int konversiBonusTunjanganAnak = (int) bonusTunjanganSuamiIstri;
        return konversiBonusTunjanganAnak;
    }
    static void gajiTrainer() {
        if(statusPegawai[inputStatusPegawai()] == statusPegawai[0]) {
            double potonganGajiTrainer =  gajiPokok[inputJabatanPegawai()] * 0.2;
            double gajiPokokTrainer = gajiPokok[inputJabatanPegawai()] - potonganGajiTrainer;
            int konversiGajiPokokTrainer = (int) gajiPokokTrainer;
            double gajiPokokAkhir = konversiGajiPokokTrainer + bonusLembur() - bpjsKesehatan - bpjsKetenagakerjaan;
            int konversi = (int) gajiPokokAkhir;
            System.out.printf("Gaji Pokok Pegawai\t: \t\t%s \n", konversiGajiPokokTrainer);
            System.out.printf("Bonus Lembur\t\t: \t\t%s \n", bonusLembur());
            System.out.printf("BPJS Kesehatan\t\t: \t\t-%s \n", bpjsKesehatan);
            System.out.printf("BPJS Ketenagakerjaan\t: \t\t-%s \n", bpjsKetenagakerjaan);
            System.out.print("------------------------------------------------- + \n");
            System.out.printf("Total\t\t\t: \t\t%s \n", konversi);
        }
    }
    static void gajiKontrakDanFullTimer() {
        if(statusPegawai[inputStatusPegawai()] == statusPegawai[1] || statusPegawai[inputStatusPegawai()] == statusPegawai[2]) {
            int konversi = (int) gajiPokok[inputJabatanPegawai()] + bonusLembur() + uangTransport + tunjanganAnak() + tunjanganSuamiIstri() - bpjsKesehatan - bpjsKetenagakerjaan;
            System.out.printf("Gaji Pokok Pegawai\t: \t\t%s \n", gajiPokok[inputJabatanPegawai()]);
            System.out.printf("Bonus Lembur\t\t: \t\t%s \n", bonusLembur());
            System.out.printf("Transport\t\t: \t\t%s \n", uangTransport);   
            System.out.printf("Tunjangan Anak\t\t: \t\t%s \n",tunjanganAnak());
            System.out.printf("Tunjangan Suami Istri\t: \t\t%s \n",tunjanganSuamiIstri());         
            System.out.printf("BPJS Kesehatan\t\t: \t\t-%s \n", bpjsKesehatan);
            System.out.printf("BPJS Ketenagakerjaan\t: \t\t-%s \n", bpjsKetenagakerjaan);
            System.out.print("------------------------------------------------- + \n");
            System.out.printf("Total\t\t\t: \t\t%s \n", konversi);
        }
    }
    static void outputIdentitasPegawai() {
        System.out.println("");
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.print("\tNAMA PEGAWAI\t\t");
        System.out.print("NO PEGAWAI\t    ");
        System.out.print("JABATAN\t\t");
        System.out.println("STATUS\t\t");
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.print( "\t" +tabel[0][0] + "\t\t");
        System.out.print(tabel[0][1] + "\t\t    ");
        System.out.print(profesi[inputJabatanPegawai()] + "\t\t");
        System.out.println(statusPegawai[inputStatusPegawai()] + "\t");
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("");
    }
   
}
