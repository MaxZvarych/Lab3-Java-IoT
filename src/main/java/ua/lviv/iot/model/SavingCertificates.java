package ua.lviv.iot.model;

public class SavingCertificates extends Securities {
	private long depositAmount;
	private float amountOfInterestOnDeposit;

	public long getDepositAmount() {
		return depositAmount;
	}

	public void setDepositAmount(long depositAmount) {
		this.depositAmount = depositAmount;
	}

	public float getAmountOfInterestOnDeposit() {
		return amountOfInterestOnDeposit;
	}

	public void setAmountOfInterestOnDeposit(float amountOfInterestOnDeposit) {
		this.amountOfInterestOnDeposit = amountOfInterestOnDeposit;
	}

	public String getHeaders() {
		return super.getHeaders() + "," + "depositAmount" + "," + "amountOfInterestOnDeposit";
	}

	public String toCSV() {
		return super.toCSV() + "," + getDepositAmount() + "," + getAmountOfInterestOnDeposit();
	}
}