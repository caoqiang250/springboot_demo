package com.example.demo.Service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

public interface UserService {
    List<HashMap> getUser() throws Exception;
}
