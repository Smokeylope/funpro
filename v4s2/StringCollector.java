/*

    T1
    b) CONCURRENT toimii, mutta ei vaikuta suoritusaikaan.

*/

package tomivaha.funprov4s2;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import static java.util.stream.Collector.Characteristics.CONCURRENT;
import static java.util.stream.Collector.Characteristics.UNORDERED;

public class StringCollector<T> implements Collector<T, StringBuffer, String> {

    @Override
    public Supplier<StringBuffer> supplier() {
        return () -> new StringBuffer();
    }

    @Override
    public BiConsumer<StringBuffer, T> accumulator() {
        return (buffer, item) -> buffer.append(String.format("%s%n", item));
    }

    @Override
    public BinaryOperator<StringBuffer> combiner() {
        return (buffer1, buffer2) -> {buffer1.append(buffer2); return buffer1;};
    }

    @Override
    public Function<StringBuffer, String> finisher() {
        return buffer -> buffer.toString();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(UNORDERED, CONCURRENT));
    }
    
}
