package ua.lviv.iot.spring.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name = "\"documentOwner\"")
public class DocumentOwner {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Integer id;

	private String name;
	@OneToMany(mappedBy = "documentOwner", fetch = FetchType.EAGER)
	@JsonIgnoreProperties("documentOwner")
	private Set<Securities> securities;
	
	public DocumentOwner(String name) {
		super();
		this.name = name;
	}
	public DocumentOwner() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Securities> getSecurities() {
		return securities;
	}
	public void setSecurities(Set<Securities> securities) {
		this.securities = securities;
	}
	
}
