import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;

class Result {

	/*
	 * Complete the 'countSimilarPairs' function below.
	 *
	 * The function is expected to return a LONG_INTEGER.
	 * The function accepts STRING_ARRAY words as parameter.
	 */

	public static long countSimilarPairs(List<String> words) {
		long counter =0;
		List<Set<String>> charactersList = new LinkedList<>();
		for (String word : words) {
			Arrays.asList(word.split("")).stream().distinct().collect(Collectors.joining(""));

		}
		for (int i=0 ; i< charactersList.size(); i++) {
			Set<String> temp = charactersList.remove(i);

			for (Set<String> characters : charactersList) {
				if (characters.equals(temp)) {
					counter++;
				}
			}
		}
		return counter;
	}

	public static List<Integer> getMinOperations(List<Long> kValues) {
		List<Integer> results = new LinkedList<>();
		for (Long value : kValues) {
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




public class Solution {
	public static void main(String[] args) throws IOException {
//		ArrayList<String> arrayList = new ArrayList<>(Arrays.asList("aba", "abaca", "baab", "cba"));
//		nodes.Result.countSimilarPairs(arrayList);

		ArrayList<Long> arrayList2 = new ArrayList<>(Arrays.asList(4l, 89l, 18l));

		Result.getMinOperations(arrayList2);
	}
}
