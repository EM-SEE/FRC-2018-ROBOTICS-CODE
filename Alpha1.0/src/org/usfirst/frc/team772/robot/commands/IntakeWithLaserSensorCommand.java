package org.usfirst.frc.team772.robot.commands;

import org.usfirst.frc.team772.robot.Robot;
import org.usfirst.frc.team772.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class IntakeWithLaserSensorCommand extends Command {

	/**
	 * This command keeps intaking the cube until the laser sensor in triggered or
	 * until 2 seconds has passed since the beginning of the command.
	 */
	public IntakeWithLaserSensorCommand() {
	}

	Timer timer = new Timer();

	// Called just before this Command runs the first time
	protected void initialize() {
		SmartDashboard.putString("DB/String 9", "Intake init");

		timer.start();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		SmartDashboard.putString("DB/String 9", "Intake exe");
		Robot.intakeSubsystem.intakeSpeed(1);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if ((Robot.laser.getValue() >= RobotMap.laserIntakeTrue) || timer.hasPeriodPassed(2)) {
			return true;
		} else {
			return false;
		}
	}

	// Called once after isFinished returns true
	protected void end() {
		SmartDashboard.putString("DB/String 9", "Intake end");
		// Robot.intakeSubsystem.intakeSpeed(0);

	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
