package address.data;

import java.util.HashSet;
import java.util.Set;

public class AddressBook {
    private Set<AddressEntry> entries = new HashSet<>();

    // Constructor, getters, setters, and other methods omitted for brevity

    public Set<AddressEntry> getEntries() {
        return entries;
    }

    public void addEntry(AddressEntry entry) {
    }

    public Set<AddressEntry> findEntriesByLastName(String lastName) {
        Set<AddressEntry> foundEntries = new HashSet<>();
        for (AddressEntry entry : entries) {
            if (entry.getLastName().startsWith(lastName)) {
                foundEntries.add(entry);
            }
        }
        return foundEntries;
    }

    public void removeEntry(AddressEntry addressEntry) {
    }

    public void listEntriesInAlphabeticOrder() {
    }
}
