package methodreferences;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Test1Comparator {

	public static void main(String[] args) {

		Comparator<Duck> compareDuck = (d1,d2) -> DuckHelper.compareByName(d1, d2);
		Comparator<Duck> compDuck = DuckHelper::compareByName;
		// Consumer no return type, only input
		//static method ref
		Consumer<List<Integer>> lambdaConsumer = l -> Collections.sort(l);
		Consumer<List<Integer>> methodRefConsumer = Collections::sort;

		// instance method ref 
		String a = "abc";
		Predicate<String> lambdaPredicate = s -> a.startsWith(s);
		Predicate<String> methodPredicate = a::startsWith;
		
		// instance method runtime - will be called on that instance
		// if non static method is used like static in method ref, call on same object
		Predicate<String> lambdaPredicate1 = s -> s.isEmpty();
		Predicate<String> methodPredicate1 = String::isEmpty;
		
		// Constructor method ref
		Supplier<List> lambdaSupplier = () -> new ArrayList();
		Supplier<List> methodRefSupplier = ArrayList::new;
		
	}

}	
