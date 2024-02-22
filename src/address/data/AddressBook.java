package address.data;

import java.util.*;

public class AddressBook {
    private List<AddressEntry> entries;

    public AddressBook() {
        entries = new ArrayList<>();
    }

    public void addEntry(AddressEntry entry) {
        entries.add(entry);
    }

    public void removeEntry(AddressEntry entry) {
        entries.remove(entry);
    }

    public Set<address.data.AddressEntry> findEntriesByLastName(String lastName) {
        Set<AddressEntry> foundEntries = new HashSet<>();
        for (AddressEntry entry : entries) {
            if (entry.getLastName().startsWith(lastName)) {
                foundEntries.add(entry);
            }
        }
        return foundEntries;
    }

    public void listEntriesInAlphabeticOrder() {
        entries.sort(Comparator.comparing(AddressEntry::getLastName));
        for (AddressEntry entry : entries) {
            System.out.println(entry);
        }
    }

    public Collection<Object> getEntries() {
        return null;
    }
}


