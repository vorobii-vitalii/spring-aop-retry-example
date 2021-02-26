package com.example.retriesdemo.aspect;

import com.example.retriesdemo.exception.FileReadException;
import com.example.retriesdemo.service.ReadFileService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@SpringBootTest
class RetryReadAspectTest {

    @SpyBean
    private ReadFileService readFileService;

    @Test
    void test1() {

        var expected = List.of("a", "b", "c");

        doThrow(FileReadException.class)
                .doReturn(expected)
                .when(readFileService)
                .readContentByFileName(anyString());

        var actual = readFileService.readContentByFileName("fileNameExample");

        assertEquals(expected, actual);

        verify(readFileService, times(2))
                .readContentByFileName(anyString());
    }

    @Test
    void test2() {
        doThrow(FileReadException.class)
                .when(readFileService)
                .readContentByFileName(anyString());


        assertThrows(FileReadException.class, () ->
                readFileService.readContentByFileName("fileNameExample"));

        verify(readFileService, times(3))
                .readContentByFileName(anyString());
    }

}