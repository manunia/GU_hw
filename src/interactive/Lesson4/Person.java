package interCourse.Lesson4;

public class Person {

    private String fio;
    private String profession;
    private String email;
    private String tel;
    private double money;
    private int age;

    public Person(String fio, String profession, String email, String tel, double money, int age) {
        this.fio = fio;
        this.profession = profession;
        this.email = email;
        this.tel = tel;
        this.money = money;
        this.age = age;
    }

    public void info () {
        System.out.println("FIO: " + this.getFio() + "; Profession: " + this.getProfession() + "; E-mail: " + this.getEmail() + "; Tel.: "
                + this.getTel() + "; Money: " + this.getMoney()+ "; Age: " + this.getAge());
    }

    public String getFio() {
        return fio;
    }

    public String getProfession() {
        return profession;
    }

    public String getEmail() {
        return email;
    }

    public String getTel() {
        return tel;
    }

    public double getMoney() {
        return money;
    }

    public int getAge() {
        return age;
    }
}
