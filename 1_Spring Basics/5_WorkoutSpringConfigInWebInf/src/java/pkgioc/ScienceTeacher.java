/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgioc;

/**
 *
 * @author arken
 */
public class ScienceTeacher implements Teacher{

    @Override
    public String teach() {
        return "teaches science";
    }

    @Override
    public String motivate() {
        return "motivates with news related to scientific discoveries";
    }
    
}
