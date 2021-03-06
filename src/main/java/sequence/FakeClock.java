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

package sequence;

import com.google.common.collect.ObjectArrays;
import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * A clock that will return the given numbers in consecutive calls starting from
 * the first. After the clock has reached the last number, it will stick on this
 * number and return it every time.
 * <p>Example:</p>
 * <p>Input: (1, 2, 3, 4, 5) -> millis() => 1, millis() => 2, ...,</p>
 * <p>n5: millis() => 5, millis() => 5</p>
 * This class takes {@link Number} instances to be more flexible. Note that it
 * will call {@link Number#longValue()} to retrieve the value for
 * {@link #millis()}.
 * <p>This class is mutable and not thread-safe, because {@link #millis}
 * mutates its state..</p>
 * @since 0.54
 */
public class FakeClock extends Clock {
    /**
     * The times to be returned from {@link #millis()}.
     */
    private final List<? extends Number> times;

    /**
     * The cursor pointing on the element that will be returned with the next
     * call of {@link #millis()}.
     */
    private int cursor;

    /**
     * Ctor.
     * @param first The first time that will be returned. This is necessary,
     *  because otherwise millis() would throw an exception when asked for a
     *  time.
     * @param times The given times that will be returned one after another with
     *  each call of {@link #millis()}.
     */
    public FakeClock(final Number first, final Number... times) {
        this(
            List.of(ObjectArrays.concat(first, times))
        );
    }

    /**
     * Ctor.
     * @param times The given times that will be returned one after another with
     *  each call of {@link #millis()}.
     */
    public FakeClock(final Collection<? extends Number> times) {
        this(new ArrayList<>(times));
    }

    /**
     * Ctor.
     * @param times The given times that will be returned one after another with
     *  each call of {@link #millis()}.
     */
    public FakeClock(final List<? extends Number> times) {
        super();
        this.times = times;
        this.cursor = -1;
    }

    @Override
    public final ZoneId getZone() {
        throw new UnsupportedOperationException("#getZone()");
    }

    @Override
    public final Clock withZone(final ZoneId zone) {
        throw new UnsupportedOperationException("#withZone()");
    }

    @Override
    public final Instant instant() {
        this.cursor = Math.min(this.cursor + 1, this.times.size() - 1);
        return Instant.ofEpochMilli(
            this.times.get(this.cursor).longValue()
        );
    }

    @Override
    public final boolean equals(final Object obj) {
        return super.equals(obj);
    }

    @Override
    public final int hashCode() {
        return super.hashCode();
    }

    @Override
    public final String toString() {
        return String.join(
            "",
            this.getClass().getSimpleName(),
            this.times.toString()
        );
    }
}
