package ma.yc.api.controller.AgentCaisse;

import ma.yc.api.dto.AgentCaisseDto;
import ma.yc.api.services.AuthentificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/agenets-caisse")
public class AgentCaisseAuthController {



    @Autowired
    @Qualifier("AgentCaisseAuthentificationServiceImpl")
    private AuthentificationService<AgentCaisseDto> authentificationService;

    public AgentCaisseAuthController(AuthentificationService<AgentCaisseDto> authentificationService) {
        this.authentificationService = authentificationService;
    }

    @PostMapping("/login")
    public AgentCaisseDto login(@RequestBody AgentCaisseDto AgentCaisseDto){
        return this.authentificationService.login(AgentCaisseDto);
    }


    @PostMapping("/register")
    public AgentCaisseDto register(@RequestBody AgentCaisseDto AgentCaisseDto){
        AgentCaisseDto AgentCaisseDto1 = AgentCaisseDto;
        return authentificationService.register(AgentCaisseDto);
    }

    @GetMapping("/logout")
    public ResponseEntity<String> logout(@RequestHeader("Authorization") String token){
        // TODO: 12/11/2023 verify token then logout when security is available
        authentificationService.logout();

        return ResponseEntity.ok("bye bye ");
    }

    @GetMapping("/resetPassword")
    public boolean resetPassword(){
        return false;
    }

    @GetMapping("/refershToken")
    public boolean refershToken(){
        return false;
    }
}
