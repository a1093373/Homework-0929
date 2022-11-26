import java.util.*;

public class week2_TreeSet {
    public static void main(String[] args) {
        Random a = new Random();
        TreeSet<Integer> tSet = new TreeSet<>();
        int randomNumber;
        System.out.println("電腦從1-100的整數中，亂數取出10個不重複的數字...");
        for (int i = 1; i <= 10; i++) {
            randomNumber = a.nextInt(100) + 1;
            randomNumber = a.nextInt(1, 101);
            while (tSet.contains(randomNumber)) {
                randomNumber = a.nextInt(100) + 1;
            }
            tSet.add(randomNumber);
            System.out.printf("第%d個數字:%d%n", i, randomNumber);
        }
        System.out.printf("物件元素個數為:%d%n", tSet.size());

        System.out.println("物件內元素的內容:" + tSet);
        System.out.println("第一個元素的內容為:" + tSet.first());
        System.out.println("最後一個元素的內容為:" + tSet.last());
        System.out.println("內容介於30~70者:" + tSet.subSet(30, 70));
    }
}