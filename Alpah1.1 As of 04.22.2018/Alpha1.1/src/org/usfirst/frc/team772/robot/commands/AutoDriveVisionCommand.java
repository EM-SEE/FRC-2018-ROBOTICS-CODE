package org.usfirst.frc.team772.robot.commands;

import org.usfirst.frc.team772.robot.Robot;
import org.usfirst.frc.team772.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AutoDriveVisionCommand extends Command {

	double Kp = 0.3;
	public double distanceNeededToTravel = 0;
	public double distanceLeftToTravel;
	double speedOfRobot;

	/**
	 * This command is deprecated for AutoDriveVisionCommandV2. Use that instead.
	 */
	public AutoDriveVisionCommand() {
		// This makes the distance declared above equal to the distance in the
		// AutoDriveCommand

	}

	// Called just before this Command runs the first time
	protected void initialize() {

		Robot.driveSubsystem.resetEncoders();
		Robot.driveSubsystem.resetGyro();
//		Robot.driveRobot.cancel();
		distanceNeededToTravel =  90;//this will be replaced with a relationship of y
		distanceLeftToTravel = (distanceNeededToTravel - Robot.driveSubsystem.getEncAve());
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {

		double angleOfRobot =  SmartDashboard.getNumber("DegreeOffset", 0);

		distanceLeftToTravel = (distanceNeededToTravel - Robot.driveSubsystem.getEncAve());

		speedOfRobot = 0.05 * distanceLeftToTravel;

		if (speedOfRobot > 1) {
			speedOfRobot = 0.60;
		} else if (speedOfRobot < -1) {
			speedOfRobot = -0.60;
			
		} else if ((speedOfRobot < 0.75) && speedOfRobot > 0) {
			speedOfRobot = 0.25;
		} else if ((speedOfRobot > -0.75) && speedOfRobot < 0) {
			speedOfRobot = -0.25;
		}

		Robot.driveSubsystem.auto(speedOfRobot, angleOfRobot * Kp);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if ((Math.abs(distanceLeftToTravel) <= 0.1) || (Robot.laser.getValue() >= RobotMap.LASER_INTAKE_TRUE)) {
			return true;
		} else {
			return false;
		}
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.driveSubsystem.auto(0, 0);
		SmartDashboard.putString("DB/String 8", "DisLeftTra: " + distanceLeftToTravel);
		SmartDashboard.putString("DB/String 9", "Laser: " + Robot.laser.getValue());

//		Robot.driveRobot.start();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
