package org.usfirst.frc.team772.robot.subsystems;

import org.usfirst.frc.team772.robot.Robot;
import org.usfirst.frc.team772.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class DriveSubsystem extends Subsystem {

	private static final int kPIDLoopIdx = 0;

	// Here, a gyro object is being created
	public ADXRS450_Gyro gyro = new ADXRS450_Gyro();

	// Here is a gear shift solenoid object
	DoubleSolenoid gearShift = new DoubleSolenoid(RobotMap.PCM, RobotMap.shotPinForward, RobotMap.shotPinReverse);

	// Here, speed controller objects are being created
	public WPI_TalonSRX frontRightMotor = new WPI_TalonSRX(1);
	public WPI_TalonSRX frontLeftMotor = new WPI_TalonSRX(3);
	public WPI_TalonSRX backRightMotor = new WPI_TalonSRX(2);
	public WPI_TalonSRX backLeftMotor = new WPI_TalonSRX(4);

	// Creating a DifferentialDrive object
	public DifferentialDrive robotDrive;

	/**
	 * Constructor. Inverts Motors. Sets up the Drive System of Robot.
	 */

	public DriveSubsystem() {

		// Here the motors are being inverted
		frontRightMotor.setInverted(RobotMap.frontRightMotorInverted);
		backRightMotor.setInverted(RobotMap.backRightMotorInverted);
		frontLeftMotor.setInverted(RobotMap.frontLeftMotorInverted);
		backLeftMotor.setInverted(RobotMap.backLeftMotorInverted);

		// Slave motors
		backRightMotor.follow(frontRightMotor);
		backLeftMotor.follow(frontLeftMotor);

		// the time out is 10 ms
		int kTimeoutMs = 10;

		// Sets the encoders in the drive subsystem
		frontRightMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, kTimeoutMs);
		frontLeftMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, kTimeoutMs);
		//
		frontRightMotor.setSensorPhase(true);
		frontLeftMotor.setSensorPhase(false);// tell doug about this

