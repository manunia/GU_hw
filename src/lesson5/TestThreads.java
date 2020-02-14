package lesson5;

public class TestThreads {

    static final int size = 10000000;
    static final int h = size / 2;
    static float[] arr = new float[size];

    public static void method1(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Время выполнения метода 1:");
        System.out.println(System.currentTimeMillis() - a);
    }


    public static void methodWithThreads(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < a1.length; i++) {
                    arr[i] = (float)(a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        };
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < a2.length; i++) {
                    arr[i] = (float)(a2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        };
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        System.out.println("Время выполнения метода с потоками:");
        System.out.println(System.currentTimeMillis() - a);
    }

    public static void main(String[] args) {
        method1(arr);
        methodWithThreads(arr);
    }

}
