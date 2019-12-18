package org.usfirst.frc.team772.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LifterSubsystem extends Subsystem {
	
	WPI_TalonSRX climberMotor = new WPI_TalonSRX(8);
	WPI_TalonSRX hookMotor = new WPI_TalonSRX(9);

	/**
	 * This sets up the lifter subsystem
	 */
	public LifterSubsystem() {
		hookMotor.setInverted(false);
	}
	
	/**
	 * This sets the speed of the hook motor
	 * 
	 * @param speed The speed that is used to turn the hook motors [-1 to 1]
	 */
	public void moveHook(double speed) {
		hookMotor.set(speed);
	}
	
	/**
	 * This sets the speed of the climber motor
	 * 
	 * @param speed The speed that is used to turn the climber motor[-1 to 1]
	 */
	public void moveClimber(double speed) {
		climberMotor.set(speed);
	}
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

