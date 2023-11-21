package ma.yc.api.repository;

import ma.yc.api.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client,Long> {
    public Optional<Client> findByEmail(String email);
}
