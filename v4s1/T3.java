/*

    T3
    Linkitetty 314 ms
    Taulukko 115 ms
    IntStream 15 ms

*/

package tomivaha.funprov4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class T3 {
    private static ArrayList<Integer> taulukkoLista = new ArrayList<>();
    private static LinkedList<Integer> linkitettyLista = new LinkedList<>();
    private static IntStream stream;
    
    public static void main(String[] args) {
        IntStream.Builder b = IntStream.builder();
        
        for (int i = 0; i <= 10000000; i++) {
            taulukkoLista.add(2);
            linkitettyLista.add(2);
            b.add(2);
        }
        
        stream = b.build();
        
        System.out.println("Linked Sum done in: " + measurePerf(T3::linkitettyNelioSumma) + " msecs");
        System.out.println("Array Sum done in: " + measurePerf(T3::taulukkoNelioSumma) + " msecs");
        System.out.println("Stream Sum done in: " + measurePerf(T3::streamNelioSumma) + " msecs");
    }

    public static <T> long measurePerf(Supplier <T> f) {
        long fastest = Long.MAX_VALUE;
        long start = System.nanoTime();
        T result = f.get();
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Result: " + result);
        if (duration < fastest) fastest = duration;
        return fastest;
    }
    
    public static int linkitettyNelioSumma() {
            return linkitettyLista.parallelStream()
                                      .map(x -> x * x)
                                      .reduce(0, (acc, x) -> acc + x);
    }
    
    public static int taulukkoNelioSumma() {
            return taulukkoLista.parallelStream()
                                      .map(x -> x * x)
                                      .reduce(0, (acc, x) -> acc + x);
    }
    
    public static int streamNelioSumma() {
        return stream
                .map(x -> x * x)
                .reduce(0, (acc, x) -> acc + x);
    }
}
