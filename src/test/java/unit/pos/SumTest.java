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

package unit.pos;

import java.util.function.BiFunction;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import unit.tuple.matcher.CorrectResult;

/**
 * Tests for {@link Sum}.
 * @since 0.55
 */
public final class SumTest {
    /**
     * {@link Sum#result(BiFunction)} must give the resulting x and y of the
     * position sum when constructed with {@link Sum#Sum(Pos, Pos)}.
     */
    @Test
    public void sumOfPositions() {
        // @checkstyle LocalFinalVariableName (4 lines)
        final int x1 = 512;
        final int y1 = 42;
        final int x2 = 434;
        final int y2 = 542;
        MatcherAssert.assertThat(
            new Sum(
                new PosOf(x1, y1),
                new PosOf(x2, y2)
            ),
            new CorrectResult(x1 + x2, y1 + y2)
        );
    }

    /**
     * {@link Sum#result(BiFunction)} must give the resulting x and y of the
     * position sum when constructed with {@link Sum#Sum(Pos, int, int)}.
     */
    @Test
    public void sumWithScalars() {
        // @checkstyle LocalFinalVariableName (4 lines)
        final int x1 = 543;
        final int y1 = 536;
        final int x2 = 342;
        final int y2 = 756;
        MatcherAssert.assertThat(
            new Sum(
                new PosOf(x1, y1),
                x2,
                y2
            ),
            new CorrectResult(x1 + x2, y1 + y2)
        );
    }
}
