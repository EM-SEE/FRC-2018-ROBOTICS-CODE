package org.usfirst.frc.team772.robot.commands;

import org.usfirst.frc.team772.robot.Robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class SetElevatorCommand extends Command {

	int elevatorPos;

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
		SmartDashboard.putString("DB/String 7", "Elevator Hello");
		Robot.elevatorSubsystem.brake(false);
		Robot.elevatorSubsystem.Elevator1Motor.set(ControlMode.MotionMagic, elevatorPos);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return (Math.abs(Robot.elevatorSubsystem.getElevatorEnc() - elevatorPos) < 10);

	}

	// Called once after isFinished returns true
	protected void end() {

		Robot.elevatorSubsystem.brake(true);
		SmartDashboard.putString("DB/String 7", "Elevator Done");

		// Robot.elevatorSubsystem.elevatorSpeed(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
