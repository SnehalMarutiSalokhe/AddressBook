import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Welcome to Address Book!");

        AddressBook a1 = new AddressBook();
        Scanner sc = new Scanner(System.in);

        int isExit = 1;
        do {
            System.out.println("Enter 1 to create contact \n Enter 2 to display al contacts");
            int choice  = sc.nextInt();
            switch (choice) {
                case 1 -> createContact(a1);

                case 2 ->  a1.display();

                default -> System.out.println("Wrong input");
            }


            System.out.println("Enter 0 to exit");
            isExit = sc.nextInt();
            System.out.println("Exiting from addressBook ..");

        } while (isExit != 0);

        System.out.println("Thank you for using address book");
        sc.close();


    }

    static void createContact(AddressBook a1) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name");
        String name = sc.next();
        System.out.println("Enter last name");
        String lname = sc.next();
        System.out.println("Enter city");
        String city = sc.next();
        System.out.println("Enter state");
        String state = sc.next();
        System.out.println("Enter email");
        String email = sc.next();
        System.out.println("Enter phone");
        int phone = sc.nextInt();
        System.out.println("Enter zip");
        int zip = sc.nextInt();
        Contact c1 = new Contact(name, lname, city, state, email, phone, zip);
        a1.addContact(c1);

    }
}
