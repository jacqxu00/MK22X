import java.util.*;

public class Quiz2Redux {

    public static ArrayList<String> combinations(String s) {
	ArrayList<String> words = new ArrayList<String>();
	combinationH(s,words,"",0);
	return words;
    }

    public static void combinationH (String s, ArrayList<String> words, String combo, int i) {
	if (i == s.length()) {
	    words.add(combo);
	    return;
	}
	else {
	    combinationH(s,words,combo,i+1);
	    combinationH(s,words,combo+s.charAt(i),i+1);
	    return;
	}
    }
	
    public static void main(String[] args) {
	System.out.println(combinations("abc"));
	System.out.println(combinations("wxof"));
    }
    
}
