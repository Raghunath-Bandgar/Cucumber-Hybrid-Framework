package learningRegex;

import java.util.regex.Pattern;

public class JavaRegularExp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		boolean matchingStatus = Pattern.matches(".*Raghunath.*", "My name is Raghunath Bandgar");
		
		if(matchingStatus) {
			
			System.out.println("Matched");
		}
		else {
			
			System.out.println("Not Matched");
		}
		
		
	}

}
