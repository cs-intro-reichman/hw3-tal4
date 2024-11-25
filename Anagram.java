/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		str1 = preProcess(str1);
		str2 = preProcess(str2);
		for(int i = 0; i < str1.length(); i++) {
			char cur1 = str1.charAt(i);
			boolean isCur1FoundInStr2 = false;
			if(cur1 != ' ') {				
				for(int j = 0; j < str2.length() && !isCur1FoundInStr2; j++) {
					char cur2 = str2.charAt(j);
					if (cur1 == cur2) {
						if(j < str2.length() - 1) {
							str2 = str2.substring(0, j) + str2.substring(j + 1);
						}
						else {
							str2 = str2.substring(0, j);
						}
						isCur1FoundInStr2 = true;
					}
				}
				if(!isCur1FoundInStr2) {
					return false;
				}
			}
		}
		for(int i = 0; i < str2.length(); i++) {
			if(str2.charAt(i) != ' ') {
				return false;
			}
		}
		return true;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String out = "";
		for(int i = 0; i < str.length(); i++) {
			char cur = str.charAt(i);
			if('A' <= cur && cur <= 'Z') {
				cur = (char) (cur - 'A' + 'a');
			}
			if(('a' <= cur && cur <= 'z') || cur == ' ') {
				out += cur;
			}
		}
		return out;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String out = "";
		while(str.length() > 0) {
			int index = (int) (Math.random() * str.length());
			out += str.charAt(index);
			if(index == str.length() - 1) {
				str = str.substring(0, index);
			}
			else {
				str = str.substring(0, index) + str.substring(index + 1);
			}
		}
		return out;
	}
}
