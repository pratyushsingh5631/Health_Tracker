import java.util.Scanner;

public class HealthTracker {
    private static String name;
    private static int age;
    private static double height; // in cm
    private static double weight; // in kg
    private static double bmi; // body mass index
    private static int waterIntake; // in ml
    private static int steps;
    private static int caloriesBurned;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Get user information
        System.out.print("Enter your name: ");
        name = input.nextLine();
        System.out.print("Enter your age: ");
        age = input.nextInt();
        System.out.print("Enter your height in cm: ");
        height = input.nextDouble();
        System.out.print("Enter your weight in kg: ");
        weight = input.nextDouble();

        // Calculate BMI
        bmi = calculateBMI(height, weight);
        System.out.println("Your BMI is: " + bmi);

        // Set water intake goal
        waterIntake = calculateWaterIntake(weight);

        // Main menu
        while (true) {
            System.out.println("\n===== Health Tracker =====");
            System.out.println("1. Record water intake");
            System.out.println("2. Record steps");
            System.out.println("3. Record calories burned");
            System.out.println("4. View progress");
            System.out.println("5. Exit");

            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    recordWaterIntake(input);
                    break;
                case 2:
                    recordSteps(input);
                    break;
                case 3:
                    recordCaloriesBurned(input);
                    break;
                case 4:
                    viewProgress();
                    break;
                case 5:
                    System.out.println("Exiting Health Tracker...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Calculate BMI
    public static double calculateBMI(double height, double weight) {
        return weight / ((height/100) * (height/100));
    }

    // Calculate water intake goal
    public static int calculateWaterIntake(double weight) {
        return (int) (weight * 30);
    }

    // Record water intake
    public static void recordWaterIntake(Scanner input) {
        System.out.print("Enter amount of water in ml: ");
        int amount = input.nextInt();
        waterIntake += amount;
        System.out.println("Recorded " + amount + " ml of water intake.");
    }

    // Record steps
    public static void recordSteps(Scanner input) {
        System.out.print("Enter number of steps: ");
        int amount = input.nextInt();
        steps += amount;
        System.out.println("Recorded " + amount + " steps.");
    }

    // Record calories burned
    public static void recordCaloriesBurned(Scanner input) {
        System.out.print("Enter number of calories burned: ");
        int amount = input.nextInt();
        caloriesBurned += amount;
        System.out.println("Recorded " + amount + " calories burned.");
    }

    // View progress
    public static void viewProgress() {
        System.out.println("\n===== Progress =====");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Height: " + height + " cm");
        System.out.println("Weight: " + weight + " kg");
        System.out.println("BMI: " + bmi);
        System.out.println("Water intake: " + waterIntake + " ml");
    }
}