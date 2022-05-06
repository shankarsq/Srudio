package studio.automate.test.app.utils;

import java.util.Random;

public class AppUtils {

	public static String generateRandomCharacters() {
		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 10;
		Random random = new Random();
		StringBuilder buffer = new StringBuilder(targetStringLength);
		for (int i = 0; i < targetStringLength; i++) {
			int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
			buffer.append((char) randomLimitedInt);
		}
		String generatedString = buffer.toString();

		System.out.println(generatedString);
		return generatedString;
	}
public static int generateRandomNumber() {
	return new Random().nextInt(90000) + 10000 ;
}
}
