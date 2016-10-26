package methodreferences;

import java.util.*;

public class Test3UpdateAllElements {

	public static void main(String[] args) {
		// void replaceAll(UnaryOperator<E> o)
		// apply UnaryOperator to each element in the list
		
		List<Integer> list = Arrays.asList(1, 2, 3);
		list.replaceAll(c -> c*2);
		System.out.println(list); //[2,4,6]
		
		
		// Looping through collection
		List<String> stringList = Arrays.asList("Raj","Surya");
		// forEach(Consumer<? super E> action)
		stringList.forEach(s -> System.out.println(s));
		stringList.forEach(System.out::println); //method ref

	}

}
