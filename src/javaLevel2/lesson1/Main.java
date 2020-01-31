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

        for (int i = 0; i < competitables.length; i++) {
            for (int j = 0; j < obstacles.length; j++) {
                if (competitables[i] instanceof Human) {
                    ((Human) competitables[i]).jump(obstacles[0].getSize());
                    ((Human) competitables[i]).run(obstacles[1].getSize());
                }
                if (competitables[i] instanceof Cat) {
                    ((Cat) competitables[i]).jump(obstacles[0].getSize());
                    ((Cat) competitables[i]).run(obstacles[1].getSize());
                }
                if (competitables[i] instanceof Robot) {
                    ((Robot) competitables[i]).jump(obstacles[0].getSize());
                    ((Robot) competitables[i]).run(obstacles[1].getSize());
                }


            }
        }

    }
}
