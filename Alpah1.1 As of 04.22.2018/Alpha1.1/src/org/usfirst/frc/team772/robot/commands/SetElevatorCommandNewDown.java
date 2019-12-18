package org.usfirst.frc.team772.robot.commands;

import org.usfirst.frc.team772.robot.Robot;
import org.usfirst.frc.team772.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class SetElevatorCommandNewDown extends Command {

	int elevatorPos;
	Timer timer = new Timer();
	double braketime = 0;
	boolean braking = false;
	/**
	 * This sets the elevator to a certain position using PID control.
	 * 
	 * @param elevatorPos
	 *            The number of encoder ticks for the elevator to travel.
	 */
	public SetElevatorCommandNewDown(int elevatorPos) {
		this.elevatorPos = elevatorPos;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		SmartDashboard.putString("DB/String 7", "Elevator Init");
		Robot.elevatorSubsystem.brake(false);// Comment this out if you want NO elevator break
		Robot.elevatorSubsystem.elevatorSpeed(-1);
		timer.start();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if(Robot.elevatorSubsystem.getElevatorEnc() <= elevatorPos) {
			Robot.elevatorSubsystem.elevatorSpeed(-0.5);
			Robot.elevatorSubsystem.brake(true);// Comment this out if you want NO elevator break
			if (!braking ) {
			braketime = timer.get();
			braking = true;
			}
			SmartDashboard.putString("DB/String 6", "Brake" + braking);
			SmartDashboard.putString("DB/String 8", "BrakeTime" + braketime);
			SmartDashboard.putString("DB/String 5", "Time" + timer);

		}

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
//		return (Robot.elevatorSubsystem.getElevatorEnc() <= elevatorPos);
		return (braking && (timer.get() - braketime) > 0.25);
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.elevatorSubsystem.brake(true);// Comment this out if you want NO elevator break
		Robot.elevatorSubsystem.elevatorSpeed(0);
		SmartDashboard.putString("DB/String 7", "Elevator End");

		// RobotMap.setElevatorTime = timer.get() * 1000;
		// RobotMap.setElevatorSpeed = (Robot.elevatorSubsystem.getElevatorEnc() /
		// RobotMap.setElevatorTime) * 100;
		// Turns ticks/ms into ticks/100ms

		timer.stop();

		// Robot.elevatorSubsystem.elevatorSpeed(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
