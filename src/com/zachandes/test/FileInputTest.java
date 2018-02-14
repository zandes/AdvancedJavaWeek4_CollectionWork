package com.zachandes.test;

import com.zachandes.FileInput;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class FileInputTest {
    FileInput input;

    @Before
    public void SetUp(){
        input = new FileInput("the_book.csv");
    }

    @Test
    public void testFileReadLine(){
        assertNotNull("Read returned null", input.fileReadLine());
        //assertTrue("Read returned null", input.fileReadLine()==null);
    }

    @After
    public void testFileClose(){
        input.fileClose();
    }
}
