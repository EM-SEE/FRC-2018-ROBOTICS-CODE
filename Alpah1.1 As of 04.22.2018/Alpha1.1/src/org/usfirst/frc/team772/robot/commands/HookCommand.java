package org.usfirst.frc.team772.robot.commands;

import org.usfirst.frc.team772.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class HookCommand extends Command {

	boolean direction;

	/**
	 * This is used to rotate the hook on the robot.
	 * 
	 * @param direction
	 *            The direction also refers to the motor speed to pass in. positive
	 *            --> clockwise | negative --> counterclockwise
	 */
	public HookCommand(boolean direction) {
		this.direction = direction;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.lifterSubsystem.moveHook(0);

	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (direction == true) {
			Robot.lifterSubsystem.moveHook(0.75);
		} else {
			Robot.lifterSubsystem.moveHook(-0.5);
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.lifterSubsystem.moveHook(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
