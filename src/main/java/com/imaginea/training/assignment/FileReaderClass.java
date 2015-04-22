package com.imaginea.training.assignment;

import java.util.HashSet;
import java.util.Set;

import com.imaginea.training.beans.DocumentLine;
import com.imaginea.training.utils.DataReader;
import com.imaginea.training.utils.MatchFinder;

public class FileReaderClass {

	public static void main(String[] args) {

		Set<DocumentLine> wordSetOne = new HashSet<DocumentLine>();

		Set<DocumentLine> wordSetTwo = new HashSet<DocumentLine>();

		String firstfilePath = null, secondfilePath = null;

		if ((args.length == 2)) {

			firstfilePath = args[0];
			secondfilePath = args[1];

		} else {
			firstfilePath = "datasource/File1.txt";
			secondfilePath = "datasource/File2.txt";
		}

		DataReader reader = new DataReader();
		wordSetOne = reader.getData(firstfilePath);
		wordSetTwo = reader.getData(secondfilePath);

		MatchFinder matchFinder = new MatchFinder();
		System.out.println("Matches:" + matchFinder.getMatch(wordSetOne, wordSetTwo));

	}
}
