package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

public class RobotBase {

    Double dLeftDrivePower = 0.0;
    Double dRightDrivePower = 0.0;
    ApplyPower applyPower = null;
    Inputs inputs = null;

    int inverseTimes = 2;

    //Drive Motors
    static TalonFX motLeftDriveMotorA = null;
	static TalonFX motLeftDriveMotorB = null;
	static TalonFX motRightDriveMotorA = null;
	static TalonFX motRightDriveMotorB = null;
    boolean isNotPressed = true;


    public RobotBase() {

        applyPower = new ApplyPower();

		motLeftDriveMotorA = new TalonFX(RobotMap.kTalonId_RightDriveMotorA);
		motLeftDriveMotorB = new TalonFX(RobotMap.kTalonId_RightDriveMotorB);
		motRightDriveMotorA = new TalonFX(RobotMap.kTalonId_LeftDriveMotorA);
		motRightDriveMotorB = new TalonFX(RobotMap.kTalonId_LeftDriveMotorB);
        
		motLeftDriveMotorA.setNeutralMode(NeutralMode.Brake);
		motLeftDriveMotorB.setNeutralMode(NeutralMode.Brake);
		motRightDriveMotorA.setNeutralMode(NeutralMode.Brake);
		motRightDriveMotorB.setNeutralMode(NeutralMode.Brake);

        
        motLeftDriveMotorA.set(ControlMode.PercentOutput, 0.0);
		motLeftDriveMotorB.set(ControlMode.PercentOutput, 0.0);
		motRightDriveMotorA.set(ControlMode.PercentOutput, 0.0);
		motRightDriveMotorB.set(ControlMode.PercentOutput, 0.0);

    }

    public void update() {
        double temp_drive_straight = 0;
        temp_drive_straight = Inputs.dDriverPower * Math.abs(Inputs.dDriverPower * Inputs.dDriverPower * Inputs.dDriverPower);
        
        dLeftDrivePower = applyPower.getWheelPower(ApplyPower.k_iLeftRearDrive, temp_drive_straight,
                Inputs.dDriverTurn);
        dRightDrivePower = applyPower.getWheelPower(ApplyPower.k_iRightRearDrive,temp_drive_straight,
                Inputs.dDriverTurn);
        if (Inputs.robotBaseInverseButton == true && isNotPressed == true){
            isNotPressed = false;
            inverseTimes+=1;
        } 
        if (Inputs.robotBaseInverseButton == false){
            isNotPressed = true;
            
        } 

        if (inverseTimes%2 == 0){  
            motLeftDriveMotorA.set(ControlMode.PercentOutput, dLeftDrivePower);
            motLeftDriveMotorB.set(ControlMode.PercentOutput, dLeftDrivePower);
            motRightDriveMotorA.set(ControlMode.PercentOutput, -dRightDrivePower);
            motRightDriveMotorB.set(ControlMode.PercentOutput, -dRightDrivePower);

        } else{
            motLeftDriveMotorA.set(ControlMode.PercentOutput, -dLeftDrivePower);
            motLeftDriveMotorB.set(ControlMode.PercentOutput, -dLeftDrivePower);
            motRightDriveMotorA.set(ControlMode.PercentOutput, dRightDrivePower);
            motRightDriveMotorB.set(ControlMode.PercentOutput, dRightDrivePower);
        }
    }
}
