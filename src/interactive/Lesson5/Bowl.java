package interactive.Lesson5;

public class Bowl {

    private double volume;
    private String food;
    private double count;

    public Bowl(double volume, String food) {
        this.volume = volume;
        this.food = food;
    }

    public void fullUp(double count) {
        if (count > 0 && count <= volume) {
            System.out.println("Bowl is full up on " + count);
            this.setCount(count);
        } else {
            System.out.println("Volume is less then " + count);
        }
    }

    public double getCount() {
        return count;
    }

    public void setCount(double count) {
        this.count = count;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public double getVolume() {
        return volume;
    }

    public String getFood() {
        return food;
    }
}
