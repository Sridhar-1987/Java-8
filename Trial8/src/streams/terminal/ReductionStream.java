package streams.terminal;

import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;
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
		
		// reduce - doesnt terminate on infinite stream
		// reduces stream into a single object - has 3 overloaded methods
		// T reduce (T identity, BinaryOperator<T> accumulator) 
		// Optional<T> reduce(BinaryOperator<T> accumalator) - if identity is not passed optinal is returned
		// <U> U reduce (U identity, BiFunction<U,T,U> accumaltor, BinaryOperator<U> combiner)
		Stream<String> finiteStream = Stream.of("w","o","l","f");
		// String word = finiteStream.reduce("", (a,b) -> a+b);
		String word = finiteStream.reduce("", String::concat); // nonstatic method
		System.out.println(word);
		
		// collect - mutable reduce as it uses same object
		// doesnt terminate in infinite stream
		// <R> R collect (Supplier<R> supplier, Biconsumer<R,T> accumalator, BiConsumer<R,R> combiner)
		// <R,A> R collect (Collector<T,A,R> collector)
		Stream<String> finiteStream1 = Stream.of("w","o","l","f");
		StringBuilder word1 = finiteStream1.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
		TreeSet<String> set = finiteStream1.collect(TreeSet<String>:: new, TreeSet<String>::add, TreeSet<String>::addAll);
		System.out.println(set); // [f, l, o, w]
		// Collectors.toCollection(Supplier)
		TreeSet<String> set1 = finiteStream1.collect(Collectors.toCollection(TreeSet<String>::new));
		Set<String> set2 = finiteStream1.collect(Collectors.toSet());
	}

}
