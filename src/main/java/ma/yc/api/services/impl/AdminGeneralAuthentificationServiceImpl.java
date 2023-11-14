package ma.yc.api.services.impl;

import jakarta.transaction.Transactional;
import ma.yc.api.dto.AdminGeneralDto;
import ma.yc.api.entity.AdminGeneral;
import ma.yc.api.exceptions.business.NotFoundException;
import ma.yc.api.mapper.AdminGeneralMapper;
import ma.yc.api.repository.AdminGeneralAuthentificationRespository;
import ma.yc.api.services.AuthentificationService;
import ma.yc.api.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Transactional
@Qualifier("AdminGeneralAuthentificationServiceImpl")
public class AdminGeneralAuthentificationServiceImpl implements AuthentificationService<AdminGeneralDto> {



    @Autowired
    private AdminGeneralAuthentificationRespository adminGeneralAuthentificationRespository;




    @Override
    public AdminGeneralDto login(AdminGeneralDto userDto) {
        AdminGeneral user1 = this.adminGeneralAuthentificationRespository.findByEmail(userDto.getEmail());
        if(user1 != null){
            if(Utils.hashPassword(userDto.getPassword()).equals(user1.getPassword())){
                AdminGeneralDto adminGeneralDto = new AdminGeneralDto();
                adminGeneralDto.setEmail(user1.getEmail());
                adminGeneralDto.setPassword(user1.getPassword());
                adminGeneralDto.setNom(user1.getNom());
                return adminGeneralDto;
            }else{
                throw new NotFoundException(" mot de passe incorrect");
            }
        }
        throw new NotFoundException("Email  incorrect");
    }

    @Override
    public boolean logout() {
        return false;
    }

    @Override
    public AdminGeneralDto register(AdminGeneralDto adminGeneralDto) {
        AdminGeneral adminGeneral = AdminGeneralMapper.adminGeneralMapper.toEntity(adminGeneralDto);
        adminGeneral.setPassword(Utils.hashPassword(adminGeneral.getPassword()));
        adminGeneral = this.adminGeneralAuthentificationRespository.save(adminGeneral);
        return AdminGeneralMapper.adminGeneralMapper.toDto(adminGeneral);
    }
}
