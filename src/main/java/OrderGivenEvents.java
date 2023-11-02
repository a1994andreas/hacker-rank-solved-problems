import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class OrderGivenEvents {

	/**    Problem1: given events (in time ranges, e.g., from 8am to 10am),
	 * how can you order them so that the most event are put in the schedule
	 * **/
	public static void main(String[] args) {
		int[][] events = { { 1, 2 }, { 1, 2 }, { 3, 3 }, { 1, 5 }, { 1, 5 } };
		System.out.println(maxEvents(events));
	}

	public static int maxEvents(int[][] events) {
		int maxEvents = 0;
		List<Pair<Integer, Integer>> eventsList = new LinkedList<>();
		for (int[] event : events) {
			eventsList.add(new Pair(event[0], event[1]));
		}
		eventsList.sort(Comparator.comparing(Pair::second));

		Set<Integer> usedDays = new HashSet<>();

		for (Pair<Integer, Integer> event : eventsList) {

			int startDate = event.first();
			int endDate = event.second();
			if (addAnEvent(usedDays, startDate, endDate))
				maxEvents++;
		}
		return maxEvents;
	}

	public static Boolean addAnEvent(Set<Integer> usedDays, int startDate, int endDate) {
		for (int i = startDate; i <= endDate; i++) {
			if (!usedDays.contains(i)) {
				usedDays.add(i);
				return true;
			}
		}
		return false;
	}

	static class Pair<K, V> {

		private final K element0;
		private final V element1;

		public <K, V> Pair<K, V> createPair(K element0, V element1) {
			return new Pair<K, V>(element0, element1);
		}

		public Pair(K element0, V element1) {
			this.element0 = element0;
			this.element1 = element1;
		}

		public K first() {
			return element0;
		}

		public V second() {
			return element1;
		}

		@Override
		public String toString() {
			return element0 + " " + element1;
		}
	}
}
