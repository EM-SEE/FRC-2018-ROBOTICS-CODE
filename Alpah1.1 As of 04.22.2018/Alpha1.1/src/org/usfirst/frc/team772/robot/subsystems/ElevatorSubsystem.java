package org.usfirst.frc.team772.robot.subsystems;

import org.usfirst.frc.team772.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ElevatorSubsystem extends Subsystem {

	public WPI_TalonSRX Elevator1Motor = new WPI_TalonSRX(7);
//	public WPI_TalonSRX Elevator2Motor = new WPI_TalonSRX(8);
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
//		Elevator2Motor.setInverted(true);


		Elevator1Motor.config_kF(0, 0.36, 10);   //was 0.32
		Elevator1Motor.config_kP(0, 4, 10);
		Elevator1Motor.config_kI(0, 0.07, 10);  //was 0.05
		Elevator1Motor.config_kD(0, 0, 10);

		Elevator1Motor.configMotionCruiseVelocity(RobotMap.ELEVATOR_SPEED, 10);
		Elevator1Motor.configMotionAcceleration(RobotMap.ELEVATOR_ACCEL, 10);
		
//		Elevator2Motor.follow(Elevator1Motor);

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
