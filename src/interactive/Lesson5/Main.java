package interactive.Lesson5;

public class Main {
    public static void main(String[] args) {
        Cat[] cats = {new Cat("Barsik"),
                      new Cat("Mursik"),
                      new Cat("Pushok")  };
        Bowl bowl = new Bowl(15,"wiskas");
        int count = 5;
        bowl.fullUp(count);
        for (Cat c:cats) {
            c.eat(bowl,5);
            System.out.println(c.getName() + " satiety = " + c.isSatiety());
            if (bowl.getCount() == 0) {
                System.out.println("food is ending!");
                bowl.fullUp(count);
            }
        }



    }
}
