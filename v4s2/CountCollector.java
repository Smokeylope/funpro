package tomivaha.funprov4s2;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import static java.util.stream.Collector.Characteristics.CONCURRENT;
import static java.util.stream.Collector.Characteristics.UNORDERED;

public class CountCollector<T> implements Collector<T, AtomicInteger, Integer> {

    @Override
    public Supplier<AtomicInteger> supplier() {
        return () -> new AtomicInteger(0);
    }

    @Override
    public BiConsumer<AtomicInteger, T> accumulator() {
        return (count, item) -> count.incrementAndGet();
    }

    @Override
    public BinaryOperator<AtomicInteger> combiner() {
        return (count1, count2) -> {count1.addAndGet(count2.get()); return count1;};
    }

    @Override
    public Function<AtomicInteger, Integer> finisher() {
        return count -> count.get();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(UNORDERED, CONCURRENT));
    }
    
}
