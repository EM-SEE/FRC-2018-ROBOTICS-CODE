package org.usfirst.frc.team772.robot.commands;

import org.usfirst.frc.team772.robot.Robot;
import org.usfirst.frc.team772.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AutoTurnVisionCommandV2 extends Command {

	double degreesNeededToTurn;
	public double degreesLeftToTurn;
	double rotationSpeed;

	Timer timer = new Timer();

	/**
	 * This is the AutoTurnVisionCommandV2 which uses an artificial PID to control
	 * the turn (degreesLeftToTurn/degreesNeededToTurn). This just turns a certain
	 * amount of degrees according to what the degree offset from the target is.
	 * This command times out in 2 sec.
	 */
	public AutoTurnVisionCommandV2() {

	}

	// Called just before this Command runs the first time
	protected void initialize() {
		SmartDashboard.putBoolean("DB/Button 4", true);
		SmartDashboard.putString("DB/String 9", "Auto Turn init");
		Robot.driveSubsystem.resetGyro();
		degreesNeededToTurn = SmartDashboard.getNumber("DegreeOffset", 0) * -1;
		degreesLeftToTurn = (degreesNeededToTurn - Robot.driveSubsystem.getDegrees());
		rotationSpeed = degreesLeftToTurn / degreesNeededToTurn;

		timer.start();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		// MR BROWNE SECTION
		double error = degreesNeededToTurn - Robot.driveSubsystem.getDegrees();
		double minspeed = RobotMap.AUTO_TURN_MIN_SPEEDV290;
		double minangle = 0.1;
		double maxspeed = RobotMap.AUTO_TURN_MAX_SPEEDV290;
		double maxangle = 60;
		// the plan:
		// error < minangle then output = 0
		// error = minangle then output = minspeed
		// error >= maxangle then output = maxspeed

		rotationSpeed = (maxspeed - minspeed) / (maxangle - minangle) * error + error / Math.abs(error) * minspeed;

		Robot.driveSubsystem.auto(0, -rotationSpeed);
		degreesLeftToTurn = error;
		SmartDashboard.putString("DB/String 9", "Auto Turn exe");
		SmartDashboard.putString("DB/String 8", "gyro: " + Robot.driveSubsystem.getDegrees());
		SmartDashboard.putString("DB/String 0",
				String.format("SV %.2f PV %.2f", degreesNeededToTurn, Robot.driveSubsystem.getDegrees()));
		SmartDashboard.putString("DB/String 2", String.format("ER %.2f MV %.2f", error, rotationSpeed));

		// END MR BROWNE SECTION

		// degreesLeftToTurn = (degreesNeededToTurn -
		// Robot.driveSubsystem.getDegrees());
		// rotationSpeed = degreesLeftToTurn / degreesNeededToTurn;
		//
		//// if(rotationSpeed < 0) {
		//// rotationSpeed = rotationSpeed - .055;
		//// }else if (rotationSpeed > 0) {
		//// rotationSpeed = rotationSpeed + .055;
		//// }
		//
		// if (degreesNeededToTurn <= 0) {
		// rotationSpeed = -rotationSpeed;
		// }
		//
		// if(rotationSpeed<0) {
		// rotationSpeed = rotationSpeed - 0.15;
		// }else {
		// rotationSpeed = rotationSpeed + 0.15;
		// }
		//
		// SmartDashboard.putString("DB/String 9" , "Auto Turn exe");
		// SmartDashboard.putString("DB/String 8" , "gyro: " +
		// Robot.driveSubsystem.getDegrees() );
		// SmartDashboard.putString("DB/String 3" , "rotation: " +
		// Math.round(rotationSpeed*100)/100);
		// SmartDashboard.putString("DB/String 5" , "DegNeeded: " + degreesNeededToTurn
		// );
		// SmartDashboard.putString("DB/String 0" , "DegLeft: " + degreesLeftToTurn );
		// SmartDashboard.putString("DB/String 4" , "Rotation: " + rotationSpeed );
		//
		//
		// Robot.driveSubsystem.auto(0, -rotationSpeed + 0.15);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if ((Math.abs(degreesLeftToTurn) <= RobotMap.AUTO_TURN_TOLERANCEV2) || timer.hasPeriodPassed(1)) {
			return true;
		} else {
			return false;
		}
	}

	// Called once after isFinished returns true
	protected void end() {
		SmartDashboard.putBoolean("DB/Button 4", false);
		SmartDashboard.putString("DB/String 9", "Auto Turn end");
		SmartDashboard.putString("DB/String 8", "gyro: " + Robot.driveSubsystem.getDegrees());
		SmartDashboard.putString("DB/String 3", "rotation: " + Math.round(rotationSpeed * 100) / 100);
		SmartDashboard.putString("DB/String 5", "DegNeeded: " + degreesNeededToTurn);
		SmartDashboard.putString("DB/String 0", "DegLeft: " + degreesLeftToTurn);
		SmartDashboard.putString("DB/String 4", "Rotation: " + rotationSpeed);

		Robot.driveSubsystem.auto(0, 0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
