package org.usfirst.frc.team772.robot.commands;

import org.usfirst.frc.team772.robot.Robot;
import org.usfirst.frc.team772.robot.subsystems.IntakeSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/*
 * 
 */
public class IntakeOutCommand extends Command {

	double speed;

	/**
	 * Makes sure intake is unclamped --> spits out the cube at 100% --> turns off
	 * the motors with intake unclamped
	 * 
	 * @param speed
	 *            The speed of the outtake [Has to be negative].
	 */
	public IntakeOutCommand(double speed) {
		this.speed = speed;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		// IntakeSubsystem.intakeStop.start();// Start the lidar
		Robot.intakeSubsystem.clampIntake(false);

	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.intakeSubsystem.intakeSpeed(speed);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.intakeSubsystem.intakeSpeed(0);// Always turn off the motors after this command is run
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
