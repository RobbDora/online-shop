package ro.msg.learning.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.models.MyUserPrincipal;

@RestController
@RequestMapping("authenticatedUser")
public class UserController {

    @RequestMapping(value = {"/username"}, method = RequestMethod.GET)

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public MyUserPrincipal getCurrentUser(@AuthenticationPrincipal MyUserPrincipal customUser) throws Exception {
        return customUser;
    }

}
