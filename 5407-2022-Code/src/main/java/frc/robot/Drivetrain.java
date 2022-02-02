// ROBOTBUILDER TYPE: Subsystem.

package frc.robot;

import edu.wpi.first.wpilibj2.command.*;
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
import com.ctre.phoenix.motorcontrol.can.TalonFX;

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
    private DifferentialDrive drive;
    private Encoder leftencoder;
    private Encoder rightencoder;
    private AnalogGyro gyro;
    private AnalogInput rangefinder;
    // TODO: rename to the correct motors

    // Drive trauin motors Names
    TalonFX motLeftDriveMotorB = null;
    TalonFX motRightDriveMotorA = null;
    TalonFX motRightDriveMotorB = null;
    TalonFX motLeftDriveMotorA = null;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    /**
    *
    */
    public Drivetrain() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        motLeftDriveMotorA = new TalonFX(RobotMap.kTalonId_LeftDriveMotorA);
        motLeftDriveMotorB = new TalonFX(RobotMap.ktalonId_LeftDriveMotorB);
        motRightDriveMotorA = new TalonFX(RobotMap.kTalonId_RightDriveMotorA);
        motRightDriveMotorB = new TalonFX(RobotMap.kTalonId_RightDriveMotorB);

        leftencoder = new Encoder(0, 1, false, EncodingType.k4X);
        addChild("left encoder", leftencoder);
        leftencoder.setDistancePerPulse(1.0);

        rightencoder = new Encoder(2, 3, false, EncodingType.k4X);
        addChild("right encoder", rightencoder);
        rightencoder.setDistancePerPulse(1.0);

        gyro = new AnalogGyro(0);
        addChild("gyro", gyro);
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
    // private final Drivetrain m_drivetrain;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // private Joystick leftJoystick = RobotContainer.getInstance().getJoystick1();
    // private Joystick rightJoystick = RobotContainer.getInstance().getJoystick2();

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

    // public TankDrive(Drivetrain subsystem) {
 
 
    //  // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    //      // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
 
    //  // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
    //      // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
 
    //      m_drivetrain = subsystem;
    //      addRequirements(m_drivetrain);
 
    //  // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    //  }

    // // Called when the command is initially scheduled.
    // @Override
    // public void initialize() {
    // }

    // // Called every time the scheduler runs while the command is scheduled.
    // @Override
    // public void execute() {
    //     m_drivetrain.drive(leftJoystick.getY(), rightJoystick.getY());
    // }

    // // Called once the command ends or is interrupted.
    // @Override
    // public void end(boolean interrupted) {
    //     m_drivetrain.drive0(.0, 0.0);
    // }

    // // Returns true when the command should end.
    // @Override
    // public boolean isFinished() {
    //     return false;
    // }

    // @Override
    // public boolean runsWhenDisabled() {
    //     // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DISABLED
    //     return false;

    //     // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DISABLED
    // }
}