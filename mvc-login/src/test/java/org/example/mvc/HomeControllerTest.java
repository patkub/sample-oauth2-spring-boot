package org.example.mvc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
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
        // Act
        String returnValue = homeController.home(model, principal);

        // Assert
        verify(model, times(1)).addAttribute(eq("profile"), Mockito.any());
        assertEquals("index", returnValue);
    }

    @Test
    public void testHomeModelNullPrincipal(){
        // Act
        String returnValue = homeController.home(model, null);

        // Assert
        verify(model, never()).addAttribute(eq("profile"), Mockito.any());
        assertEquals("index", returnValue);
    }

}