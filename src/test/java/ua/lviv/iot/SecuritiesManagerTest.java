package ua.lviv.iot;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ua.lviv.iot.manager.SecuritiesManager;
import ua.lviv.iot.model.BiddingTrend;
import ua.lviv.iot.model.RiskLevel;

class SecuritiesManagerTest extends BaseSecuritiesManager {

	private SecuritiesManager securitiesManager;

	@BeforeEach
	public void setUp() {
		// FIXME:Manager initialization logic goes here
		//create required objects here
		
		securitiesManager = new SecuritiesManager();
		createSecurities();
		securitiesManager.addSecurities(securities);
		
	}

	@Test
	public void testSearchByPrice() {
		securitiesManager.searchByPrice(30);
	assertEquals(30,securitiesManager.searchByPrice(30).getPrice());
	}

	@Test
	public void testSearchByLevelOfRisk() {
		securitiesManager.searchByLevelOfRisk(RiskLevel.LOW);
		assertEquals(RiskLevel.LOW,securitiesManager.searchByLevelOfRisk(RiskLevel.LOW).getLevelOfRisk());
	}

	@Test
	public void testSearchByTrendOfBidding() {
		securitiesManager.searchByTrendOfBidding(BiddingTrend.ASCENDING);
		assertEquals(BiddingTrend.ASCENDING,securitiesManager.searchByTrendOfBidding(BiddingTrend.ASCENDING).getTrendOfBidding());
	}

}
