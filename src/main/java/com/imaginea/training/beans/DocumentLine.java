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

		
		String listToBeProcess[] = otherFileArray.length > thisFileArray.length ? thisFileArray : otherFileArray;
		DocumentLine referenceLine=otherFileArray.length <= thisFileArray.length ? this : fileLine;
		
		
		
		for (int i = 0; i < listToBeProcess.length; i++) {

			if (referenceLine.getLineData().matches(".*\\b" + listToBeProcess[i] + "\\b.*")) {
				count++;
			}
		}
	
		return (count==listToBeProcess.length);
		
		
		
		
		
		
		
		
		
	}

}
