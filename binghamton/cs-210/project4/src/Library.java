import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class MemberRow {
    // Public members to simulate common postgres drivers (also, no point of encapsulation)
    public String name;

    ///  A set of the member's borrowed books, by ISBNs.
    public HashSet<String> borrowed = new HashSet<>();
}

class BookRow {
    public String isbn;
    public String name;
    public String author;

    /// The amount of books with this isbn, or the number of copies + 1.
    public long count = 0;

    /// The amount of books with this isbn that are available for borrowing.
    public long available = 0;
}

public class Library {
    private int nextMemberId = 1;

    // I would store keys as strings "M*", but integer hashes are usually faster
    private HashMap<Integer, MemberRow> memberTable;

    private HashMap<String, BookRow> bookTable;

    public Library() {
        memberTable = new HashMap<>();
        bookTable = new HashMap<>();
    }

    private String getMemberIdString(int memberId) {
        return String.format("M%d", memberId);
    }

    private int getMemberId(String memberIdStr) {
        return Integer.parseInt(memberIdStr.substring(1));
    }

    ///  Returns the total count of the book added.
    /// (e.g. when inserting a book not present in the database, 1 is returned).
    public long addBook(String name, String author, String isbn) {
        BookRow row = bookTable.computeIfAbsent(isbn, (_k) -> {
            BookRow r = new BookRow();
            r.name = name;
            r.author = author;
            r.isbn = isbn;
            return r;
        });

        row.available++;

        return ++row.count;
    }

    /// Either returns the number of available copies after this operation, or returns an error message.
    public Either<Long, String> issueBook(String memberIdStr, String isbn) {
        MemberRow m = memberTable.get(getMemberId(memberIdStr));

        if (m == null)
            return Either.right("No such member with the ID " + getMemberIdString(getMemberId(memberIdStr)) + ".");

        BookRow b = bookTable.get(isbn);

        if (b == null)
            return Either.right("This book doesn't exist in our records!");

        if (b.available == 0)
            return Either.right(String.format("No copies of \"%s\" book are available right now.", b.name));

        if (m.borrowed.contains(isbn))
            return Either.right(String.format("This member is already borrowing a copy of \"%s\".", b.name));

        m.borrowed.add(isbn);
        return Either.left(--b.available);
    }

    public Either<Long, String> returnBook(String memberIdStr, String isbn) {
        MemberRow m = memberTable.get(getMemberId(memberIdStr));

        if (m == null)
            return Either.right("No such member with the ID " + getMemberIdString(getMemberId(memberIdStr)) + ".");

        BookRow b = bookTable.get(isbn);

        if (b == null)
            return Either.right("This book doesn't exist in our records!");

        if (!m.borrowed.contains(isbn))
            return Either.right(String.format("This member hasn't borrowed the book \"%s\".", b.name));

        m.borrowed.remove(isbn);

        return Either.left(++b.available);
    }

    /// Returns the ID of the newly added member.
    public int addMember(String name) {
        final int memberId = nextMemberId++;

        MemberRow row = new MemberRow();
        row.name = name;

        memberTable.put(memberId, row);

        return memberId;
    }

    /// Either returns the set of borrowed book ISBNs, or returns an error message.
    public Either<HashSet<String>, String> borrowedBooks(String memberIdStr) {
        MemberRow m = memberTable.get(getMemberId(memberIdStr));

        if (m == null)
            return Either.right("No such member with the ID " + getMemberIdString(getMemberId(memberIdStr)) + ".");

        return Either.left(m.borrowed);
    }

    /// Search books by title.
    /// Returns a list of results, or a string "No books matching "title" found!"
    public Either<List<BookRow>, String> searchBooksByTitle(String title) {
        List<BookRow> ls = bookTable.values().stream()
            .filter(bookRow -> bookRow.name.toLowerCase().contains(title.toLowerCase()))
            .toList();

        if (ls.isEmpty())
            return Either.right(String.format("No books matching \"%s\" found!", title));
        else
            return Either.left(ls);
    }

    /// Search books by author
    /// Returns a list of results, or a string "No books with the author matching "author" found!"
    public Either<List<BookRow>, String> searchBooksByAuthor(String author) {
        List<BookRow> ls = bookTable.values().stream()
                .filter(bookRow -> bookRow.name.toLowerCase().equals(author.toLowerCase()))
                .toList();

        if (ls.isEmpty())
            return Either.right(String.format("No books with the author matching \"%s\" found!", author));
        else
            return Either.left(ls);
    }

    /// Get a book with a specific ISBN
    /// Returns either the BookRow or null
    public BookRow getBook(String isbn) {
        return bookTable.get(isbn);
    }
}
