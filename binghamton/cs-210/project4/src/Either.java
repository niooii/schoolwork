/*
 * A class inspired by Haskell's Either monad, for more expressive
 * handling of errors (at least for this project, most return types from the db driver can be
 * expressed as <Ret, ErrorString>).
 */

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Consumer;

public class Either<L, R> {
    private final L left;
    private final R right;
    private final boolean isLeft;

    private Either(L left, R right, boolean isLeft) {
        this.left = left;
        this.right = right;
        this.isLeft = isLeft;
    }

    /* Factory methods */
    public static <L, R> Either<L, R> left(L value) {
        return new Either<>(value, null, true);
    }

    public static <L, R> Either<L, R> right(R value) {
        return new Either<>(null, value, false);
    }

    public boolean isLeft() {
        return isLeft;
    }

    public boolean isRight() {
        return !isLeft;
    }

    ///  Get the Left value, unchecked.
    public L getLeft() {
        return left;
    }

    ///  Get the Right value, unchecked.
    public R getRight() {
        return right;
    }

    ///  Apply a function depending on whether it is a Left or Right variant.
    public void apply(Consumer<L> leftFunction, Consumer<R> rightFunction) {
        if (isLeft)
            leftFunction.accept(left);
        else
            rightFunction .accept(right);
    }
}
