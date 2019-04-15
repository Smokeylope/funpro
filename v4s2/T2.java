/*

    T2
    b) Sarjallinen 38 ms, rinnakkainen 134 ms
    c) AtomicInteger mahdollistaa yhteisen tulosolion käytön

*/

package tomivaha.funprov4s2;

import java.util.stream.DoubleStream;

public class T2 {
    public static void main(String[] args) {
        long start = System.nanoTime();
        
        int count = DoubleStream.generate(Math::random)
            .limit(500000)
            .boxed()
            .collect(new CountCollector<>());
    
        long duration = System.nanoTime() - start;
        System.out.println("Sarjallinen");
        System.out.println(count);
        System.out.println(duration / 1000000 + " ms");
        
        start = System.nanoTime();
        
        count = DoubleStream.generate(Math::random)
            .parallel()
            .limit(500000)
            .boxed()
            .collect(new CountCollector<>());
    
        duration = System.nanoTime() - start;
        System.out.println("Rinnakkainen");
        System.out.println(count);
        System.out.println(duration / 1000000 + " ms");
    }
}
