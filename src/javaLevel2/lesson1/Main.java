package javaLevel2.lesson1;

public class Main {

    public static void main(String[] args) {
        Competitable[] competitables = {
                new Human("Ivan", 1, 500),
                new Cat("Mursik", 2,890),
                new Robot("C3PiO", 1, 1800)
        };

        Obstacle[] obstacles = {
                new Wall(1),
                new Road(400)
        };
    }
}
