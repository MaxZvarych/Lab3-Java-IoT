package ua.lviv.iot.spring.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.iot.spring.dataaccess.SecuritiesRepository;
import ua.lviv.iot.spring.model.Securities;

@Service
public class SecuritiesService {
	@Autowired
	private SecuritiesRepository securitiesRepository;

	public Securities createSecurities(Securities securities) {
		return securitiesRepository.save(securities);

	}
}
