package tasks;

public class Main {
    public static void main(String[] args) {
        int x1 = 1;
        int y1 = 1;
        int x2 = 4;
        int y2 = 4;

        int x3 = 3;
        int y3 = 1;
        int x4 = 1;
        int y4 = 3;

        int x = ((x1 * y2 - x2 * y1) * (x4 - x3) - (x3 * y4 - x4 * y3) * (x2 - x1)) / ((y1 - y2) * (x4 - x3) - (y3 - y4) * (x2 - x1));
        int y = ((y3 - y4) * x - (x3 * y4 - x4 * y3)) / (x4 - x3);

        if(((x1<=x)&&(x2>=x)&&(x3<=x)&&(x4 >=x))||((y1<=y)&&(y2>=y)&&(y3<=y) &&(y4>=y))){
            System.out.println("Пересекаются");
        } else{
            System.out.println("Не пересекаются");
        }
    }
}
