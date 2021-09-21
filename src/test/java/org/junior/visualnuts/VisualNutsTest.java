package org.junior.visualnuts;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.Before;
import org.junit.Test;

public class VisualNutsTest {

    private static final String VISUAL = "Visual";
    private static final String NUTS = "Nuts";
    private static final String MAX_NUMBER = "maxNumber";
    private static final String CURRENT_MAX_NUMBER = "100";
    
    private Properties prop;

    @Before
    public void init() throws IOException {
        prop = new Properties();
        InputStream input = VisualNuts.class.getClassLoader().getResourceAsStream("config.properties");

        // load a properties file
        prop.load(input);
    }
    
    @Test
    public void test() {
 
        VisualNuts.loopAndPrintVisualNuts(1000000);
 
        assertEquals(VisualNuts.visualNuts(8), "8");
        assertEquals(VisualNuts.visualNuts(27), VISUAL);
        assertEquals(VisualNuts.visualNuts(80), NUTS);
        assertEquals(VisualNuts.visualNuts(90), VISUAL + " " + NUTS);
    }
    
    @Test
    public void testHavingMaxNumber() {
          assertNotNull(prop.getProperty(MAX_NUMBER));
    }

    @Test
    public void testMaxNumberValue() {
          assertEquals(CURRENT_MAX_NUMBER, prop.getProperty(MAX_NUMBER));
    }
    
    @Test
    public void testGetNaxNumberProperty() {
          assertEquals( Integer.parseInt(CURRENT_MAX_NUMBER), VisualNuts.getNaxNumberProperty());
    }
    
}
