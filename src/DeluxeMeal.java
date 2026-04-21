public class DeluxeMeal extends Meal {
    private String dessert;

    public DeluxeMeal(String name, int calories, String dessert) {
        super(name, calories);
        this.dessert = dessert;
    }

    @Override
    public double getPrice() {
        double price = 15;
        if (getName().toLowerCase().contains("lobster"))
            price += 10;
        if (dessert.toLowerCase().contains("cake"))
            price += 5;
        return price;
    }

    @Override
    public String toString() {
        return super.toString() +
                ("Dessert: " + dessert);
    }
}