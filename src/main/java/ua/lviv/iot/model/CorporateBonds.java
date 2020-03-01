package ua.lviv.iot.model;

public class CorporateBonds extends Securities {
	private String services;

	public String getServices() {
		return services;
	}

	public void setServices(String services) {
		this.services = services;
	}

	public String getHeaders() {
		return super.getHeaders() + "," + "services";
	}

	public String toCSV() {
		return super.toCSV() + "," + getServices();
	}
}
