public class KidsMeal extends Meal {
    private boolean includesToy;

    public KidsMeal(String name, int calories, boolean includesToy) {
        super(name, calories);
        this.includesToy = includesToy;
    }

    @Override
    public double getPrice() {
        return includesToy? 7.50 : 6.00;
    }

    @Override
    public String toString() {
        return super.toString() +
                (includesToy ? " Includes a toy." : " No toy included.");
    }
}