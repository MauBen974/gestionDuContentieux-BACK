package com.adaming.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.adaming.entity.Utilisateur;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

	@Query("from Utilisateur u where u.email like :x and u.password like :y")
    public Optional<Utilisateur> authentification(@Param("x") String email, @Param("y") String password);
	
	@Query("from Utilisateur u where u.archive is false")
    public List<Utilisateur> findAllIfArchiveFalse();
	
	@Query("from Utilisateur u where u.idUtilisateur like :x and u.archive like false")
    public Optional<Utilisateur> findOneIfAchiveFalse(@Param("x") Long id);
}
