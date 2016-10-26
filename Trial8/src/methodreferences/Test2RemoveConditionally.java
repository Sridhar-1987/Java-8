package methodreferences;

import java.util.*;
public class Test2RemoveConditionally {

	public static void main(String[] args) {
		
		// boolean removeIf(Predicate<? super E> filter)
		
		List<String> list = new ArrayList<>();
		list.add("Magician");
		list.add("Assistant");
		System.out.println(list);
		list.removeIf(s -> s.startsWith("A"));
		//list.removeIf(String::startsWith); is wrong check Test1
		System.out.println(list);

	}

}
