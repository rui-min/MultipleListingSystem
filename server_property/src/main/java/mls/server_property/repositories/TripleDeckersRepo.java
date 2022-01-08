package mls.server_property.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("TripleDeckersRepo")
public interface TripleDeckersRepo extends JpaRepository<TripleDeckersRepo, Long> {
}
