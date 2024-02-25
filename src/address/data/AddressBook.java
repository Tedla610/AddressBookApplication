package address.data;

import java.util.*;

public class AddressBook {
    private Set<AddressEntry> entries = new HashSet<>();


    public Set<AddressEntry> getEntries() {
        return entries;
    }

    public void addEntry(AddressEntry entry) {
        entries.add(entry);
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
        entries.remove(addressEntry);
    }

    public void listEntriesInAlphabeticOrder() {
        List<AddressEntry> sortedEntries = new ArrayList<>(entries);
        Collections.sort(sortedEntries, Comparator.comparing(AddressEntry::getLastName).thenComparing(AddressEntry::getFirstName));
        for (AddressEntry entry : sortedEntries) {
            System.out.println(entry);
        }
    }
}
