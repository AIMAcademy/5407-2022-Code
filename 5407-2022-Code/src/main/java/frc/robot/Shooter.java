package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;


public class Shooter {
    
    CANSparkMax motShooter = null; 
    Inputs input = null;
    
    public Shooter(){

        motShooter = new CANSparkMax(RobotMap.kCANId_motShooter,CANSparkMaxLowLevel.MotorType.kBrushless);
        motShooter.set(0.0);

    }
    public void update() {

        if (input.shooterButton == true) {
            motShooter.set(input.motShooterPower);
        }
        else{
            motShooter.set(0.0);
        }
    }
}
