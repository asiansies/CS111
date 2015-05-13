/* Aihoa Le (aihoale@bu.edu)
 * Problem Set 5 | Part 2
 * 
 * Postage Calculator computes the postage required for a piece of first-class U.S. mail.
 */

import java.util.*;

public class PostageCalculator {
    static int type;
    static int weight;
    static String size;
    
    public static void main (String[] args) {
        Scanner console = new Scanner(System.in);
        type = getType(console);
        if (type != 1) {
            weight = getWeight(console);
        }
        if (type == 4) {
            if (weight >= 14) {
                size = getSize(console);
            }
        }
        calculatePostage(type);      
    }
    
    //Give introduction and uses Scanner to ask user for item type.
    public static int getType(Scanner console) {
        System.out.println("Welcome to the Postage Calculator!");
        System.out.println("Supported item types:");
        System.out.println("  1) postcard");
        System.out.println("  2) letter");
        System.out.println("  3) flat");
        System.out.println("  4) parcel");
        System.out.println();
        System.out.print("Enter the type of item (1-4): ");
        int type = console.nextInt();
        return type;
    }
    
    //Uses Scanner to ask user for weight of a non-postcard item.
    public static int getWeight(Scanner console) {
        System.out.print("Enter its weight in ounces: ");
        int ounces = console.nextInt();
        return ounces;
    }
    
    //Uses Scanner to ask user for parcel size if parcel is selected as type.
    public static String getSize(Scanner console) {
        System.out.println("Enter the box size (small, medium, large): ");
        String size = console.next();
        return size;
    }    
    
    //Calculates and prints the required postage.
    public static void calculatePostage(int type) {    
        double price;
        if (type == 1) {
            price = 0.33;
        } else if (type == 2) {
            if (weight < 4) {
                price = 0.46 + ((weight - 1) * .20);
            } else if (weight < 14) {
                price = 0.92 + ((weight - 1) * 0.20);
            } else {
                price = 5.60;
            }
        } else if (type == 3) {
            if (weight < 14) {
                price = 0.92 + ((weight - 1) * 0.20);
            } else {
                price = 5.60;
            }
        } else {
            if (weight < 14) {
                if (weight <= 3) {
                    price = 2.07;
                } else {
                    price = 2.07 + ((weight - 3) * .17);
                } 
            }else if (size.equals("small")) {
                price = 5.80;
            } else if (size.equals("medium")) {
                price = 12.35;
            } else {
                price = 16.85;
            }
        }
        System.out.printf("Required postage: $%.2f\n", price);
    }    
} 