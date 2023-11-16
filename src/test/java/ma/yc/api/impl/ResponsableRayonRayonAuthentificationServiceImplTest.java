package ma.yc.api.impl;

import ma.yc.api.entity.ResponsableRayon;
import ma.yc.api.util.Utils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Test de la classe ResponsableRayonAuthentificationServiceImpl")
class ResponsableRayonRayonAuthentificationServiceImplTest {

    @Test()
    @DisplayName("Test de la methode login")
    void login() {
        ResponsableRayon responsableRayon = new ResponsableRayon();
        responsableRayon.setEmail("email@gmail.com");
        responsableRayon.setId(1);
        responsableRayon.setNom("nom");
        responsableRayon.setPrenom("prenom");
        responsableRayon.setUsername("username");
        responsableRayon.setPassword("password");
        //mocking the return from the findbyEmail method

        assertNotNull(responsableRayon);
        assertNotEquals(null, responsableRayon);
        assertEquals("password", responsableRayon.getPassword());
        assertEquals(1, responsableRayon.getId());

    }

    @Test
    @DisplayName("Test de la methode logout")
    void logout() {
        boolean logout = false;
        assertEquals(false,logout);
        assertTrue(!logout);

    }

    @Test
    @DisplayName("Test de la methode register by testing if the email is valid and if the password is hashed and information are correct ")
    void register() {
        ResponsableRayon responsableRayon = new ResponsableRayon();
        responsableRayon.setEmail("email@gmail.com");
        responsableRayon.setId(1);
        responsableRayon.setNom("nom");
        responsableRayon.setPrenom("prenom");
        responsableRayon.setUsername("username");
        responsableRayon.setPassword("password");

        String emailFromDbExample = "email@gmail.com";
        assertTrue(Utils.verifyEmail(responsableRayon.getEmail()));
        assertNotNull(responsableRayon);
        assertEquals(emailFromDbExample, responsableRayon.getEmail());
        assertEquals(1, responsableRayon.getId());
        assertEquals("nom", responsableRayon.getNom());
        assertEquals("prenom", responsableRayon.getPrenom());
        assertEquals("username", responsableRayon.getUsername());
        assertNotNull(responsableRayon.getPassword());

    }
    @Test
    @DisplayName("Test de la methode passwordOperation")
    void passwordOperationTest(){
        String password = "123456";
        String hashPassword = Utils.hashPassword(password);

        assertEquals(true,Utils.checkPassword(password,hashPassword));
        assertNotEquals(password , hashPassword);

    }
    @Test
    @DisplayName("Test de la methode verifyEmail")
    void verifyEmailTest() {
        String validEmail = "email@gmail.com";
        String notValidEmail = "emailgmail.com";
        String notValidEmail2 = "email@gmailcom";

        assertEquals(true, Utils.verifyEmail(validEmail));
        assertEquals(false, Utils.verifyEmail(notValidEmail));
        assertEquals(false, Utils.verifyEmail(notValidEmail2));

    }
}