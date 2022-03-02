package frc.robot;

import edu.wpi.first.util.sendable.Sendable;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;

public class Pneumatics {

    static Compressor comp = new Compressor(PneumaticsModuleType.CTREPCM); 
    DoubleSolenoid solenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 1); 

    public Pneumatics() {

    }
    public void update() {
        if(Inputs.PneunamticsLeftButton) {
            solenoid.set(DoubleSolenoid.Value.kForward);
        } else if(Inputs.PneunamticsRightButton) {
            solenoid.set(DoubleSolenoid.Value.kReverse);
        } else {
            //comp.disable();
        }
    }
}
