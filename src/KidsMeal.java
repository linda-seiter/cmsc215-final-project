public class KidsMeal extends Meal {
    private boolean includesToy;

    public KidsMeal(String name, int calories, boolean includesToy) {
        super(name, calories);
        this.includesToy = includesToy;
    }

    @Override
    public double getPrice() {
        double base = 5.00;
        if (includesToy) {
            base += 1.50;
        }
        return base;
    }

    @Override
    public String toString() {
        return super.toString() +
                (includesToy ? " Includes a toy." : " No toy included.");
    }
}