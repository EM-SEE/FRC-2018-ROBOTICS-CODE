package org.usfirst.frc.team772.robot.commands;

import org.usfirst.frc.team772.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveToUltraSonicCommand extends Command {

	double distanceLeftToTravel;
	double speedOfRobot;
	public double distanceAwayFromObject = 0;

	/**
	 * Essentially what its name implies. Drives to an Ultrasonic distance using
	 * artificial PIDs
	 * 
	 * @param distanceAwayFromObject
	 *            The distance for the ultrasonic to read in order for the robot to
	 *            stop.
	 */
	public DriveToUltraSonicCommand(double distanceAwayFromObject) {
		this.distanceAwayFromObject = distanceAwayFromObject;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		SmartDashboard.putString("DB/String 8", "DisLefTra: " + distanceLeftToTravel);
		SmartDashboard.putString("DB/String 9", "Ultra in Init");
		Robot.driveSubsystem.resetGyro();
		Robot.driveSubsystem.auto(0, 0);
		distanceLeftToTravel = (Robot.ultrasonicForward.getRangeInches() - distanceAwayFromObject);

	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		SmartDashboard.putString("DB/String 8", "DisLefTra: " + distanceLeftToTravel);
		SmartDashboard.putString("DB/String 9", "Ultra in Exe");
		distanceLeftToTravel = (Robot.ultrasonicForward.getRangeInches() - distanceAwayFromObject);
		double angleOfRobot = Robot.driveSubsystem.getDegrees();
		speedOfRobot = 0.005 * distanceLeftToTravel;

		if (speedOfRobot > 1) {
			SmartDashboard.putString("DB/String 5", "0.8: ");
			speedOfRobot = 0.8;
		} else if (speedOfRobot < -1) {
			SmartDashboard.putString("DB/String 5", "-0.8: ");
			speedOfRobot = -0.8;
		} else if ((speedOfRobot < 0.75) && speedOfRobot > 0) {
			SmartDashboard.putString("DB/String 5", "0.40: ");
			speedOfRobot = 0.40;
		} else if ((speedOfRobot > -0.75) && speedOfRobot < 0) {
			SmartDashboard.putString("DB/String 5", "-0.40: ");
			speedOfRobot = -0.40;
		}

		Robot.driveSubsystem.auto(speedOfRobot, angleOfRobot * 0.3);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if (distanceLeftToTravel <= 0 // + RobotMap.ultraTol
		) {
			return true;
		} else {
			return false;
		}
	}

	// Called once after isFinished returns true
	protected void end() {
		SmartDashboard.putString("DB/String 8", "DisLefTra: " + distanceLeftToTravel);
		SmartDashboard.putString("DB/String 9", "Ultra in end");
		Robot.driveSubsystem.auto(0, 0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
