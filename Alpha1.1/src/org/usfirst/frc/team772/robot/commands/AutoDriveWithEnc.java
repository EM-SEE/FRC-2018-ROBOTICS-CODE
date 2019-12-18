package org.usfirst.frc.team772.robot.commands;

import org.usfirst.frc.team772.robot.Robot;
import org.usfirst.frc.team772.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AutoDriveWithEnc extends Command {
	
	
	public double distance;//The distance to travel rn in encoder ticks
	public double targetEncR;//The distance that the right encoder has to travel
	public double targetEncL;//The distance that the left encoder has to travel

	/**
	 * This command is currently deprecated. It is not functional.
	 * @param distance The distance to travel in encoder ticks
	 */
	public AutoDriveWithEnc(double distance) {
    	this.distance = distance;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
		Robot.driveSubsystem.resetEncoders();

		//This makes the left and right encoders target value to be 1 meter  
		Robot.driveSubsystem.frontLeftMotor.set(ControlMode.MotionMagic, Robot.driveSubsystem.getLeftEnc() + distance);
		Robot.driveSubsystem.frontRightMotor.set(ControlMode.MotionMagic, Robot.driveSubsystem.getRightEnc() + distance);
		
//		targetEnc = (Robot.driveSubsystem.getLeftEnc() + distance + Math.abs(Robot.driveSubsystem.getRightEnc()) + distance)/2;
		
		//This 
		targetEncR = Robot.driveSubsystem.getRightEnc() + distance;
		targetEncL = Robot.driveSubsystem.getLeftEnc() + distance;
		
		//Inverting the motors
		Robot.driveSubsystem.frontLeftMotor.setInverted(!RobotMap.frontLeftMotorInverted);
		Robot.driveSubsystem.backLeftMotor.setInverted(!RobotMap.backLeftMotorInverted);

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

    	//SmartDashboard.putString("DB/String 7" , "This is Running");
    	//SmartDashboard.putString("DB/String 11" , "TE" + Robot.driveSubsystem.getRightEnc() + targetEncR);
		//SmartDashboard.putString("DB/String 12" , "TE" + Robot.driveSubsystem.getLeftEnc() + targetEncL);
//    	Robot.driveSubsystem.AutoDriveWithEnc(distance);    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {

    	//This is the room for error for when the robot stops
    	if ((Math.abs(targetEncR-Robot.driveSubsystem.getRightEnc()) < 240)  &&
    			(Math.abs(targetEncL-Robot.driveSubsystem.getLeftEnc()) < 240)) {
    	return true;
    	}
    	else {
    		return false;
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    	if(distance > 0) {
    	SmartDashboard.putString("AutoDriveStatus: " , "This is End");}
    	else {
    		SmartDashboard.putString("AutoDriveStatus: " , "This is -End");
    	}
    	
    	targetEncR = 9988888899.99999;
    	targetEncL = 9988888999.9999;
    	
    	Robot.driveSubsystem.AutoDriveWithEncStop();
    	
    	//This resets the motor inversions
    	Robot.driveSubsystem.frontLeftMotor.setInverted(RobotMap.frontLeftMotorInverted);
		Robot.driveSubsystem.backLeftMotor.setInverted(RobotMap.backLeftMotorInverted);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
