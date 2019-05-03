package com.javamentor.sbclientapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

   /* @RequestMapping(value = {"/", "/welcome**"}, method = RequestMethod.GET)
    public ModelAndView getIndexPage(ModelAndView modelAndView) {
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "logout", required = false) String logout, HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION"));
        }
        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }
        model.setViewName("login");
        String url = "http://localhost:8080/login";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getForEntity(url,Void.class);
        return model;
    }

    @ModelAttribute("user")
    public User createUser() {
        return new User();
    }*/


   /* @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView getUserPage(ModelAndView modelAndView) {
        modelAndView.setViewName("userpage");
        modelAndView.addObject("role_admin", "ROLE_ADMIN");
        return modelAndView;
    }*/

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getAdminPage(ModelAndView modelAndView) {
        modelAndView.addObject("role_user", "ROLE_USER");
        modelAndView.setViewName("adminpage");
        return modelAndView;
    }

   /* @RequestMapping(value = "/403", method = RequestMethod.GET)
    public ModelAndView accessDenied(ModelAndView modelAndView) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();
            System.out.println(userDetail);

            modelAndView.addObject("username", userDetail.getUsername());

        }
        modelAndView.setViewName("403");
        return modelAndView;

    }
*/
    /*private String getErrorMessage(HttpServletRequest request, String key) {
        Exception exception = (Exception) request.getSession().getAttribute(key);
        String error;
        if (exception instanceof BadCredentialsException) {
            error = "Invalid username and password!";
        } else if (exception instanceof LockedException) {
            error = exception.getMessage();
        } else {
            error = "Invalid username and password!";
        }
        return error;
    }*/

}
