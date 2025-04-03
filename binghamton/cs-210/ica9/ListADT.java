/**
 * List Abstract Data Type (ADT) Interface.
 * This interface defines the methods required for a list implementation.
 *  Any different classes that implement this interface will behave exactly the same,
 *  Regardless of the used underlying data structure.
 */
public interface ListADT {

    /**
     * Inserts the specified string at the specified index.
     * Shifts the element currently at that index (if any) and any subsequent elements to the right.
     *
     * @param index The position at which the string should be inserted.
     * @param s The string to be inserted.
     * @return {@code true} if the addition was successful, {@code false} if {@code index < 0} or {@code index > size}.
     */
    public abstract boolean add(int index, String s);

    /**
     * Removes and returns the string at the specified index.
     * Shifts any subsequent elements to the left.
     *
     * @param index The position of the string to be removed.
     * @return The removed string, or an empty string if {@code index < 0} or {@code index >= size}.
     */
    public abstract String remove(int index);

    /**
     * Removes all elements from the list.
     * The list will be empty after this method is called.
     */
    public abstract void clear();

    /**
     * Returns a string representation of the list with elements separated by the given separator.
     *
     * @param sep The separator string to be used between elements.
     * @return A string representation of the list with elements separated by {@code sep}.
     */
    public abstract String print(String sep);

    /**
     * Retrieves the string at the specified index.
     * Throws an {@code IndexOutOfBoundsException} if the index is out of range.
     *
     * @param index The position of the element to retrieve.
     * @return The string at the specified index.
     * @throws IndexOutOfBoundsException if {@code index < 0} or {@code index >= size}.
     */
    public abstract String getIndex(int index);
}
