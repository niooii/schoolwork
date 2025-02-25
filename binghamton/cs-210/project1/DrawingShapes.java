import java.util.Optional;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

enum ShapeType {
    Rectangle,
    Triangle,
    Hexagon,
    Octagon,
    Pentagon;

    public String toString() {
        return this.name().toLowerCase();
    }

    public String details(int w, int h) {
        switch (this) {
            case Rectangle:
                return String.format("%d by %d rectangle of *", w, h);
            case Triangle:
                return String.format("triangle with two side lengths of %d *", w);
            case Pentagon:
                return String.format("pentagon with 4 side lengths of %d *", w);
            default:
                return String.format("%s with side lengths of %d *", this, w);
        }
    }

    public boolean needsHeight() {
        return this == Rectangle;
    }

    String centeredStarString(int centerIdx, int numStars) {
        String stars = IntStream.range(0, numStars)
                .mapToObj(_i -> "*")
                .collect(Collectors.joining());

        String padding = IntStream.range(0, centerIdx - numStars/2)
                .mapToObj(_i -> " ")
                .collect(Collectors.joining());

        return String.format("%s%s", padding, stars);
    }

    /*
    We represent each shape as a function f : RowNumber -> NumStars, then drawing becomes simple and elegant.
    We know to draw any shape, we need the function f, the "center axis" (index of the axis of symmetry), and the domain.
    */
    String drawArbitrary(Function<Integer, Integer> stars, int domainEnd, int centerIdx) {
        StringBuilder s = new StringBuilder();
        for (int x = 0; x <= domainEnd; x++) {
            s.append(centeredStarString(centerIdx, stars.apply(x)));
            s.append('\n');
        }
        return s.toString();
    }

    public void draw(int w, int h) {
        String s = "";
        switch (this) {
            // draw rectangle
            case Rectangle:
            {
                s = drawArbitrary(
                        (i) -> w,
                        h - 1,
                        0
                );
                break;
            }
            // draw hexagon
            case Hexagon:
            {
                // domain is from 0 to 2(length) - 2
                s = drawArbitrary(
                    /*
                    function for stars on the ith row.
                    example for w=4:

                    domain:
                    {0, 1  , 2  , 3  , 4  , 5  , 6}
                    image:
                    {4, 6  , 8  , 10 , 8  , 6  , 4}

                    so:
                    f: {0, 1, 2, 3, 4, 5, 6} -> {4, 6, 8, 10, 8, 6, 4}

                    generalize the image in terms of w:
                    {w, w+2, w+4, w+6, w+4, w+2, w}

                    in this particular case of w=4, we can derive a function:
                    f(i) = w + 2 * min(i, 6-i)

                    generalizing to all w cases:
                    f(i) = w + 2 * min(i, 2*(w-1)-i)

                    ^^ This is the idea behind how the function was derived, i will not be explaining
                    the subsequent star functions.
                    */
                        (i) -> w + 2 * Math.min(i, 2*(w-1)-i),
                        w * 2 - 2,
                        w + w/2
                );
                break;
            }
            // draw triangle
            case Triangle:
            {
                // domain is from 0 to length - 1
                s = drawArbitrary(
                        (i) -> i * 2 + 1,
                        w - 1,
                        w - 1
                );
                break;
            }
            // draw octagon
            case Octagon:
            {
                // domain is from 0 to 3(length) - 3 this time,
                final int domainEnd = w * 3 - 3;
                s = drawArbitrary(
                        (i) -> {
                            final int twoThirdsDomain = 2 * domainEnd / 3;
                            if (i < domainEnd / 3) {
                                return w + 2 * i;
                            } else if (i < twoThirdsDomain) {
                                return w + twoThirdsDomain;
                            } else {
                                return w + (twoThirdsDomain) - 2 * (i - twoThirdsDomain);
                            }
                        },
                        domainEnd,
                        w + w/2
                );
                break;
            }
            // draw pentagon
            case Pentagon:
            {
                String triangle = drawArbitrary(
                        (i) -> i * 2 + 1,
                        w - 1,
                        w - 1
                );
                String rect = drawArbitrary(
                        (i) -> w * 2 - 1,
                        w - 2,
                        0
                );
                s = String.format("%s%s", triangle, rect);
                break;
            }
        }
        System.out.printf("Below is a %s\n", this.details(w, h));
        System.out.println(s);
    }
}

public class DrawingShapes {
    static void err(String error) {
        System.out.println(error);
        System.out.println("Goodbye!");
        System.exit(1);
    }

    static Optional<ShapeType> tryParse(char c) {
        switch (c) {
            case 'r':
                return Optional.of(ShapeType.Rectangle);
            case 't':
                return Optional.of(ShapeType.Triangle);
            case 'h':
                return Optional.of(ShapeType.Hexagon);
            case 'o':
                return Optional.of(ShapeType.Octagon);
            case 'p':
                return Optional.of(ShapeType.Pentagon);
            default:
                return Optional.empty();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a shape: r t h o p");
        Optional<ShapeType> type = tryParse(sc.next().charAt(0));
        type.ifPresentOrElse(t -> {

            System.out.println("Enter a length");
            int w = sc.nextInt();

            if (w <= 1) {
                err("Length must be greater than 1");
            }

            int h;
            if (t.needsHeight()) {
                System.out.println("Enter a height");
                h = sc.nextInt();
                if (h <= 1)
                    err("Height must be greater than 1");
            } else {
                h = 0;
            }

            t.draw(w, h);
        }, () -> err("Invalid shape"));
    }
}
