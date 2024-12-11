/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.akhir;

/**
 *
 * @author LENOVO
 */
import java.util.Scanner;
public class ProjectAkhir {
    static Scanner sc = new Scanner(System.in);
    static String profesi[] = {
        "Manager", "Supervisor", "Dokter Spesialis", "Dokter Umum", "Dokter Gigi", "Dokter Gigi Spesialis", "Perawat", "Bidan", "Perawat Gigi", "Radiografer", "Analisis Kesehatan", "Fisioterapi", "Apoteker", "Tenaga Teknis Kefarmasian", "Gizi", "Rekam Medis", "CSSD", "Staf Bimrohis", "Staf Duty Manajer", "Staf Kesehatan Lingkungan", "Maintenance", "Office Boy"
    };
    static String statusPegawai[] = {
        "Trainer", "Kontrak", "Full TImer"
    };
    static int upah[] = {
        5000000
    };
    static void inputProfesi() {
        for(int x = 0; x < profesi.length; x++) {
            System.out.println((x+1) + " " + profesi[x]);
        }
        System.out.print("Masukkan Profesi Anda !!DALAM BENTUK ANGKA!! : ");
        int dataInput = sc.nextInt();
        profesi = new String[dataInput];
    }
    static void statusPegawai(){
        for(int y = 0; y < statusPegawai.length; y++ ) {
            System.out.println((y+1 + " " + statusPegawai[y]));
        }
        System.out.print("Masukkan Status Anda !!DALAM BENTUK ANGKA!! : ");
        int dataStatusPegawai = sc.nextInt();     
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        inputProfesi();
        statusPegawai();
    }
    
}
