/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spform;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import spform.validation.CourseCode;

/**
 *
 * @author SilverDoe
 */
public class Customer {
    
    
    private String firstName;
    
    @NotNull(message="is required")
    @Size(min=1,message="is required")
    private String lastName;
    
    @NotNull(message="is required")
    @Min(value=0,message="must be greater than or equal to zero")
    @Max(value=10,message="must be less than or equal to 10")
    private Integer freePasses;

    @Pattern(regexp="[A-za-z0-9]{6}", message="exactly 6 chars/digits")
    private String postalCode;
    
    @CourseCode(value = "GCEK", message = "must start with GCEK") // adding custom annotation <<<<<<<<<<<<<<<. Take a look at the validation package
    private String courseCode;
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
    
    

    public Customer() {
    }
    
}
