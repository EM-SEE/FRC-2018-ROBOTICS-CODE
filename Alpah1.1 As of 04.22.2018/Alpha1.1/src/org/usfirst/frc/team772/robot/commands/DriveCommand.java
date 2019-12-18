package org.usfirst.frc.team772.robot.commands;

import org.usfirst.frc.team772.robot.Robot;
import org.usfirst.frc.team772.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveCommand extends Command {

	/**
	 * This command drives the robot in arcade mode during teleop.
	 */
	public DriveCommand() {
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.driveSubsystem.drive(Robot.m_oi.DriverStick(), 0);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {

		Robot.driveSubsystem.drive(Robot.m_oi.DriverStick(), RobotMap.driveSensitivity);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.driveSubsystem.drive(Robot.m_oi.DriverStick(), 0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
