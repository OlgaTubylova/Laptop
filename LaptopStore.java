package java_projects;

import java.util.*;

class Laptop {
    String brand;
    int ram;
    int storage;
    String os;
    String color;

    public Laptop(String brand, int ram, int storage, String os, String color) {
        this.brand = brand;
        this.ram = ram;
        this.storage = storage;
        this.os = os;
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public int getRam() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }

    public String getOs() {
        return os;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "brand='" + brand + '\'' +
                ", ram=" + ram +
                ", storage=" + storage +
                ", os='" + os + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}

public class LaptopStore {
    public static void main(String[] args) {
        Set<Laptop> laptops = new HashSet<>();
        laptops.add(new Laptop("Dell", 8, 512, "Windows", "Black"));
        laptops.add(new Laptop("Apple", 16, 256, "macOS", "Silver"));
        laptops.add(new Laptop("Asus", 16, 1024, "Windows", "White"));
        laptops.add(new Laptop("HP", 8, 256, "Windows", "Black"));
        laptops.add(new Laptop("Lenovo", 32, 1024, "Windows", "Gray"));

        Scanner scanner = new Scanner(System.in);
        Map<String, Object> filterCriteria = new HashMap<>();

        System.out.println("Enter the number corresponding to the required criteria:");
        System.out.println("1 - RAM");
        System.out.println("2 - Storage");
        System.out.println("3 - Operating System");
        System.out.println("4 - Color");

        int criteria = scanner.nextInt();
        scanner.nextLine(); 

        switch (criteria) {
            case 1:
                System.out.print("Enter RAM: ");
                int ram = scanner.nextInt();
                filterCriteria.put("ram", ram);
                break;
            case 2:
                System.out.print("Enter storage: ");
                int storage = scanner.nextInt();
                filterCriteria.put("storage", storage);
                break;
            case 3:
                System.out.print("Enter operating system: ");
                String os = scanner.nextLine();
                filterCriteria.put("os", os);
                break;
            case 4:
                System.out.print("Enter color: ");
                String color = scanner.nextLine();
                filterCriteria.put("color", color);
                break;
            default:
                System.out.println("Invalid input");
                return;
        }

        filterAndPrintLaptops(laptops, filterCriteria);
    }

    public static void filterAndPrintLaptops(Set<Laptop> laptops, Map<String, Object> filterCriteria) {
        for (Laptop laptop : laptops) {
            boolean matches = true;

            if (filterCriteria.containsKey("ram")) {
                int requiredRam = (int) filterCriteria.get("ram");
                if (laptop.getRam() < requiredRam) {
                    matches = false;
                }
            }
            if (filterCriteria.containsKey("storage")) {
                int requiredStorage = (int) filterCriteria.get("storage");
                if (laptop.getStorage() < requiredStorage) {
                    matches = false;
                }
            }
            if (filterCriteria.containsKey("os")) {
                String requiredOs = (String) filterCriteria.get("os");
                if (!laptop.getOs().equalsIgnoreCase(requiredOs)) {
                    matches = false;
                }
            }
            if (filterCriteria.containsKey("color")) {
                String requiredColor = (String) filterCriteria.get("color");
                if (!laptop.getColor().equalsIgnoreCase(requiredColor)) {
                    matches = false;
                }
            }

            if (matches) {
                System.out.println(laptop);
            }
        }
    }
}
