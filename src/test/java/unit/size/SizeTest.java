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

package unit.size;

import java.util.function.ObjIntConsumer;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * Tests for {@link Size}.
 * @since 0.5
 */
public class SizeTest {
    /**
     * {@link Size#applyOn(Size, ObjIntConsumer)} gives the correct width and
     * height.
     */
    @Test
    public void givesCorrectWidthAndHeight() {
        final int width = 52;
        final int height = 43;
        Size.applyOn(
            new Size2D(width, height),
            // @checkstyle ParameterName (1 line)
            (resWidth, resHeight) -> {
                MatcherAssert.assertThat(resWidth, Matchers.equalTo(width));
                MatcherAssert.assertThat(resHeight, Matchers.equalTo(height));
            }
        );
    }
}