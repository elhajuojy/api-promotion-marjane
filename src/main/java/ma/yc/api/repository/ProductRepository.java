package ma.yc.api.repository;


import ma.yc.api.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Produit,Integer> {
}
