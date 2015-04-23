package com.imaginea.training.utils;

import com.imaginea.training.beans.DocumentLine;

public class SimilarityCheckerImpl implements SimilarityChecker<DocumentLine> {

	public boolean similarCheck(DocumentLine firstObject, DocumentLine secondObject) {

		if (secondObject == firstObject) {
			return true;
		}
		if (firstObject == null) {
			return false;
		}
		if (secondObject.getClass() != firstObject.getClass()) {
			return false;
		}
		int count = 0;

		String otherFileArray[] = firstObject.getLineData().toLowerCase().split(" ");

		String thisFileArray[] = secondObject.getLineData().toLowerCase().split(" ");

		String listToBeProcess[] = otherFileArray.length > thisFileArray.length ? thisFileArray : otherFileArray;

		DocumentLine referenceLine = otherFileArray.length <= thisFileArray.length ? secondObject : firstObject;

		int listLength = listToBeProcess.length;

		for (int i = 0; i < listLength; i++) {

			if (referenceLine.getLineData().matches(".*\\b" + listToBeProcess[i] + "\\b.*")) {

				count++;
			}
		}
		return (count == listLength);
	}
}
