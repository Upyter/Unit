/*
 * Copyright 2018 Upyter
 *
 * Permission is hereby granted, free of charge, to any person obtaining a
 * copy of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following conditions:
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */

package unit.area;

/*
I am not happy about this naming, but my other idea's regarding the interface
name and the basic implementation weren't good either (impl or simple for
example). So I took the more annoying name for the implementation to lower the
chance that a user might use the class name as a parameter type
*/

import java.util.Objects;
import java.util.function.BiFunction;
import unit.pos.Pos;
import unit.pos.PosOf;
import unit.size.Size;
import unit.size.SizeOf;

/**
 * Basic concrete implementation of {@link Area}.
 * <p>Whether this class is immutable or thread-safe, depends on the given
 * {@link Pos} and {@link Size}. This class
 * doesn't mutate state by itself. Additionally note that the methods provide
 * the actual objects without any safe-copies.</p>
 * @since 0.6
 */
public class AreaOf implements Area {
    /**
     * The pos of this area.
     */
    private final Pos pos;

    /**
     * The size of this area.
     */
    private final Size size;

    /**
     * Ctor. Uses x = 0, y = 0, width = 0 and height = 0 as its values.
     */
    public AreaOf() {
        this(0, 0, 0, 0);
    }

    /**
     * Ctor. The created area will have a position of x = 0 and y = 0.
     * @param width The width of the area.
     * @param height The height of the area.
     */
    public AreaOf(final int width, final int height) {
        this(0, 0, width, height);
    }

    /**
     * Ctor.
     * @param x The x coordinate of the area.
     * @param y The y coordinate of the area.
     * @param width The width of the area.
     * @param height The height of the area.
     * @checkstyle ParameterNumber (3 lines)
     * @checkstyle ParameterName (2 lines)
     */
    public AreaOf(final int x, final int y, final int width, final int height) {
        this(
            new PosOf(x, y),
            new SizeOf(width, height)
        );
    }

    /**
     * Ctor. Uses x = 0 and y = 0 as its coordinates.
     * @param size The size of the area.
     */
    public AreaOf(final Size size) {
        this(new PosOf(), size);
    }

    /**
     * Ctor. Uses width = 0 and height = 0 as its size.
     * @param pos The pos of the area.
     */
    public AreaOf(final Pos pos) {
        this(pos, new SizeOf());
    }

    /**
     * Ctor.
     * @param pos The pos of the area.
     * @param size The size of the area.
     */
    public AreaOf(final Pos pos, final Size size) {
        this.pos = Objects.requireNonNull(pos);
        this.size = Objects.requireNonNull(size);
    }

    @Override
    public final <R> R result(final BiFunction<Pos, Size, R> target) {
        return Objects.requireNonNull(target).apply(this.pos, this.size);
    }

    @Override
    public final String toString() {
        return Area.result(
            this,
            // @checkstyle ParameterName (1 line)
            (x, y, width, height) -> new StringBuilder("Area")
                .append("(x = ").append(x)
                .append(", y = ").append(y)
                .append(", width = ").append(width)
                .append(", height = ").append(height)
                .append(')')
            .toString()
        );
    }
}
