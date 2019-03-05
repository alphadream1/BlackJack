package myPackage;

public enum Face {

	ace(11, "ace"), two(2, "2"), three(3, "3"), four(4, "4"), five(5, "5"), six(6, "6"), seven(7, "7"), eight(8, "8"),
	nine(9, "9"), ten(10, "10"), jack(10, "Jack"), queen(10, "Queen"), king(10, "King");

	private int values;
	private String face;

	private Face(int values, String face) {
		this.values = values;
		this.face = face;
	}

	public int getValues() {
		return values;
	}

	public void setValues(int values) {
		this.values = values;
	}

	public String getFace() {
		return face;
	}

	public void setFace(String face) {
		this.face = face;
	}

}
