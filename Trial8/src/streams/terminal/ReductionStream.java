package streams.terminal;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * 	Looks at each element in stream and returns single element
 */
public class ReductionStream {

	public static void main(String[] args) {
		// Count - doesnt terminate on Infinite Streams
		// long Count()
		Stream<String> s = Stream.of("monkey", "gorilla" , "bonobo");
		System.out.println(s.count());
		
		// min max - doesnt terminate on Infinite Streams
		// Optional<T> min(<? super T> comparator)
		// Optional<T> max(<? super T> comparator)
		Stream<String> streamMin = Stream.of("monkey", "ape" , "bonobo");
		Optional<String> min = streamMin.min((s1, s2) -> s1.length() - s2.length());
		min.ifPresent(System.out::println); // ape
		
		
	}

}
