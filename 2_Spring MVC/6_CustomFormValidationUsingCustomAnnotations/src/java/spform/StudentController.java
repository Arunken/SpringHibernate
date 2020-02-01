
package spform;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author SilverDoe
 */

@Controller
@RequestMapping("/student")
public class StudentController {
    
    @RequestMapping("/showForm")
    public String showForm(Model mymodel)
    {
        // create student object
        Student s = new Student();
        
        // add student object to model
        mymodel.addAttribute("student",s); // this key should be the modelAttribute of the form in the jsp page
        return "student-form";
    }
}
