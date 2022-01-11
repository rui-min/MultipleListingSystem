package mls.server_property.repositories;


import mls.server_property.domain.TripleDeckers;
import org.springframework.stereotype.Repository;

@Repository("TripleDeckersRepo")
public interface TripleDeckersRepo extends CondominiumRepo<TripleDeckers> {
}
