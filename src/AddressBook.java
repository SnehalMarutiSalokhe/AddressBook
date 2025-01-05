import java.util.*;
import java.util.stream.Collectors;

public class AddressBook {

    private String addressBookName;
    List<Contact> addressesBk = new ArrayList<>();

    public AddressBook(String addressBookName) {
        this.addressBookName = addressBookName;
    }

    public String getAddressBookName() {
        return this.addressBookName;
    }

    public void addContact(Contact c1) {
        addressesBk.add(c1);
        System.out.println("Contact is added.");
    }

    public void display() {
        addressesBk.forEach(System.out::println);
    }

    public List<Contact> getContacts() {
        return addressesBk;
    }

    public void editContact(String firstName) {
        for (Contact c : addressesBk) {
            if (c.firstName.equalsIgnoreCase(firstName)) {
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
                return;
            }
        }
        System.out.println("No contact found with the given name.");
    }

    public void deleteContact(String firstName) {
        addressesBk.removeIf(c -> c.firstName.equalsIgnoreCase(firstName));
        System.out.println("Contact deleted successfully.");
    }

    public void sortByCity() {
        List<Contact> sortedList = addressesBk.stream()
                .sorted(Comparator.comparing(c -> c.city))
                .collect(Collectors.toList());
        System.out.println("Contacts sorted by City:");
        sortedList.forEach(System.out::println);
    }

    public void sortByState() {
        List<Contact> sortedList = addressesBk.stream()
                .sorted(Comparator.comparing(c -> c.state))
                .collect(Collectors.toList());
        System.out.println("Contacts sorted by State:");
        sortedList.forEach(System.out::println);
    }

    public void sortByZip() {
        List<Contact> sortedList = addressesBk.stream()
                .sorted(Comparator.comparingInt(c -> c.zip))
                .collect(Collectors.toList());
        System.out.println("Contacts sorted by Zip:");
        sortedList.forEach(System.out::println);
    }
}
