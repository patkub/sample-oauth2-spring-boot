package org.example.webflux;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.test.util.ReflectionTestUtils;
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
    public void testProfileModel() {
        // Act
        String returnValue = profileController.profile(model, oidcUser);

        // Assert
        verify(model, times(1)).addAttribute(eq("profile"), Mockito.any());
        verify(model, times(1)).addAttribute(eq("profileJson"), Mockito.any());
        assertEquals("profile", returnValue);
    }

    @Test
    public void testProfileModel_Exception() throws JsonProcessingException {
        // Prepare
        // Mock Logger
        Logger mockedLogger = Mockito.mock(Logger.class);
        ReflectionTestUtils.setField(profileController, "log", mockedLogger);

        // Mocked ObjectWriter calls writeValueAsString() and throws JsonProcessingException
        ObjectWriter mockedWriter = Mockito.mock(ObjectWriter.class);
        when(mockedWriter.writeValueAsString(Mockito.any())).thenThrow(new JsonProcessingException("Error"){});

        // Mocked ObjectMapper returns mocked ObjectWriter
        ObjectMapper mockedMapper = Mockito.mock(ObjectMapper.class);
        when(mockedMapper.writerWithDefaultPrettyPrinter()).thenReturn(mockedWriter);

        // Set mocked ObjectMapper on class through reflection
        ReflectionTestUtils.setField(profileController, "mapper", mockedMapper);

        // Act
        String returnValue = profileController.profile(model, oidcUser);

        // Assert
        verify(model, times(1)).addAttribute(eq("profile"), Mockito.any());
        verify(model, times(1)).addAttribute(eq("profileJson"), Mockito.any());
        assertEquals("profile", returnValue);
    }

}
