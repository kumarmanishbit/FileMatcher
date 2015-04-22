package com.imaginea.training.assignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Logger;

import com.imaginea.training.beans.DocumentLine;

public class FileReaderClass {

	private final static Logger logger = Logger.getLogger(FileReaderClass.class.getName());

	public static void main(String[] args) {

		Set<DocumentLine> wordSetOne = new HashSet<DocumentLine>();

		Set<DocumentLine> wordSetTwo = new HashSet<DocumentLine>();

		Set<DocumentLine> matchedLines = new HashSet<DocumentLine>();

		DocumentLine lineText = null;

		BufferedReader fileReaderONE = null, fileReaderTWO = null;

		String firstfilePath = null, secondfilePath = null;

		if ((args.length == 2)) {

			firstfilePath = args[0];
			secondfilePath = args[1];

		} else {
			firstfilePath = "datasource/File1.txt";
			secondfilePath = "datasource/File2.txt";
		}

		try {

			String line = null;

			fileReaderONE = new BufferedReader(new FileReader(firstfilePath));
			fileReaderTWO = new BufferedReader(new FileReader(secondfilePath));

			while ((line = fileReaderONE.readLine()) != null) {
				lineText = new DocumentLine(line.toLowerCase());

				wordSetOne.add(lineText);

			}

			while ((line = fileReaderTWO.readLine()) != null) {
				lineText = new DocumentLine(line.toLowerCase());

				wordSetTwo.add(lineText);
			}

		} catch (IOException ioException) {
			logger.info("Exception while reading input files");
			logger.info(ioException.getMessage());
		} finally {
			try {
				if (fileReaderONE != null)
					fileReaderONE.close();
				if (fileReaderTWO != null)
					fileReaderTWO.close();
			} catch (IOException ioException) {
				logger.info("Exception while closing the resource handlers");
				logger.info(ioException.getMessage());

			}
		}

		Iterator<DocumentLine> iterateFirsList = wordSetOne.iterator();
		Iterator<DocumentLine> iterateSecondList = wordSetTwo.iterator();
		DocumentLine personInListOne = null, personInListTwo = null;

		while (iterateFirsList.hasNext()) {
			personInListOne = iterateFirsList.next();

			while (iterateSecondList.hasNext()) {
				personInListTwo = iterateSecondList.next();
				if (personInListOne.equals(personInListTwo)) {

					matchedLines.add(personInListOne);
				

				}
			}
			iterateSecondList = wordSetTwo.iterator();
		}

		System.out.println("Matching word : " + matchedLines.size());

	}
}
