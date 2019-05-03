package com.javamentor.sbclientapp.service;

import com.javamentor.sbclientapp.model.User;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    private final RestTemplate restTemplate;

    public UserServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public User addUser(User user) {
        /*HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);*/
        /* headers.add("Authorization" ,"Basic QWRtaW46QWRtaW4K");*/
        String url = "http://localhost:8080/rest/admin/add";
        /* HttpEntity<User> requestEntity = new HttpEntity<>(user, headers);*/
        return restTemplate.postForObject(url, user, User.class);
    }

    @Override
    public User updateUser(User user) {
        String url = "http://localhost:8080/rest/admin/update";
        return restTemplate.postForObject(url, user, User.class);
    }

    @Override
    public void deleteUser(int id) {
        String url = "http://localhost:8080/rest/admin/delete/{id}";
        Map<String, Integer> params = new HashMap<>();
        params.put("id", id);
        restTemplate.delete(url, params)/*;exchange(url, HttpMethod.POST, requestEntity, Integer.class, id)*/;
    }

    @Override
    public User getUserById(int id) {
        String url = "http://localhost:8080/rest/admin/getUserById/{id}";
        Map<String, Integer> params = new HashMap<>();
        params.put("id", id);
        ResponseEntity<User> responseEntity = restTemplate.getForEntity(url, User.class, params);
        return responseEntity.getBody();
    }

    @Override
    public List<User> getAllUsers() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBasicAuth("Admin","Admin");/*add("Authorization" ,"Basic QWRtaW46QWRtaW4K");*/
        String url = "http://localhost:8080/rest/admin/getListUsers";
        HttpEntity<List<User>> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<List<User>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, new ParameterizedTypeReference<List<User>>() {
        });
        return responseEntity.getBody();
    }
}
