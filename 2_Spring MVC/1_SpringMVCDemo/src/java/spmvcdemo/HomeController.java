/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spmvcdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author SilverDoe
 */

@Controller
public class HomeController {
    
    @RequestMapping("/")
    public String showPage()
    {
        return "mainpage"; // view resolver in dispatcher-servlet.xml will prefix file path and suffix extension(.jsp)
    }
    
}
