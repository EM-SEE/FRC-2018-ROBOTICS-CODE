package org.usfirst.frc.team772.robot.subsystems;

import org.usfirst.frc.team772.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class IntakeSubsystem extends Subsystem {

	public WPI_TalonSRX intake1Motor = new WPI_TalonSRX(5);
	public WPI_TalonSRX intake2Motor = new WPI_TalonSRX(6);
	// public static final LidarSubsystem intakeStop = new
	// LidarSubsystem(I2C.Port.kMXP);
	public DoubleSolenoid clamp = new DoubleSolenoid(RobotMap.PCM, RobotMap.intakeOpen, RobotMap.intakeClose);

	public IntakeSubsystem() {
		intake1Motor.follow(intake2Motor);

		// this inverts the intake motors if it's true
		intake1Motor.setInverted(true);//false
		intake2Motor.setInverted(false);//true
	}

	// public boolean getLaserStatus() {
	// return laser.get();
	//
	// }

	/**
	 * This sets the speed of the intake motors
	 * 
	 * @param speed
	 *            positive --> intake || negative --> outtake [-1 to 1]
	 */
	public void intakeSpeed(double speed) {
		intake2Motor.set(speed);
	}

	/**
	 * This clamps the intake when it is called
	 * 
	 * @param intake
	 *            true --> clamps intake || false --> unclamps intake
	 */
	public void clampIntake(boolean intake) {
		if (intake == true) {
			clamp.set(DoubleSolenoid.Value.kReverse);// This is forward (it is wierd I know the electrical leader
														// refuses to fix this)
		} else {
			clamp.set(DoubleSolenoid.Value.kForward);// This is reverse
		}
	}

	// // This method reads the intakeStopper's value and returns whether or not it
	// is
	// // near 0
	// public boolean cubeIn() {
	// if (intakeStop.getDistance() <= 5) {
	// return true;
	// } else {
	// return false;
	// }
	// }

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
