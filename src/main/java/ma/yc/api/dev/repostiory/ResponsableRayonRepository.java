package ma.yc.api.dev.repostiory;

import ma.yc.api.dev.entity.ResponsableRayon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ResponsableRayonRepository extends JpaRepository<ResponsableRayon, Long> {
    public Optional<ResponsableRayon> findAllByEmail(String email);
    public Optional<ResponsableRayon> findAllByUsername(String username);
}
