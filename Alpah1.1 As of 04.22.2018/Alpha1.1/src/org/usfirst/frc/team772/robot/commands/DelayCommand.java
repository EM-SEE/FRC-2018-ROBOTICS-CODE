package org.usfirst.frc.team772.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DelayCommand extends Command {

	double seconds;
	Timer timer;

	/**
	 * This is the command that is used to delay the robot for a set amount of
	 * seconds.
	 * 
	 * @param seconds
	 *            The number of seconds to delay
	 */
	public DelayCommand(double seconds) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		this.seconds = seconds;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		SmartDashboard.putString("DB/String 9", "Delay init");
		timer = new Timer();
		timer.start();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		SmartDashboard.putString("DB/String 9", "Delay exe");
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return timer.hasPeriodPassed(seconds);
	}

	// Called once after isFinished returns true
	protected void end() {
		SmartDashboard.putString("DB/String 9", "Delay end");
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
