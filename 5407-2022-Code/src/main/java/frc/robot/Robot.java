// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Pneumatics;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();
  Inputs inputs = null;
  RobotBase robotBase = null;
  Shooter shooter = null;
  Intake intake = null;
  RobotClimb climb = null;
  Timer timer = null;


  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    inputs = new Inputs();	
    timer = new Timer();		
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);
    robotBase = new RobotBase();
    shooter = new Shooter();
    intake = new Intake();
    climb = new RobotClimb();

  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {}

  /**
   * This autonomous (along with the chooser code above) shows how to select between different
   * autonomous modes using the dashboard. The sendable chooser code works with the Java
   * SmartDashboard. If you prefer the LabVIEW Dashboard, remove all of the chooser code and
   * uncomment the getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to the switch structure
   * below with additional strings. If using the SendableChooser make sure to add them to the
   * chooser code above as well.
   */
  private double startTime;
  @Override
  public void autonomousInit() {
    startTime = Timer.getFPGATimestamp();
    m_autoSelected = m_chooser.getSelected();
    // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    System.out.println("Auto selected: " + m_autoSelected);
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
    double time = Timer.getFPGATimestamp();
    if (time - startTime < 2){
      RobotBase.motLeftDriveMotorA.set(ControlMode.PercentOutput, 0.8);
      RobotBase.motLeftDriveMotorB.set(ControlMode.PercentOutput, 0.8);
      RobotBase.motRightDriveMotorA.set(ControlMode.PercentOutput, -0.8);
      RobotBase.motRightDriveMotorB.set(ControlMode.PercentOutput, -0.8);
    } else if( time - startTime < 3){
      RobotBase.motLeftDriveMotorA.set(ControlMode.PercentOutput, 0.0);
      RobotBase.motLeftDriveMotorB.set(ControlMode.PercentOutput, 0.0);
      RobotBase.motRightDriveMotorA.set(ControlMode.PercentOutput, 0.0);
      RobotBase.motRightDriveMotorB.set(ControlMode.PercentOutput, 0.0);
    }else if(time-startTime < 5){
      Shooter.motShooter.set(-0.74);
    } else if (time - startTime< 7){
      Shooter.motShooter.set(0.0);
    }else if(time-startTime < 11) {
      RobotBase.motLeftDriveMotorA.set(ControlMode.PercentOutput, -0.8);
      RobotBase.motLeftDriveMotorB.set(ControlMode.PercentOutput, -0.8);
      RobotBase.motRightDriveMotorA.set(ControlMode.PercentOutput, 0.8);
      RobotBase.motRightDriveMotorB.set(ControlMode.PercentOutput, 0.8);
    } else{
      RobotBase.motLeftDriveMotorA.set(ControlMode.PercentOutput, 0.0);
      RobotBase.motLeftDriveMotorB.set(ControlMode.PercentOutput, 0.0);
      RobotBase.motRightDriveMotorA.set(ControlMode.PercentOutput, 0.0);
      RobotBase.motRightDriveMotorB.set(ControlMode.PercentOutput, 0.0);
    }

  }

  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() {
    Pneumatics.comp.enabled(); 
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    inputs.readValues();
    robotBase.update();
    shooter.update();
    //climb.update();
    //intake.update();


  }
  

  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {
    Pneumatics.comp.disable();
  }

  /** This function is called periodically when disabled. */
  @Override
  public void disabledPeriodic() {}

  /** This function is called once when test mode is enabled. */
  @Override
  public void testInit() {}

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}
}
