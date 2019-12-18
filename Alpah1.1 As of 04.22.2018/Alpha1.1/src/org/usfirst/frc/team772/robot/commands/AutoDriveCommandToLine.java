package org.usfirst.frc.team772.robot.commands;

import org.usfirst.frc.team772.robot.Robot;
import org.usfirst.frc.team772.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AutoDriveCommandToLine extends Command {

	double Kp = 0.1;//was 0.3
	public double distanceNeededToTravel = 0;
	public double distanceLeftToTravel;
	double speedOfRobot;
	double seconds;
	double gyroPosAtStart;
	double wheelsPosAtStart;
	double speed;

	Timer timer = new Timer();

	/**
	 * This command drives the Robot to the line
	 * 
	 * @param seconds
	 *            This is the timeout in seconds for this command. The command will
	 *            end either way if this times out.
	 */
	public AutoDriveCommandToLine(double speed, double seconds) {
		// This makes the distance declared above equal to the distance in the
		// AutoDriveCommand
		this.seconds = seconds;
		this.speed = speed;

	}

	// Called just before this Command runs the first time
	protected void initialize() {
		SmartDashboard.putString("DB/String 9", "Drive Initialize");

//		Robot.driveSubsystem.resetEncoders();
		wheelsPosAtStart = Robot.driveSubsystem.getEncAve();
//		Robot.driveSubsystem.resetGyro();
		// Robot.driveRobot.cancel();
		gyroPosAtStart = Robot.driveSubsystem.getDegrees();
//		distanceLeftToTravel = (distanceNeededToTravel + wheelsPosAtStart - Robot.driveSubsystem.getEncAve());
		timer.start();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		SmartDashboard.putString("DB/String 9", "Drive Execute");
		double angleOfRobot = Robot.driveSubsystem.getDegrees() - gyroPosAtStart;

//		distanceLeftToTravel = (distanceNeededToTravel + wheelsPosAtStart - Robot.driveSubsystem.getEncAve());
		speedOfRobot = speed;

		Robot.driveSubsystem.auto(speedOfRobot, angleOfRobot * Kp);
		SmartDashboard.putString("DB/String 8", "Speed: " + speedOfRobot);

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if ((Robot.driveSubsystem.AtLineLeft(RobotMap.lowVoltLeft, RobotMap.highVoltLeft) || (Robot.driveSubsystem.AtLineRight(RobotMap.lowVoltRight, RobotMap.highVoltRight))|| (timer.hasPeriodPassed(seconds)))) {
			return true;
		} else {
			return false;
		}
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.driveSubsystem.auto(0, 0);
		// Robot.driveRobot.start();
		SmartDashboard.putString("DB/String 9", "Drive End");
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
