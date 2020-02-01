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
public class MathTeacher implements Teacher{

    MotivationService ms;
    
    public MathTeacher(MotivationService mse)
    {
        ms = mse;
    }
    
    @Override
    public String teach() {
        return "teaches mathematics";
    }

    @Override
    public String motivate() {
        return  ms.getmotivation();
    }
    
}
