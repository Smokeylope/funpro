/*

    T2
    a) Filter kutsuu lambdaa 10 kertaa
    b) Map kutsuu lambdaa 5 kertaa
    c) Map kutsuu lambdaa 10 kertaa

*/

package tomivaha.funprov4;

import java.util.stream.IntStream;

public class T2 {
    private static int countFilter;
    private static int countMap;
    
    public static void main(String[] args) {
        //  sum of the triples of even integers from 2 to 10
        /*System.out.printf(
          "Sum of the triples of even integers from 2 to 10 is: %d%n",              
          IntStream.rangeClosed(1,10)
                  .filter(x -> x%2 == 0)
                  .map(x -> x*3)
                  .sum());*/
        
        System.out.printf(
            "Sum of the triples of even integers from 2 to 10 is: %d%n",
            IntStream.rangeClosed(1,10)
                    .filter(x -> filter(x))
                    .map(x -> map(x))
                    .sum());
        
        System.out.printf("Filter was called %d times%n", countFilter);
        System.out.printf("Map was called %d times%n", countMap);
        
        countFilter = 0;
        countMap = 0;
        System.out.println("Reverse order:");
        
        System.out.printf(
            "Sum of the triples of even integers from 2 to 10 is: %d%n",
            IntStream.rangeClosed(1,10)
                    .map(x -> map(x))
                    .filter(x -> filter(x))
                    .sum());
        
        System.out.printf("Filter was called %d times%n", countFilter);
        System.out.printf("Map was called %d times%n", countMap);
    }
    
    public static boolean filter(int x) {
        countFilter++;
        return x%2 == 0;
    }
    
    public static int map(int x) {
        countMap++;
        return x*3;
    }
}