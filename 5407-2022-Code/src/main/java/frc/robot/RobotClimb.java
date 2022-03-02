package frc.robot;

import edu.wpi.first.wpilibj.motorcontrol.Spark;


public class RobotClimb{
    
    static Spark motClimb = null; 
    
    public RobotClimb() {

        motClimb = new Spark(RobotMap.climb_PMW_2);
        motClimb.set(0.0);

    }
    public void update() {

        if (Inputs.climb_POV == 0) {
            motClimb.set(Inputs.motClimbPower);
        }
        else if (Inputs.climb_POV == 180){
            motClimb.set(-(Inputs.motClimbPower));
        }
        else{
        motClimb.set(0.0);
        }
    }
}
