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
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Inputs {
    // Controller
    private XboxController gamepadOperator = null;
    // private XboxController gamepadDriver = null;
    public Joystick joyTestController = null;

    // Motor Power
    public static double dDriverPower = 0.0;
    public static double dDriverTurn = 0.0;
    public boolean shooterButton = false;
    public double motShooterPower = .8;

    //What is the end game
    public boolean bInEndGame  = false;
    public boolean bSpeed = false;

    private Drivetrain drivetrain = new Drivetrain();

    public Inputs() {
        joyTestController = new Joystick(RobotMap.kUSBPort_TestJoyStick);
        // gamepadDriver = new XboxController(RobotMap.kUSBPort_DriverControl );
        gamepadOperator = new XboxController(RobotMap.kUSBPort_OperatorControl);
        zeroInputs(); // this will init many variables
    }

    public void readValues() {
        // if(joyTestController.getTop() == true){
        // iGyroRequest = Gyro.kGyro_Assist;
        // }
        // I need to read up on what this does
        shooterButton = gamepadOperator.getXButton();
        dDriverPower = gamepadOperator.getRightX();
        dDriverTurn = gamepadOperator.getLeftY();

        // else if (joystickDegrees == 270) {
        // dLeftDriveMotorPower = -0.5;
        // dRightDriveMotorPower = -0.5;
        // } else if (joystickDegrees == 360) {
        // dLeftDriveMotorPower = 0.5;
        // dRightDriveMotorPower = -0.5;
        // }
    }

    public void zeroInputs() { // reset all variables to stop or off state
    }
}