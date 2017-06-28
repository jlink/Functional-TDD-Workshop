package pbt.diamond;

import net.jqwik.api.*;
import net.jqwik.properties.*;

import java.util.*;

class DiamondProperties {

	@Property
	boolean anyDiamondStartsWithA(@ForAll("charsFromAToZ") String aString) {
		return diamond(aString).get(0).trim().equals("a");
	}

	@Property
	boolean anyDiamondEndsWithA(@ForAll("charsFromAToZ") String aString) {
		List<String> diamond = diamond(aString);
		return diamond.get(diamond.size() - 1).trim().equals("a");
	}

	@Property
	boolean numberOfLines(@ForAll("charsFromAToZ") String letter) {
		List<String> diamond = diamond(letter);
		int indexInAlphabet = letter.charAt(0) - 'a' + 1;
		return diamond.size() == indexInAlphabet * 2 - 1;
	}

//	@Property
//	boolean allLinesStartWithCorrectChar(@ForAll("charsFromAToZ") String letter) {
//		List<String> diamond = diamond(letter);
//		int indexInAlphabet = letter.charAt(0) - 'a' + 1;
//		for (int i = 0; i < diamond.size(); i++) {
//			char firstCharOfLine = diamond.get(i).trim().charAt(0);
//			diamond.size() /2
//		}
//
//		return diamond.size() == indexInAlphabet * 2 - 1;
//	}

	@Generate
	Arbitrary<String> charsFromAToZ() {
		return Generator.string('a', 'z', 1).filter(s -> !s.isEmpty());
	}

	private static List<String> diamond(String letter) {
		List<String> diamond = new ArrayList<>();
		int letterIndex = letter.charAt(0) - 'a' + 1;
		for (int i = 1; i <= letterIndex; i++) {
			diamond.add(letterForIndex(i));
		}
		for (int i = letterIndex - 1; i >= 1; i--) {
			diamond.add(letterForIndex(i));
		}
		return diamond;
	}

	private static String letterForIndex(int index) {
		return Character.toString((char) (index + 'a' -1));
	}

}
