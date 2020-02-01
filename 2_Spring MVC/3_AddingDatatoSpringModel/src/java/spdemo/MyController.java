/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spdemo;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author SilverDoe
 */
@Controller
public class MyController {
    
    @RequestMapping("/")
    public String showInputPage()
    {
        return "formpage";
    }
    
    @RequestMapping("/respage")
    public String resultPage(HttpServletRequest request,Model model) // or use annotation as parameter (@RequestParam("uname") String username, Model model) 
    {
        
        String username = request.getParameter("uname");
        model.addAttribute("message", username);
        
        return "resultpage";
    }
    
}
