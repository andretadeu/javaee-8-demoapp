package com.andretadeu.demoapp.service;

import com.andretadeu.demoapp.domain.User;
import com.andretadeu.demoapp.persistence.UserDAO;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("users")
@Stateless
@Produces({MediaType.APPLICATION_JSON})
public class UserService {

    @Inject
    private UserDAO userDAO;

    @GET
    public Response listUsers() {
        List<User> result = userDAO.list();
        if (result.isEmpty()) {
            userDAO.add(new User("Test User", "test@domain.com"));
            userDAO.add(new User("New Test User", "new.test@domain.com"));
        }
        return Response.ok(userDAO.list()).build();
    }
}
