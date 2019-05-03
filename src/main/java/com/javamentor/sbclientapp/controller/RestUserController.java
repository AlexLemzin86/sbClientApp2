package com.javamentor.sbclientapp.controller;

import com.javamentor.sbclientapp.model.Role;
import com.javamentor.sbclientapp.model.User;
import com.javamentor.sbclientapp.service.RoleService;
import com.javamentor.sbclientapp.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class RestUserController {
    private UserService userService;
    private RoleService roleService;

    public RestUserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @RequestMapping(value = "/rest/admin/add", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> addNewUser(@ModelAttribute User user,
                                           @RequestParam(value = "isAdmin", required = false) String isAdmin,
                                           @RequestParam(value = "isUser", required = false) String isUser) {

        getRoles(user, isAdmin, isUser);
        return new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/rest/admin/update", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> updateUserRest(@ModelAttribute User user,
                                               @RequestParam(value = "isAdmin", required = false) String isAdmin,
                                               @RequestParam(value = "isUser", required = false) String isUser) {
        getRoles(user, isAdmin, isUser);
        return new ResponseEntity<>(userService.updateUser(user), HttpStatus.OK);
    }

    private void getRoles(User user, String isAdmin, String isUser) {
        Set<Role> roles = new HashSet<>();
        if (isAdmin != null && !isAdmin.isEmpty()) {
            Role admin = roleService.getRoleName("ROLE_ADMIN");
            roles.add(admin);
        }
        if (isUser != null && !isUser.isEmpty()) {
            Role userRole = roleService.getRoleName("ROLE_USER");
            roles.add(userRole);
        }
        user.setRoles(roles);
    }

    @RequestMapping(value = "/rest/admin/getListUsers", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> getListUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @RequestMapping(value = "/rest/admin/getUserById/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUserByIdRest(@PathVariable("id") int id) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/rest/admin/delete/{id}", method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> deleteUserRest(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
