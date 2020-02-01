
package spdemo;

/**
 *
 * @author arken
 */
public class MyApp { 
    
    public static void main(String[] args) {
        Coach bc = new TrackCoach(); // hardcoded. This part is not configurable through a config file.
        
        System.out.println(bc.getDailyWorkout());
    }
}
