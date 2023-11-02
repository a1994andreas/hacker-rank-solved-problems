import java.util.List;

public class SlotMachine2 {
	public static void main(String[] args) {

	}
	/** Problem5: Slot Machine 2.0 (search for HackerRank, should be published at some point)
	 * Having a list of strings as input e.g. spins[] = ["721", "324","451"]
	 * we need to find for each string the highest number and remove it from the string
	 * then we need to sum the bigger number (e.g. the 7 on the first run, 5 in the second and 4 in the third)
	 * then repeat until the strings are empty
	 * **/
	public static int slotWheels(List<String> history) {
		int sum = 0;
		int length = history.get(0).length();
		for (int i=0; i< length; i ++) {

			int maxofAllRows = -1;
			for (int j = 0; j < history.size(); j++) {

				int maxIndex = findIndexOfMax(history.get(j));
				//	System.out.println(history.get(j) + " "+ maxIndex);

				int max = Character.getNumericValue(history.get(j).charAt(maxIndex));
				if (max > maxofAllRows) {
					maxofAllRows = max;
				}
				history.set(j, new StringBuilder(history.get(j)).deleteCharAt(maxIndex).toString());
			}
			sum += maxofAllRows;
			if(history.get(0).length() == 0)
				break;
		}
		System.out.println(sum);
		return sum;
	}

	public static int findIndexOfMax(String history) {
		int max = (int) history.charAt(0);
		int index = 0;
		for (int i = 0; i<history.length(); i++){
			if((int)history.charAt(i)> max){
				max= (int) history.charAt(i);
				index = i;
			}
		}
		return index;
	}
}
