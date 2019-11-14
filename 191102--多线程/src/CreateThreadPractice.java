public class CreateThreadPractice {
    private static class P1 extends Thread {
        private int count = 100_0000;

        @Override
        public void run() {
            long sum = 0;
            for (int i = 1; i <= count; i++) {
                sum += i;
            }
            System.out.println("P1: 1 + 2 + ... + n = " + sum);
        }
    }

    private static class P2 extends Thread {
        private int count = 100_0001;

        @Override
        public void run() {
            long sum = 0;
            for (int i = 1; i <= count; i += 2) {
                sum += i;
            }
            System.out.println("P2: 1 + 3 + ... + n = " + sum);
        }
    }

    private static class P3 extends Thread {
        private int count = 10_0000;

        @Override
        public void run() {
            long sum = 0;
            for (int i = 1; i <= count; i++) {
                sum += (i * i);
            }
            System.out.println("P3: 1 + 4 + ... + n = " + sum);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        long begin = System.currentTimeMillis();

        Thread t1 = new P1();
        Thread t2 = new P2();
        Thread t3 = new P3();

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        long end = System.currentTimeMillis();
        System.out.println((end - begin) * 1.0 / 1000);
    }
}
