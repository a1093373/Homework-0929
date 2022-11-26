import java.util.*;

public class hashMap_practice {
    public static void main(String[] args) {
        HashMap<Integer, String> hmap = new HashMap<>();
        Scanner input = new Scanner(System.in);
        int inputNumber;
        hmap.put(1, "January");
        hmap.put(2, "February");
        hmap.put(3, "March");
        hmap.put(4, "April");
        hmap.put(5, "May");
        hmap.put(6, "June");
        hmap.put(7, "July");
        hmap.put(8, "August");
        hmap.put(9, "September");
        hmap.put(10, "October");
        hmap.put(11, "November");
        hmap.put(12, "December");
        do {
            System.out.print("請輸入 1~12?");
            inputNumber = input.nextInt();
            if (inputNumber > 12 || inputNumber < 1) {
                System.out.println("輸入錯誤!");
            }
        } while (inputNumber > 12 || inputNumber < 1);
        System.out.printf("第%d月的英文單字為%s", inputNumber, hmap.get(inputNumber));
    }
}