public class Lat {
    public static void main(String[] args) {
        int x= 10, y=9 , z=12;
        if (y>8 && z<10){
            if (x >= y){
            y++;
            x-=y;
            } else {
            x-=z;
            }
            } else {
            y--;
            x+=y;
            }
        System.out.println(x);
}
    }
