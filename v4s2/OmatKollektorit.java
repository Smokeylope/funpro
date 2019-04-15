package tomivaha.funprov4s2;

import java.util.stream.Collector;

public class OmatKollektorit {
    public static <T> StringCollector<T> merkkijono() {
        return new StringCollector<>();
    }
}
