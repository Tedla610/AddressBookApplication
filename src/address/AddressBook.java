package address;

import java.util.ArrayList;
import java.util.List;

/**
 * AddressBook Class
 */
class AddressBook {
    private List<AddressEntry> addressEntryList;

    // Constructor
    public AddressBook() {
        this.addressEntryList = new ArrayList<>();
    }

    /**
     *
     * @param entry
     */
    // Method to add an entry to the address book
    public void addAddressEntry(AddressEntry entry) {
        addressEntryList.add(entry);
    }

    // Method to print all entries in the address book
    public void initAddressBookExercise() {
        for (AddressEntry entry : addressEntryList) {
            System.out.println(entry);
        }
    }
}
