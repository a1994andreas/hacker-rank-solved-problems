import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class PrintArrayListInDescendingOrder {


	public static void main(String[] args) {
		ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(5, 3, 4, 1, 3, 7, 2, 9, 9, 4));

		printReverseOrderUsingStreams(arrayList);
		System.out.println("---");
		printInOrderUsingStreams(arrayList);

	}

	public static void printReverseOrderUsingStreams(ArrayList<Integer> arrayList) {
		arrayList.stream()
				.sorted(Comparator.reverseOrder()).forEach(System.out::println);
	}

	public static void printInOrderUsingStreams(ArrayList<Integer> arrayList) {
		arrayList.stream().sorted(Integer::compare).forEach(System.out::println);
	}
}
