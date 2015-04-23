package com.imaginea.training.assignment;

import java.util.HashSet;
import java.util.Set;

import com.imaginea.training.beans.DocumentLine;
import com.imaginea.training.utils.DataReader;
import com.imaginea.training.utils.DataReaderImpl;
import com.imaginea.training.utils.MatchFinder;
import com.imaginea.training.utils.SimilarityChecker;
import com.imaginea.training.utils.SimilarityCheckerImpl;

public class TextMatchExecutor {

	public static void main(String[] args) {

		Set<DocumentLine> listSetOne = new HashSet<DocumentLine>();

		Set<DocumentLine> listSetTwo = new HashSet<DocumentLine>();

		String firstSourcePath = null, secondSourcePath = null;

		SimilarityChecker<DocumentLine> similarityChecker=new SimilarityCheckerImpl();
		
		if ((args.length == 2)) {

			firstSourcePath = args[0];
			secondSourcePath = args[1];

		} else {
			firstSourcePath = "datasource/File1.txt";
			secondSourcePath = "datasource/File2.txt";
		}
		DataReader<DocumentLine, String> reader = new DataReaderImpl();
		
		listSetOne = reader.getData(firstSourcePath);
		
		listSetTwo = reader.getData(secondSourcePath);

		MatchFinder matchFinder = new MatchFinder();
		
		System.out.println("Matches:" + matchFinder.getMatch(listSetOne, listSetTwo,similarityChecker));

	}
}
