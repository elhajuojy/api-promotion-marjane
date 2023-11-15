package ma.yc.api.controller.AdminCentre;

import ma.yc.api.dto.AdminCentreDto;
import ma.yc.api.services.AuthentificationService;
import ma.yc.api.services.AuthentificationServiceAdmCtr;
import ma.yc.api.services.impl.AdminCentreAuthentificationServiceImpl;
import ma.yc.api.dto.AdminCentreDto;
import ma.yc.api.services.AuthentificationService;
import ma.yc.api.services.impl.AdminCentreAuthentificationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/adminCentre")
public class AuthentificationController {


    private final AuthentificationService<AdminCentreDto> authentificationService;


    @Autowired
    public AuthentificationController(@Qualifier("AdminCentreAuthentificationServiceImpl") AuthentificationServiceAdmCtr authentificationService){
        this.authentificationService = authentificationService;
    }
    @PostMapping("/register")
    public AdminCentreDto register(@RequestBody AdminCentreDto adminCentreDto){
            return authentificationService.register(adminCentreDto);
    }
    @PostMapping ("/login")
    public AdminCentreDto login(@RequestBody AdminCentreDto adminCentreDto){
        return authentificationService.login(adminCentreDto);
    }
}
