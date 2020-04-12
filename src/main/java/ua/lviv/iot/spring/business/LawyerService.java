package ua.lviv.iot.spring.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.spring.dataaccess.LawyerRepository;
import ua.lviv.iot.spring.model.Lawyer;

@Service
public class LawyerService {
	@Autowired
	private LawyerRepository lawyerRepository;

	public Lawyer createLawyer(Lawyer lawyer) {
		return lawyerRepository.save(lawyer);

	}

	public List<Lawyer> findAll() {
		return lawyerRepository.findAll();
	}

	public Lawyer findLawyer(Integer id) {
		return lawyerRepository.getOne(id);
	}

	public void deleteLawyer(Integer id) {
		lawyerRepository.deleteById(id);
	}

	public boolean checkIfLawyerExist(Integer id) {
		return lawyerRepository.existsById(id);
	}

	public Lawyer updateLawyer(Integer id, Lawyer lawyer) {
		Lawyer firstlawyer = lawyerRepository.findById(id).get();
		Lawyer oldlawyer = new Lawyer(firstlawyer.getName());
		oldlawyer.setId(id);
		lawyer.setId(id);
		lawyerRepository.save(lawyer);
		return oldlawyer;
	}

}
