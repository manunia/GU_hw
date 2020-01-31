package interCourse.Lesson4;

public class Main {
    public static void main(String[] args) {
        Person[] persArr = new Person[5];
        persArr[0]  = new Person("Ivanov Ivan", "Engineer", " ivivan@mailbox.com ", "892312312", 3000.0,30);
        persArr[1]  = new Person("Petrov Kolia", "Supervaiser", " petrk@mailbox.com ", "89288888", 3030.0,45);
        persArr[2]  = new Person("Sidorova Irina", "Manadger", " sidrr@mailbox.com ", "892222555", 5000.0,28);
        persArr[3]  = new Person("Krasko Roman", "Saller", " kras@mailbox.com ", "892545698", 3800.0,56);
        persArr[4]  = new Person("Popov Sergey", "security", " popov@mailbox.com ", "892387897", 3020.0,50);

        for (int i = 0; i < persArr.length; i++) {
            if (persArr[i].getAge() > 40)
                persArr[i].info();
        }

        Cat cat = new Cat("Barsik", 12);
        Dog dog = new Dog("Bublic", 4,400);
        Dog dog1 = new Dog("Sharic", 3, 600);

        cat.run(7);
        cat.swim(4);
        cat.jump(1.5);

        dog.run(500);
        dog1.run(500);


    }
}
