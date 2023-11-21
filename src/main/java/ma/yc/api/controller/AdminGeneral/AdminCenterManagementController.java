package ma.yc.api.controller.AdminGeneral;

import ma.yc.api.dto.AdminCentreDto;
import ma.yc.api.services.AuthentificationService;
import ma.yc.api.services.AuthentificationServiceAdmCtr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/admins-center")
public class AdminCenterManagementController {
    private final AuthentificationService<AdminCentreDto> authentificationService;
    @Autowired
    public AdminCenterManagementController(@Qualifier("AdminCentreAuthentificationServiceImpl") AuthentificationServiceAdmCtr authentificationService){
        this.authentificationService = authentificationService;
    }
    @PostMapping("/register")
    public AdminCentreDto register(@RequestBody AdminCentreDto adminCentreDto){
        return authentificationService.register(adminCentreDto);
    }
}
