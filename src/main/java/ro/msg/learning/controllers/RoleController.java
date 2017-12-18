package ro.msg.learning.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.services.RoleService;

@RestController
@RequestMapping("/roles")
public class RoleController {

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PutMapping(value = "/changeRole/{userId}")
    public void changeRole(@PathVariable("userId") Long userId) {
        roleService.changeRole(userId);
    }

}
