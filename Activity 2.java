import java.util.ArrayList;
import java.util.Scanner;

public class Cosmetic {
    private String itemName;
    private double price;
    private int sold;
    private int stock;

    public Cosmetic(String itemName, double price, int stock) {
        this.itemName = itemName;
        this.price = price;
        this.stock = stock;
        this.sold = 0;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getSold() {
        return sold;
    }

    public int getStock() {
        return stock;
    }

    public void logDetails() {
        System.out.println("Cosmetic: " + itemName +
                           " | Price: " + price +
                           " | Stock: " + stock +
                           " | Sold: " + sold);
    }

    public void buy() {
        if (stock > 0) {
            sold++;
            stock--;
            System.out.println("you purchased: " + itemName);
        } else {
            System.out.println("Sorry, " + itemName + " is out of stock.");
        }
    }

    public void returnItem() {
        if (sold > 0) {
            sold--;
            stock++;
            System.out.println("️ You returned: " + itemName);
        } else {
            System.out.println("No " + itemName + " to return.");
        }
    }

    // main method now belongs here
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Cosmetic> cosmetics = new ArrayList<>();

        // Add cosmetics with default stock
        cosmetics.add(new Cosmetic("Eyeliner", 120.0, 5));
        cosmetics.add(new Cosmetic("Lipstick", 150.0, 5));
        cosmetics.add(new Cosmetic("Foundation", 300.0, 5));
        cosmetics.add(new Cosmetic("Mascara", 200.0, 5));
        cosmetics.add(new Cosmetic("Blush On", 180.0, 5));

        int choice;
        do {
            System.out.println("\n=== Cosmetics Shop Menu ===");
            System.out.println("1. Buy a cosmetic");
            System.out.println("2. Return a cosmetic");
            System.out.println("3. View cosmetics details");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\nWhich cosmetic do you want to buy?");
                    for (int i = 0; i < cosmetics.size(); i++) {
                        System.out.println((i + 1) + ". " + cosmetics.get(i).getItemName() +
                                           " - " + cosmetics.get(i).getPrice());
                    }
                    System.out.print("Enter number: ");
                    int buyChoice = sc.nextInt() - 1;
                    if (buyChoice >= 0 && buyChoice < cosmetics.size()) {
                        cosmetics.get(buyChoice).buy();
                    } else {
                        System.out.println("Invalid choice.");
                    }
                    break;

                case 2:
                    System.out.println("\nWhich cosmetic do you want to return?");
                    for (int i = 0; i < cosmetics.size(); i++) {
                        System.out.println((i + 1) + ". " + cosmetics.get(i).getItemName());
                    }
                    System.out.print("Enter number: ");
                    int returnChoice = sc.nextInt() - 1;
                    if (returnChoice >= 0 && returnChoice < cosmetics.size()) {
                        cosmetics.get(returnChoice).returnItem();
                    } else {
                        System.out.println("Invalid choice.");
                    }
                    break;

                case 3:
                    System.out.println("\n--- Cosmetics Details ---");
                    for (Cosmetic c : cosmetics) {
                        c.logDetails();
                    }
                    break;

                case 4:
                    System.out.println("Thank you for visiting the flower knows cosmetics shop!");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        } while (choice != 4);

        sc.close();
    }
}
