package ua.lviv.iot.spring.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.lviv.iot.spring.model.DocumentOwner;

@Repository
public interface DocumentOwnerRepository extends JpaRepository<DocumentOwner, Integer> {

}
