package streams.create;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CreateStream {

	public static void main(String[] args) {
		// Finite Stream
		Stream<String> emptyStream = Stream.empty(); // count = 0;
		Stream<Integer> singleElement = Stream.of(1); // count = 1
		Stream<Integer> fromArray = Stream.of(1, 2, 3); // count = 3;

		// List to stream
		List<String> list = Arrays.asList("1", "2", "3");
		Stream<String> streamFromList = list.stream();
		Stream<String> parallelStreamFromList = list.parallelStream();

		// Infinite stream - (Infinite list not possible)
		// generate(Supplier s)	
		Stream<Double> randoms = Stream.generate(Math::random);
		// iterate(final T seed, final UnaryOperator<T> f)
		Stream<Integer> oddNumbers = Stream.iterate(1, f -> f+2);
	}

}
