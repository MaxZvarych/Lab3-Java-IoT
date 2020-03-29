package ua.lviv.iot.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import ua.lviv.iot.model.BiddingTrend;
import ua.lviv.iot.model.RiskLevel;

@Entity
public class Securities {
	protected int price;
	protected String documentOwner;
	protected RiskLevel levelOfRisk;
	protected BiddingTrend trendOfBidding;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDocumentOwner() {
		return documentOwner;
	}

	public void setDocumentOwner(String documentOwner) {
		this.documentOwner = documentOwner;
	}

	public RiskLevel getLevelOfRisk() {
		return levelOfRisk;
	}

	public void setLevelOfRisk(RiskLevel levelOfRisk) {
		this.levelOfRisk = levelOfRisk;
	}

	public BiddingTrend getTrendOfBidding() {
		return trendOfBidding;
	}

	public void setTrendOfBidding(BiddingTrend trendOfBidding) {
		this.trendOfBidding = trendOfBidding;
	}

	public String getHeaders() {
		return "price" + "," + "documentOwner" + "," + "levelOfRisk" + "," + "trendOfBidding";
	}

	public String toCSV() {
		return getPrice() + "," + getDocumentOwner() + "," + getLevelOfRisk() + "," + getTrendOfBidding();
	}

	public Securities(int price, String documentOwner, RiskLevel levelOfRisk, BiddingTrend trendOfBidding) {
		this.price = price;
		this.documentOwner = documentOwner;
		this.levelOfRisk = levelOfRisk;
		this.trendOfBidding = trendOfBidding;
	}

	public Securities(int price, RiskLevel levelOfRisk, BiddingTrend trendOfBidding) {
		this(price, null, levelOfRisk, trendOfBidding);
	}

	public Securities() {
	}

}
