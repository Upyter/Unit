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

/*
This interface is necessary (compared to using width and height each time)
because this library depends on the possibility to implement own
implementations like a scaling size
*/

/**
 * The two dimensional cartesian based size of a rectangular area.
 * Implementations of this interface are equal to each other.
 * @since 0.4
 */
public interface Size {
    /**
     * Returns the width.
     * @return The width.
     */
    double w();

    /**
     * Returns the height.
     * @return The height.
     */
    double h();

    /**
     * Returns the unadjusted height.
     * @return The unadjusted height.
     */
    double cleanW();

    /**
     * Returns the unadjusted height.
     * @return The unadjusted height.
     */
    double cleanH();

    /**
     * Returns true if the size is fix (doesn't use adjustments from
     * {@link AdjustableSize#adjustment(Object)} or otherwise false.
     * @return True if the size is fix and otherwise false.
     */
    boolean isFix();
}
