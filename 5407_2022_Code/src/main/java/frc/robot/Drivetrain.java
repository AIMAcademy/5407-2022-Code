// ROBOTBUILDER TYPE: Subsystem.

package frc.robot.subsystems;


import frc.robot.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.TalonFX;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class Drivetrain extends SubsystemBase {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS
public static final double PlaceDistance = 0.1;
public static final double BackAwayDistance = 0.6;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
private TalonFX left1;
private TalonFX left2;
private MotorControllerGroup leftMotor;
private TalonFX right1;
private TalonFX right2;
private MotorControllerGroup rightMotor;
private DifferentialDrive drive;
private Encoder leftencoder;
private Encoder rightencoder;
private AnalogGyro gyro;
private AnalogInput rangefinder;
//TODO: rename to the correct motors

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    /**
    *
    */
    public Drivetrain() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
left1 = new TalonFX(0);
 addChild("left1",left1);
 left1.setInverted(false);

left2 = new TalonFX(1);
 addChild("left2",left2);
 left2.setInverted(false);

leftMotor = new MotorControllerGroup(left1, left2  );
 addChild("Left Motor",leftMotor);


right1 = new TalonFX(5);
 addChild("right1",right1);
 right1.setInverted(false);

right2 = new TalonFX(6);
 addChild("right2",right2);
 right2.setInverted(false);

rightMotor = new MotorControllerGroup(right1, right2  );
 addChild("Right Motor",rightMotor);

 motLeftDriveMotorA = new TalonFX(RobotMap.kCANId_RightDriveMotorA);
		motLeftDriveMotorB = new TalonFX(RobotMap.kCANId_RightDriveMotorB);
		motRightDriveMotorA = new TalonFX(RobotMap.kCANId_LeftDriveMotorA);
		motRightDriveMotorB = new TalonFX(RobotMap.kCANId_LeftDriveMotorB);


drive = new DifferentialDrive(leftMotor, rightMotor);
 addChild("Drive",drive);
 drive.setSafetyEnabled(true);
drive.setExpiration(0.1);
drive.setMaxOutput(1.0);


leftencoder = new Encoder(0, 1, false, EncodingType.k4X);
 addChild("left encoder",leftencoder);
 leftencoder.setDistancePerPulse(1.0);

rightencoder = new Encoder(2, 3, false, EncodingType.k4X);
 addChild("right encoder",rightencoder);
 rightencoder.setDistancePerPulse(1.0);

gyro = new AnalogGyro(0);
 addChild("gyro",gyro);
 gyro.setSensitivity(0.007);

rangefinder = new AnalogInput(1);
 addChild("range finder", rangefinder);



    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run

    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run when in simulation

    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void drive(double left, double right) {
        drive.tankDrive(left, right);
    }

     // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
     private final Drivetrain m_drivetrain;

     // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
     private Joystick leftJoystick = RobotContainer.getInstance().getJoystick1();
     private Joystick rightJoystick = RobotContainer.getInstance().getJoystick2();
 
     // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
 
 
     public TankDrive(Drivetrain subsystem) {
 
 
     // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
         // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
 
     // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
         // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
 
         m_drivetrain = subsystem;
         addRequirements(m_drivetrain);
 
     // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
     }
 
     // Called when the command is initially scheduled.
     @Override
     public void initialize() {
     }
 
     // Called every time the scheduler runs while the command is scheduled.
     @Override
     public void execute() {
         m_drivetrain.drive(leftJoystick.getY(), rightJoystick.getY());
     }
 
     // Called once the command ends or is interrupted.
     @Override
     public void end(boolean interrupted) {
         m_drivetrain.drive(0.0, 0.0);
     }
 
     // Returns true when the command should end.
     @Override
     public boolean isFinished() {
         return false;
     }
 
     @Override
     public boolean runsWhenDisabled() {
         // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DISABLED
         return false;
 
     // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DISABLED
     }
}