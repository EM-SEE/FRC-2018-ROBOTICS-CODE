package org.usfirst.frc.team772.robot.commands;

import org.usfirst.frc.team772.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class TeleGetCube extends CommandGroup {

	/**
	 * This command gets a cube in teleop. It is also known as the hunter command.
	 */
    public TeleGetCube() {
    	addSequential(new CameraControl(1));
//    	Robot.driveRobot.cancel();
    	addSequential(new ClampIntakeCommand(false));
    	addSequential(new SetElevatorCommand(0));
    	addSequential(new setElevatorSpeed(0));
//    	if (SmartDashboard.getNumber("TargetY", -1) != -1) {
        	addSequential(new AutoTurnVisionCommand());
        	addParallel(new IntakeWithLaserSensorCommand());
    		addSequential(new AutoDriveVisionCommandV2());
    		addSequential(new IntakeXSecCommand(1));
    		addSequential(new ClampIntakeCommand(true));
//    	}
//    	Robot.driveRobot.start();
    	addSequential(new CameraControl(0));
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
