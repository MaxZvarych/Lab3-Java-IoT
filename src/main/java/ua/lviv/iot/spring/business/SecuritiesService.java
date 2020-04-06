package ua.lviv.iot.spring.business;

import java.util.List;

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

	public List<Securities> findAll() {
		return securitiesRepository.findAll();
	}

	public Securities findSecurity(Integer id) {
		return securitiesRepository.getOne(id);
	}

	public void deleteSecurity(Integer id) {
		securitiesRepository.deleteById(id);
	}

	public boolean checkIfSecurityExist(Integer id) {
		return securitiesRepository.existsById(id);
	}

	public Securities updateSecurity(Integer id, Securities security) {
		Securities firstSecurity = securitiesRepository.findById(id).get();
		Securities oldSecurity = new Securities(firstSecurity.getPrice(), firstSecurity.getDocumentOwner(),
				firstSecurity.getLevelOfRisk(), firstSecurity.getTrendOfBidding());
		oldSecurity.setId(id);
		security.setId(id);
		securitiesRepository.save(security);
		return oldSecurity;
	}

}
