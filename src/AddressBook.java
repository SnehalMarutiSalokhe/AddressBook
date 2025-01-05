import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddressBook {

    List<Contact> addressesBk = new ArrayList<>();

    public void addContact(Contact c1) {
        boolean isDuplicate = addressesBk.stream()
                .anyMatch(contact -> contact.equals(c1));

        if (isDuplicate) {
            System.out.println("Duplicate Contact! A contact with this name already exists.");
        } else {
            addressesBk.add(c1);
            System.out.println("Contact added successfully.");
        }
    }

    public void display() {
        if (addressesBk.isEmpty()) {
            System.out.println("Address Book is empty.");
        } else {
            addressesBk.forEach(System.out::println);
        }
    }

    public void editContact(String firstName) {
        boolean contactFound = false;
        for (Contact c : addressesBk) {
            if (c.firstName.equalsIgnoreCase(firstName)) {
                contactFound = true;
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter new last name:");
                c.lastName = sc.next();
                System.out.println("Enter new city:");
                c.city = sc.next();
                System.out.println("Enter new state:");
                c.state = sc.next();
                System.out.println("Enter new email:");
                c.email = sc.next();
                System.out.println("Enter new phone number:");
                c.phone = sc.nextInt();
                System.out.println("Enter new zip:");
                c.zip = sc.nextInt();
                System.out.println("Contact updated successfully.");
                break;
            }
        }
        if (!contactFound) {
            System.out.println("No contact found with the given name.");
        }
    }

    public void deleteContact(String firstName) {
        boolean contactFound = false;
        for (int i = 0; i < addressesBk.size(); i++) {
            if (addressesBk.get(i).firstName.equalsIgnoreCase(firstName)) {
                contactFound = true;
                addressesBk.remove(i);
                System.out.println("Contact removed successfully.");
                break;
            }
        }
        if (!contactFound) {
            System.out.println("No contact found with the given name.");
        }
    }

    public List<Contact> searchContactByName(String firstName) {
        return addressesBk.stream()
                .filter(contact -> contact.firstName.equalsIgnoreCase(firstName))
                .collect(Collectors.toList());
    }
}
