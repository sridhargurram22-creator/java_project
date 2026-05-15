package automation_collections_practice;

public class Day2Java {
	
	
	public static String reverseWord(String input) {
		
		if (input == null || input.isEmpty()) {
			throw new IllegalArgumentException("Please enter string");
		}
		
		String[] arr = input.split(" ");
		
		StringBuilder output = new StringBuilder();
		
		for (int i = 0; i < arr.length; i++) {
			
			
			
			char[] ch = arr[i].toCharArray();
			
			for (int j = ch.length-1; j >= 0 ; j--) {
				output.append(ch[j]);
				
				
			}
			
			output.append(" ");
			
		}
		
		return output.toString().trim();
	}

	public static void main(String[] args) {
		// Reverse each word in a sentence without reversing the order of the words 
		// using Java String methods only (no StringBuilder reverse).
		
		System.out.println(reverseWord("Selenium is awesome"));
		System.out.println(reverseWord("QA Automation"));
		System.out.println(reverseWord(""));
		
		
		
		
	}

}
