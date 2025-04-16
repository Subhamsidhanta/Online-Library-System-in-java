import java.util.Scanner;

class Library {
    int option;
    public static String[] hackingBooks = new String[100];

    static void books(String... book) {
        for (int i = 0; i < book.length; i++) {
            hackingBooks[i] = book[i];
        }
    }

    void issueBook(int bi) {
        if (bi >= 0 && bi < hackingBooks.length && hackingBooks[bi] != null && !hackingBooks[bi].contains(" (not available)")) {
            System.out.println("Book issued: " + hackingBooks[bi]);
            hackingBooks[bi] = hackingBooks[bi] + " (not available)";
            System.out.println("Book issued successfully!");
        } else {
            System.out.println("Book not available!");
        }
    }

    void returnBook(int bi) {
        if (bi >= 0 && bi < hackingBooks.length && hackingBooks[bi] != null && hackingBooks[bi].contains(" (not available)")) {
            String bookName = hackingBooks[bi].replace(" (not available)", "");
            hackingBooks[bi] = bookName;
            System.out.println("Returning book: " + bookName);
            System.out.println("Book returned successfully!");
        }
        else {
            System.out.println("\nBook not issued!");
        }
    }

    void addBook(String newBook) {

        for (int i = 0; i < hackingBooks.length; i++) {
            if (hackingBooks[i] == null) {
                hackingBooks[i] = newBook;
                System.out.println("Book added: " + newBook);
                return;
            }
        }
        System.out.println("No space to add new book!");
    }

    void showAvailableBooks() {

        System.out.println("Available Hacking Books:");
        for (int i = 0; i < hackingBooks.length; i++) {
            if (hackingBooks[i] != null) {
                System.out.println((i + 1) + ". " + hackingBooks[i]);
            }
        }
    }

    void display() {
        System.out.println("\n\n------------------------------");
        System.out.println("Welcome to the Online Library!");
        System.out.println("------------------------------");
        System.out.println("1. Show available books");
        System.out.println("2. Add a new book");
        System.out.println("3. Issue a book");
        System.out.println("4. Return a book");
        System.out.println("5. Exit");
        System.out.print("Please select an option: ");
        Scanner sc = new Scanner(System.in);//
        option = sc.nextInt();
        System.out.println("------------------------------");

    }

    void menu() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            display();
            switch (option) {
                case 1:
                    showAvailableBooks();
                    break;
                case 2:
                    System.out.print("Enter the name of the book to add: ");
                    String newBook = sc.nextLine();
                    addBook(newBook);
                    break;
                case 3:
                    System.out.print("Enter the index of the book to issue: ");
                    int issueIndex = sc.nextInt() - 1;
                    issueBook(issueIndex);
                    break;
                case 4:
                    System.out.print("Enter the index of the book to return: ");
                    int returnIndex = sc.nextInt() - 1;
                    returnBook(returnIndex);
                    break;
                case 5:
                    System.out.println("Exiting the library system. Goodbye!");

                    return;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }

    }
}

public class OnlineLibrary {
    public static void main(String[] args) {
        // Step 1: Load books
        Library.books(
                "The Web Application Hacker's Handbook",
                "Hacking: The Art of Exploitation",
                "Black Hat Python",
                "Gray Hat Python",
                "Violent Python",
                "Metasploit: The Penetration Tester’s Guide",
                "The Hacker Playbook 3",
                "Linux Basics for Hackers",
                "Ghost in the Wires",
                "Social Engineering: The Science of Human Hacking",
                "Network Security Assessment",
                "The Shellcoder's Handbook",
                "Practical Malware Analysis",
                "Reversing: Secrets of Reverse Engineering",
                "Penetration Testing: A Hands-On Introduction to Hacking",
                "Red Team Field Manual (RTFM)",
                "Blue Team Field Manual (BTFM)",
                "Wireshark Network Analysis",
                "Cybersecurity for Beginners",
                "The Art of Memory Forensics");

        Library l = new Library();
        l.menu();

    }
}
