    package frc.robot;

    import edu.wpi.first.wpilibj.motorcontrol.Spark;


    public class Intake {

        static Spark motIntake = null; 
        Inputs input = null;

        public Intake(){

            motIntake = new Spark(RobotMap.intake_0_PWN_0);
            motIntake.set(0.0);

        }
        public void update() {

            if (input.intakeButton == true) {
                motIntake.set(input.motIntakePower);
            }
            else{
                motIntake.set(0.0);
            }

            if (input.intakeButtonInverse == true){
                motIntake.set(-(input.motIntakePower));
            }
            else{
                motIntake.set(0.0);
            }
        }
    }