package edu.mum.project1.QuoraClone.control;

import edu.mum.project1.QuoraClone.model.User;
import edu.mum.project1.QuoraClone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProfileController {

    @Autowired
    private UserService userService;

    @RequestMapping(value= "/profile", method = RequestMethod.GET)
    public String profile(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        model.addAttribute("logged_name",  user.getName());
        model.addAttribute("logged_email",  user.getEmail());
        return "profile";
    }

}
