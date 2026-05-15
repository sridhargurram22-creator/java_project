package automation_collections_practice;



import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;



public class ClaudeCode2 {

	public static void main(String[] args) {
		/*Q4. Compare two Lists — expected vs actual results
    expectedList = ["Home", "About", "Contact"]
    actualList   = ["Home", "About", "Services"]
    → Find missing and extra items
		 * 
		 * 
		 */
		List<String> expectedList = new ArrayList<String>(List.of("Home", "About", "Contact"));
		
		List<String> actualList = new ArrayList<String>(List.of("Home", "About", "Services"));
		
		Set<String> missextra = new LinkedHashSet<String>();
		
		for (String ref : expectedList) {
			if (!actualList.contains(ref)) {
				missextra.add(ref);
			}
		}
		for (String ref1 : actualList) {
			if (!expectedList.contains(ref1)) {
				missextra.add(ref1);
			}
		}
		
		System.out.println(missextra);

	}

	

}
