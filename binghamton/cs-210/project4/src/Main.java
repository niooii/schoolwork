import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        AtomicBoolean shouldContinue = new AtomicBoolean(true);

        while (shouldContinue.get()) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Add Member");
            System.out.println("3. Search Book");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. List Borrowed Books");
            System.out.println("7. Exit");
            Utils.promptIntInput("Choose an option: ").ifPresentOrElse(
                (Integer choice) -> {
                    switch (choice) {
                        case 1: handleAddBook(library); break;
                        case 2: handleAddMember(library); break;
                        case 3: handleSearchBook(library); break;
                        case 4: handleIssueBook(library); break;
                        case 5: handleReturnBook(library); break;
                        case 6: handleListBorrowedBooks(library); break;
                        case 7:
                            shouldContinue.set(false);
                            System.out.println("Exiting...");
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                },
                () -> System.out.println("Invalid input. Please enter a number.")
            );
        }
    }

    private static void handleAddBook(Library library) {
        Utils.promptStrInput("Enter book title: ", ".+").ifPresentOrElse(
            (String title) ->
                Utils.promptStrInput("Enter book author: ", ".+").ifPresentOrElse(
                (String author) -> Utils.promptStrInput("Enter book ISBN: ", "\\d+").ifPresentOrElse(
                    (String isbn) -> Utils.promptIntInput("Enter number of copies: ").ifPresentOrElse(
                        (Integer copies) -> {
                            if (copies <= 0) {
                                System.out.println("Number of copies must be positive.");
                                return;
                            }

                            long totalCopies = 0;
                            for (int i = 0; i < copies; i++) {
                                totalCopies = library.addBook(title, author, isbn);
                            }

                            System.out.printf("%d copies of '%s' added successfully. Total: %d\n",
                                copies, title, totalCopies);
                        },
                        () -> System.out.println("Invalid number of copies.")
                    ),
                    () -> System.out.println("Invalid ISBN.")
                ),
                () -> System.out.println("Invalid author name.")
            ),
            () -> System.out.println("Invalid book title.")
        );
    }

    private static void handleAddMember(Library library) {
        Utils.promptStrInput("Enter member name: ", ".+").ifPresentOrElse(
            (String name) -> {
                int memberId = library.addMember(name);
                System.out.printf("Member added successfully with ID: M%d\n", memberId);
            },
            () -> System.out.println("Invalid member name.")
        );
    }

    private static void handleSearchBook(Library library) {
        System.out.println("Search book by:");
        System.out.println("1. Title");
        System.out.println("2. ISBN");
        System.out.println("3. Author");

        Utils.promptIntInput("Enter your choice: ").ifPresentOrElse(
            (Integer choice) -> {
                switch (choice) {
                    case 1:
                        Utils.promptStrInput("Enter the book title: ", ".+").ifPresentOrElse(
                            (String title) ->
                                    library.searchBooksByTitle(title).apply(
                                (books) -> {
                                    System.out.println("Found " + books.size() + " matching books:");
                                    books.forEach(book ->
                                        System.out.printf("ISBN: %s, Title: %s, Author: %s, Available: %d/%d\n",
                                            book.isbn, book.name, book.author, book.available, book.count));
                                },
                                System.out::println
                            ),
                            () -> System.out.println("Invalid title.")
                        );
                        break;

                    case 2:
                        Utils.promptStrInput("Enter book ISBN: ", "\\d+").ifPresentOrElse(
                            (String isbn) -> {
                                BookRow book = library.getBook(isbn);

                                if (book == null) {
                                    System.out.println("No book found with ISBN '" + isbn + "'.");
                                    return;
                                }

                                System.out.printf("ISBN: %s, Title: %s, Author: %s, Available: %d/%d\n",
                                    isbn, book.name, book.author, book.available, book.count);
                            },
                            () -> System.out.println("Invalid ISBN.")
                        );
                        break;

                    case 3:
                        Utils.promptStrInput("Enter the author name: ", ".+").ifPresentOrElse(
                            (String author) ->
                                library.searchBooksByAuthor(author).apply(
                                (books) ->
                                    books.forEach(book ->
                                        System.out.printf("ISBN: %s, Title: %s, Author: %s, Available: %d/%d\n",
                                        book.isbn, book.name, book.author, book.available, book.count)),
                                    System.out::println
                                ),
                            () -> System.out.println("Invalid author name.")
                        );
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }
            },
            () -> System.out.println("Invalid input. Please enter a number.")
        );
    }

    private static void handleIssueBook(Library library) {
        Utils.promptStrInput("Enter member ID: ", "M\\d+").ifPresentOrElse(
            (String memberId) ->
                Utils.promptStrInput("Enter book title to borrow: ", ".+").ifPresentOrElse(
                (String title) ->
                    library.searchBooksByTitle(title).apply(
                    (books) -> {
                        // guarenteed to be safe
                        BookRow book = books.getFirst();
                        library.issueBook(memberId, book.isbn).apply(
                            (copiesLeft) -> System.out.printf("Success. Numbers of copies of \"%s\" left: %d", book.name, copiesLeft),
                            System.out::println
                        );
                    },
                    System.out::println
                ),
                () -> System.out.println("Invalid book title.")
            ),
            () -> System.out.println("Invalid member ID.")
        );
    }

    private static void handleReturnBook(Library library) {
        Utils.promptStrInput("Enter member ID: ", "M\\d+").ifPresentOrElse(
            (String memberId) ->
                Utils.promptStrInput("Enter book title to return: ", ".+").ifPresentOrElse(
                (String title) ->
                    library.searchBooksByTitle(title).apply(
                        (books) -> {
                            BookRow book = books.getFirst();
                            library.returnBook(memberId, book.isbn).apply(
                                (copiesLeft) -> System.out.printf("Success. Numbers of copies of \"%s\" left: %d", book.name, copiesLeft),
                                System.out::println
                            );
                        },
                        System.out::println
                    ),
                () -> System.out.println("Invalid book title.")
            ),
            () -> System.out.println("Invalid member ID.")
        );
    }

    private static void handleListBorrowedBooks(Library library) {
        Utils.promptStrInput("Enter member ID to list borrowed books: ", "M\\d+").ifPresentOrElse(
            (String memberId) ->
                library.borrowedBooks(memberId).apply(
                (HashSet<String> isbnSet) -> {
                    if (isbnSet.isEmpty()) {
                        System.out.println("This member hasn't borrowed any books.");
                        return;
                    }

                    System.out.println("Borrowed books:");
                    isbnSet.forEach(isbn -> {
                        BookRow book = library.getBook(isbn);
                        if (book != null)
                            System.out.printf("ISBN: %s, Title: %s, Author: %s%n", isbn, book.name, book.author);
                    });
                },
                System.out::println
            ),
            () -> System.out.println("Invalid member ID.")
        );
    }
}