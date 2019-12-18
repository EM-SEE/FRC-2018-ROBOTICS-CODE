package org.usfirst.frc.team772.robot.commands;

import org.usfirst.frc.team772.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ClimberCommand extends Command {

	boolean direction;

	/**
	 * This command is used to turn the climber on the motor. Essentially, the
	 * winch.
	 * 
	 * @param direction
	 *            true --> clockwise | false --> counterclockwise
	 */
	public ClimberCommand(boolean direction) {
		this.direction = direction;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.lifterSubsystem.moveClimber(0);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (direction == true) {
			Robot.lifterSubsystem.moveClimber(1);
		} else {
			Robot.lifterSubsystem.moveClimber(-1);
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.lifterSubsystem.moveClimber(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
