import java.util.ArrayList;
import java.util.Scanner;

public class MainConsoleInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Meal> meals = new ArrayList<>();

        boolean running = true;

        while (running) {
            System.out.println("\nCreate a meal:");
            System.out.println("1. Kids Meal");
            System.out.println("2. Deluxe Meal");
            System.out.println("3. Quit");
            System.out.print("Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            if (choice == 3) {
                running = false;
                break;
            }

            System.out.print("Enter meal name: ");
            String name = scanner.nextLine();

            System.out.print("Enter calories: ");
            int calories = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Includes toy? (true/false): ");
                boolean toy = scanner.nextBoolean();
                meals.add(new KidsMeal(name, calories, toy));

            } else if (choice == 2) {
                System.out.print("Has dessert? (true/false): ");
                boolean dessert = scanner.nextBoolean();
                meals.add(new DeluxeMeal(name, calories, dessert));
            }
        }

        // Print all meals
        System.out.println("\n--- Meal List ---");
        for (Meal m : meals) {
            System.out.println(m); // polymorphic toString()
            System.out.printf("Price: $%.2f%n", m.getPrice()); //polymorphic getPrice()
            System.out.println();
        }

        scanner.close();
    }
}