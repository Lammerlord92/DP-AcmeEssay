package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import security.UserAccount;

import domain.Organiser;

@Repository
public interface OrganiserRepository extends JpaRepository<Organiser,Integer>{
	@Query("select o from Organiser o where o.userAccount=?1")
	Organiser findByUserAccount(UserAccount userAccount);
}
