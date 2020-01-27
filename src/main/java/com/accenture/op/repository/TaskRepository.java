package com.accenture.op.repository;

import com.accenture.op.domain.Task;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;

@Repository
public class TaskRepository {
    private String fileName;

    public TaskRepository(String fileName) {
        this.fileName = fileName;
    }

    public List<Task> findAll() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(this.fileName)));
        String s = reader.readLine();

        Task task = new ObjectMapper().readValue(s, Task.class);
        System.out.println(task);

        return Collections.singletonList(task);

    }


    public void save(Task task) throws IOException {
        Writer out = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(this.fileName), StandardCharsets.UTF_8));
        try {
            out.write(new ObjectMapper().writeValueAsString(task));
        } finally {
            out.close();
        }
     }
}
