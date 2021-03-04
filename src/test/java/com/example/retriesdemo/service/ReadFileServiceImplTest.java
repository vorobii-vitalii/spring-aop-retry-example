package com.example.retriesdemo.service;

import com.example.retriesdemo.exception.FileReadException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReadFileServiceImplTest {
    private static final String TEST_FILE_NAME = "test.txt";

    @SpyBean
    ReadFileServiceImpl readFileService;

    @Test
    public void testReadLines_GivenNotExistentFile_ThrowFileReadException() {
        var notExistentFile = "not_existent.txt";

        assertThrows(FileReadException.class, () ->
                readFileService.readContentByFileName(notExistentFile));
    }

    @Test
    public void testReadLines_GivenCorrectFileName_ReturnsListOfLines() {
        var expected = List.of("Line1", "Line2", "Line3");

        var actual = readFileService.readContentByFileName(TEST_FILE_NAME);

        assertEquals(expected, actual);
    }


}