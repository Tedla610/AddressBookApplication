package address.data;

import java.util.*;

/**
 * AddressBook class represents and contains a possibly every growing and/or shrinking "list" of AddressEntries
 */
public class AddressBook {

    /** Set to store AddressEntry objects, using HashSet for fast retrieval and uniqueness */
    private Set<AddressEntry> entries = new HashSet<>();

    /** Getter method to retrieve the set of entries */
    public Set<AddressEntry> getEntries() {
        return entries;
    }

    /** Method to add an entry to the address book */
    public void addEntry(AddressEntry entry) {
        entries.add(entry);
    }

    /** Method to find entries by last name */
    public Set<AddressEntry> findEntriesByLastName(String lastName) {
        Set<AddressEntry> foundEntries = new HashSet<>();
        for (AddressEntry entry : entries) {
            // Check if the last name of the entry starts with the provided last name
            if (entry.getLastName().startsWith(lastName)) {
                foundEntries.add(entry);
            }
        }
        return foundEntries;
    }

    /** Method to remove an entry from the address book */
    public void removeEntry(AddressEntry addressEntry) {
        entries.remove(addressEntry);
    }

    /** Method to list entries in alphabetic order (by last name, then first name) */
    public void listEntriesInAlphabeticOrder() {
        // Copy entries to a list for sorting
        List<AddressEntry> sortedEntries = new ArrayList<>(entries);
        // Sort the list based on last name, then first name
        Collections.sort(sortedEntries, Comparator.comparing(AddressEntry::getLastName).thenComparing(AddressEntry::getFirstName));
        // Print each entry in the sorted list
        for (AddressEntry entry : sortedEntries) {
            System.out.println(entry);
        }
    }
}
