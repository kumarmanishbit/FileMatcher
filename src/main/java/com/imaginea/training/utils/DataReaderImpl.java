package com.imaginea.training.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import com.imaginea.training.beans.DocumentLine;

public class DataReaderImpl implements DataReader<DocumentLine, String> {
	private final static Logger logger = Logger.getLogger(DataReaderImpl.class.getName());

	public Set<DocumentLine> getData(String filePath) {
		Set<DocumentLine> wordSet = new HashSet<DocumentLine>();
		BufferedReader fileReaderOne = null;

		try {

			String line = null;

			fileReaderOne = new BufferedReader(new FileReader(filePath));

			while ((line = fileReaderOne.readLine()) != null) {

				wordSet.add(new DocumentLine(line.toLowerCase()));

			}

		} catch (IOException ioException) {
			logger.info("Exception while reading input files : You may need to check file existence");
			logger.info(ioException.getMessage());
		} finally {
			try {
				if (fileReaderOne != null)
					fileReaderOne.close();
			} catch (IOException ioException) {
				logger.info("Exception while closing the resource handlers");
				logger.info(ioException.getMessage());

			}
		}
		return wordSet;
	}

}
