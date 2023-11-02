package twoOperations;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MinimumOperations {
	/*
	* given that we can do only two operations
	* ADD 1
	* MULTIPLY BY 2
	* find the minimum operations needed to reach each number
	*
	* */
	public static void main(String[] args) throws IOException {
		List<Long> arrayList2 = new LinkedList<>(Arrays.asList(4L, 89L, 18L));
		getMinOperations(arrayList2).forEach(System.out::println);


	}

	public static List<Integer> getMinOperations(List<Long> kValues) {

		List<Integer> results = new LinkedList<>();
		for (Long value : kValues) {
			// edge cases
			if (value == 0) {
				results.add(0);
				continue;
			} else if (value == 1) {
				results.add(1);
				continue;
			}


			Integer steps =1 ;
			while (value /2 > 1) {
				if (value % 2 != 0) {
					value--;
					steps++;
				}
				value = value /2;
				steps++;
			}
			if (value /2 != 0)
				steps++;

			results.add(steps);
		}

		return results;

	}
}
