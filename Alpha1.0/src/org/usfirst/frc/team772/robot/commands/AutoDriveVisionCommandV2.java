package org.usfirst.frc.team772.robot.commands;

import org.usfirst.frc.team772.robot.Robot;
import org.usfirst.frc.team772.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AutoDriveVisionCommandV2 extends Command {

	double Kp = 0.3;
	public double distanceNeededToTravel = 0;
	public double distanceLeftToTravel;
	double speedOfRobot;
	double YValue;

	/**
	 * This command drive the robot straight towards a cube target and turns off
	 * when the laser triggers or when it reaches its destination (which is dictated
	 * by whatever the vision perceives).
	 */
	public AutoDriveVisionCommandV2() {

	}

	// Called just before this Command runs the first time
	protected void initialize() {
		SmartDashboard.putString("DB/String 9", "Drive init");
		YValue = SmartDashboard.getNumber("TargetY", 0);
		if (YValue <= 22) {
			YValue = 72;
		} else if (YValue <= 43 && YValue >= 22) {
			YValue = 62;
		} else if (YValue <= 84 && YValue >= 43) {
			YValue = 48;
		} else if (YValue <= 114 && YValue >= 84) {
			YValue = 35;
		} else if (YValue <= 156) {
			YValue = 19;
		}

		distanceNeededToTravel = YValue + 10;
		Robot.driveSubsystem.resetEncoders();
		Robot.driveSubsystem.resetGyro();
		// Robot.driveRobot.cancel();
		distanceLeftToTravel = (distanceNeededToTravel - Robot.driveSubsystem.getEncAve());
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		SmartDashboard.putString("DB/String 9", "Drive exe");
		double angleOfRobot = Robot.driveSubsystem.getDegrees();

		distanceLeftToTravel = (distanceNeededToTravel - Robot.driveSubsystem.getEncAve());

		speedOfRobot = 0.05 * distanceLeftToTravel;

		if (speedOfRobot > 1) {
			speedOfRobot = .8;
		} else if (speedOfRobot < -1) {
			speedOfRobot = -.8;

		} else if ((speedOfRobot < 0.75) && speedOfRobot > 0) {
			speedOfRobot = 0.40;
		} else if ((speedOfRobot > -0.75) && speedOfRobot < 0) {
			speedOfRobot = -0.40;
		}

		Robot.driveSubsystem.auto(speedOfRobot, angleOfRobot * Kp);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if ((Math.abs(distanceLeftToTravel) <= 0.1) || (Robot.laser.getValue() >= RobotMap.laserIntakeTrue)) {
			return true;
		} else {
			return false;
		}
	}

	// Called once after isFinished returns true
	protected void end() {
		SmartDashboard.putString("DB/String 9", "Drive end");
		Robot.driveSubsystem.auto(0, 0);
		SmartDashboard.putString("DB/String 8", "DisLeftTra: " + distanceLeftToTravel);
		SmartDashboard.putString("DB/String 1", "Laser: " + Robot.laser.getValue());

		// Robot.driveRobot.start();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
