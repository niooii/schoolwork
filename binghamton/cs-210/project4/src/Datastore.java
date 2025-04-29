/*
 * An abstraction layer for reading and writing data.
 * By keeping everything in one place, we gain the ability to change
 * implementation details at a later date.
 */

import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;

/* Fake database schema */
class MemberRow {
    // Public members to simulate common postgres drivers (also, no point of encapsulation)
    public String name;

    ///  A set of the member's borrowed books, by ISBNs.
    public HashSet<String> borrowed = new HashSet<>();
}

class BookRow {
    public String name;
    public String author;

    /// The amount of books with this isbn, or the number of copies + 1.
    public long count = 0;

    /// The amount of books with this isbn that are available for borrowing.
    public long available = 0;
}

public class Datastore {
    // I would store keys as strings "M*", but integer hashes are usually faster
    private HashMap<Integer, MemberRow> memberTable;

    private HashMap<String, BookRow> bookTable;

    public Datastore() {
        memberTable = new HashMap<>();
        bookTable = new HashMap<>();
    }

    private String getMemberIdString(int memberId) { return String.format("M%d", memberId); }

    ///  Returns the total count of the book added.
    /// (e.g. when inserting a book not present in the database, 1 is returned).
    public long addBook(String name, String author, String isbn) {
        BookRow row = bookTable.computeIfAbsent(isbn, (_k) -> {
            BookRow r = new BookRow();
            r.name = name;
            r.author = author;
            return r;
        });

        row.available++;

        return ++row.count;
    }

    /// Either returns the number of available copies after this operation, or returns an error message.
    public Either<Long, String> issueBook(int memberId, String isbn) {
        MemberRow m = memberTable.get(memberId);

        if (m == null)
            return Either.right("No such member with the ID " + getMemberIdString(memberId) + ".");

        BookRow b = bookTable.get(isbn);

        if (b == null)
            return Either.right("This book doesn't exist in our records!");

        if (b.available == 0)
            return Either.right("No copies of this book are available right now.");

        return Either.left(--b.available);
    }
}
