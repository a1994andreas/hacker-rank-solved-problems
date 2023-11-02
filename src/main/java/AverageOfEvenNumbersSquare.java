import java.util.ArrayList;
import java.util.Arrays;

public class AverageOfEvenNumbersSquare {


	public static void main(String[] args) {
		ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(5, 3, 4, 1, 3, 7, 2, 9, 9, 4));
		Double average = arrayList.stream()
				.filter(n -> n % 2 == 0) // filter even numbers
				.mapToDouble(n -> n * n) // calculate square
				.average().orElse(0.0); // find average
		System.out.println("Average: " +average);

	}

}
