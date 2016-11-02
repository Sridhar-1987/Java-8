package methodreferences;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class BuiltIn3PredicateBiPredicate {

	public static void main(String[] args) {
			//	@FunctionalInterface public class Predicate<T> {
			//		boolean test(T t);
			//	}
			//	@FunctionalInterface public class BiPredicate<T, U> {
			//		boolean test(T t, U u);
			//	}
		// Predicate
		Predicate<String> predLamda = s -> s.isEmpty();
		Predicate<String> methodRefLamda = String::isEmpty; // non-static method
		System.out.println(predLamda.test("notEmpty"));
		System.out.println(methodRefLamda.test(""));
		
		//BiPredicate
		BiPredicate<String, String> bipredicateLamda = (a,prefix) -> a.startsWith(prefix);
		BiPredicate<String, String> bipredicateMethodRef = String::startsWith; 
		//non-static first input is string second input is prefix
		System.out.println(bipredicateLamda.test("Abcdef", "Abc"));
		System.out.println(bipredicateMethodRef.test("Abcdef", "d"));
		
		// Default method in Predicate
		Predicate<String> egg = s -> s.contains("egg");
		Predicate<String> brown = s -> s.contains("brown");
		
		Predicate<String> brownEgg = egg.and(brown);
		Predicate<String> otherColorEgg = egg.and(brown.negate());
		
		
		
	}
}
