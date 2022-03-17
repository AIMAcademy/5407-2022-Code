package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;

/**********************************************************************
 * Inputs Class -- This is used to collect all human input or what is considered input for the robot.
 *<p>
 *Here we will document how the joysticks accept the human input
 *
 * <pre>
 *     Source     Range     Usage
 * 
 * Driver Turn     Axis     -1 to 1
 * 
 * </pre>  
 */

//import edu.wpi.first.wpilibj.GenericHID.Hand;
public class Inputs {
    // Controller
    private XboxController gamepadDriver = null;
    private XboxController gamepadOperator = null;
    // private XboxController gamepadDriver = null;
    public Joystick joyTestController = null;

    // Motor Power
    public double dDriverPower = 0.0;
    public double dDriverTurn = 0.0;
    public double motShooterPower = 0.0;
    public double motIntakePower = 0.0;
    public double motClimbPower = 0;
    public boolean robotBaseInverseButton = false;
    public boolean PneunamticsRightButton = false;
    public boolean PneunamticsLeftButton = false;
    public double shooterButton = 0.0;
    public double indexButton = 0.0;
    public double motIndexPower = 0.0;
    public boolean intake_air = false;
    public boolean climb_air = false;

    public boolean shifter = false;


    // What is the end game
    public boolean bInEndGame = false;
    public boolean bSpeed = false;


    public Inputs() {
        joyTestController = new Joystick(RobotMap.kUSBPort_TestJoyStick);
        gamepadDriver = new XboxController(RobotMap.kUSBPort_DriverControl);
        gamepadOperator = new XboxController(RobotMap.kUSBPort_OperatorControl);

        zeroInputs(); // this will init many variables
    }

    public void readValues() {
        // if(joyTestController.getTop() == true){
        // iGyroRequest = Gyro.kGyro_Assist;
        // }
        // I need to read up on what this does
        shooterButton = gamepadOperator.getLeftTriggerAxis();
        indexButton = gamepadOperator.getRightTriggerAxis();

        //Intake
        if (gamepadOperator.getXButton()) {
            motIntakePower = -0.75;
        } else if (gamepadOperator.getBButton()) {
            motIntakePower = 0.75;
        } else {
            motIntakePower = 0;
        }

        if (gamepadOperator.getPOV() == 180) {
            motClimbPower = 1;
        }
        else if (gamepadOperator.getPOV() == 0) {
            motClimbPower = -1;
        }
        else {
            motClimbPower = 0;
        }

        if(indexButton != 0.0){
            motIndexPower = indexButton * Math.abs(indexButton * indexButton * indexButton);
        } else{
            motIndexPower = 0.0;
        }

        if (shooterButton !=0.0) {
            motShooterPower = -.86;
        }
        else{
            motShooterPower = 0.0;

        shifter = gamepadDriver.getRightBumper();

        if (gamepadOperator.getPOV() == 90){
            climb_air = true;
        }
        else if(gamepadOperator.getPOV() == 270){
            climb_air = false;

        }
        if (PneunamticsLeftButton == true){
            intake_air = false;
        }
        else if(PneunamticsRightButton == true){
            intake_air = true;
        }


        PneunamticsLeftButton = gamepadOperator.getLeftBumper();
        PneunamticsRightButton = gamepadOperator.getRightBumper();

        dDriverPower = gamepadDriver.getRightY();
        dDriverTurn = gamepadDriver.getLeftX();
        robotBaseInverseButton = gamepadDriver.getBButton();

        }
    }
    public void zeroInputs() { // reset all variables to stop or off state
    }
}
