package ua.lviv.iot.spring.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Lawyer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String name;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "Securities_Lawyers", joinColumns = {
			@JoinColumn(name = "lawyer_id", nullable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "security_id", nullable = false) })
	@JsonIgnoreProperties("lawyers")
	private Set<Securities> securities;

	public Lawyer(String name) {
		super();
		this.name = name;
	}

	public Lawyer() {
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
