package professional.lesson5;

import java.util.concurrent.CountDownLatch;

public class MainClass {
    public static final int CARS_COUNT = 4;
    //ожидание когда все будут готовы к старту
    public static CountDownLatch cdlStart;
    //ожидание завершения операций в других потоках
    public static CountDownLatch cdlFinish;

    public static CountDownLatch getCdlStart() {
        return cdlStart;
    }

    public static CountDownLatch getCdlFinish() {
        return cdlFinish;
    }

    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        cdlStart = new CountDownLatch(CARS_COUNT);
        cdlFinish = new CountDownLatch(CARS_COUNT);

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }
        Thread[] threads = new Thread[cars.length];
        for (int i = 0; i < cars.length; i++) {
            threads[i] = new Thread(cars[i]);
            threads[i].start();
        }
        try {
            cdlStart.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        try {
            cdlFinish.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}
