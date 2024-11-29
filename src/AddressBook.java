import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {

    List<Contact> addressesBk = new ArrayList<>();

    public void addContact(Contact c1) {
        addressesBk.add(c1);
        System.out.println("Contact is added.");
    }

    public void display() {
        System.out.println(addressesBk);
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
                System.out.println("Contact details updated successfully.");
                break;
            }
        }
        if (!contactFound) {
            System.out.println("No contact found with the given name.");
        }
    }
}
