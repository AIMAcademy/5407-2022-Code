package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;


public class Shooter {
    
    static CANSparkMax motShooter = null; 
    
    public Shooter(){

        motShooter = new CANSparkMax(RobotMap.kCANId_motShooter,CANSparkMaxLowLevel.MotorType.kBrushless);
        motShooter.set(0.0);

    }
    public void update() {

        if (Inputs.shooterButton == true) {
            motShooter.set(Inputs.motShooterPower);
        }
        else{
            motShooter.set(0.0);
        }
    }
}
