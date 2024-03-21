package ci.magir.sa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ci.magir.sa.entities.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long> {

}
