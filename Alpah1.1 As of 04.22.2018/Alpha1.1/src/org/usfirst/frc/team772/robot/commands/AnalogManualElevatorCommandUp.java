package org.usfirst.frc.team772.robot.commands;

import org.usfirst.frc.team772.robot.Robot;
import org.usfirst.frc.team772.robot.RobotMap;

import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AnalogManualElevatorCommandUp extends Command {

	Timer timer = new Timer();
	/**
	 * The elevator is manually controlled using a set speed. (This one is updated
	 * with rumble)
	 * 
	 * @param speed
	 *            The speed to set the elevator at [-1 to 1]
	 *           
	 * @author Mahir Chowdhury team 772
	 */
	public AnalogManualElevatorCommandUp() {
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.elevatorSubsystem.brake(false);//Comment this out if you want NO elevator
		Robot.m_oi.OperatorStick().setRumble(RumbleType.kLeftRumble, 0);
		Robot.m_oi.OperatorStick().setRumble(RumbleType.kRightRumble, 0);
		timer.start();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.elevatorSubsystem.elevatorSpeed(Robot.m_oi.OperatorStick().getRawAxis(3));
		Robot.m_oi.OperatorStick().setRumble(RumbleType.kLeftRumble, 0.45);
		Robot.m_oi.OperatorStick().setRumble(RumbleType.kRightRumble, 0.45);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.m_oi.OperatorStick().setRumble(RumbleType.kLeftRumble, 0);
		Robot.m_oi.OperatorStick().setRumble(RumbleType.kRightRumble, 0);

		Robot.elevatorSubsystem.brake(true);//Comment this out if you want NO elevator
		Robot.elevatorSubsystem.elevatorSpeed(0);//Comment this out if you want NO elevator
		RobotMap.manualElevatorTime = timer.get()*1000;
		RobotMap.manualElevatorSpeed = (Robot.elevatorSubsystem.getElevatorEnc() / RobotMap.manualElevatorTime)*100;
		//Turns ticks/ms into ticks/100ms
		
		timer.stop();
		
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
