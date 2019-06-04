package com.dejff;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.*;
import java.io.File;
import org.junit.Before;
import org.junit.Rule;

public class CheckerTest {

    private Checker checker;
    private File testFile, wrongFile;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp(){
        testFile = new File(getClass().getClassLoader().getResource("testXml.xml").getFile());
        checker = new Checker();
    }

    @Test
    public void shouldRetunNodeVal() {
        String returnValue = "";
        String xpath = "/XpathChecker/Node1[@tutId='01']/author";
        returnValue = checker.getNode(xpath, testFile);
        assertEquals("Janusz1 Nosacz1", returnValue);
        assertTrue(true);
    }
}
