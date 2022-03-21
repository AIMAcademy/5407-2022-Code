package frc.robot;

import edu.wpi.first.wpilibj.PneumaticsModuleType;

class RobotMap {

    public final static int kCANId_PCM = 0;  
    public final static PneumaticsModuleType kPCM_TYPE = PneumaticsModuleType.CTREPCM;   
    public final static PneumaticsModuleType kPCM_TYPE_climb = PneumaticsModuleType.CTREPCM;   
    public final static PneumaticsModuleType kPCM_TYPE_intake = PneumaticsModuleType.CTREPCM;   
    public final static PneumaticsModuleType kPCM_TYPE_climbRelease = PneumaticsModuleType.CTREPCM;   

    //Drive train motors
    public final static int kTalonId_RightDriveMotorA = 1;
    public final static int kTalonId_RightDriveMotorB = 2;
    public final static int kTalonId_LeftDriveMotorA = 3;
    public final static int kTalonId_LeftDriveMotorB = 4;

    //Shooter motor
    public final static int kCANId_motShooter = 5;
    public final static int kCanId_motClimb = 7;
    //USB Ports
    public final static int kUSBPort_DriverControl = 0; 
    public final static int kUSBPort_OperatorControl = 1;
    public final static int kUSBPort_TestJoyStick = 3;

    public static final int intakePWN = 0;
    public static final int indexPWN = 1;

    public static final int climbPMW = 2;

}