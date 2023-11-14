package ma.yc.api.services.impl;

import jakarta.transaction.Transactional;
import ma.yc.api.dto.ProduitDto;
import ma.yc.api.dto.PromotionDto;
import ma.yc.api.entity.Produit;
import ma.yc.api.entity.Promotion;
import ma.yc.api.exceptions.business.NotFoundException;
import ma.yc.api.mapper.ProduitMapper;
import ma.yc.api.mapper.PromotiomMapper;
import ma.yc.api.repository.ProductRepository;
import ma.yc.api.repository.PromotionRepository;
import ma.yc.api.services.PromotionService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PromotionServiceImpl implements PromotionService {

    private final PromotionRepository promotionRepository;
    private final ProductRepository productRepository;

    Logger logger = org.slf4j.LoggerFactory.getLogger(PromotionServiceImpl.class);


    @Autowired
    public PromotionServiceImpl(PromotionRepository promotionRepository, ProductRepository productRepository) {
        this.promotionRepository = promotionRepository;
        this.productRepository = productRepository;
    }

    @Override
    public ProduitDto addPromotion(ProduitDto produitDto, PromotionDto promotionDto) {
        Produit produit = ProduitMapper.produitMapper.toEntity(produitDto);
        Promotion promotion = PromotiomMapper.promotionMapper.toEntity(promotionDto);
        Optional<Produit> optionalProduit = productRepository.findById(1);
        if (optionalProduit.isPresent()){
            produit = optionalProduit.get();
            double prix = produit.getPrix();
            double pourcentage = promotion.getPrecentage();
            double prixPromotion = prix - (prix * pourcentage);
            produit.setPrix(prixPromotion);
            productRepository.save(produit);
            promotionRepository.save(promotion);
            produitDto = ProduitMapper.produitMapper.toDto(produit);
            return produitDto;
        }else {
            throw new NotFoundException("Le produit n'existe pas");
        }
    }

    @Override
    public List<PromotionDto> getAll() {

        logger.info("getAll");
        List<PromotionDto> promotionDtos = new ArrayList<>();
        this.promotionRepository.findAll().forEach(promotion -> {
            promotionDtos.add(PromotiomMapper.promotionMapper.toDto(promotion));
        });

        return promotionDtos;
    }


}
