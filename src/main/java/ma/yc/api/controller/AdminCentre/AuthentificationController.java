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
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin_centres")
public class AuthentificationController {


    private final AuthentificationService<AdminCentreDto> authentificationService;


    @Autowired
    public AuthentificationController(@Qualifier("AdminCentreAuthentificationServiceImpl") AuthentificationServiceAdmCtr authentificationService){
        this.authentificationService = authentificationService;
    }

    @PostMapping ("/login")
    public AdminCentreDto login(@RequestBody AdminCentreDto adminCentreDto){
        return authentificationService.login(adminCentreDto);
    }

    @GetMapping("/logout")
    public boolean logout(@RequestHeader("Authorization") String token){
        // TODO: 21/11/2023 verify token then logout when security is available
        return false;
    }

}
