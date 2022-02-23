package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;


public class RobotClimb{
    
    static CANSparkMax motClimb = null; 
    
    public RobotClimb() {

        motClimb = new CANSparkMax(RobotMap.kCanId_motClimb,CANSparkMaxLowLevel.MotorType.kBrushless);
        motClimb.set(0.0);

    }
    public void update() {

        if (Inputs.climbButton == true) {
            motClimb.set(Inputs.motShooterPower);
        }
        else{
            motClimb.set(0.0);
        }
    }
}
