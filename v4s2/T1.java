package tomivaha.funprov4s2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class T1 {
    public static void main(String[] args) {
        List<Omena> omenat = new ArrayList<>();
        
        
        for (int i = 0; i < 1000000; i++) {
            omenat.add(new Omena("punainen", 150));
        }
        
        long start = System.nanoTime();
        String res = omenat.stream().parallel().collect(OmatKollektorit.merkkijono());
        long duration = System.nanoTime() - start;
        //System.out.println(res);
        System.out.println(duration / 1000000);
    }
}
