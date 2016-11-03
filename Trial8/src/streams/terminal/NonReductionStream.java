package streams.terminal;

import java.util.stream.Stream;

/**
 * Either doesnt look at all values or doesnt return a value
 */
public class NonReductionStream {

	public static void main(String[] args) {
		
		// findAny / findFirst
		// terminates in infinite stream
		// Optional<T> findAny()
		// Optional<T> findFirst()
		Stream<String> finiteStream = Stream.of("monkey", "gorilla", "bonobo");
		// generate(Supplier s)
		Stream<String> infinite = Stream.generate(() -> "chimp");
		finiteStream.findAny().ifPresent(System.out::println);
		infinite.findAny().ifPresent(System.out::println);
		
		// allMatch/anyMatch/noneMatch
		// sometimes terminates in infinite stream
		// boolean anyMatch(Predicate <? super T> predicate)
		// boolean allMatch(Predicate <? super T> predicate)
		// boolean noneMatch(Predicate <? super T> predicate)
		Stream<String> finiteStream1 =  Stream.of("monkey", "1", "gorilla");
		// generate(Supplier s)
		Stream<String> infiniteStream1 = Stream.generate(() -> "ape");
		finiteStream1.anyMatch(s -> Character.isLetter(s.charAt(0)));
		finiteStream1.allMatch(s -> Character.isLetter(s.charAt(0)));
		finiteStream1.noneMatch(s -> Character.isLetter(s.charAt(0)));
		
	}

}
