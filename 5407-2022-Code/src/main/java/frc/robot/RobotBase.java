package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.motorcontrol.Spark;

public class RobotBase {

    Double dLeftDrivePower = 0.0;
    Double dRightDrivePower = 0.0;
    ApplyPower applyPower = null;
    Inputs inputs = null;

    Compressor mCompressor = null;
    Solenoid solShifter = null;
    Solenoid solClimb = null;
    Solenoid solIntake = null;

    int inverseTimes = 2;

    // Drive Motors
    static TalonFX motLeftDriveMotorA = null;
    static TalonFX motLeftDriveMotorB = null;
    static TalonFX motRightDriveMotorA = null;
    static TalonFX motRightDriveMotorB = null;

    static Spark motIntake = null;
    static Spark motIndex = null;
    static Spark motClimb = null;
    static CANSparkMax motShooter = null;

    boolean isNotPressed = true;

    public RobotBase(Inputs passedInputs) {

        inputs = passedInputs;

        motIntake = new Spark(RobotMap.intakePWN);
        motClimb = new Spark(RobotMap.climbPMW);
        motIndex = new Spark(RobotMap.indexPWN);
        motShooter = new CANSparkMax(RobotMap.kCANId_motShooter, CANSparkMaxLowLevel.MotorType.kBrushless);

        motClimb.set(0.0);
        motIntake.set(0.0);
        motIndex.set(0.0);

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

        if (mCompressor == null) {
            mCompressor = new Compressor(RobotMap.kCANId_PCM, RobotMap.kPCM_TYPE);
            mCompressor.enabled();
        }

        solShifter = new Solenoid(RobotMap.kPCM_TYPE, 0);
        solClimb = new Solenoid(RobotMap.kPCM_TYPE_climb, 1);
        solIntake = new Solenoid(RobotMap.kPCM_TYPE_intake, 2);

    }

    public void update() {
        double temp_drive_straight = 0;
        double temp_drive_turn = 0;
        temp_drive_straight = inputs.dDriverPower
                * Math.abs(inputs.dDriverPower * inputs.dDriverPower * inputs.dDriverPower);
        temp_drive_turn = inputs.dDriverTurn * Math.abs(inputs.dDriverTurn);

        if (inputs.robotBaseInverseButton == true && isNotPressed == true) {
            isNotPressed = false;
            inverseTimes += 1;
        }
        if (inputs.robotBaseInverseButton == false) {
            isNotPressed = true;

        }

        if (inverseTimes % 2 == 0) {
            dLeftDrivePower = applyPower.getWheelPower(ApplyPower.k_iLeftRearDrive, temp_drive_straight,
                    temp_drive_turn);
            dRightDrivePower = applyPower.getWheelPower(ApplyPower.k_iRightRearDrive, temp_drive_straight,
                    temp_drive_turn);
            motLeftDriveMotorA.set(ControlMode.PercentOutput, dLeftDrivePower);
            motLeftDriveMotorB.set(ControlMode.PercentOutput, dLeftDrivePower);
            motRightDriveMotorA.set(ControlMode.PercentOutput, -dRightDrivePower);
            motRightDriveMotorB.set(ControlMode.PercentOutput, -dRightDrivePower);
            // inputs.dDriverTurn *= -1;

        } else {
            dLeftDrivePower = applyPower.getWheelPower(ApplyPower.k_iLeftRearDrive, temp_drive_straight,
                    -temp_drive_turn);
            dRightDrivePower = applyPower.getWheelPower(ApplyPower.k_iRightRearDrive, temp_drive_straight,
                    -temp_drive_turn);
            motLeftDriveMotorA.set(ControlMode.PercentOutput, -dLeftDrivePower);
            motLeftDriveMotorB.set(ControlMode.PercentOutput, -dLeftDrivePower);
            motRightDriveMotorA.set(ControlMode.PercentOutput, dRightDrivePower);
            motRightDriveMotorB.set(ControlMode.PercentOutput, dRightDrivePower);
            // inputs.dDriverTurn *= -1;
        }

        motIntake.set(inputs.motIntakePower);
        motClimb.set(inputs.motClimbPower);
        motIndex.set(inputs.motIndexPower);
        solShifter.set(inputs.shifter);
        solClimb.set(inputs.climb_air);
        solIntake.set(inputs.intake_air);
        motShooter.set(inputs.motShooterPower);
    }
}
