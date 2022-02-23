    package frc.robot;
    import com.revrobotics.CANSparkMax;
    import com.revrobotics.CANSparkMaxLowLevel;


    public class Intake {

        CANSparkMax motIntake = null; 
        Inputs input = null;

        public Intake(){

            motIntake = new CANSparkMax(RobotMap.kCanId_motIntake,CANSparkMaxLowLevel.MotorType.kBrushless);
            motIntake.set(0.0);

        }
        public void update() {

            if (input.intakeButton == true) {
                motIntake.set(input.motIntakePower);
            }
            else{
                motIntake.set(0.0);
            }
        }
    }