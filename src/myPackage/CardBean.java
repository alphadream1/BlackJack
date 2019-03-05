package myPackage;

class CardBean {

	// ---------------------
	// attribut
	// ---------------------

	private Color color;
	private Face face;

	// -------------------------
	// constructor
	// -------------------

	public CardBean() {
		super();
	}

	public CardBean(Color c, Face f) {
		color = c;
		face = f;
	}

	// -----------------
	// methode
	// -----------------

	public void makeCard() {

	}

	// ----------------
	// getter & setter
	// ----------------

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Face getFace() {
		return face;
	}

	public void setFace(Face face) {
		this.face = face;
	}

}
