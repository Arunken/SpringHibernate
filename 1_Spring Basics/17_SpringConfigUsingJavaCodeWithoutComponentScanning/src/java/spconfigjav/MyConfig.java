/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spconfigjav;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author SilverDoe
 */

@Configuration // Configuration class
public class MyConfig {
    // defining beans manually in config(this class) instead of automatically creating using component scanning
    // define bean for HappyFortuneService
    @Bean
    public FortuneService happyFortuneService()
    {
        return new HappyFortuneService();
    }
    
    // define bean for TennisCoach and inject dependency
    @Bean 
    public Coach tennisCoach() // this method name will be the bean id registered in spring container
    {
        TennisCoach tc = new TennisCoach(happyFortuneService());
        return tc;
    }
    
}
