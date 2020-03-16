package professional.lesson4;

public class Test {
    static Object mon = new Object();
    static char currentChar = 'A';

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    synchronized (mon) {
                        while (currentChar != 'A') {
                            mon.wait();
                        }
                        System.out.print("A");
                        currentChar = 'B';
                        mon.notifyAll();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    synchronized (mon) {
                        while (currentChar != 'B') {
                            mon.wait();
                        }
                        System.out.print("B");
                        currentChar = 'C';
                        mon.notifyAll();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    synchronized (mon) {
                        while (currentChar != 'C') {
                            mon.wait();
                        }
                        System.out.print("C");
                        currentChar = 'A';
                        mon.notifyAll();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
