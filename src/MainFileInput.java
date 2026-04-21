import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/*
 * FILE FORMAT (meals.txt):
 * Each line represents ONE meal, comma-separated:
 *
 * Type,Name,Calories,ExtraField
 *
 * Type:
 *   K = KidsMeal
 *   D = DeluxeMeal
 *
 * Examples:
 *   K,Happy Meal,600,true
 *   D,Steak Dinner,1200,false
 *
 * Notes:
 * - Calories must be a positive integer (> 0)
 * - ExtraField:
 *     KidsMeal   -> includesToy (true/false)
 *     DeluxeMeal -> hasDessert (true/false)
 *
 * Invalid lines will be skipped with an error message.
 */

public class MainFileInput {
    public static void main(String[] args) {
        ArrayList<Meal> meals = new ArrayList<>();

        try {
            Scanner fileScanner = new Scanner(new File("meals.txt"));

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();

                try {
                    String[] parts = line.split(",");

                    if (parts.length < 4) {
                        throw new InvalidMealDataException("Missing fields");
                    }

                    String type = parts[0].trim();
                    String name = parts[1].trim();
                    int calories = Integer.parseInt(parts[2].trim());

                    // Validation
                    if (calories <= 0) {
                        throw new InvalidMealDataException("Calories must be > 0");
                    }

                    if (type.equalsIgnoreCase("K")) {
                        boolean includesToy = Boolean.parseBoolean(parts[3].trim());
                        meals.add(new KidsMeal(name, calories, includesToy));

                    } else if (type.equalsIgnoreCase("D")) {
                        String dessert = parts[3].trim();
                        meals.add(new DeluxeMeal(name, calories, dessert));

                    } else {
                        throw new InvalidMealDataException("Unknown meal type: " + type);
                    }

                } catch (InvalidMealDataException e) {
                    System.out.println("Skipping invalid data: " + line);
                    System.out.println("  Reason: " + e.getMessage());

                } catch (NumberFormatException e) {
                    System.out.println("Skipping invalid number in line: " + line);
                }
            }

            fileScanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            return;
        }

        // Print all meals
        System.out.println("\n--- Meal List ---");
        for (Meal m : meals) {
            System.out.println(m);
            System.out.printf("Price: $%.2f%n", m.getPrice());
            System.out.println();
        }
    }
}