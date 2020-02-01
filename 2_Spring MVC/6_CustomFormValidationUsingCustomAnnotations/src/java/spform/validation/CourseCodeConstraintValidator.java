/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spform.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author SilverDoe
 */
class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String>{

    private String coursePrefix;
    
    @Override
    public void initialize(CourseCode cc) {
        coursePrefix = cc.value();
    }

    @Override
    public boolean isValid(String thecode, ConstraintValidatorContext cvalidatorContext) {
        
        boolean result;
        
        if(thecode!=null)
        {
            result = thecode.startsWith(coursePrefix);
        }
        else
        {
            result = true;
        }
        return result;
    }
    
}
