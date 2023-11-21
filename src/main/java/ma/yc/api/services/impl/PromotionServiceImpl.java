package ma.yc.api.services.impl;

import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import ma.yc.api.dto.ProduitDto;
import ma.yc.api.dto.PromotionDto;
import ma.yc.api.entity.Produit;
import ma.yc.api.entity.Promotion;
import ma.yc.api.entity.ResponsableRayon;
import ma.yc.api.exceptions.business.NotFoundException;
import ma.yc.api.exceptions.business.OutOfTimeExpection;
import ma.yc.api.mappers.ProduitMapper;
import ma.yc.api.mappers.PromotiomMapper;
import ma.yc.api.repository.ProductRepository;
import ma.yc.api.repository.PromotionRepository;
import ma.yc.api.repository.ResponsableRayonRepository;
import ma.yc.api.services.PromotionService;
import ma.yc.api.services.ResponsablePromotionService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.*;

@Service
@Transactional
@Log4j2
public class PromotionServiceImpl implements PromotionService {

    private final PromotionRepository promotionRepository;
    private final ProductRepository productRepository;
    @Autowired
    private ResponsableRayonRepository responsableRayonRepository;


    Logger logger = org.slf4j.LoggerFactory.getLogger(PromotionServiceImpl.class);


    @Autowired
    public PromotionServiceImpl(PromotionRepository promotionRepository, ProductRepository productRepository, ResponsablePromotionService responsablePromotionService) {
        this.promotionRepository = promotionRepository;
        this.productRepository = productRepository;
    }

    @Override
    public ProduitDto addPromotion(ProduitDto produitDto, PromotionDto promotionDto) {
        logger.info("addPromotion" , produitDto , promotionDto);

        Produit produit =  ProduitMapper.INSTANCE.toEntity(produitDto);
        Promotion promotion = PromotiomMapper.INSTANCE.toEntity(promotionDto);
        Optional<Produit> optionalProduit = productRepository.findById(1);
        if (optionalProduit.isPresent()){
            produit = optionalProduit.get();
            double prix = produit.getPrix();
            double pourcentage = promotion.getPrecentage();
            double prixPromotion = prix - (prix * pourcentage);
            produit.setPrix(prixPromotion);
            productRepository.save(produit);
            promotionRepository.save(promotion);
            produitDto = ProduitMapper.INSTANCE.toDto(produit);
            return produitDto;
        }else {
            throw new NotFoundException("Le produit n'existe pas");
        }
    }

    @Override
    public List<PromotionDto> getAll() {
        PromotiomMapper promotiomMapper = PromotiomMapper.INSTANCE;
        logger.info("GET ALL PROMOTIONS");
        List<PromotionDto> promotionDtos = new ArrayList<>();
        this.promotionRepository.findAll().forEach(promotion -> {
            promotionDtos.add(promotiomMapper.toDto(promotion));
        });

        return promotionDtos;
    }

    @Override
    public Collection<PromotionDto> consulterListPromotionValide() {
        logger.info("consulterListPromotionValide");
        Collection<PromotionDto> promotionDtos = new ArrayList<>();
        isCurrentTimeInRange();
        for (Promotion promotion : promotionRepository.findAll()) {
            promotionDtos.add(PromotiomMapper.INSTANCE.toDto(promotion));
        }
        return promotionDtos;
    }

    @Override
    public Collection<PromotionDto> consulterListPromotionValideParId(int id) {
        logger.info("consulterListPromotionValideParId");
//        Long id = Long.getLong(id);
        Long idLong = Long.valueOf(id);
        this.promotionRepository.findById(idLong );
        return null;
    }



    @Override
    public Collection<PromotionDto> consulterListPromotionPourResponsableRayon(int id) {
        logger.info("consulter List Promotion Par Responsable Rayon");
        Collection<PromotionDto> promotionDtos = new ArrayList<>();
        isCurrentTimeInRange();

        Long idLong = Long.valueOf(id);


        Optional<ResponsableRayon> responsableRayon = responsableRayonRepository.findById(idLong);

        if (responsableRayon.isPresent()){
            // : 15/11/2023 GET PROMOTION RELATED TO RESPONSABLE RAYON
                responsableRayon.get().getRayon().getCategorie().getProduits().forEach(
                        produit -> {
                            // : 16/11/2023 verifie si proudit valable ou pas
                            Date dateFin = produit.getPromotion().getDateFin();
                            Date dateDebut = produit.getPromotion().getDateDebut();

                            if (produit.getQuantite() > 0 &&  !dateDebut.before(new Date()) && !dateFin.after(new Date())){
                                promotionDtos.add(PromotiomMapper.INSTANCE.toDto(produit.getPromotion()));
                            }

                        }

                );

                promotionDtos.add(PromotiomMapper.INSTANCE.toDto(responsableRayon.get().getRayon().getCategorie().getPromotion()));
                return promotionDtos;


        }else {
            logger.error("Le responsable n'existe pas");
            throw new NotFoundException("Le responsable n'existe pas");
        }


    }

    public  boolean isCurrentTimeInRange() {
        final LocalTime START_TIME = LocalTime.of(8, 0); // 8 AM
        final LocalTime END_TIME = LocalTime.of(12, 0); // 12 PM
//        LocalTime currentTime = LocalTime.of(7, 0);
        LocalTime currentTime = LocalTime.now();

        if (currentTime.isBefore(START_TIME) || currentTime.isAfter(END_TIME)) {
            logger.error("les promotions soient consultables par les" +
                    " responsable des rayon seulement entre 8h-12h00 du matin ,");
            throw  new
                    OutOfTimeExpection("les promotions soient consultables par les" +
                    " responsable des rayon seulement entre 8h-12h00 du matin ,");
        }

        return true;
    }




}
