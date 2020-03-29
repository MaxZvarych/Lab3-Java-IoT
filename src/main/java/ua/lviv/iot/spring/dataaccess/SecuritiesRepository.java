package ua.lviv.iot.spring.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.lviv.iot.spring.model.Securities;

@Repository
public interface SecuritiesRepository extends JpaRepository<Securities, Integer> {

}
