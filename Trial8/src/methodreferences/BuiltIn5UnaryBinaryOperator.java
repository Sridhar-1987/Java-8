package methodreferences;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class BuiltIn5UnaryBinaryOperator {

	public static void main(String[] args) {
		// @FunctionalInterface public class UnaryOperator<T>
		//			extends Function<T, T> { }
		// @FunctionalInterface public class BinaryOperator<T>
		//			extends BiFunction<T, T, T> { }
		
		// UnaryOperator
		UnaryOperator<String> unaryLamda = s -> s.toUpperCase();
		UnaryOperator<String> unaryMethodRef =  String::toUpperCase;// non-static method
		
		System.out.println(unaryLamda.apply("lower"));
		System.out.println(unaryMethodRef.apply("toUpperCase"));
		
		// BinaryOperator
		BinaryOperator<String> binaryLamda = (s, appendedStr) -> s.concat(appendedStr);
		BinaryOperator<String> binaryMethodRef = String::concat; // non-static method
		
		System.out.println(binaryLamda.apply("Hello ", "World!"));
		System.out.println(binaryMethodRef.apply("Hello ", "World!"));
	}

}
