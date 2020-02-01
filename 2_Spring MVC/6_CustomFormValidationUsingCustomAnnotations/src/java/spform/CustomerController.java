
package spform;

import javax.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author SilverDoe
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {
    
    @RequestMapping("/showForm")
    public String showForm(Model myModel)
    {
        myModel.addAttribute("customer", new Customer());
        
        return "customer-form";
    }
    
    @RequestMapping("/processForm")// going to validate customer form
    public String processForm(@Valid @ModelAttribute("customer") Customer cobj, 
            BindingResult bindingResult)
    {
        System.out.println("Last Name : |"+cobj.getLastName()+"|");
        System.out.println("Binding result : "+bindingResult); // contains the error codes and info
        System.out.println("\n\n\n\n");
        if(bindingResult.hasErrors())
        {
            return "customer-form";
        }
        return "customer-confirmation";
    }
    
    @InitBinder // pre-process all web requests coming into our controller
    public void initBinder(WebDataBinder dataBinder)
    {
        StringTrimmerEditor ste = new StringTrimmerEditor(true); // object that can be used to trim the white spaces
        dataBinder.registerCustomEditor(String.class, ste);// removes white spaces
    }
}
