package org.usfirst.frc.team772.robot.commands;

import org.usfirst.frc.team772.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class IntakeOutXSecCommandPramSec extends Command {

	double seconds;
	double speed;

	/**
	 * This command intakes OUT the cube in at 75% power for a set amount of seconds
	 * 
	 * @param seconds
	 *            The number of seconds to outtake the cube for.
	 */
	public IntakeOutXSecCommandPramSec(double seconds, double speed) {
		this.seconds = seconds;
		this.speed = speed;
	}

	Timer timer = new Timer();

	// Called just before this Command runs the first time
	protected void initialize() {
		timer.start();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		SmartDashboard.putString("DB/String 9", "OutTake Execute");
		Robot.intakeSubsystem.intakeSpeed(speed);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return timer.hasPeriodPassed(seconds);
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.intakeSubsystem.intakeSpeed(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
