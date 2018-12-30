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

package unit.functional;

/*
Personally I wouldn't call this class "Consumer", but in this case I thought
it may be better to follow the standard libraries way. Otherwise users might
be confused
*/
/**
 * This interface defines a consumer like {@link java.util.function.Consumer}.
 * The difference is that this consumer takes four arguments.
 * @param <A> The type of the first argument.
 * @param <B> The type of the second argument.
 * @param <C> The type of the third argument.
 * @param <D> The type of the fourth argument.
 * @since 0.9.0
 */
@FunctionalInterface
public interface QuadConsumer<A, B, C, D> {
    /**
     * Accepts the given arguments.
     * @param a The first argument.
     * @param b The second argument.
     * @param c The third argument.
     * @param d The fourth argument.
     * @checkstyle ParameterNumber (3 lines)
     * @checkstyle ParameterNameCheck (2 lines)
     */
    void accept(A a, B b, C c, D d);
}