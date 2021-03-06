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

import java.util.List;
import java.util.function.BiFunction;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import unit.pos.PosOf;
import unit.size.SizeOf;
import unit.tuple.matcher.CorrectResult;

/**
 * Tests for {@link Covered}.
 * @since 0.58
 */
public final class CoveredTest {
    /**
     * {@link Covered#result(BiFunction)} must give an empty pos and size when
     * constructed without areas.
     */
    @Test
    public void noArea() {
        MatcherAssert.assertThat(
            new Covered(),
            new CorrectResult(
                new PosOf(),
                new SizeOf()
            )
        );
    }

    /**
     * {@link Covered#result(BiFunction)} must give the same pos and size as the
     * given area when Cover was constructed with only one area.
     */
    @Test
    public void oneArea() {
        // @checkstyle LocalFinalVariableName (2 lines)
        final int x = 4534;
        final int y = 5438;
        final int width = 3873;
        final int height = 37;
        MatcherAssert.assertThat(
            new Covered(
                new AreaOf(x, y, width, height)
            ),
            new CorrectResult(
                new PosOf(x, y),
                new SizeOf(width, height)
            )
        );
    }

    /**
     * {@link Covered#result(BiFunction)} must give a size where the width is
     * the rightmost value.
     */
    @Test
    public void oneAfterAnotherHorizontal() {
        // @checkstyle LocalFinalVariableName (2 lines)
        final int x = 100;
        final int y = 200;
        final int width = 500;
        final int height = 700;
        MatcherAssert.assertThat(
            new Covered(
                List.of(
                    new AreaOf(x, y, width, height),
                    new AreaOf(x + width, y, width, height)
                )
            ),
            new CorrectResult(
                new PosOf(x, y),
                new SizeOf(width * 2, height)
            )
        );
    }

    /**
     * {@link Covered#result(BiFunction)} must give a size where the height is
     * the most bottom value.
     */
    @Test
    public void oneAfterAnotherVertical() {
        // @checkstyle LocalFinalVariableName (2 lines)
        final int x = 675;
        final int y = 534;
        final int width = 532;
        final int height = 435;
        MatcherAssert.assertThat(
            new Covered(
                new AreaOf(x, y + height, width, height),
                new AreaOf(x, y, width, height)
            ),
            new CorrectResult(
                new PosOf(x, y),
                new SizeOf(width, height * 2)
            )
        );
    }

    /**
     * {@link Covered#result(BiFunction)} must give a pos that is the lowest and
     * a size that results in the highest position.
     */
    @Test
    public void withGap() {
        // @checkstyle LocalFinalVariableName (4 lines)
        final int x1 = 0;
        final int y1 = 0;
        final int x2 = 500;
        final int y2 = 500;
        final int width = 100;
        final int height = 100;
        MatcherAssert.assertThat(
            new Covered(
                new AreaOf(x1, y1, width, height),
                new AreaOf(x2, y2, width, height)
            ),
            new CorrectResult(
                new PosOf(x1, y1),
                new SizeOf(x2 + width, y2 + height)
            )
        );
    }

    /**
     * {@link Covered#result(BiFunction)} must give a pos that is the lowest and
     * a size that results in the highest position. An intersecting area
     * mustn't make a difference.
     */
    @Test
    public void withIntersection() {
        // @checkstyle LocalFinalVariableName (4 lines)
        final int x1 = 0;
        final int y1 = 0;
        final int x2 = 500;
        final int y2 = 500;
        final int width = 100;
        final int height = 100;
        MatcherAssert.assertThat(
            new Covered(
                new AreaOf(x1, y1, width, height),
                new AreaOf(x1, y1, width / 2, height / 2),
                new AreaOf(x2, y2, width, height)
            ),
            new CorrectResult(
                new PosOf(x1, y1),
                new SizeOf(x2 + width, y2 + height)
            )
        );
    }
}
