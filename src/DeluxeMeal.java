public class DeluxeMeal extends Meal {
    private boolean hasDessert;

    public DeluxeMeal(String name, int calories, boolean hasDessert) {
        super(name, calories);
        this.hasDessert = hasDessert;
    }

    @Override
    public double getPrice() {
        return hasDessert? 15 : 12;
    }

    @Override
    public String toString() {
        return super.toString() +
                (hasDessert ? " Includes dessert." : " No dessert.");
    }
}