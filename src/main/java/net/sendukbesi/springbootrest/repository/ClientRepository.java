package net.sendukbesi.springbootrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.sendukbesi.springbootrest.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

}