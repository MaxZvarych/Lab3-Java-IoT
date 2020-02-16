package ua.lviv.iot;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;

import ua.lviv.iot.model.BiddingTrend;
import ua.lviv.iot.model.RiskLevel;
import ua.lviv.iot.model.Securities;

public abstract class BaseSecuritiesManager {
 protected List<Securities> securities;
 @BeforeEach
 public void createSecurities() {
	  
	 securities= new ArrayList<Securities>();
	 securities.add(new Securities(40, RiskLevel.HIGH, BiddingTrend.ASCENDING));
	 securities.add(new Securities(30, RiskLevel.MEDIUM, BiddingTrend.ASCENDING));
	 securities.add(new Securities(20, RiskLevel.LOW, BiddingTrend.ASCENDING));
	 
	 
	 
 }
}
