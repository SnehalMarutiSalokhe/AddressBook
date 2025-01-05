import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book System!");

        Map<String, AddressBook> addressBookSystem = new HashMap<>();
        Map<String, List<Contact>> cityMap = new HashMap<>();
        Map<String, List<Contact>> stateMap = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        int choice;

        do {
            System.out.println("""
                Enter 1 to create a new Address Book
                Enter 2 to select an existing Address Book
                Enter 3 to display all Address Book names
                Enter 4 to search persons by City or State
                Enter 5 to view persons by City or State
                Enter 0 to exit""");
            choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> createAddressBook(addressBookSystem);
                case 2 -> selectAddressBook(addressBookSystem, cityMap, stateMap);
                case 3 -> {
                    System.out.println("Available Address Books:");
                    addressBookSystem.keySet().forEach(System.out::println);
                }
                case 4 -> searchByCityOrState(addressBookSystem);
                case 5 -> viewPersonsByCityOrState(cityMap, stateMap);
                case 0 -> System.out.println("Exiting Address Book System...");
                default -> System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 0);

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

    static void selectAddressBook(Map<String, AddressBook> system, Map<String, List<Contact>> cityMap, Map<String, List<Contact>> stateMap) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the Address Book to select:");
        String addressBookName = sc.nextLine();

        if (system.containsKey(addressBookName)) {
            AddressBook selectedAddressBook = system.get(addressBookName);
            manageAddressBook(selectedAddressBook, cityMap, stateMap);
        } else {
            System.out.println("Address Book with this name does not exist.");
        }
    }

    static void manageAddressBook(AddressBook a1, Map<String, List<Contact>> cityMap, Map<String, List<Contact>> stateMap) {
        Scanner sc = new Scanner(System.in);

        int choice;

        do {
            System.out.println("""
                Enter 1 to create contact
                Enter 2 to display all contacts
                Enter 3 to edit an existing contact
                Enter 4 to delete a contact
                Enter 0 to return to main menu""");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> createContact(a1, cityMap, stateMap);
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
                case 0 -> System.out.println("Returning to main menu...");
                default -> System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 0);
    }

    static void createContact(AddressBook a1, Map<String, List<Contact>> cityMap, Map<String, List<Contact>> stateMap) {
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

        // Update city and state maps
        cityMap.putIfAbsent(city, new ArrayList<>());
        cityMap.get(city).add(c1);

        stateMap.putIfAbsent(state, new ArrayList<>());
        stateMap.get(state).add(c1);
    }

    static void searchByCityOrState(Map<String, AddressBook> system) {
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                Enter 1 to search by City
                Enter 2 to search by State""");
        int searchChoice = sc.nextInt();
        sc.nextLine(); // Consume newline

        List<Contact> results;

        switch (searchChoice) {
            case 1 -> {
                System.out.println("Enter the City to search:");
                String city = sc.nextLine();
                results = system.values().stream()
                        .flatMap(addressBook -> addressBook.getContacts().stream())
                        .filter(contact -> contact.city.equalsIgnoreCase(city))
                        .collect(Collectors.toList());
            }
            case 2 -> {
                System.out.println("Enter the State to search:");
                String state = sc.nextLine();
                results = system.values().stream()
                        .flatMap(addressBook -> addressBook.getContacts().stream())
                        .filter(contact -> contact.state.equalsIgnoreCase(state))
                        .collect(Collectors.toList());
            }
            default -> {
                System.out.println("Invalid choice. Returning to main menu...");
                return;
            }
        }

        if (results.isEmpty()) {
            System.out.println("No contacts found for the given search criteria.");
        } else {
            System.out.println("Search Results:");
            results.forEach(System.out::println);
        }
    }

    static void viewPersonsByCityOrState(Map<String, List<Contact>> cityMap, Map<String, List<Contact>> stateMap) {
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                Enter 1 to view persons by City
                Enter 2 to view persons by State""");
        int choice = sc.nextInt();
        sc.nextLine(); // Consume newline

        switch (choice) {
            case 1 -> {
                System.out.println("Enter the City to view persons:");
                String city = sc.nextLine();
                List<Contact> contacts = cityMap.getOrDefault(city, Collections.emptyList());

                if (contacts.isEmpty()) {
                    System.out.println("No contacts found in the specified city.");
                } else {
                    System.out.println("Persons in city " + city + ":");
                    contacts.forEach(System.out::println);
                }
            }
            case 2 -> {
                System.out.println("Enter the State to view persons:");
                String state = sc.nextLine();
                List<Contact> contacts = stateMap.getOrDefault(state, Collections.emptyList());

                if (contacts.isEmpty()) {
                    System.out.println("No contacts found in the specified state.");
                } else {
                    System.out.println("Persons in state " + state + ":");
                    contacts.forEach(System.out::println);
                }
            }
            default -> System.out.println("Invalid choice. Returning to main menu...");
        }
    }
}
