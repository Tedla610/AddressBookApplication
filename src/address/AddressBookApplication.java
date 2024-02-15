//Name: Tedla Boke
//Date: 01/30/23
//NetId: uq6435

package address;

/** main AddressBookApplication: purpose is to create some instance of AddressBook
 **/
class AddressBookApplication {
     private AddressBook addressBook;

     // Constructor
     public AddressBookApplication() {
     addressBook = new AddressBook();
     }

     // Method to add entries to the address book
     public void add(AddressEntry entry1, AddressEntry entry2) {
     addressBook.addAddressEntry(entry1);
     addressBook.addAddressEntry(entry2);
     }

     // Method to list all entries in the address book
     public void list() {
     addressBook.initAddressBookExercise();
     }

     public static void main(String[] args) {
     // Creating instances of AddressEntry
     AddressEntry entry1 = new AddressEntry("Tedla", "Boke", "1001 Main St", "Milpitas", "CA", 95035, "408-646-1124", "tboke@gmail.com");
     AddressEntry entry2 = new AddressEntry("Jason", "Marvin", "123 Abel Ave", "Cupertino", "CA", 95129, "408-561-1178", "Coding123@yahoo.com");

     // Creating instance of AddressBookApplication
     AddressBookApplication ab = new AddressBookApplication();

     // Adding entries to the address book
     ab.add(entry1, entry2);

     // Listing all entries in the address book
     ab.list();
     }

    public static void main() {

        //create instance of menu
        address.Menu myMenu = new address.Menu();

        //Display to standard output all of the Menu prompts
        System.out.println(myMenu.prompt_FirstName());

        System.out.println(myMenu.prompt_LastName());

        System.out.println(myMenu.prompt_Street());

        System.out.println(myMenu.prompt_City());

        System.out.println(myMenu.prompt_State());

        System.out.println(myMenu.prompt_Zip());

        System.out.println(myMenu.prompt_Telephone());

        System.out.println(myMenu.prompt_Email());



        //***YOU NOW FINISH CODE TO CALL ALL the rest of the Menu prompts and display to standard output

    }
}
