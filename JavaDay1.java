package automation_collections_practice;

import java.util.LinkedHashMap;
import java.util.Map;

public class JavaDay1 {
	
	public static char firstNonRepeat(String s) {
	
	if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("Input cannot be null or empty");
        }
		
	Map<Character, Integer> map = new LinkedHashMap<>();
	
	char[] ch = s.toCharArray();
	
	for (char ref: ch) {
		map.put(ref, map.getOrDefault(ref, 0)+1);
	}
	
	
	for (Map.Entry<Character, Integer> a : map.entrySet()) {
		
		if (a.getValue() == 1) {
			return a.getKey();
		}
	}
	
	return '\0';
	
}

	public static void main(String[] args) {
		
		System.out.println(firstNonRepeat("automation"));
		System.out.println(firstNonRepeat("testng"));
		System.out.println(firstNonRepeat("aabb"));

	}

}
