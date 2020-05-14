package net.sendukbesi.springbootrest.toilet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoToilet  extends JpaRepository<ModelToilet, Long>{
	
	ModelToilet findByName(String name);

}
