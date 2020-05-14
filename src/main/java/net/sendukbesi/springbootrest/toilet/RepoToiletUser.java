package net.sendukbesi.springbootrest.toilet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoToiletUser extends JpaRepository<ModelToiletUser, Long> {

}
