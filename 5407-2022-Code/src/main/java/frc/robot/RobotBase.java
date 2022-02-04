package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

public class RobotBase {

    Double dLeftDrivePower = 0.0;
    Double dRightDrivePower = 0.0;
    ApplyPower applyPower = null;
    Inputs inputs = null;


    //Drive Motors
    TalonFX motLeftDriveMotorA = null;
	TalonFX motLeftDriveMotorB = null;
	TalonFX motRightDriveMotorA = null;
	TalonFX motRightDriveMotorB = null;


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
        dLeftDrivePower = applyPower.getWheelPower(ApplyPower.k_iLeftRearDrive, Inputs.dDriverPower,
                Inputs.dDriverTurn);
        dRightDrivePower = applyPower.getWheelPower(ApplyPower.k_iRightRearDrive,Inputs.dDriverPower,
                Inputs.dDriverTurn);

        motLeftDriveMotorA.set(ControlMode.PercentOutput, dLeftDrivePower);
        motLeftDriveMotorB.set(ControlMode.PercentOutput, dLeftDrivePower);
        motRightDriveMotorA.set(ControlMode.PercentOutput, -dRightDrivePower);
        motRightDriveMotorB.set(ControlMode.PercentOutput, -dRightDrivePower);

    }

}
