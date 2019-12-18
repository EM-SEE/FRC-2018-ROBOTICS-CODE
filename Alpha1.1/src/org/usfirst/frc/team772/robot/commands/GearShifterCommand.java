package org.usfirst.frc.team772.robot.commands;

import org.usfirst.frc.team772.robot.Robot;

import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GearShifterCommand extends Command {

	boolean highGear;

	/**
	 * This command is used to shift the gear on the robot. The controller rumbles
	 * if in high gear.
	 * 
	 * @param highGear
	 *            true --> highGear | false --> lowGear
	 */
	public GearShifterCommand(boolean highGear) {
		this.highGear = highGear;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		// Robot.gearShifterSubsystem.shiftTheGear(direction);
		if (highGear == true) {
			Robot.driveSubsystem.highGear();
			Robot.m_oi.DriverStick().setRumble(RumbleType.kLeftRumble, 1);
			Robot.m_oi.DriverStick().setRumble(RumbleType.kRightRumble, 1);
		} else {
			Robot.driveSubsystem.lowGear();
		}
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return true;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.m_oi.DriverStick().setRumble(RumbleType.kLeftRumble, 0);
		Robot.m_oi.DriverStick().setRumble(RumbleType.kRightRumble, 0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
