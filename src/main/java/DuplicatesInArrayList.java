import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DuplicatesInArrayList {

	public static void main(String[] args) {
		ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(5, 3, 4, 1, 3, 7, 2, 9, 9, 4));

		// Solution 1 Using streams:
		printDuplicatesUsingStreams(arrayList);

		// Solution 2 (Simpler) count frequency:
		printDuplicatedCountingFrequencyOfWords(arrayList);
	}

	public static void printDuplicatesUsingStreams(ArrayList<Integer> arrayList) {
		System.out.println("1.Print Duplicates Using Streams");
		arrayList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())) // create a map {1=1, 2=1, 3=2, 4=2, 5=1, 7=1, 9=2}
				.entrySet().stream()
				.filter(m -> m.getValue() > 1)       // if map value > 1, duplicate element
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet()).forEach(System.out::println);
	}

	public static void printDuplicatedCountingFrequencyOfWords(ArrayList<Integer> arrayList) {
		System.out.println("2.Print Duplicates Using Frequency Map");
		Map<Integer,Integer> frequency = new HashMap<>();
		for (Integer number : arrayList) {
			if(frequency.get(number) != null) {
				frequency.put(number, frequency.get(number)+1);
			} else {
				frequency.put(number, 1);
			}
		}
		System.out.println("-  Print Map with for loop");
		for(Map.Entry<Integer,Integer> kvEntry :frequency.entrySet()) {
			if (kvEntry.getValue() > 1)
				System.out.println(kvEntry.getKey());
		}
		System.out.println("-  Print Map using streams");
		frequency.entrySet().stream().filter(f -> f.getValue() > 1 ).map(f -> f.getKey()).forEach(System.out::println);

	}

}
