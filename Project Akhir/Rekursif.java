import java.util.Scanner;
public class Rekursif {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan Angka : ");
        int angka = sc.nextInt();
        System.out.println(faktorialRekursif(angka));
        System.out.println(faktorialRekursif2(angka));
    }
    static int faktorialRekursif(int n) {
        int x;
        if(n == 0) {
            x = 0;
            return x;
        } else {
            return ( x = n + faktorialRekursif(n-1));
        }
    }
    static int faktorialRekursif2(int n) {
        int faktor = 0;
        for(int i = n; i >= 1; i--) {
            faktor += i;
        }
        return faktor;
    }
}
