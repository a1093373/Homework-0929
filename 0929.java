
class Main {
    private static int piau = 10000;

    public synchronized static int synTest(int i) {
        if (piau > 0) {
            int sold = (int) (Math.random() * 4) + 1;

            if ((piau - sold) > 0) {
                piau -= sold;
            } else {
                sold = piau;
                piau = 0;
            }
            System.out.print("售票機" + i + "售出了" + sold + "張票。\n");
            return sold;
        }
        return 0;
    }

    public static void main(String[] args) {

        Thread thread1 = new Thread(new Runnable() {// 售票機1
            public synchronized void run() {
                int ttl = 0;// 售票機1售出票數
                while (piau > 0) {// 當票沒賣完
                    ttl += synTest(1);// 售票並將售出票數加進售出票數
                }
                System.out.print("|售票機1共售出了" + ttl + "張票");// 印出此機台售出票數
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                int ttl = 0;
                while (piau > 0) {
                    ttl += synTest(2);
                }
                System.out.print("|售票機2共售出了" + ttl + "張票");
            }
        });
        Thread thread3 = new Thread(new Runnable() {
            public void run() {
                int ttl = 0;
                while (piau > 0) {
                    ttl += synTest(3);
                }
                System.out.print("|售票機3共售出了" + ttl + "張票");
            }
        });
        Thread thread4 = new Thread(new Runnable() {
            public void run() {
                int ttl = 0;
                while (piau > 0) {
                    ttl += synTest(4);
                }
                System.out.print("|售票機4共售出了" + ttl + "張票");
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
// public的問題