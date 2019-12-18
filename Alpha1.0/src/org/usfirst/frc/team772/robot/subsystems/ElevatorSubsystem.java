package org.usfirst.frc.team772.robot.subsystems;

import org.usfirst.frc.team772.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ElevatorSubsystem extends Subsystem {

	public WPI_TalonSRX Elevator1Motor = new WPI_TalonSRX(7);
	public DoubleSolenoid brakes = new DoubleSolenoid(RobotMap.PCM, RobotMap.elevatorBrakeOn,
			RobotMap.elevatorBrakeOff);

	/**
	 * This configures all of the subsystem dependencies like pid and encoders for
	 * the Elevator on the robot
	 */
	public ElevatorSubsystem() {
		Elevator1Motor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 10);
		Elevator1Motor.setSensorPhase(true);
		Elevator1Motor.setInverted(true);

		Elevator1Motor.config_kF(0, 0.32, 10);
		Elevator1Motor.config_kP(0, 10, 10);
		Elevator1Motor.config_kI(0, 0.05, 10);
		Elevator1Motor.config_kD(0, 0, 10);

		Elevator1Motor.configMotionCruiseVelocity(RobotMap.elevatorSpeed, 10);
		Elevator1Motor.configMotionAcceleration(RobotMap.elevatorAccel, 10);

	}

	/**
	 * This method RETURNS the value of the encoders of the elevator
	 */
	public double getElevatorEnc() {
		return Elevator1Motor.getSelectedSensorPosition(0);
	}

	/**
	 * This method RESETS the encoder value of the elevator
	 */
	public void resetElevatorEncoders() {
		Elevator1Motor.setSelectedSensorPosition(0, 0, 10);
	}

	/**
	 * This method sets the speed of the elevator
	 * 
	 * @param speed
	 *            The speed that is outputted to the elevator motor [-1 to 1]
	 */
	public void elevatorSpeed(double speed) {
		Elevator1Motor.set(speed);
	}

	/**
	 * This method enables/disables the brakes on the elevator
	 * 
	 * @param deployBrakes
	 *            true --> enables brakes || false --> disables brakes
	 */
	public void brake(boolean deployBrakes) {
		if (deployBrakes == true) {
			brakes.set(DoubleSolenoid.Value.kForward);
		} else {
			brakes.set(DoubleSolenoid.Value.kReverse);
		}
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
