/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spmvcform;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author SilverDoe
 */

@Controller
@RequestMapping("/")
public class FormController {
    
    @RequestMapping //or @RequestMapping("/")
    public String showMainPage()
    {
        return "mainpage";
    }
    
    @RequestMapping("/showForm")
    public String showForm()
    {
        return "myform";
    }
    
    @RequestMapping("/processForm")
    public String processForm()
    {
        return "helloworld";
    }
    
}
