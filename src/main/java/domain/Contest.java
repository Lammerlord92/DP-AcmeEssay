package domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Access(AccessType.PROPERTY)
public class Contest extends DomainEntity{
	// Attributes -----------------------------------------------------------
	private String name;
	private String description;
	private Date holdingDate;
	private Date deadline;
	private String result;
	
	// Getters and Setters --------------------------------------------------
	@NotBlank
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@NotBlank
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@DateTimeFormat(pattern="dd/MM/yyyy HH:mm")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getHoldingDate() {
		return holdingDate;
	}
	public void setHoldingDate(Date holdingDate) {
		this.holdingDate = holdingDate;
	}
	
	@DateTimeFormat(pattern="dd/MM/yyyy HH:mm")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	
	// Relationships --------------------------------------------------------
	private Organiser contestOrganiser;
	private Collection<Essay> essays;

	@ManyToOne(optional = false)
	public Organiser getContestOrganiser() {
		return contestOrganiser;
	}
	public void setContestOrganiser(Organiser contestOrganiser) {
		this.contestOrganiser = contestOrganiser;
	}
	
	@OneToMany(mappedBy = "contest")
	public Collection<Essay> getEssays() {
		return essays;
	}
	public void setEssays(Collection<Essay> essays) {
		this.essays = essays;
	}
	
	
}