//		/* set closed loop gains in slot0 */
//		frontRightMotor.config_kF(kPIDLoopIdx, 0.32, kTimeoutMs);
//		frontRightMotor.config_kP(kPIDLoopIdx, 0.1, kTimeoutMs);
//		frontRightMotor.config_kI(kPIDLoopIdx, 0, kTimeoutMs);
//		frontRightMotor.config_kD(kPIDLoopIdx, 0, kTimeoutMs);
//		//
//		frontLeftMotor.config_kF(kPIDLoopIdx, 0.32, kTimeoutMs);
//		frontLeftMotor.config_kP(kPIDLoopIdx, 0.1, kTimeoutMs);
//		frontLeftMotor.config_kI(kPIDLoopIdx, 0, kTimeoutMs);
//		frontLeftMotor.config_kD(kPIDLoopIdx, 0, kTimeoutMs);
//
//		frontRightMotor.configMotionCruiseVelocity(1200, kTimeoutMs);// units are encoder pulses/ 100ms
//		frontRightMotor.configMotionAcceleration(3600, kTimeoutMs);// encoder pulses /100ms/s
//		//
//		frontLeftMotor.configMotionCruiseVelocity(1200, kTimeoutMs);
//		frontLeftMotor.configMotionAcceleration(3600, kTimeoutMs);

		// This is initializing the robotDrive object
		robotDrive = new DifferentialDrive(frontLeftMotor, frontRightMotor);

		// Enabling safety for the robot
		robotDrive.setSafetyEnabled(false);

	}

	/**
	 * This allows the robot to switch the drive mode to coast mode
	 */
	public void setCoastMode() {
		frontRightMotor.setNeutralMode(NeutralMode.Coast);
		frontLeftMotor.setNeutralMode(NeutralMode.Coast);
		backRightMotor.setNeutralMode(NeutralMode.Coast);
		backLeftMotor.setNeutralMode(NeutralMode.Coast);
	}

	/**
	 * This allows the robot to switch the drive mode to brake mode
	 */
	public void setBrakeMode() {
		frontRightMotor.setNeutralMode(NeutralMode.Brake);
		frontLeftMotor.setNeutralMode(NeutralMode.Brake);
		backRightMotor.setNeutralMode(NeutralMode.Brake);
		backLeftMotor.setNeutralMode(NeutralMode.Brake);
	}

	/**
	 * This allows the robot to drive using arcade drive in teleop
	 * 
	 * @param joystick
	 *            Takes in a xbox controller object to read values from
	 * @param speed
	 *            Takes in the sensitivity of the joystick [-1 to 1]
	 */
	public void drive(Joystick joystick, double speed) {
		robotDrive.arcadeDrive(joystick.getY() * speed, -joystick.getX());
	}

	/**
	 * This allows the robot to drive using arcade drive in autonomous
	 * 
	 * @param forwardSpeed
	 *            this is the value that is put into the motors to drive forwards
	 *            [-1 to 1]
	 * @param rotationSpeed
	 *            this is the value that is put in to the motors to turn the
	 *            robot[-1 to 1]
	 */
	public void auto(double forwardSpeed, double rotationSpeed) {
		robotDrive.arcadeDrive(-forwardSpeed, rotationSpeed);
	}

	/**
	 * This allows the robot to drive using the encoders of the left and right side
	 * in autonomous using Magic Motion
	 * 
	 * @param distance
	 *            Takes in the distance needed to travel in encoder ticks
	 */
	public boolean AtLineLeft(double lowVolt, double highVolt) {
		if(Robot.lightSensorLeft.getVoltage() >= lowVolt && Robot.lightSensorLeft.getVoltage() <= highVolt){
			return true;
		}
		else {
			return false;
		}
	}
	public boolean AtLineRight(double lowVolt, double highVolt) {
		if(Robot.lightSensorRight.getVoltage() >= lowVolt && Robot.lightSensorRight.getVoltage() <= highVolt){
			return true;
		}
		else {
			return false;
		}
	}
	
	public void AutoDriveWithEnc(double distance) {
		resetEncoders();
		frontRightMotor.set(ControlMode.Position, getRightEnc() + distance);
		frontLeftMotor.set(ControlMode.Position, getLeftEnc() + distance);
	}

	public void AutoDriveWithEncStop() {
		frontRightMotor.set(ControlMode.PercentOutput, 0);
		frontLeftMotor.set(ControlMode.PercentOutput, 0);// try with disabled
	}

	public boolean inPosition() {
		if ((Math.abs(frontLeftMotor.getClosedLoopError(0)) <= 100)
				&& (frontLeftMotor.getControlMode() == ControlMode.Position)) {
			return false;
		} else {
			return false;
		}

	}

	/**
	 * This returns the value of the right encoder of the robot
	 */
	public double getRightEnc() {
		// This encoder is inverted so the inversion is set in the constructor
		return frontRightMotor.getSelectedSensorPosition(0);
	}

	/**
	 * This returns the value of the left encoder of the robot
	 */
	public double getLeftEnc() {
		return frontLeftMotor.getSelectedSensorPosition(0);
	}

	/**
	 * This returns the encoder average in inches
	 */
	public double getEncAve() {
		return ((getRightEnc() + getLeftEnc()) / 2) / RobotMap.DRIVE_CONVERTION_FACTOR;
	}

	/**
	 * This method resets the drive encoders' position to 0
	 */
	public void resetEncoders() {
		frontRightMotor.setSelectedSensorPosition(0, 0, 10);
		frontLeftMotor.setSelectedSensorPosition(0, 0, 10);
	}

	/**
	 * This returns the value of the front ultrasonic in inches
	 */
//	public double getUltrasonicFront() {
//		return Robot.ultrasonicForward.getRangeInches();
//	}

	/**
	 * This returns the angle of the robot in degrees
	 */
	public double getDegrees() {

		if (gyro.getAngle() > 360) {
			return -(gyro.getAngle() - 360);
		} else if (gyro.getAngle() < -360) {
			return -(gyro.getAngle() + 360);
		} else {
			return -gyro.getAngle();
		}

	}

	/**
	 * This method resets the gyro to 0
	 */
	public void resetGyro() {
		gyro.reset();
	}

	/**
	 * The robot is switched to high gear when this is called
	 */
	public void highGear() {
		gearShift.set(DoubleSolenoid.Value.kForward);
	}

	/**
	 * The robot is switched to low gear when this is called
	 */
	public void lowGear() {
		gearShift.set(DoubleSolenoid.Value.kReverse);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
