package org.usfirst.frc.team772.robot.commands;

import org.usfirst.frc.team772.robot.Robot;
import org.usfirst.frc.team772.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AutoTurnCommand extends Command {

	double degreesNeededToTurn;
	double rotation = 0;
	public double degreesLeftToTurn;

	double Kp = 0.045;// 0.05 //0.015//0.025

	/**
	 * This is the AutoTurnCommand which uses an artificial PID to control the turn.
	 * This just turns a certain amount of degrees.
	 * 
	 * @param degreesNeededToTurn
	 *            The degrees to turn robot. positive --> clockwise | negative -->
	 *            counterclockwise
	 */
	public AutoTurnCommand(double degreesNeededToTurn) {
		this.degreesNeededToTurn = degreesNeededToTurn;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		SmartDashboard.putString("DB/String 9", "Auto Turn init");
		Robot.driveSubsystem.resetGyro();
		degreesLeftToTurn = (degreesNeededToTurn - Robot.driveSubsystem.getDegrees());
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		SmartDashboard.putString("DB/String 9", "Auto Turn exe");

		degreesLeftToTurn = (degreesNeededToTurn - Robot.driveSubsystem.getDegrees());

		rotation = Kp * degreesLeftToTurn;

		if (rotation > 1) {
			rotation = -0.8;// 1
		} else if (rotation < -1) {
			rotation = 0.8;// 1
		} else if (rotation < .9 && rotation > 0) {
			rotation = -.55;
		} else if (rotation > -.9 && rotation < 0) {
			rotation = .55;
		}

		Robot.driveSubsystem.auto(0, rotation);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if (Math.abs(degreesLeftToTurn) <= 0.5) { // 0.1 this value is amazing
			return true;
		} else {
			return false;
		}
	}

	// Called once after isFinished returns true
	protected void end() {
		SmartDashboard.putString("DB/String 9", "Turn Command End");
		Robot.driveSubsystem.auto(0, 0);

		RobotMap.teleTurnDegrees = -1; // This is only for the autoturn in teleop. This WON'T AFFECT AUTONOMOUS.
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
