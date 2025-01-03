import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book System!");

        Map<String, AddressBook> addressBookSystem = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        int isExit = 1;
        do {
            System.out.println("""
                Enter 1 to create a new Address Book
                Enter 2 to select an existing Address Book
                Enter 3 to display all Address Book names""");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> createAddressBook(addressBookSystem);
                case 2 -> selectAddressBook(addressBookSystem);
                case 3 -> displayAllAddressBooks(addressBookSystem);
                default -> System.out.println("Invalid choice. Please try again.");
            }

            System.out.println("Enter 0 to exit");
            isExit = sc.nextInt();
            sc.nextLine(); // Consume newline
            System.out.println("Exiting Address Book System...");
        } while (isExit != 0);

        System.out.println("Thank you for using the Address Book System.");
        sc.close();
    }

    static void createAddressBook(Map<String, AddressBook> system) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a unique name for the new Address Book:");
        String addressBookName = sc.nextLine();

        if (system.containsKey(addressBookName)) {
            System.out.println("An Address Book with this name already exists. Try another name.");
        } else {
            system.put(addressBookName, new AddressBook());
            System.out.println("Address Book '" + addressBookName + "' created successfully!");
        }
    }

    static void selectAddressBook(Map<String, AddressBook> system) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the Address Book to select:");
        String addressBookName = sc.nextLine();

        if (system.containsKey(addressBookName)) {
            AddressBook selectedAddressBook = system.get(addressBookName);
            manageAddressBook(selectedAddressBook);
        } else {
            System.out.println("Address Book with this name does not exist.");
        }
    }

    static void manageAddressBook(AddressBook a1) {
        Scanner sc = new Scanner(System.in);

        int isExit = 1;
        do {
            System.out.println("""
                Enter 1 to create contact
                Enter 2 to display all contacts
                Enter 3 to edit an existing contact
                Enter 4 to delete a contact
                Enter 5 to add multiple contacts""");
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> createContact(a1);
                case 2 -> a1.display();
                case 3 -> {
                    System.out.println("Enter the first name of the contact to edit:");
                    String firstName = sc.next();
                    a1.editContact(firstName);
                }
                case 4 -> {
                    System.out.println("Enter the first name of the contact to delete:");
                    String firstName = sc.next();
                    a1.deleteContact(firstName);
                }
                case 5 -> addMultipleContacts(a1);
                default -> System.out.println("Wrong input");
            }

            System.out.println("Enter 0 to return to main menu");
            isExit = sc.nextInt();
            sc.nextLine(); // Consume newline
        } while (isExit != 0);
    }

    static void createContact(AddressBook a1) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first name:");
        String firstName = sc.next();
        System.out.println("Enter last name:");
        String lastName = sc.next();
        System.out.println("Enter city:");
        String city = sc.next();
        System.out.println("Enter state:");
        String state = sc.next();
        System.out.println("Enter email:");
        String email = sc.next();
        System.out.println("Enter phone number:");
        int phone = sc.nextInt();
        System.out.println("Enter zip code:");
        int zip = sc.nextInt();
        Contact c1 = new Contact(firstName, lastName, city, state, email, phone, zip);
        a1.addContact(c1);
    }

    static void addMultipleContacts(AddressBook a1) {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many contacts do you want to add?");
        int numberOfContacts = sc.nextInt();

        for (int i = 0; i < numberOfContacts; i++) {
            System.out.println("Adding contact " + (i + 1));
            createContact(a1);
        }
        System.out.println(numberOfContacts + " contacts added successfully!");
    }

    static void displayAllAddressBooks(Map<String, AddressBook> system) {
        if (system.isEmpty()) {
            System.out.println("No Address Books found in the system.");
        } else {
            System.out.println("List of Address Books:");
            for (String name : system.keySet()) {
                System.out.println("- " + name);
            }
        }
    }
}
