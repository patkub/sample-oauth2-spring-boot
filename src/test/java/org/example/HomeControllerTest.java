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
class HomeControllerTest {

    private HomeController homeController;

    @Mock
    private Model model;

    @Mock
    private OidcUser principal;

    @BeforeEach
    public void beforeEach(){
        homeController = new HomeController();
    }

    @Test
    public void testHomeModel(){
        String returnValue = homeController.home(model, principal);
        verify(model, times(1)).addAttribute(eq("profile"), Mockito.any());
        assertEquals("index", returnValue);
    }

    @Test
    public void testHomeModelNullPrincipal(){
        String returnValue = homeController.home(model, null);
        verify(model, never()).addAttribute(eq("profile"), Mockito.any());
        assertEquals("index", returnValue);
    }

}