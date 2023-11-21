package ma.yc.api.repository;

import ma.yc.api.entity.AgentCaisse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AgentRepository extends JpaRepository<AgentCaisse,Long > {

    public Optional<AgentCaisse> findByEmail(String email);
}
