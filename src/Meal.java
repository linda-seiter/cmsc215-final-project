public class Meal {
    protected String name;
    protected int calories;

    public Meal(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }

    @Override
    public String toString() {
        return name + " has " + calories + " calories.";
    }

    public double getPrice() {
        return 8.99; // base price
    }
}