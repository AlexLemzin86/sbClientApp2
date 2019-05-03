package com.javamentor.sbclientapp.service;

import com.javamentor.sbclientapp.model.Role;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class RoleServiceImpl implements RoleService {


    private final RestTemplate restTemplate;

    public RoleServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Role getRoleName(String name) {
        String url = "http://localhost:8080/rest/admin/getRoleByName/{name}";
        Map<String, String> params = new HashMap<>();
        params.put("name", name);
        ResponseEntity<Role> responseEntity = restTemplate.getForEntity(url, Role.class, params);
        return responseEntity.getBody();
    }
}
