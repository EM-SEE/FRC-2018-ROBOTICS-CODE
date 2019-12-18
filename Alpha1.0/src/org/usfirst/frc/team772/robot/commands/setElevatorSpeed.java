package org.usfirst.frc.team772.robot.commands;

import org.usfirst.frc.team772.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class setElevatorSpeed extends Command {

	double speed;

	/**
	 * This command sets the elevator to a certain speed and then ends the command.
	 * 
	 * @param speed
	 *            The speed to set the elevator motors
	 */
	public setElevatorSpeed(double speed) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);

		this.speed = speed;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {

		Robot.elevatorSubsystem.elevatorSpeed(speed);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return true;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
