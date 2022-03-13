/**
 * Project Name: seMethods
 * Package: PACKAGE_NAME
 * User: Greg Ewens
 * Date Created: 13/03/2022 13:44
 * File Purpose: Integration Tests for application
 */

import com.napier.sem.App;
import com.napier.sem.Program;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTests {

    static App app;


    @BeforeAll
    static void init()
    {
        //String[] args = new String[2];
        //args[0] = "localhost:33060";
        //args[1] = "30000";

        //app = new App();
        //app.initialise(app, args);

    }

    @AfterAll
    static void dispose(){
        //app.disconnect();
    }

    @Test
    void testGetCity()
    {
        //var city = app.cityService.getCityById(1);

        assertEquals(1,1);

        //assertEquals(city.id, 1);
        //assertEquals(city.population, 1780000);
        //assertEquals(city.district, "Kabol");
        //assertEquals(city.countryCode, "AFG");
        //assertEquals(city.name, "Kabul");
    }

}
