package methodreferences;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class BuiltIn2ConsumerBiConsumer {

	public static void main(String[] args) {

			//	@FunctionalInterface public class Consumer<T> {
			//		void accept(T t);
			//	}
			//	@FunctionalInterface public class BiConsumer<T, U> {
			//		void accept(T t, U u);
			//	}
		
		// Consumer
		Consumer<String> consumerLambda = s -> System.out.println(s);
		Consumer<String> consumerMethodRef = System.out::println;
		
		consumerLambda.accept("someString");
		consumerMethodRef.accept("someOtherString");
		
		// BiConsumer
		Map<String,Integer> map = new HashMap<>();
		BiConsumer<String,Integer> biconsumerLamda = (k,v) -> map.put(k,v);
		BiConsumer<String, Integer> biconsumerMethodRef = map::put;
		
		biconsumerLamda.accept("key1", 1);
		biconsumerMethodRef.accept("key2", 2);
		
	}

}
