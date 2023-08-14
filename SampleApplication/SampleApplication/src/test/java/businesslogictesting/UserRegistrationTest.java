package businesslogictesting;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

import com.javasample.SpringBootSampleApplication;

import com.javasample.model.DAOUser;

import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootSampleApplication.class)

public class UserRegistrationTest {
	@Test
    public void TestUsernameIsEmpty() {
         DAOUser UsernameValidator = new DAOUser();
        assertFalse(UsernameValidator.isValidUsername(""));
    }

    @Test
    public void TestUsernameIsNull() {
        DAOUser Test = new DAOUser();
        Test.setUsername(null);
        assertFalse(Test.isValidUsername(null));
    }

    @Test
    public void TestInvalidLongUsername() {
        DAOUser UsernameValidator = new DAOUser();
        assertFalse(UsernameValidator.isValidUsername("this_is_a_very_long_username"));    
    }

    @Test
    public void TestUsernameWithSpaces() {
        DAOUser UsernameValidator = new DAOUser();
        assertFalse(UsernameValidator.isValidUsername("user name"));
    }

    @Test
    public void TestValidEmails() { 
        DAOUser EmailValidator = new DAOUser();
        assertTrue(EmailValidator.isValidEmail("user@example.com")); 
    }

    @Test
    public void TestValidLongTLD() { 
        DAOUser EmailValidator = new DAOUser();
        assertTrue(EmailValidator.isValidEmail("user.name@example.co.uk")); 
    }

    @Test
    public void IsSubdomainValid() { 
        DAOUser EmailValidator = new DAOUser();
        assertTrue(EmailValidator.isValidEmail("user123@subdomain.domain.com")); 
    }

 

    @Test
    public void TestInvalidEmailMissingTLD() { 
        DAOUser EmailValidator = new DAOUser();
    assertFalse(EmailValidator.isValidEmail("user@example")); 
    }

    @Test
    public void TestInvalidEmailMultipleDots() { 
        DAOUser EmailValidator = new DAOUser();
    assertFalse(EmailValidator.isValidEmail("user.example.com")); 
    }

    @Test
    public void TestInvalidEmailMissingDomain() { 
        DAOUser EmailValidator = new DAOUser();
    assertFalse(EmailValidator.isValidEmail("user@.com")); 
    }

    @Test
    public void TestInvalidEmailMissingDomainAndTLD() { 
        DAOUser EmailValidator = new DAOUser();
    assertFalse(EmailValidator.isValidEmail("user@com.")); 
    }

 

    @Test
    public void TestValidPasswordWithSpecialCharsAndNumbers() { 
        DAOUser PasswordValidator = new DAOUser();
    assertTrue(PasswordValidator.isValidPassword("P@ssw0rd")); 
    }

    @Test
    public void TestValidPasswordWithMixedCase() { 
        DAOUser PasswordValidator = new DAOUser();
    assertTrue(PasswordValidator.isValidPassword("MyP@ss123")); 
    }

    @Test
    public void TestValidPasswordWithUnderscoreAndNumber() { 
        DAOUser PasswordValidator = new DAOUser();
    assertTrue(PasswordValidator.isValidPassword("Secure_P@ssword2")); 
    }

 

    @Test
    public void TestWeakPasswordIsInvalid() { 
        DAOUser PasswordValidator = new DAOUser();
    assertFalse(PasswordValidator.isValidPassword("weak")); 
    }

    @Test
    public void TestNumericPassword() { 
        DAOUser PasswordValidator = new DAOUser();
    assertFalse(PasswordValidator.isValidPassword("password123")); 
    }

    @Test
    public void TestNoSpecialCharactersIsInvalid() { 
        DAOUser PasswordValidator = new DAOUser();
    assertFalse(PasswordValidator.isValidPassword("no_special_characters")); 
    }

    @Test
    public void TestAllLowercasePasswordIsInvalid() { 
        DAOUser PasswordValidator = new DAOUser();
    assertFalse(PasswordValidator.isValidPassword("alllowercase")); 
    }

 

}


