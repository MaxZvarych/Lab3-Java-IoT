package ua.lviv.iot.manager;
import java.util.ArrayList;
import java.util.List;
import ua.lviv.iot.model.BiddingTrend;
import ua.lviv.iot.model.RiskLevel;
import ua.lviv.iot.model.Securities;

public class SecuritiesManager {

	private List<Securities> listOfSecurities = new ArrayList<>();
	{
		listOfSecurities.clear();
		this.listOfSecurities.add(0, new Securities(40, RiskLevel.HIGH, BiddingTrend.ASCENDING));
		this.listOfSecurities.add(1, new Securities(30, RiskLevel.MEDIUM, BiddingTrend.ASCENDING));
		this.listOfSecurities.add(2, new Securities(20, RiskLevel.LOW, BiddingTrend.ASCENDING));
	}

	public void addSecurities(List<Securities> securities) {
		if (securities == null || securities.isEmpty()) {
			listOfSecurities.set(0, new Securities(40, RiskLevel.HIGH, BiddingTrend.ASCENDING));
			listOfSecurities.set(1, new Securities(30, RiskLevel.MEDIUM, BiddingTrend.ASCENDING));
			listOfSecurities.set(2, new Securities(20, RiskLevel.LOW, BiddingTrend.ASCENDING));
		} else {
			listOfSecurities.clear();
			listOfSecurities.addAll(securities);
		}
	}

	public void addSecurity(Securities security) {
		listOfSecurities.add(security);
	}

	public Securities searchByLevelOfRisk(RiskLevel levelOfRisk) {
		Securities result = new Securities();

		for (int i = 0; i < listOfSecurities.size(); i++) {
			if (listOfSecurities.get(i).getLevelOfRisk() == levelOfRisk) {
				result = listOfSecurities.get(i);
				break;
			} else
				continue;
		}
		return result;
	}

	public Securities searchByTrendOfBidding(BiddingTrend trendOfBidding) {

		Securities result = new Securities();

		for (int i = 0; i < listOfSecurities.size(); i++) {
			if (listOfSecurities.get(i).getTrendOfBidding() == trendOfBidding) {
				result = listOfSecurities.get(i);
				break;
			} else
				continue;
		}
		return result;
	}

	public Securities searchByPrice(int price) {

		Securities result = new Securities();

		for (int i = 0; i < listOfSecurities.size(); i++) {
			if (listOfSecurities.get(i).getPrice() == price) {
				result = listOfSecurities.get(i);
				break;
			} else
				continue;
		}
		return result;
	}

}
