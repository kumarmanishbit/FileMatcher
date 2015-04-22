package com.imaginea.training.beans;

import java.util.HashSet;
import java.util.Set;

public class DocumentLine {

	private boolean equalCheckflg = false;

	private String lineData;

	public String getLineData() {
		return lineData;
	}

	public DocumentLine(String name) {
		this.lineData = name;
	}

	@Override
	public boolean equals(Object object) {

		if (this == object) {
			return true;
		}
		if (object == null) {
			return false;
		}
		if (getClass() != object.getClass()) {
			return false;
		}

		DocumentLine fileLine = (DocumentLine) object;

		Set<String> firstFileData = new HashSet<String>();

		String arrayData[] = this.getLineData().split(" ");

		for (int i = 0; i < arrayData.length; i++) {
			firstFileData.add(arrayData[i]);
		}

		arrayData = null;
		arrayData = fileLine.getLineData().split(" ");
		for (int i = 0; i < arrayData.length; i++) {
			equalCheckflg = true;
			if (!firstFileData.contains(arrayData[i])) {

				equalCheckflg = false;
				break;
			}

		}

		return equalCheckflg;
	}

}
