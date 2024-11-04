package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ProfileControllerTest {

    private ProfileController profileController;

    @Mock
    private Model model;

    @Mock
    private OidcUser oidcUser;

    @BeforeEach
    public void beforeEach(){
        profileController = new ProfileController();
    }

    @Test
    public void testProfileModel(){
        String returnValue = profileController.profile(model, oidcUser);
        verify(model, times(1)).addAttribute(eq("profile"), Mockito.any());
        verify(model, times(1)).addAttribute(eq("profileJson"), Mockito.any());
        assertEquals("profile", returnValue);
    }

}
