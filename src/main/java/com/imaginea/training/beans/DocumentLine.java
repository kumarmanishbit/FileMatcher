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

		boolean chkOne = false, checkTwo = false;

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

		String otherFileArray[] = fileLine.getLineData().split(" ");

		String thisFileArray[] = this.getLineData().split(" ");

		for (int i = 0; i < otherFileArray.length; i++) {

			if (!this.getLineData().matches(".*\\b" + otherFileArray[i] + "\\b.*")) {
		//		chkOne = false;

			} else {
				count++;
			}
		}

		chkOne = otherFileArray.length == count;

		count = 0;

		for (int i = 0; i < thisFileArray.length; i++) {

			if (!fileLine.getLineData().matches(".*\\b" + thisFileArray[i] + "\\b.*")) {
			//	checkTwo = false;

			} else {
			//	checkTwo = true;
				count++;
			}

		}
		checkTwo = thisFileArray.length == count;

		return checkTwo || chkOne;
	}

}
