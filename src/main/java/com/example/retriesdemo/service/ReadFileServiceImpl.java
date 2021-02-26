package com.example.retriesdemo.service;

import com.example.retriesdemo.exception.FileReadException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ReadFileServiceImpl implements ReadFileService {

    @Override
    public List<String> readContentByFileName(String fileName) {
        final List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            reader.lines().forEach(lines::add);
        }
        catch (IOException e) {
            log.error("Error while reading file");
            throw new FileReadException();
        }

        return lines;
    }

}
