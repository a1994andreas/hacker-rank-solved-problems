import java.util.ArrayList;
import java.util.Arrays;

public class FindTheMissingNumberInArray {


	public static void main(String[] args) {
		ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 5, 6, 7)); // We need to find 4
		ArrayList<Integer> arrayList2 = new ArrayList<>(Arrays.asList(1, 2, 3, 5, 6, 7, 9)); // We need to find 4 and 8

		printTheMissingNumberInArray(arrayList);
		System.out.println("--");
		printTheMissingNumberInArray(arrayList2);
	}
	public static void printTheMissingNumberInArray(ArrayList<Integer> arrayList) {
		Integer prev = null;

		for (Integer num : arrayList){
			if (prev != null && num - prev > 1) {
				System.out.println("Missing number: "+(prev+1));
			}
			prev = num;
		}
	}

}
