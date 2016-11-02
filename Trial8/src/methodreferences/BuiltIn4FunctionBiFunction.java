package methodreferences;

import java.util.function.BiFunction;
import java.util.function.Function;

public class BuiltIn4FunctionBiFunction {

	public static void main(String[] args) {
		//  @FunctionalInterface public class Function<T, R> {
		// 		R apply(T t);
		//	}
		//  @FunctionalInterface public class BiFunction<T, U, R> {
		//		R apply(T t, U u);
		//	}
		
		// Function
		Function<String, Integer> functionLamda = s -> s.length();
		Function<String, Integer> functionMethodRef = String::length; // non-static method
		
		System.out.println(functionLamda.apply("inputStr"));
		System.out.println(functionMethodRef.apply("inputStr"));
		
		// BiFunction
		BiFunction<String,String,String> bifuncationLamda = (str, apeendedStr) -> str.concat(apeendedStr);
		BiFunction<String,String,String> bifunctionMethodRef = String::concat; //non-static method
		System.out.println(bifuncationLamda.apply("Hello", " World"));
		System.out.println(bifunctionMethodRef.apply("Hello", " World"));
	}

}
