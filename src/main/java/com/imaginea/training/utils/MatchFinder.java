package com.imaginea.training.utils;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.imaginea.training.beans.DocumentLine;

public class MatchFinder {

	public int getMatch(Set<DocumentLine> wordSetOne, Set<DocumentLine> wordSetTwo) {

		Set<String> matchedLines = new HashSet<String>();
		Iterator<DocumentLine> iterateFirsList = wordSetOne.iterator();
		Iterator<DocumentLine> iterateSecondList = wordSetTwo.iterator();
		DocumentLine personInListOne = null, personInListTwo = null;

		while (iterateFirsList.hasNext()) {
			personInListOne = iterateFirsList.next();

			while (iterateSecondList.hasNext()) {
				personInListTwo = iterateSecondList.next();
				if (personInListOne.equals(personInListTwo)) {

					matchedLines.add(personInListOne.getLineData() + ">>" + personInListTwo.getLineData());
					System.out.println(personInListOne.getLineData() + ">>" + personInListTwo.getLineData());
				}
			}
			iterateSecondList = wordSetTwo.iterator();
		}

		return matchedLines.size();
	}
}
