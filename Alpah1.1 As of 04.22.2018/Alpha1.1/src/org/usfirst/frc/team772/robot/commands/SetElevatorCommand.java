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
public class SetElevatorCommand extends Command {

	int elevatorPos;
	Timer timer = new Timer();

	/**
	 * This sets the elevator to a certain position using PID control.
	 * 
	 * @param elevatorPos
	 *            The number of encoder ticks for the elevator to travel.
	 */
	public SetElevatorCommand(int elevatorPos) {
		this.elevatorPos = elevatorPos;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		SmartDashboard.putString("DB/String 7", "Elevator Init");
		Robot.elevatorSubsystem.brake(false);// Comment this out if you want NO elevator break
		if (elevatorPos == RobotMap.ELEVATOR_HOME) {
			Robot.elevatorSubsystem.Elevator1Motor.configMotionCruiseVelocity(RobotMap.ELEVATOR_SPEED * 2, 10);
		} else {
			Robot.elevatorSubsystem.Elevator1Motor.configMotionCruiseVelocity(RobotMap.ELEVATOR_SPEED, 10);
		}

		Robot.elevatorSubsystem.Elevator1Motor.set(ControlMode.MotionMagic, elevatorPos);

		timer.start();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return (Math.abs(Robot.elevatorSubsystem.getElevatorEnc() - elevatorPos) < 100);// Was 10
	}

	// Called once after isFinished returns true
	protected void end() {
		if (elevatorPos == RobotMap.ELEVATOR_HOME) {
			Robot.elevatorSubsystem.elevatorSpeed(0);
		} else {
			Robot.elevatorSubsystem.brake(true);// Comment this out if you want NO elevator break
			Robot.elevatorSubsystem.Elevator1Motor.set(ControlMode.MotionMagic,
					Robot.elevatorSubsystem.getElevatorEnc());// Comment this out if you want NO elevator break
			SmartDashboard.putString("DB/String 7", "Elevator End");

			RobotMap.setElevatorTime = timer.get() * 1000;
			RobotMap.setElevatorSpeed = (Robot.elevatorSubsystem.getElevatorEnc() / RobotMap.setElevatorTime) * 100;
			// Turns ticks/ms into ticks/100ms

			timer.stop();
		}
		// Robot.elevatorSubsystem.elevatorSpeed(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
