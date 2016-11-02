package methodreferences;

import java.util.Optional;

public class OptionalExample {
	public static void main(String... args) {

		System.out.println(average(9, 11));
		System.out.println(average());

		Optional<Integer> opt = average(10, 11, 12);
		// check if Optional has value
		if (opt.isPresent()) { // Without check NoSuchElementException will happen
			//get Optional value
			System.out.println(opt.get());
		}
		Integer intVal = 24;
		// Optional create if value is present
		Optional.ofNullable(intVal); // if intVal is null empty is created, else Optional is created
		
		Optional<Integer> opt2 = average(23,24,45,46);
		// print only if present
		opt2.ifPresent(System.out::println); // consumer
		
		Optional<Integer> opt3 = average();
		System.out.println(opt3.orElse(Integer.MAX_VALUE)); // T otherValue
		System.out.println(opt3.orElseGet(() -> (int)Math.random()));  // Supplier (cant throw checked exception)
		System.out.println(opt3.orElseThrow(() -> new IllegalStateException())); // Supplier (note this is a runtime exception)
	}

	public static Optional<Integer> average(int... scores) {
		if (scores.length == 0) {
			return Optional.empty();
		}
		int sum = 0;
		for (int score : scores)
			sum += score;
		// Optional creation
		return Optional.of(sum / scores.length);
	}
}
