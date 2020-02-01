
package spform.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;


/**
 *
 * @author SilverDoe
 */

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD}) // the annotation can be applied on methods and fields
@Retention(RetentionPolicy.RUNTIME)// Retain this annotation in the bytecode and also use it at runtime by the JVM
public @interface CourseCode {
    
    
    public String value() default "LUV";
    
    public String message() default "must start with LUV";
    
    public Class<?>[] groups() default {};
    
    public Class<? extends Payload>[] payload() default {};
}
