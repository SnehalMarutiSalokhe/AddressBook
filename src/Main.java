import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book!");

        AddressBook a1 = new AddressBook();
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

            System.out.println("Enter 0 to exit");
            isExit = sc.nextInt();
            System.out.println("Exiting from Address Book...");
        } while (isExit != 0);

        System.out.println("Thank you for using Address Book.");
        sc.close();
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
}
