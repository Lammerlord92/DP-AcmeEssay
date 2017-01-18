package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@Access(AccessType.PROPERTY)
public class Organiser extends Customer{
	// Attributes -----------------------------------------------------------
	// Getters and Setters --------------------------------------------------
	// Relationships --------------------------------------------------------
	private Collection<Contest> contests;

	@OneToMany(mappedBy = "contestOrganiser")
	public Collection<Contest> getContests() {
		return contests;
	}
	public void setContests(Collection<Contest> contests) {
		this.contests = contests;
	}
	
	
	
}
