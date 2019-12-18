package org.usfirst.frc.team772.robot.commands;

import org.usfirst.frc.team772.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AutoTurnVisionCommand extends Command {

	double degreesNeededToTurn;
	double rotation = 0;
	public double degreesLeftToTurn;

	double Kp = 0.045;// 0.025

	/**
	 * This is the AutoTurnVisionCommand which uses an artificial PID to control the
	 * turn. This just turns a certain amount of degrees according to what the
	 * degree offset from the target is. 
	 */
	public AutoTurnVisionCommand() {
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		SmartDashboard.putBoolean("DB/Button 4", true);
		Robot.driveSubsystem.resetGyro();
		degreesNeededToTurn = SmartDashboard.getNumber("DegreeOffset", 0) * -1;
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		SmartDashboard.putString("DB/String 9", "DegreesNeededToTurn: " + degreesNeededToTurn);
		degreesLeftToTurn = (degreesNeededToTurn - Robot.driveSubsystem.getDegrees());

		rotation = Kp * degreesLeftToTurn;

		if (rotation > 1) {
			rotation = -0.60;
		} else if (rotation < -1) {
			rotation = 0.60;
		} else if (rotation < .9 && rotation > 0) {
			rotation = -.55;
		} else if (rotation > -.9 && rotation < 0) {
			rotation = .55;
		}

		Robot.driveSubsystem.auto(0, rotation);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if (Math.abs(degreesLeftToTurn) <= 0.5) { // 0.5 this value is amazing
			return true;
		} else {
			return false;
		}
	}

	// Called once after isFinished returns true
	protected void end() {
		SmartDashboard.putBoolean("DB/Button 4", false);
		Robot.driveSubsystem.auto(0, 0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
