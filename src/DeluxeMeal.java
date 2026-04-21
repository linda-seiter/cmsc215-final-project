public class DeluxeMeal extends Meal {
    private boolean hasDessert;

    public DeluxeMeal(String name, int calories, boolean hasDessert) {
        super(name, calories);
        this.hasDessert = hasDessert;
    }

    @Override
    public double getPrice() {
        double base = 12.00;
        if (hasDessert) {
            base += 3.00;
        }
        return base;
    }

    @Override
    public String toString() {
        return name + " is a deluxe meal with " + calories + " calories." +
                (hasDessert ? " Includes dessert." : " No dessert.");
    }
}