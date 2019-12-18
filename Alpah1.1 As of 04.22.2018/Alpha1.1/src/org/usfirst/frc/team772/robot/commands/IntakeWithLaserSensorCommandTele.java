package org.usfirst.frc.team772.robot.commands;

import org.usfirst.frc.team772.robot.Robot;
import org.usfirst.frc.team772.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class IntakeWithLaserSensorCommandTele extends Command {

	/**
	 * This command keeps intaking the cube until the laser sensor in triggered or
	 * until 2 seconds has passed since the beginning of the command.
	 */
	public IntakeWithLaserSensorCommandTele() {
	}


	// Called just before this Command runs the first time
	protected void initialize() {
		if ((Robot.laser.getValue() <= RobotMap.LASER_INTAKE_TRUE)) {
			Robot.intakeSubsystem.clampIntake(false);
		}
		Robot.m_oi.DriverStick().setRumble(RumbleType.kLeftRumble, 0);
		SmartDashboard.putString("DB/String 9", "Intake init");


	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		SmartDashboard.putString("DB/String 9", "Intake exe");
		Robot.m_oi.DriverStick().setRumble(RumbleType.kLeftRumble, 1);
		if ((Robot.laser.getValue() <= RobotMap.LASER_INTAKE_TRUE)) {
			Robot.intakeSubsystem.intakeSpeed(1);
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if ((Robot.laser.getValue() >= RobotMap.LASER_INTAKE_TRUE)) {
			return true;
		} else {
			return false;
		}
	}

	// Called once after isFinished returns true
	protected void end() {
		SmartDashboard.putString("DB/String 9", "Intake end");
		Robot.m_oi.DriverStick().setRumble(RumbleType.kLeftRumble, 0);
		Robot.intakeSubsystem.clampIntake(true);
		 Robot.intakeSubsystem.intakeSpeed(0);

	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		Robot.m_oi.DriverStick().setRumble(RumbleType.kLeftRumble, 0);
		 Robot.intakeSubsystem.intakeSpeed(0);
	}
}
