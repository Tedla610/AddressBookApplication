//Name: Tedla Boke
//Date: 01/30/23
//NetId: uq6435

package address;
import address.data.AddressBook;
import address.data.AddressEntry;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;

public class AddressBookApplication {
    private static final AddressBook addressBook = new AddressBook();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char choice;

        do {
            printMenu();
            System.out.print("Enter your menu selection: ");
            choice = scanner.nextLine().toLowerCase().charAt(0);

            switch (choice) {
                case 'a':
                    loadFromFile(scanner);
                    break;
                case 'b':
                    addEntry(scanner);
                    break;
                case 'c':
                    removeEntry(scanner);
                    break;
                case 'd':
                    findEntry(scanner);
                    break;
                case 'e':
                    listEntries();
                    break;
                case 'f':
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 'f');
    }

    private static void printMenu() {
        System.out.println("*****************************");
        System.out.println("Please enter your menu selection");
        System.out.println("a) Loading From File");
        System.out.println("b) Addition");
        System.out.println("c) Removal");
        System.out.println("d) Find");
        System.out.println("e) Listing");
        System.out.println("f) Quit");
        System.out.println("*****************************");
    }

    private static void loadFromFile(Scanner scanner) {
        System.out.println("Enter in FileName:");
        String fileName = scanner.nextLine();
        try {
            File file = new File(fileName);
            Scanner fileScanner = new Scanner(file);
            int count = 0;
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] data = line.split(",");
                if (data.length == 8) {
                    AddressEntry entry = new AddressEntry(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7]);
                    addressBook.addEntry(entry);
                    count++;
                }
            }
            fileScanner.close();
            System.out.println("Read in " + count + " new Addresses, successfully loaded, currently " + addressBook.getEntries().size() + " Addresses");
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }

    private static void addEntry(Scanner scanner) {
        System.out.println("First Name:");
        String firstName = scanner.nextLine();
        System.out.println("Last Name:");
        String lastName = scanner.nextLine();
        System.out.println("Street:");
        String street = scanner.nextLine();
        System.out.println("City:");
        String city = scanner.nextLine();
        System.out.println("State:");
        String state = scanner.nextLine();
        System.out.println("Zip:");
        String zip = scanner.nextLine();
        System.out.println("Phone:");
        String phone = scanner.nextLine();
        System.out.println("Email:");
        String email = scanner.nextLine();

        AddressEntry entry = new AddressEntry(firstName, lastName, street, city, state, zip, email, phone);
        addressBook.addEntry(entry);
        System.out.println("Thank you the following contact has been added to your address book:");
        System.out.println(entry);
    }

    private static void removeEntry(Scanner scanner) {
        System.out.println("Enter the last name of the entry to remove:");
        String lastName = scanner.nextLine();
        Set<AddressEntry> foundEntries = addressBook.findEntriesByLastName(lastName);
        if (foundEntries.isEmpty()) {
            System.out.println("No entries found with last name " + lastName);
            return;
        }
        System.out.println("Multiple entries found with last name " + lastName + ":");
        int index = 1;
        for (AddressEntry entry : foundEntries) {
            System.out.println(index + ") " + entry);
            index++;
        }
        System.out.print("Enter the index of the entry to remove: ");
        int entryIndex = scanner.nextInt();
        if (entryIndex <= 0 || entryIndex > foundEntries.size()) {
            System.out.println("Invalid index!");
            return;
        }
        AddressEntry[] entriesArray = foundEntries.toArray(new AddressEntry[0]);
        addressBook.removeEntry(entriesArray[entryIndex - 1]);
        System.out.println("Entry removed successfully.");
    }

    private static void findEntry(Scanner scanner) {
        System.out.println("Enter the beginning of the last name:");
        String lastNameStart = scanner.nextLine();
        Set<AddressEntry> foundEntries = addressBook.findEntriesByLastName(lastNameStart);
        if (foundEntries.isEmpty()) {
            System.out.println("No entries found with last name starting with " + lastNameStart);
            return;
        }
        System.out.println("Entries found:");
        for (AddressEntry entry : foundEntries) {
            System.out.println(entry);
        }
    }

    private static void listEntries() {
        addressBook.listEntriesInAlphabeticOrder();
    }
}

