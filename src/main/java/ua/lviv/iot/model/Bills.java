package ua.lviv.iot.model;

public class Bills extends Securities {
	private String term;

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public String getHeaders() {
		return super.getHeaders() + "," + "term";
	}

	public String toCSV() {
		return super.toCSV() + "," + getTerm();
	}
}
