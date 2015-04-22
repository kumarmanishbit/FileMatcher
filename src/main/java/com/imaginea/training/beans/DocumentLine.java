package com.imaginea.training.beans;

import java.util.ArrayList;
import java.util.List;

public class DocumentLine {

	private boolean flagCheck = false;

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
		// System.out.println(person.getName());
		// file 2 data
		
		
		List<String> personTwo = new ArrayList<String>();

		String arrayPerson[] = this.getLineData().split(" ");

		for (int i = 0; i < arrayPerson.length; i++) {
			personTwo.add(arrayPerson[i]);
		}

		arrayPerson = null;
		arrayPerson = fileLine.getLineData().split(" ");
		for (int i = 0; i < arrayPerson.length; i++) {
			flagCheck = true;
			if (!personTwo.contains(arrayPerson[i])) {

				flagCheck = false;
				break;
			}

		}

		return flagCheck;
	}

}
