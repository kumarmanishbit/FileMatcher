package com.imaginea.training.beans;

public class DocumentLine {

	private String lineData;

	public String getLineData() {
		return lineData;
	}

	public DocumentLine(String name) {
		this.lineData = name;
	}

	@Override
	public boolean equals(Object other) {

		boolean checkOne = false, checkTwo = false;

		if (this == other) {
			return true;
		}
		if (other == null) {
			return false;
		}
		if (getClass() != other.getClass()) {
			return false;
		}

		int count = 0;
		DocumentLine fileLine = (DocumentLine) other;

		String otherFileArray[] = fileLine.getLineData().toLowerCase().split(" ");

		String thisFileArray[] = this.getLineData().toLowerCase().split(" ");

		
		for (int i = 0; i < otherFileArray.length; i++) {

			if (this.getLineData().toLowerCase().matches(".*\\b" + otherFileArray[i] + "\\b.*")) {
				count++;
			}
		}

		checkOne = otherFileArray.length == count;

		count = 0;

		for (int i = 0; i < thisFileArray.length; i++) {

			if (fileLine.getLineData().toLowerCase().matches(".*\\b" + thisFileArray[i] + "\\b.*")) {
				count++;

			}

		}
		checkTwo = thisFileArray.length == count;

		return checkTwo || checkOne;
	}

}
