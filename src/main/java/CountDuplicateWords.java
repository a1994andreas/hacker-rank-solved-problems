import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CountDuplicateWords {
	public static void main(String[] args) {
		//1 using streams
		String paragraph = "This is a test paragraph that we need to count the duplicate words. to count the duplicate words.";
		List<String> paragraphList = Arrays.asList(paragraph.split(" "));
		paragraphList.stream().filter(i -> Collections.frequency(paragraphList, i) >1)
				.collect(Collectors.toSet()).forEach(System.out::println);

		//2 using a Map to store the frequencies

		String[] words  = paragraph.split(" ");
		Map<String,Integer> frequencyMap = new HashMap<>();
		for (String word : words){
			if(frequencyMap.containsKey(word))
				frequencyMap.put(word, frequencyMap.get(word)+1);
			else
				frequencyMap.put(word, 1);
		}
		for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
			if(entry.getValue() >1 )
				System.out.println(entry.getKey());
		}
	}

}
