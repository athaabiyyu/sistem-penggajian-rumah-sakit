import java.util.Scanner;
public class Rekursif2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan Nilai 1 : ");
        int nilai1 = sc.nextInt();
        System.out.print("Masukkan Nilai 2 : ");
        int nilai2 = sc.nextInt();
        System.out.println(permutasi(nilai1, nilai2));
    }
    static int permutasi(int m, int n) {
        int hasil= 1;
        for(int i = 0; i < n; i++) {
            hasil *= m-i;
        }
        return hasil;
    }
}   
