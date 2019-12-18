package org.usfirst.frc.team772.robot.commands;

import org.usfirst.frc.team772.robot.Robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ManualElevatorCommand extends Command {

	double speed;

	/**
	 * The elevator is manually controlled using a set speed. (This one is updated
	 * with rumble)
	 * 
	 * @param speed
	 *            The speed to set the elevator at [-1 to 1]
	 */
	public ManualElevatorCommand(double speed) {
		this.speed = speed;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.elevatorSubsystem.brake(false);
		Robot.m_oi.OperatorStick().setRumble(RumbleType.kLeftRumble, 0);
		Robot.m_oi.OperatorStick().setRumble(RumbleType.kRightRumble, 0);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.elevatorSubsystem.elevatorSpeed(speed);
		Robot.m_oi.OperatorStick().setRumble(RumbleType.kLeftRumble, 0.45);
		Robot.m_oi.OperatorStick().setRumble(RumbleType.kRightRumble, 0.45);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.m_oi.OperatorStick().setRumble(RumbleType.kLeftRumble, 0);
		Robot.m_oi.OperatorStick().setRumble(RumbleType.kRightRumble, 0);

		Robot.elevatorSubsystem.brake(true);
		Robot.elevatorSubsystem.elevatorSpeed(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
