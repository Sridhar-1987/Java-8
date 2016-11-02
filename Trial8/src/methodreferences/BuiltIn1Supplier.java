package methodreferences;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class BuiltIn1Supplier {

	public static void main(String[] args) {

		// @FunctionalInterface public class Supplier<T> {
		// public T get();
		// }

		// Example 1 - with static method
		Supplier<LocalDate> dateMethodRef = LocalDate::now;
		Supplier<LocalDate> dateLambda = () -> LocalDate.now();

		System.out.println(dateMethodRef.get());
		System.out.println(dateLambda.get());

		// Example 2 - with constructor
		Supplier<StringBuilder> stringMethodRef = StringBuilder::new;
		Supplier<StringBuilder> stringLambda = () -> new StringBuilder();

		System.out.println(stringMethodRef.get());
		System.out.println(stringLambda.get());

		// Example 3 - with generics
		Supplier<List<String>> listGenerics = ArrayList<String>::new;
		Supplier<List<String>> listGenericsLambda = () -> new ArrayList<String>();
		System.out.println(listGenerics.get());
		System.out.println(listGenericsLambda.get());

	}

}
