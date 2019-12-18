package org.usfirst.frc.team772.robot.commandGroup;

import org.usfirst.frc.team772.robot.RobotMap;
import org.usfirst.frc.team772.robot.commands.AutoDriveCommand;
import org.usfirst.frc.team772.robot.commands.AutoDriveVisionCommand;
import org.usfirst.frc.team772.robot.commands.AutoDriveVisionCommandV2;
import org.usfirst.frc.team772.robot.commands.AutoDriveWithEnc;
import org.usfirst.frc.team772.robot.commands.AutoTurnCommand;
import org.usfirst.frc.team772.robot.commands.AutoTurnCommandV2;
import org.usfirst.frc.team772.robot.commands.AutoTurnVisionCommand;
import org.usfirst.frc.team772.robot.commands.AutoTurnVisionCommandV2;
import org.usfirst.frc.team772.robot.commands.ClampIntakeCommand;
import org.usfirst.frc.team772.robot.commands.DelayCommand;
import org.usfirst.frc.team772.robot.commands.DriveToUltraSonicCommand;
import org.usfirst.frc.team772.robot.commands.IntakeInCommand;
import org.usfirst.frc.team772.robot.commands.IntakeOutCommand;
import org.usfirst.frc.team772.robot.commands.IntakeOutXSecCommand;
import org.usfirst.frc.team772.robot.commands.IntakeWithLaserSensorCommand;
import org.usfirst.frc.team772.robot.commands.IntakeXSecCommand;
import org.usfirst.frc.team772.robot.commands.SetElevatorCommand;
import org.usfirst.frc.team772.robot.commands.setElevatorSpeed;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AutonomousCommand extends CommandGroup {

	public static boolean ourSwitchSideOnLeft;
	public static boolean ourScaleSideOnLeft;
	public static boolean enemySwitchSideOnLeft;

	/**
	 * This is the autonomous command constructor which takes in the position that
	 * the robot is currently in on the field.
	 * 
	 * @param robotPosition
	 */
	public AutonomousCommand(int robotPosition) {
		// SmartDashboard.putString("DB/String 5", ":" + robotPosition + ":");

		switch (robotPosition) {

		case 1:// _________________________________________________Pos 1
			randomizationResult();

			if (ourSwitchSideOnLeft && !ourScaleSideOnLeft) {// LR
				// SmartDashboard.putString("DB/String 6", "Pos:1 AutoMode:LR");
				autoModeLR();
			}

			if (ourSwitchSideOnLeft && ourScaleSideOnLeft) {// LL
				// SmartDashboard.putString("DB/String 6", "Pos:1 AutoMode:LL");
				posOneTwoCubeScaleLeft();
			}

			if (!ourSwitchSideOnLeft && ourScaleSideOnLeft) {// RL
				// SmartDashboard.putString("DB/String 6", "Pos:1 AutoMode:RL");
				autoModeLR();// RL
			}

			if (!ourSwitchSideOnLeft && !ourScaleSideOnLeft) {// RR
				// SmartDashboard.putString("DB/String 6", "Pos:1 AutoMode:RR");
				autoModeLR(); // A method that allows the robot to go to the other side in auto
			}

			break;

		case 2:// _________________________________________________Pos 2
			randomizationResult();

			if (ourSwitchSideOnLeft && !ourScaleSideOnLeft) {// LR
			}

			if (ourSwitchSideOnLeft && ourScaleSideOnLeft) {// LL
				if (SmartDashboard.getBoolean("DB/Button 1", false)) {
					breadAndButterLeftGarlic();
					SmartDashboard.putString("DB/String 4", "Bread & Butter Garlic Left");
				} else {
					breadButterLeft();
					SmartDashboard.putString("DB/String 4", "Bread & Butter Left");
				}

				if (!ourSwitchSideOnLeft && ourScaleSideOnLeft) {// RL
				}

				if (!ourSwitchSideOnLeft && !ourScaleSideOnLeft) {// RR
					if (SmartDashboard.getBoolean("DB/Button 1", false)) {
						breadButterGarlicRight();
						SmartDashboard.putString("DB/String 4", "Bread & Butter Garlic Right");
					} else {
						breadButterRight();
						SmartDashboard.putString("DB/String 4", "Bread & Butter Right");
					}
				}
			}
			break;

		case 3:// _________________________________________________Pos 3
			randomizationResult();

			if (ourSwitchSideOnLeft && !ourScaleSideOnLeft) {// LR
				autoModeLR();
			}

			if (ourSwitchSideOnLeft && ourScaleSideOnLeft) {// LL
				autoModeLR();
			}

			if (!ourSwitchSideOnLeft && ourScaleSideOnLeft) {// RL
				autoModeLR();// RL
			}

			if (!ourSwitchSideOnLeft && !ourScaleSideOnLeft) {// RR
				// cross the auto line or go to other side
			}
			break;

		default:
			SmartDashboard.putString("DB/String 6", "I am in default");
			AutoDefault();
			break;
		}
	}

	/**
	 * This is the randomization method that is used to set the position of where
	 * the switch and scale is.
	 */
	public void randomizationResult() {

		String gameData = DriverStation.getInstance().getGameSpecificMessage();

		if (gameData.charAt(0) == 'L') {
			// Put left auto code here
			ourSwitchSideOnLeft = true;
		} else {
			// Put right auto code here
			ourSwitchSideOnLeft = false;
		}

		if (gameData.charAt(1) == 'L') {
			// Put left auto code here
			ourScaleSideOnLeft = true;
		} else {
			// Put right auto code here
			ourScaleSideOnLeft = false;
		}

		if (gameData.charAt(2) == 'L') {
			// Put left auto code here
			enemySwitchSideOnLeft = true;
		} else {
			// Put right auto code here
			enemySwitchSideOnLeft = false;
		}

	}

	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	// THESE ARE ALL THE AUTOMODES FOR POSITION 1
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

	/**
	 * This Automode drives straight to the LEFT side of the scale and then drops
	 * the cube there. Then gets another cube and puts that on the scale as well.
	 */
	public void posOneTwoCubeScaleLeft() {
		addParallel(new ClampIntakeCommand(true));// clamp the intake
		addParallel(new IntakeXSecCommand(1));// while intaking the cube for a sec
		addSequential(new SetElevatorCommand(1000));// also while raising the elevator to 1000 (allows for a head start)
		addParallel(new SetElevatorCommand(RobotMap.elevatorScale));// Then, raise the elevator to scale height
		addSequential(new AutoDriveCommand(240, 5));// While driving straight towards the scale
		addSequential(new IntakeOutXSecCommand(2));// Spit out the cube for 2 seconds after reaching the scale
		addParallel(new SetElevatorCommand(RobotMap.elevatorHome));// Then, lower the elevator to home position
		addSequential(new AutoDriveCommand(-240, 5));// While driving backwards to where the robot started from

		// addSequential(new AutoTurnCommandV2(90));
		// addSequential(new DelayCommand(0.5));
		// addSequential(new AutoDriveCommand(24));//24 inches
		// addSequential(new IntakeOutXSecCommand(0.5));
		//// addSequential(new AutoDriveCommand(-24));
		// addSequential(new AutoTurnCommand(-90));
		// addSequential(new DelayCommand(0.5));
		// addSequential(new SetElevatorCommand(0));
		// addParallel(new setElevatorSpeed(0));
		// addParallel(new ClampIntakeCommand(false));
		// addSequential(new AutoDriveCommand(36));
		// addSequential(new AutoTurnCommand(90));
		// addSequential(new DelayCommand(0.5));
		// addSequential(new AutoTurnVisionCommand());
		// addParallel(new IntakeWithLaserSensorCommand());
		// addSequential(new AutoDriveVisionCommandV2());
		// addParallel(new ClampIntakeCommand(true));
		// addSequential(new IntakeXSecCommand(1));
		// addSequential(new SetElevatorCommand(100));
		// addSequential(new AutoTurnCommand(-90));
		// addSequential(new AutoDriveCommand(84));
		// addSequential(new SetElevatorCommand(7000));
		// addSequential(new IntakeOutXSecCommand(1));
	}

	/**
	 * This Automode drives straight to the LEFT side of the scale and then drops
	 * the cube there. Then, gets a cube and puts it on the switch.
	 */
	public void posOneScaleAndSwitchLeft() {

	}

	/**
	 * This Automode drives and puts a cube on the LEFT switch first. Then it goes
	 * to the scale and then drops the cube there.
	 */
	public void posOneSwitchAndScaleLeft() {

	}

	/**
	 * This Automode drives straight to the RIGHT side of the scale and then drops
	 * the cube there. Then gets another cube and puts that on the scale as well.
	 */
	public void posOneTwoCubeScaleRight() {

	}
	
	/**
	 * This Automode drives straight to the RIGHT side of the scale and then drops
	 * the cube there. Then, gets a cube and puts it on the switch.
	 */
	public void posOneScaleAndSwitchRight() {

	}

	/**
	 * This Automode drives and puts a cube on the RIGHT switch first. Then it goes
	 * to the scale and then drops the cube there.
	 */
	public void posOneSwitchAndScaleRight() {

	}

	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	// THESE ARE ALL THE AUTOMODES FOR POSITION 2
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

	/**
	 * This is bread and butter. Starts in position 2. Puts cube in RIGHT side of
	 * switch.
	 */
	public void breadButterRight() {
		addParallel(new IntakeXSecCommand(.25));
		addSequential(new ClampIntakeCommand(true));
		addSequential(new AutoTurnCommand(25));// Turn to the switch
		addSequential(new SetElevatorCommand(2000));// Move the elevator up a bit//2000 in the past
		// addSequential(new DelayCommand(0.5));
		addSequential(new setElevatorSpeed(0));
		addSequential(new DelayCommand(0.5));
		addSequential(new AutoDriveCommand(100, 1));// Drive to the switch
		// addSequential(new DriveToUltraSonicCommand());
		addSequential(new IntakeOutXSecCommand(1));// 3 sec in the past
	}

	/**
	 * This is bread and butter with garlic. Starts in position 2. Puts 2 cubes in
	 * RIGHT side of switch.
	 */
	public void breadButterGarlicRight() {
		addParallel(new IntakeXSecCommand(.25));
		addSequential(new ClampIntakeCommand(true));
		addSequential(new AutoTurnCommand(25));// Turn to the switch
		addSequential(new SetElevatorCommand(2000));// Move the elevator up a bit//2000 in the past
		// addSequential(new DelayCommand(0.5));
		addSequential(new setElevatorSpeed(0));
		addSequential(new DelayCommand(0.5));
		addSequential(new AutoDriveCommand(100, 1));// Drive to the switch
		// addSequential(new DriveToUltraSonicCommand());
		addSequential(new IntakeOutXSecCommand(1));// 3 sec in the past

		// THIS IS THE SECOND PART OF THE BREAD AND BUTTER. THIS IS THE GARLIC.
		addSequential(new AutoDriveCommand(-36, 4));
		addSequential(new SetElevatorCommand(0));
		addSequential(new DelayCommand(0.5));
		addSequential(new setElevatorSpeed(0));
		addSequential(new AutoTurnCommand(-45));
		addSequential(new DelayCommand(2));// 0.5
		addSequential(new AutoTurnVisionCommand());
		addSequential(new DelayCommand(0.5));
		addSequential(new ClampIntakeCommand(false));
		addParallel(new IntakeWithLaserSensorCommand());
		addSequential(new AutoDriveVisionCommandV2());
		addSequential(new IntakeXSecCommand(1));
		addSequential(new ClampIntakeCommand(true));
		addSequential(new SetElevatorCommand(2000));
		addSequential(new AutoDriveCommand(-36, 2));// Drive back 36 inches
		addSequential(new AutoTurnCommand(45));// Turn 45 degrees clockwise
		addSequential(new AutoDriveCommand(18, 2));// Go forward 18 inches
		addParallel(new ClampIntakeCommand(false));
		addSequential(new IntakeOutXSecCommand(.75));

	}

	/**
	 * This is bread and butter. Starts in position 2. Puts cube in LEFT side of
	 * switch.
	 */
	public void breadButterLeft() {
		addParallel(new IntakeXSecCommand(.25));// intake the cube for a quarter of a sec
		addSequential(new ClampIntakeCommand(true));// while it is clamped
		addSequential(new AutoTurnCommand(-15));// Turn to the switch 15 degrees counterclockwise
		addSequential(new SetElevatorCommand(3000));// Move the elevator up to switch height
		// addSequential(new DelayCommand(0.5));
		addSequential(new setElevatorSpeed(0));
		addSequential(new DelayCommand(0.5));
		addSequential(new AutoDriveCommand(96, 1));// Drive to the switch
		// addSequential(new DriveToUltraSonicCommand());
		addSequential(new IntakeOutXSecCommand(1));// 3 sec in the past
	}

	/**
	 * This is bread and butter with garlic. Starts in position 2. Puts 2 cubes in
	 * LEFT side of switch.
	 */
	public void breadAndButterLeftGarlic() {
		addSequential(new ClampIntakeCommand(true));// clamp the intake
		addSequential(new AutoDriveCommand(6, 1));// drive 6 inches forwards
		addParallel(new IntakeXSecCommand(.25));// turn on the intake for a quarter of a sec
		addSequential(new AutoTurnCommandV2(-30));// while turning towards the switch
		addParallel(new SetElevatorCommand(3000));// Move the elevator to the switch position
		// addSequential(new DelayCommand(0.25));
		// addSequential(new setElevatorSpeed(0));
		// addSequential(new DelayCommand(0.25));
		addSequential(new AutoDriveCommand(82, 4));// while driving to the switch
		addSequential(new DelayCommand(0.25));// After reaching the drive distance, delay
		addSequential(new AutoTurnCommandV2(30));// Square up the robot to the scale
		addSequential(new DelayCommand(0.25));// Delay to settle the robot
		addSequential(new AutoDriveCommand(25, 2));// Drive forward after squaring up 20
		// addSequential(new DriveToUltraSonicCommand());
		addSequential(new IntakeOutXSecCommand(.5));// SPIT OUT THE FIRST CUBE

		// THIS IS THE SECOND PART OF THE BREAD AND BUTTER. THIS IS THE
		// GARLIC.--------------
		addParallel(new ClampIntakeCommand(false));// unclamp the intake
		addParallel(new IntakeWithLaserSensorCommand());// while intaking using the laser
		addParallel(new SetElevatorCommand(0));// also while lowering the elevator to 0
		addSequential(new AutoDriveCommand(-24, 2));// and while driving back 2 feet
		// addSequential (new SetElevatorCommand(0));
		// addSequential(new DelayCommand(0.25));
		// addSequential(new setElevatorSpeed(0));
		addSequential(new AutoTurnCommandV2(50));// Turn clockwise 50 degrees
		addSequential(new DelayCommand(0.25));// Settle the robot for a quarter second
		addSequential(new AutoTurnVisionCommandV2());// Line up with a cube using turn vision
		addSequential(new DelayCommand(0.25));// Settle the robot
		addSequential(new AutoDriveVisionCommandV2());// Drive towards cube using vision
		addSequential(new IntakeXSecCommand(0.5));// and intake for the cube for half a second

		addParallel(new ClampIntakeCommand(true));// clamp the cube
		addParallel(new SetElevatorCommand(3000));// while raising the elevator to switch height
		// addSequential(new DelayCommand(0.25));
		// addSequential(new setElevatorSpeed(0));
		addSequential(new AutoDriveCommand(-36, 2));// also while driving 3 feet backwards
		addSequential(new AutoTurnCommandV2(-70));// turn 70 degrees counterclockwise
		addSequential(new AutoDriveCommand(12, 2));// drive forwards a foot
		addSequential(new IntakeOutXSecCommand(.5));// SPIT OUT THE SECOND CUBE

	}

	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	// THESE ARE ALL THE AUTOMODES FOR POSITION 3
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

	/**
	 * This Automode drives to the LEFT side of the scale and then drops
	 * the cube there. Then gets another cube and puts that on the scale as well.
	 */
	public void posThreeTwoCubeScaleLeft() {

	}

	/**
	 * This Automode drives to the LEFT side of the scale and then drops
	 * the cube there. Then, gets a cube and puts it on the switch.
	 */
	public void posThreeScaleAndSwitchLeft() {

	}

	/**
	 * This Automode drives and puts a cube on the LEFT switch first. Then it goes
	 * to the scale and then drops the cube there.
	 */
	public void posThreeSwitchAndScaleLeft() {

	}

	/**
	 * This Automode drives straight to the RIGHT side of the scale and then drops
	 * the cube there. Then gets another cube and puts that on the scale as well.
	 */
	public void posThreeTwoCubeScaleRight() {
		addParallel(new ClampIntakeCommand(true));// clamp the intake
		addParallel(new IntakeXSecCommand(1));// while intaking the cube for a sec
		addSequential(new SetElevatorCommand(1000));// also while raising the elevator to 1000 (allows for a head start)
		addParallel(new SetElevatorCommand(RobotMap.elevatorScale));// Then, raise the elevator to scale height
		addSequential(new AutoDriveCommand(240, 5));// While driving straight towards the scale
		addSequential(new IntakeOutXSecCommand(2));// Spit out the cube for 2 seconds after reaching the scale
		addParallel(new SetElevatorCommand(RobotMap.elevatorHome));// Then, lower the elevator to home position
		addSequential(new AutoDriveCommand(-240, 5));// While driving backwards to where the robot started from
	}
	
	/**
	 * This Automode drives straight to the RIGHT side of the scale and then drops
	 * the cube there. Then, gets a cube and puts it on the switch.
	 */
	public void posThreeScaleAndSwitchRight() {

	}

	/**
	 * This Automode drives and puts a cube on the RIGHT switch first. Then it goes
	 * to the scale and then drops the cube there.
	 */
	public void posThreeSwitchAndScaleRight() {

	}
	
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	// THESE ARE ALL THE TEST AUTOMODES
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

	public void autoModeLR() {
		// addSequential(new AutoDriveCommand(1));// Drives 1.5 meters forwards
		// addSequential(new AutoTurnCommand(90));// Turns 90 degrees clockwise
		// addSequential(new AutoDriveCommand(1));
		// addSequential(new DriveToUltraSonicCommand(.50));
	}

	public void autoMode1LL() {
		addParallel(new SetElevatorCommand(600));// Move the elevator up a bit
		addSequential(new ClampIntakeCommand(true));// Clamp the intake
		addSequential(new DelayCommand(0.5));// Delay for half a second
		addSequential(new setElevatorSpeed(0));//
		addSequential(new SetElevatorCommand(0));// Lower it down
		addSequential(new DelayCommand(1));
		addSequential(new setElevatorSpeed(0));
		addParallel(new IntakeXSecCommand(0.5)); // Intake the cube while the elevator is being lowered
		addSequential(new AutoDriveCommand(120, 3)); // Drive 72 inch or 6 ft
		// addSequential(new AutoTurnCommand(90)); // Turns 90 degrees clockwise
		// SmartDashboard.getNumber("DB/Slider 2", 180)
		// addParallel(new IntakeXSecCommand(0)); // Intake the cube while the elevator
		// is being lowered
		addSequential(new SetElevatorCommand(5000));
		addSequential(new DelayCommand(0.25));
		addSequential(new setElevatorSpeed(0));
		addSequential(new AutoTurnVisionCommand());
		// addSequential(new IntakeOutCommand());
		// addSequential(new AutoDriveCommand(5));
		// addSequential(new DriveToUltraSonicCommand(2500, .50));
	}

	// A test command for our encoders//
	public void AutoModeWithEnc() {
		// addSequential(new AutoDriveWithEnc(12000));//1 meter
		// addSequential(new AutoDriveWithEnc(-12000));//1 meter
		addSequential(new AutoTurnCommand(90));
	}

	// This is test code that starts in pos 1, and will drive straight to the left
	// side of the switch if it is ours//
	public void DriveToOppsiteSideOfScale() {// go straight to the scale, turn 90, drive to the other side, turn 90
		addSequential(new AutoDriveCommand(6.7056, 3));// need to check this number
		addSequential(new AutoTurnCommand(90));
	}

	public void AutoMode13() {
		addSequential(new AutoTurnVisionCommand());
		addSequential(new DelayCommand(1));
		// addSequential (new AutoTurnCommand(90));
		// addSequential(new ClampIntakeCommand(false));// Clamp the intake
		// addParallel(new IntakeXSecCommand(10));// Intake the cube while the elevator
		// is being lowered
		// addSequential(new AutoDriveWithEnc(29100));
		addSequential(new ClampIntakeCommand(false));

		addParallel(new AutoDriveVisionCommandV2());
		addSequential(new IntakeWithLaserSensorCommand());

		addSequential(new ClampIntakeCommand(true));
		addSequential(new IntakeXSecCommand(2));
	}

	// A default command that gets called if no others do//
	public void AutoDefault() {
		addSequential(new AutoDriveCommand(60, 5));// Drive five feet/60 inches
	}

}
