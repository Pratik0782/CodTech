import java.util.*;

public class RecommendationApp {

    static class Item {
        String name;
        String category;

        Item(String name, String category) {
            this.name = name;
            this.category = category;
        }
    }

    public static void main(String[] args) {
        // Sample data (Movies / Products)
        List<Item> items = new ArrayList<>();
        items.add(new Item("Avengers", "Action"));
        items.add(new Item("John Wick", "Action"));
        items.add(new Item("Inception", "Sci-Fi"));
        items.add(new Item("Interstellar", "Sci-Fi"));
        items.add(new Item("Notebook", "Romance"));
        items.add(new Item("Titanic", "Romance"));
        items.add(new Item("The Hangover", "Comedy"));
        items.add(new Item("Home Alone", "Comedy"));

        Scanner sc = new Scanner(System.in);

        System.out.println("Available Categories: Action, Sci-Fi, Romance, Comedy");
        System.out.print("Enter your preferred category: ");
        String preference = sc.nextLine();

        System.out.println("\nRecommended for you (" + preference + "):");

        boolean found = false;
        for (Item item : items) {
            if (item.category.equalsIgnoreCase(preference)) {
                System.out.println("👉 " + item.name);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No recommendations found for this category.");
        }

        sc.close();
    }
}
