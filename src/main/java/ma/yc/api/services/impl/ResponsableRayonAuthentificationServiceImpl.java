package ma.yc.api.services.impl;

import jakarta.transaction.Transactional;
import ma.yc.api.dto.ResponsableDto;
import ma.yc.api.entity.ResponsableRayon;
import ma.yc.api.mappers.ResponsableMapper;
import ma.yc.api.repository.ResponsableRayonRepository;
import ma.yc.api.services.AuthentificationService;
import ma.yc.api.util.Utils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("ResponsableRayonAuthentificationService")
@Transactional
public class ResponsableRayonAuthentificationServiceImpl implements AuthentificationService<ResponsableDto> {


    private ResponsableRayonRepository responsableRayonRepository;
    private ResponsableMapper responsableMapper  ;
//    @Autowired
    public ResponsableRayonAuthentificationServiceImpl(ResponsableRayonRepository responsableRayonRepository) {
        this.responsableRayonRepository = responsableRayonRepository;

    }
    @Override
    public ResponsableDto login(ResponsableDto responsableDto) {
        ResponsableRayon responsableRayon = this.responsableRayonRepository.findByEmail(responsableDto.getEmail());
        if (responsableRayon !=null){

            // TODO: 3/11/2023 check password after you hash it
            if (Utils.checkPassword(responsableDto.getPassword(), responsableRayon.getPassword())){
                // TODO: 3/11/2023 mapper the user1 to userDto
//                return true;
                return this.responsableMapper.toDto(responsableRayon);
            }
            throw new RuntimeException("password is not correct");
        }
        throw new RuntimeException("user not found");
    }

    @Override
    public boolean logout() {
        return false;
    }

    @Override
    public ResponsableDto register(ResponsableDto responsableDto) {
        ResponsableRayon responsableRayon = this.responsableRayonRepository.findByEmail(responsableDto.getEmail());
        if (responsableRayon == null){
            ResponsableRayon responsableRayon1 = ResponsableMapper.Instance.toEntity(responsableDto);
            // TODO: 11/11/2023 very password before  hashing it and  save it
            responsableRayon1.setPassword(Utils.hashPassword(responsableRayon1.getPassword()));
            this.responsableRayonRepository.save(responsableRayon1);

        }else{
            throw new RuntimeException("user already exist");
        }
        return responsableDto;
    }


}
