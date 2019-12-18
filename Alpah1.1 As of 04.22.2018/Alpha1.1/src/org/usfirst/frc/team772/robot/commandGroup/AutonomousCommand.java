package org.usfirst.frc.team772.robot.commandGroup;

import org.usfirst.frc.team772.robot.RobotMap;
import org.usfirst.frc.team772.robot.commands.AutoDriveCommand;
import org.usfirst.frc.team772.robot.commands.AutoDriveCommandKeepPos;
import org.usfirst.frc.team772.robot.commands.AutoDriveCommandNew;
import org.usfirst.frc.team772.robot.commands.AutoDriveCommandToLine;
import org.usfirst.frc.team772.robot.commands.AutoDriveVisionCommand;
import org.usfirst.frc.team772.robot.commands.AutoDriveVisionCommandV2;
import org.usfirst.frc.team772.robot.commands.AutoDriveVisionCommandV2SpeedPram;
import org.usfirst.frc.team772.robot.commands.AutoDriveWithEnc;
import org.usfirst.frc.team772.robot.commands.AutoTurnCommand;
import org.usfirst.frc.team772.robot.commands.AutoTurnCommandV2;
import org.usfirst.frc.team772.robot.commands.AutoTurnCommandV290;
import org.usfirst.frc.team772.robot.commands.AutoTurnCommandVKeepPos;
import org.usfirst.frc.team772.robot.commands.AutoTurnCommandVKeepPosSeconds;
import org.usfirst.frc.team772.robot.commands.AutoTurnCommandVKeepPosSecondsPram;
import org.usfirst.frc.team772.robot.commands.AutoTurnCommandVKeepPosSecondsPramToLine;
import org.usfirst.frc.team772.robot.commands.AutoTurnVisionCommand;
import org.usfirst.frc.team772.robot.commands.AutoTurnVisionCommandV2;
import org.usfirst.frc.team772.robot.commands.ClampIntakeCommand;
import org.usfirst.frc.team772.robot.commands.DelayCommand;
import org.usfirst.frc.team772.robot.commands.DriveToUltraSonicCommand;
import org.usfirst.frc.team772.robot.commands.IntakeInCommand;
import org.usfirst.frc.team772.robot.commands.IntakeOutCommand;
import org.usfirst.frc.team772.robot.commands.IntakeOutXSecCommand;
import org.usfirst.frc.team772.robot.commands.IntakeOutXSecCommandPramSec;
import org.usfirst.frc.team772.robot.commands.IntakeWithLaserSensorCommand;
import org.usfirst.frc.team772.robot.commands.IntakeXSecCommand;
import org.usfirst.frc.team772.robot.commands.ResetEncoders;
import org.usfirst.frc.team772.robot.commands.SetElevatorCommand;
import org.usfirst.frc.team772.robot.commands.SetElevatorCommandNew;
import org.usfirst.frc.team772.robot.commands.SetElevatorCommandNewDown;
import org.usfirst.frc.team772.robot.commands.TeleGetCube;
import org.usfirst.frc.team772.robot.commands.setElevatorSpeed;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AutonomousCommand extends CommandGroup {

	/**
	 * This is the autonomous command constructor which takes in the position that
	 * the robot is currently in on the field.
	 * 
	 * @param robotPosition
	 * @param preferenceCode
	 */
	public AutonomousCommand(int robotPosition, int preferenceCode) {

		switch (robotPosition) {

		case 1:// _______________________________________________________________________Pos 1

			switch (preferenceCode) {

			case 111:// ____________________________________________
				if (RobotMap.ourSwitchSideOnLeft && !RobotMap.ourScaleSideOnLeft) {// LR
					SmartDashboard.putString("DB/String 4", "A2");
					A2();
				}

				if (RobotMap.ourSwitchSideOnLeft && RobotMap.ourScaleSideOnLeft) {// LL
					SmartDashboard.putString("DB/String 4", "A2");
					A2();
				}

				if (!RobotMap.ourSwitchSideOnLeft && RobotMap.ourScaleSideOnLeft) {// RL
					SmartDashboard.putString("DB/String 4", "A11");
					A11();
				}

				if (!RobotMap.ourSwitchSideOnLeft && !RobotMap.ourScaleSideOnLeft) {// RR
					SmartDashboard.putString("DB/String 4", "A11");
					A11();
				}
				break;

			case 110:// ___________________________________________
				if (RobotMap.ourSwitchSideOnLeft && !RobotMap.ourScaleSideOnLeft) {// LR
					SmartDashboard.putString("DB/String 4", "A2");
					A2();
				}

				if (RobotMap.ourSwitchSideOnLeft && RobotMap.ourScaleSideOnLeft) {// LL
					SmartDashboard.putString("DB/String 4", "A2");
					A2();
				}

				if (!RobotMap.ourSwitchSideOnLeft && RobotMap.ourScaleSideOnLeft) {// RL
					SmartDashboard.putString("DB/String 4", "A3");
					A3();
				}

				if (!RobotMap.ourSwitchSideOnLeft && !RobotMap.ourScaleSideOnLeft) {// RR
					SmartDashboard.putString("DB/String 4", "A1");
					A1();
				}
				break;

			case 121:// ____________________________________________
				if (RobotMap.ourSwitchSideOnLeft && !RobotMap.ourScaleSideOnLeft) {// LR
					SmartDashboard.putString("DB/String 4", "A4");
					A4();
				}

				if (RobotMap.ourSwitchSideOnLeft && RobotMap.ourScaleSideOnLeft) {// LL
					SmartDashboard.putString("DB/String 4", "A3");
					A3();
				}

				if (!RobotMap.ourSwitchSideOnLeft && RobotMap.ourScaleSideOnLeft) {// RL
					SmartDashboard.putString("DB/String 4", "A3");
					A3();
				}

				if (!RobotMap.ourSwitchSideOnLeft && !RobotMap.ourScaleSideOnLeft) {// RR
					SmartDashboard.putString("DB/String 4", "A4");
					A4();
				}
				break;

			case 120:// _______________________________________________
				if (RobotMap.ourSwitchSideOnLeft && !RobotMap.ourScaleSideOnLeft) {// LR
					SmartDashboard.putString("DB/String 4", "A2");
					A2();
				}

				if (RobotMap.ourSwitchSideOnLeft && RobotMap.ourScaleSideOnLeft) {// LL
					SmartDashboard.putString("DB/String 4", "A3");
					A3();
				}

				if (!RobotMap.ourSwitchSideOnLeft && RobotMap.ourScaleSideOnLeft) {// RL
					SmartDashboard.putString("DB/String 4", "A3");
					A3();
				}

				if (!RobotMap.ourSwitchSideOnLeft && !RobotMap.ourScaleSideOnLeft) {// RR
					SmartDashboard.putString("DB/String 4", "A1");
					A1();
				}
				break;

			case 211:// _______________________________________________
				if (RobotMap.ourSwitchSideOnLeft && !RobotMap.ourScaleSideOnLeft) {// LR
					SmartDashboard.putString("DB/String 4", "A8");
					A8();
				}

				if (RobotMap.ourSwitchSideOnLeft && RobotMap.ourScaleSideOnLeft) {// LL
					SmartDashboard.putString("DB/String 4", "A7");
					A7();
				}

				if (!RobotMap.ourSwitchSideOnLeft && RobotMap.ourScaleSideOnLeft) {// RL
					SmartDashboard.putString("DB/String 4", "A5");
					if (SmartDashboard.getBoolean("DB/Button 1", false)) {
						A5New();
					} else {
						A5();
					}
				}

				if (!RobotMap.ourSwitchSideOnLeft && !RobotMap.ourScaleSideOnLeft) {// RR
					SmartDashboard.putString("DB/String 4", "A6");
					A6();
				}
				break;

			case 210:// _______________________________________________
				if (RobotMap.ourSwitchSideOnLeft && !RobotMap.ourScaleSideOnLeft) {// LR
					SmartDashboard.putString("DB/String 4", "A2");
					A2();
				}

				if (RobotMap.ourSwitchSideOnLeft && RobotMap.ourScaleSideOnLeft) {// LL
					SmartDashboard.putString("DB/String 4", "A7");
					A7();
				}

				if (!RobotMap.ourSwitchSideOnLeft && RobotMap.ourScaleSideOnLeft) {// RL
					SmartDashboard.putString("DB/String 4", "A5");
					if (SmartDashboard.getBoolean("DB/Button 1", false)) {
						A5New();
					} else {
						A5();
					}
				}

				if (!RobotMap.ourSwitchSideOnLeft && !RobotMap.ourScaleSideOnLeft) {// RR
					SmartDashboard.putString("DB/String 4", "A1");
					A1();
				}
				break;

			case 221:// _______________________________________________
				if (RobotMap.ourSwitchSideOnLeft && !RobotMap.ourScaleSideOnLeft) {// LR
					SmartDashboard.putString("DB/String 4", "A6");
					A6();
				}

				if (RobotMap.ourSwitchSideOnLeft && RobotMap.ourScaleSideOnLeft) {// LL
					SmartDashboard.putString("DB/String 4", "A9");
					A9();
				}

				if (!RobotMap.ourSwitchSideOnLeft && RobotMap.ourScaleSideOnLeft) {// RL
					SmartDashboard.putString("DB/String 4", "A5");
					if (SmartDashboard.getBoolean("DB/Button 1", false)) {
						A5New();
					} else {
						A5();
					}
				}

				if (!RobotMap.ourSwitchSideOnLeft && !RobotMap.ourScaleSideOnLeft) {// RR
					SmartDashboard.putString("DB/String 4", "A10");
					A10();
				}
				break;

			case 220:// _______________________________________________
				if (RobotMap.ourSwitchSideOnLeft && !RobotMap.ourScaleSideOnLeft) {// LR
					SmartDashboard.putString("DB/String 4", "A2");
					A2();
				}

				if (RobotMap.ourSwitchSideOnLeft && RobotMap.ourScaleSideOnLeft) {// LL
					SmartDashboard.putString("DB/String 4", "A5");
					if (SmartDashboard.getBoolean("DB/Button 1", false)) {
						A5New();
					} else {
						A5();
					}
				}

				if (!RobotMap.ourSwitchSideOnLeft && RobotMap.ourScaleSideOnLeft) {// RL
					SmartDashboard.putString("DB/String 4", "A5");
					if (SmartDashboard.getBoolean("DB/Button 1", false)) {
						A5New();
					} else {
						A5();
					}
				}

				if (!RobotMap.ourSwitchSideOnLeft && !RobotMap.ourScaleSideOnLeft) {// RR
					SmartDashboard.putString("DB/String 4", "A1");
					A1();
				}
				break;

			case 241:// _______________________________________________
				if (RobotMap.ourSwitchSideOnLeft && !RobotMap.ourScaleSideOnLeft) {// LR
					SmartDashboard.putString("DB/String 4", "A6");
					A6();
				}

				if (RobotMap.ourSwitchSideOnLeft && RobotMap.ourScaleSideOnLeft) {// LL
					SmartDashboard.putString("DB/String 4", "A5");
					if (SmartDashboard.getBoolean("DB/Button 1", false)) {
						A5New();
					} else {
						A5();
					}
				}

				if (!RobotMap.ourSwitchSideOnLeft && RobotMap.ourScaleSideOnLeft) {// RL
					SmartDashboard.putString("DB/String 4", "A5");
					if (SmartDashboard.getBoolean("DB/Button 1", false)) {
						A5New();
					} else {
						A5();
					}
				}

				if (!RobotMap.ourSwitchSideOnLeft && !RobotMap.ourScaleSideOnLeft) {// RR
					SmartDashboard.putString("DB/String 4", "A6");
					A6();
				}
				break;

			case 240:// _______________________________________________
				if (RobotMap.ourSwitchSideOnLeft && !RobotMap.ourScaleSideOnLeft) {// LR
					SmartDashboard.putString("DB/String 4", "A2");
					A2();
				}

				if (RobotMap.ourSwitchSideOnLeft && RobotMap.ourScaleSideOnLeft) {// LL
					SmartDashboard.putString("DB/String 4", "A5");
					if (SmartDashboard.getBoolean("DB/Button 1", false)) {
						A5New();
					} else {
						A5();
					}
				}

				if (!RobotMap.ourSwitchSideOnLeft && RobotMap.ourScaleSideOnLeft) {// RL
					SmartDashboard.putString("DB/String 4", "A5");
					if (SmartDashboard.getBoolean("DB/Button 1", false)) {
						A5New();
					} else {
						A5();
					}
				}

				if (!RobotMap.ourSwitchSideOnLeft && !RobotMap.ourScaleSideOnLeft) {// RR
					SmartDashboard.putString("DB/String 4", "A1");
					A1();
				}
				break;

			}
			break;

		case 2:// _________________________________________________Pos 2

			if (RobotMap.ourSwitchSideOnLeft) {// LL && LR
				if (SmartDashboard.getBoolean("DB/Button 1", false)) {
					breadAndButterLeftGarlic();
					SmartDashboard.putString("DB/String 4", "B&B Garlic Left");
				} else if (SmartDashboard.getBoolean("DB/Button 3", false)) {
					SmartDashboard.putString("DB/String 4", "B&B Garlic Fast Left");
					breadAndButterLeftFastGarlic();
				} else {
					breadButterLeft();
					SmartDashboard.putString("DB/String 4", "B&B Left");
				}

			} else if (!RobotMap.ourSwitchSideOnLeft) {
				if (SmartDashboard.getBoolean("DB/Button 1", false)) {
					breadButterGarlicRight();
					SmartDashboard.putString("DB/String 4", "B&B Garlic Right");
				} else if (SmartDashboard.getBoolean("DB/Button 3", false)) {
					SmartDashboard.putString("DB/String 4", "B&B Garlic Fast Right ");
					breadAndButterRightFastGarlic();
				} else {
					breadButterRight();
					SmartDashboard.putString("DB/String 4", "B&B Right");
				}
			}

			break;

		case 3:// _______________________________________________________________________Pos 3

			switch (preferenceCode) {

			case 111:// ____________________________________________
				if (RobotMap.ourSwitchSideOnLeft && !RobotMap.ourScaleSideOnLeft) {// LR
					SmartDashboard.putString("DB/String 4", "B11");
					B11();
				}

				if (RobotMap.ourSwitchSideOnLeft && RobotMap.ourScaleSideOnLeft) {// LL
					SmartDashboard.putString("DB/String 4", "B11");
					B11();
				}

				if (!RobotMap.ourSwitchSideOnLeft && RobotMap.ourScaleSideOnLeft) {// RL
					SmartDashboard.putString("DB/String 4", "B2");
					B2();
				}

				if (!RobotMap.ourSwitchSideOnLeft && !RobotMap.ourScaleSideOnLeft) {// RR
					SmartDashboard.putString("DB/String 4", "B2");
					B2();
				}
				break;

			case 110:// ___________________________________________
				if (RobotMap.ourSwitchSideOnLeft && !RobotMap.ourScaleSideOnLeft) {// LR
					SmartDashboard.putString("DB/String 4", "B3");
					B3();
				}

				if (RobotMap.ourSwitchSideOnLeft && RobotMap.ourScaleSideOnLeft) {// LL
					SmartDashboard.putString("DB/String 4", "B1");
					B1();
				}

				if (!RobotMap.ourSwitchSideOnLeft && RobotMap.ourScaleSideOnLeft) {// RL
					SmartDashboard.putString("DB/String 4", "B2");
					B2();
				}

				if (!RobotMap.ourSwitchSideOnLeft && !RobotMap.ourScaleSideOnLeft) {// RR
					SmartDashboard.putString("DB/String 4", "B2");
					B2();
				}
				break;

			case 121:// ____________________________________________
				if (RobotMap.ourSwitchSideOnLeft && !RobotMap.ourScaleSideOnLeft) {// LR
					SmartDashboard.putString("DB/String 4", "B3");
					B3();
				}

				if (RobotMap.ourSwitchSideOnLeft && RobotMap.ourScaleSideOnLeft) {// LL
					SmartDashboard.putString("DB/String 4", "B4");
					B4();
				}

				if (!RobotMap.ourSwitchSideOnLeft && RobotMap.ourScaleSideOnLeft) {// RL
					SmartDashboard.putString("DB/String 4", "B4");
					B4();
				}

				if (!RobotMap.ourSwitchSideOnLeft && !RobotMap.ourScaleSideOnLeft) {// RR
					SmartDashboard.putString("DB/String 4", "B3");
					B3();
				}
				break;

			case 120:// _______________________________________________
				if (RobotMap.ourSwitchSideOnLeft && !RobotMap.ourScaleSideOnLeft) {// LR
					SmartDashboard.putString("DB/String 4", "B3");
					B3();
				}

				if (RobotMap.ourSwitchSideOnLeft && RobotMap.ourScaleSideOnLeft) {// LL
					SmartDashboard.putString("DB/String 4", "B1");
					B1();
				}

				if (!RobotMap.ourSwitchSideOnLeft && RobotMap.ourScaleSideOnLeft) {// RL
					SmartDashboard.putString("DB/String 4", "B2");
					B2();
				}

				if (!RobotMap.ourSwitchSideOnLeft && !RobotMap.ourScaleSideOnLeft) {// RR
					SmartDashboard.putString("DB/String 4", "B3");
					B3();
				}
				break;

			case 211:// _______________________________________________
				if (RobotMap.ourSwitchSideOnLeft && !RobotMap.ourScaleSideOnLeft) {// LR
					SmartDashboard.putString("DB/String 4", "B5");
					if (SmartDashboard.getBoolean("DB/Button 1", false)) {
						B5New();
					} else {
						B5();
					}
				}

				if (RobotMap.ourSwitchSideOnLeft && RobotMap.ourScaleSideOnLeft) {// LL
					SmartDashboard.putString("DB/String 4", "B6");
					B6();
				}

				if (!RobotMap.ourSwitchSideOnLeft && RobotMap.ourScaleSideOnLeft) {// RL
					SmartDashboard.putString("DB/String 4", "B8");
					B8();
				}

				if (!RobotMap.ourSwitchSideOnLeft && !RobotMap.ourScaleSideOnLeft) {// RR
					SmartDashboard.putString("DB/String 4", "B7");
					B7();
				}
				break;

			case 210:// _______________________________________________
				if (RobotMap.ourSwitchSideOnLeft && !RobotMap.ourScaleSideOnLeft) {// LR
					SmartDashboard.putString("DB/String 4", "B5");
					if (SmartDashboard.getBoolean("DB/Button 1", false)) {
						B5New();
					} else {
						B5();
					}
				}

				if (RobotMap.ourSwitchSideOnLeft && RobotMap.ourScaleSideOnLeft) {// LL
					SmartDashboard.putString("DB/String 4", "B1");
					B1();
				}

				if (!RobotMap.ourSwitchSideOnLeft && RobotMap.ourScaleSideOnLeft) {// RL
					SmartDashboard.putString("DB/String 4", "B2");
					B2();
				}

				if (!RobotMap.ourSwitchSideOnLeft && !RobotMap.ourScaleSideOnLeft) {// RR
					SmartDashboard.putString("DB/String 4", "B7");
					B7();
				}
				break;

			case 221:// _______________________________________________
				if (RobotMap.ourSwitchSideOnLeft && !RobotMap.ourScaleSideOnLeft) {// LR
					SmartDashboard.putString("DB/String 4", "B5");
					if (SmartDashboard.getBoolean("DB/Button 1", false)) {
						B5New();
					} else {
						B5();
					}
				}

				if (RobotMap.ourSwitchSideOnLeft && RobotMap.ourScaleSideOnLeft) {// LL
					SmartDashboard.putString("DB/String 4", "B10");
					B10();
				}

				if (!RobotMap.ourSwitchSideOnLeft && RobotMap.ourScaleSideOnLeft) {// RL
					SmartDashboard.putString("DB/String 4", "B6");
					B6();
				}

				if (!RobotMap.ourSwitchSideOnLeft && !RobotMap.ourScaleSideOnLeft) {// RR
					SmartDashboard.putString("DB/String 4", "B9");
					B9();
				}
				break;

			case 220:// _______________________________________________
				if (RobotMap.ourSwitchSideOnLeft && !RobotMap.ourScaleSideOnLeft) {// LR
					SmartDashboard.putString("DB/String 4", "B5");
					if (SmartDashboard.getBoolean("DB/Button 1", false)) {
						B5New();
					} else {
						B5();
					}
				}

				if (RobotMap.ourSwitchSideOnLeft && RobotMap.ourScaleSideOnLeft) {// LL
					SmartDashboard.putString("DB/String 4", "B1");
					B1();
				}

				if (!RobotMap.ourSwitchSideOnLeft && RobotMap.ourScaleSideOnLeft) {// RL
					SmartDashboard.putString("DB/String 4", "B2");
					B2();
				}

				if (!RobotMap.ourSwitchSideOnLeft && !RobotMap.ourScaleSideOnLeft) {// RR
					SmartDashboard.putString("DB/String 4", "B9");
					B9();
				}
				break;

			case 241:// _______________________________________________
				if (RobotMap.ourSwitchSideOnLeft && !RobotMap.ourScaleSideOnLeft) {// LR
					SmartDashboard.putString("DB/String 4", "B5");
					if (SmartDashboard.getBoolean("DB/Button 1", false)) {
						B5New();
					} else {
						B5();
					}
				}

				if (RobotMap.ourSwitchSideOnLeft && RobotMap.ourScaleSideOnLeft) {// LL
					SmartDashboard.putString("DB/String 4", "B6");
					B6();
				}

				if (!RobotMap.ourSwitchSideOnLeft && RobotMap.ourScaleSideOnLeft) {// RL
					SmartDashboard.putString("DB/String 4", "B6");
					B6();
				}

				if (!RobotMap.ourSwitchSideOnLeft && !RobotMap.ourScaleSideOnLeft) {// RR
					SmartDashboard.putString("DB/String 4", "B5");
					if (SmartDashboard.getBoolean("DB/Button 1", false)) {
						B5New();
					} else {
						B5();
					}
				}
				break;

			case 240:// _______________________________________________
				if (RobotMap.ourSwitchSideOnLeft && !RobotMap.ourScaleSideOnLeft) {// LR
					SmartDashboard.putString("DB/String 4", "B5");
					if (SmartDashboard.getBoolean("DB/Button 1", false)) {
						B5New();
					} else {
						B5();
					}
				}

				if (RobotMap.ourSwitchSideOnLeft && RobotMap.ourScaleSideOnLeft) {// LL
					SmartDashboard.putString("DB/String 4", "B1");
					B1();
				}

				if (!RobotMap.ourSwitchSideOnLeft && RobotMap.ourScaleSideOnLeft) {// RL
					SmartDashboard.putString("DB/String 4", "B2");
					B2();
				}

				if (!RobotMap.ourSwitchSideOnLeft && !RobotMap.ourScaleSideOnLeft) {// RR
					SmartDashboard.putString("DB/String 4", "B5");
					if (SmartDashboard.getBoolean("DB/Button 1", false)) {
						B5New();
					} else {
						B5();
					}
				}
				break;

			}
			break;
		case 4:
			EleTest();
			SmartDashboard.putString("DB/String 4", "EleTest");
			break;

		default:
			SmartDashboard.putString("DB/String 4", "I am in default");
			AutoDefault();
			break;
		}
	}

	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	// THESE ARE ALL THE AUTOMODES FOR POSITION 1
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

	/**
	 * Cross the base line [A1]
	 */
	public void A1() {
		addParallel(new ClampIntakeCommand(true));// Clamp the intake
		addParallel(new IntakeXSecCommand(1));// while intaking the cube for a sec
		addSequential(new SetElevatorCommandNew(RobotMap.ELEVATOR_DRIVE));// also while raising the elevator to 1000
		addSequential(new AutoDriveCommandKeepPos(210, 5));// Driving straight towards the scale
		addSequential(new AutoTurnCommandVKeepPos(90));
		addSequential(new DelayCommand(0.25));
		addSequential(new AutoDriveCommandKeepPos(80, 3));
	}

	/**
	 * 1 cube left switch from side [A2]
	 */
	public void A2() {
		addParallel(new ClampIntakeCommand(true));// Clamp the intake
		addParallel(new IntakeXSecCommand(1));// while intaking the cube for a sec
		addSequential(new AutoDriveCommandKeepPos(145, 5));// Driving straight towards the scale
		addSequential(new AutoTurnCommandVKeepPos(90));
		addParallel(new SetElevatorCommandNew(RobotMap.ELEVATOR_SWITCH));// also while raising the elevator to 1000
		addSequential(new AutoDriveCommandKeepPos(20, 3));// Driving straight towards the scale
		addSequential(new IntakeOutXSecCommand(.5));// Spit out the cube for 2
		addSequential(new AutoDriveCommandKeepPos(-20, 3));// Driving straight towards the scale
		addParallel(new SetElevatorCommandNewDown(RobotMap.ELEVATOR_HOME));// also while raising the elevator to 1000
		addSequential(new AutoTurnCommandVKeepPos(90));
		addSequential(new AutoDriveCommandKeepPos(-80, 3));// Driving straight towards the scale
		addSequential(new IntakeWithLaserSensorCommand());
		addSequential(new AutoTurnCommandVKeepPos(-30));
		addSequential(new AutoTurnVisionCommandV2());
		addSequential(new AutoDriveVisionCommandV2());
		addSequential(new IntakeXSecCommand(0.5));

	}

	/**
	 * 1 cube left scale from front [A3]
	 */
	public void A3() {
		addParallel(new ClampIntakeCommand(true));// Clamp the intake
		addParallel(new IntakeXSecCommand(1));// while intaking the cube for a sec
		addSequential(new SetElevatorCommandNew(RobotMap.ELEVATOR_DRIVE));// also while raising the elevator to 1000
		addSequential(new AutoDriveCommand(270, 5));// Driving straight towards the scale
		addSequential(new AutoTurnCommandV290(90));
		addSequential(new DelayCommand(0.25));
		// addSequential(new AutoDriveCommand(-12, 2));/// Driving straight towards the
		// scale
		// addSequential(new AutoDriveCommand(20, 3));// Driving straight towards the
		// scale
		addSequential(new SetElevatorCommandNew(RobotMap.ELEVATOR_SCALE));// Then, raise
		addSequential(new DelayCommand(0.25));// Settle the robot
		addSequential(new IntakeOutXSecCommand(.5));// Spit out the cube for 2
		// addSequential(new AutoDriveCommand(20, 3));// Driving straight towards the
		// scale

	}

	/**
	 * 1 cube to right scale [A4]
	 */
	public void A4() {
		addParallel(new ClampIntakeCommand(true));// Clamp the intake
		addParallel(new IntakeXSecCommand(1));// while intaking the cube for a sec
		addSequential(new SetElevatorCommandNew(RobotMap.ELEVATOR_DRIVE));
		addSequential(new AutoDriveCommandKeepPos(210, 5));// Driving straight towards the hallway
		addSequential(new DelayCommand(0.25));
		addSequential(new ResetEncoders());
		addSequential(new AutoTurnCommandVKeepPos(89));
		addSequential(new ResetEncoders());
		addSequential(new AutoDriveCommandKeepPos(240, 5));// Drive through the hallway
		addSequential(new DelayCommand(0.25));
		addSequential(new ResetEncoders());
		addSequential(new AutoTurnCommandVKeepPosSeconds(-125, 2));
		addSequential(new ResetEncoders());
		addSequential(new AutoDriveCommandToLine(0.5, 15));
		addSequential(new ResetEncoders());
		addSequential(new DelayCommand(0.25));
		addSequential(new AutoDriveCommandKeepPos(-6, 3));
		addSequential(new SetElevatorCommandNew(RobotMap.ELEVATOR_SCALE));
		addSequential(new IntakeOutXSecCommand(.5));// Spit out the cube for 2
		addSequential(new SetElevatorCommandNewDown(RobotMap.ELEVATOR_HOME));
	}

	/**
	 * 2 cubes on the left scale [A5]
	 */
	public void A5() {
		addParallel(new ClampIntakeCommand(true));// Clamp the intake
		addParallel(new IntakeXSecCommand(1));// while intaking the cube for a sec
		addSequential(new SetElevatorCommandNew(RobotMap.ELEVATOR_DRIVE));// also while raising the elevator to 1000
		addSequential(new AutoDriveCommand(262.5, 5));// Driving straight towards the scale
		addSequential(new ResetEncoders());
		addSequential(new AutoTurnCommandVKeepPosSeconds(70, 1));
		addSequential(new ResetEncoders());
		addSequential(new SetElevatorCommandNew(RobotMap.ELEVATOR_SCALE));// Then, raise
		addSequential(new ResetEncoders());// Settle the robot
		addSequential(new IntakeOutXSecCommand(.5));// Spit out the cube for 2
		addParallel(new ClampIntakeCommand(false));// Clamp the intake
		addSequential(new SetElevatorCommandNewDown(RobotMap.ELEVATOR_HOME));
		addSequential(new ResetEncoders());// Settle the robot
		addSequential(new AutoTurnCommandVKeepPosSeconds(80, 1));
		addParallel(new IntakeWithLaserSensorCommand());
		addSequential(new AutoDriveCommand(35, 1));
		addSequential(new AutoDriveVisionCommandV2());
		addSequential(new ResetEncoders());// Settle the robot
		addSequential(new AutoDriveVisionCommandV2());
		addSequential(new IntakeXSecCommand(1));
		addSequential(new AutoDriveCommand(-60, 2));
		addSequential(new AutoTurnCommandVKeepPosSeconds(-50, 3));
		// addSequential(new AutoDriveCommandKeepPos(20, 2.5));
		addSequential(new SetElevatorCommandNew(RobotMap.ELEVATOR_SCALE));
		addSequential(new ResetEncoders());// Settle the robot
		addSequential(new IntakeOutXSecCommand(0.5));
	}

	public void A5New() {
		addParallel(new ClampIntakeCommand(true));// Clamp the intake
		addParallel(new IntakeXSecCommand(1));// while intaking the cube for a sec
		addParallel(new SetElevatorCommandNew(6600));// also while raising the elevator to 1000
		// addParallel(new SetElevatorCommandNew(RobotMap.ELEVATOR_SCALE));// also while
		// raising the elevator to 1000
		addSequential(new AutoDriveCommandNew(250, 5));// Driving straight towards the scale
		addSequential(new AutoTurnCommandVKeepPosSeconds(45, 1.5));
		addSequential(new ResetEncoders());
		// addSequential(new AutoTurnCommandVKeepPosSeconds(70, 1));
		// addSequential(new ResetEncoders());
		// addSequential(new SetElevatorCommand(RobotMap.ELEVATOR_SCALE));// Then, raise
		addSequential(new ResetEncoders());// Settle the robot
		addSequential(new IntakeOutXSecCommand(.5));// Spit out the cube for 2
		addParallel(new ClampIntakeCommand(false));// Clamp the intake
		addParallel(new AutoDriveCommandKeepPos(-20, 1.5));
		addSequential(new SetElevatorCommandNewDown(400));
		addSequential(new ResetEncoders());// Settle the robot
		addSequential(new AutoTurnCommandVKeepPosSeconds(90, 4));
		addParallel(new IntakeWithLaserSensorCommand());
		addSequential(new AutoDriveCommand(20, 1));
		addSequential(new AutoTurnVisionCommandV2());
		addSequential(new ResetEncoders());// Settle the robot
		addSequential(new AutoDriveVisionCommandV2());
		addParallel(new ClampIntakeCommand(true));// Clamp the intake
		addSequential(new IntakeXSecCommand(1.5));
		addSequential(new IntakeXSecCommand(1));
		addSequential(new AutoDriveCommand(-20, 2));
		addSequential(new IntakeXSecCommand(0.5));
		addSequential(new AutoTurnCommandVKeepPosSeconds(-120, 3));
		// addSequential(new AutoDriveCommandKeepPos(20, 2.5));
		addParallel(new SetElevatorCommandNew(6600));
		addSequential(new AutoDriveCommand(45, 1));
		addSequential(new ResetEncoders());// Settle the robot
		addSequential(new IntakeOutXSecCommand(0.5));
		addParallel(new ClampIntakeCommand(false));// Clamp the intake
		addParallel(new AutoDriveCommandKeepPos(-20, 1.5));
		addSequential(new SetElevatorCommandNewDown(400));
		addSequential(new ResetEncoders());// Settle the robot
		addSequential(new AutoTurnCommandVKeepPosSeconds(150, 1));
		addParallel(new IntakeWithLaserSensorCommand());
		addSequential(new AutoDriveCommand(20, 1));
		addSequential(new AutoDriveVisionCommandV2());
		addSequential(new ResetEncoders());// Settle the robot
		addSequential(new AutoDriveVisionCommandV2());
		addParallel(new ClampIntakeCommand(true));// Clamp the intake
		addSequential(new IntakeXSecCommand(1));
		// addSequential(new AutoDriveCommand(-60, 2));
		addSequential(new AutoTurnCommandVKeepPosSeconds(-150, 3));
		// addSequential(new AutoDriveCommandKeepPos(20, 2.5));
		addSequential(new SetElevatorCommandNew(6600));
		addSequential(new AutoDriveCommandNew(20, 1));
		addSequential(new ResetEncoders());// Settle the robot
		addSequential(new IntakeOutXSecCommand(0.5));
	}

	/**
	 * 2 cubes on the right scale [A6]
	 */
	// DONE BY ABIIE//
	public void A6() {
		addParallel(new ClampIntakeCommand(true));// Clamp the intake
		addParallel(new IntakeXSecCommand(1));// while intaking the cube for a sec
		addSequential(new SetElevatorCommandNew(RobotMap.ELEVATOR_DRIVE));
		addSequential(new AutoDriveCommandKeepPos(210, 5));// Driving straight towards the hallway
		addSequential(new DelayCommand(0.25));
		addSequential(new ResetEncoders());
		addSequential(new AutoTurnCommandVKeepPos(89));
		addSequential(new ResetEncoders());
		addSequential(new AutoDriveCommandKeepPos(240, 5));// Drive through the hallway
		addSequential(new ResetEncoders());
		addSequential(new AutoTurnCommandVKeepPos(-125));
		addSequential(new ResetEncoders());
		addSequential(new AutoDriveCommandToLine(0.6, 15));
		addSequential(new SetElevatorCommandNew(RobotMap.ELEVATOR_SCALE));
		addSequential(new IntakeOutXSecCommand(.5));// Spit out the cube for 2
		addSequential(new SetElevatorCommandNewDown(RobotMap.ELEVATOR_HOME));
		addSequential(new AutoTurnCommandVKeepPos(-89));
		addSequential(new IntakeWithLaserSensorCommand());
		addSequential(new ResetEncoders());
		addSequential(new AutoDriveCommandKeepPos(20, 3));
		addSequential(new ResetEncoders());
		addSequential(new AutoTurnVisionCommandV2());
		addSequential(new ResetEncoders());
		addSequential(new AutoDriveVisionCommandV2());
		addSequential(new IntakeInCommand(0.5));
	}

	/**
	 * First cube to left switch from side and second cube to left scale [A7]
	 */
	public void A7() {
		addParallel(new ClampIntakeCommand(true));// Clamp the intake

		addParallel(new DelayCommand(0.15));
		addParallel(new IntakeXSecCommand(1));// while intaking the cube for a sec
		addSequential(new AutoDriveCommand(126, 5));// Driving straight towards the scale
		addSequential(new AutoTurnCommandV2(90));
		addSequential(new SetElevatorCommandNew(RobotMap.ELEVATOR_SWITCH));// also while raising the elevator to 1000
		addParallel(new ClampIntakeCommand(true));// Clamp the intake
		addSequential(new IntakeOutXSecCommand(.5));// Spit out the cube for 2
		addSequential(new SetElevatorCommandNewDown(RobotMap.ELEVATOR_HOME));
		addSequential(new setElevatorSpeed(0));
		addParallel(new ClampIntakeCommand(false));
		addSequential(new AutoTurnCommandV2(-90));
		addSequential(new AutoDriveCommand(60, 2));
		addSequential(new AutoTurnCommandV2(90));
		addSequential(new DelayCommand(0.15));
		addSequential(new AutoDriveCommand(24, 5));// go get the cube closest to switch
		addSequential(new AutoTurnCommandV2(90));// Turn towards the cube
		addSequential(new DelayCommand(0.15));// HUNTER COMMAND COMMENCE
		addParallel(new IntakeWithLaserSensorCommand());// Spit out the cube for 2
		addSequential(new AutoTurnVisionCommandV2());// Line up with a cube using turn vision
		addSequential(new AutoDriveVisionCommandV2());
		addParallel(new ClampIntakeCommand(true));
		addSequential(new DelayCommand(0.15));
		addSequential(new AutoTurnCommandV2(180));
		addSequential(new AutoDriveCommand(72, 4));
		addSequential(new SetElevatorCommandNew(RobotMap.ELEVATOR_SCALE));
		addSequential(new setElevatorSpeed(0));
		addSequential(new IntakeOutXSecCommand(1));// Spit out the cube for 2

		// WHAT MIGHT WORK INSTAED, JUST NOT FINISHED//

		addParallel(new ClampIntakeCommand(true));// Clamp the intake
		addParallel(new IntakeXSecCommand(1));// while intaking the cube for a sec
		addParallel(new SetElevatorCommandNewDown(RobotMap.ELEVATOR_SWITCH));// also while raising the elevator to 1000
		addSequential(new AutoDriveCommandKeepPos(145, 5));// Driving straight towards the scale
		addSequential(new AutoTurnCommandVKeepPos(-90));
		addSequential(new AutoDriveCommandKeepPos(10, 2));// Driving straight towards the scale
		addSequential(new IntakeOutXSecCommand(.5));// Spit out the cube for 2
		addSequential(new AutoDriveCommandKeepPos(-10, 2));// Driving straight towards the scale
		addSequential(new AutoTurnCommandVKeepPos(90));

		// HAVE NOT FINISHED THE REST OF THE CODE FOR THIS AUTO//
		// addSequential(new AutoDriveCommand(135, 5));// Driving straight towards the
		// scale
		// addSequential(new AutoTurnCommandV2(-70));
		// addSequential(new DelayCommand(0.25));
		// addSequential(new AutoDriveCommand(-12, 2));// Driving straight towards the
		// scale
		// addSequential(new SetElevatorCommand(RobotMap.ELEVATOR_SCALE));// Then, raise
		// addSequential(new DelayCommand(0.25));// Settle the robot
		// addSequential(new IntakeOutXSecCommand(.5));// Spit out the cube for 2
	}

	/**
	 * First cube to left switch from side and go to right side of the scale [A8]
	 */
	public void A8() {
		addParallel(new ClampIntakeCommand(true));// Clamp the intake

		addParallel(new DelayCommand(0.15));
		addParallel(new IntakeXSecCommand(1));// while intaking the cube for a sec
		addSequential(new AutoDriveCommand(126, 5));// Driving straight towards the scale
		addSequential(new AutoTurnCommandV2(90));
		addSequential(new SetElevatorCommandNew(RobotMap.ELEVATOR_SWITCH));// also while raising the elevator to 1000
		addParallel(new ClampIntakeCommand(true));// Clamp the intake
		addSequential(new IntakeOutXSecCommand(.5));// Spit out the cube for 2
		addSequential(new SetElevatorCommandNewDown(RobotMap.ELEVATOR_HOME));
		addSequential(new setElevatorSpeed(0));
		addParallel(new ClampIntakeCommand(false));
		addSequential(new AutoTurnCommandV2(-90));
		addSequential(new AutoDriveCommand(60, 2));
		addSequential(new AutoTurnCommandV2(90));
		addSequential(new DelayCommand(0.15));
		addSequential(new AutoDriveCommand(162, 5));
		addSequential(new AutoTurnCommandV2(90));// Turn towards the cube
		addSequential(new DelayCommand(0.15));// HUNTER COMMAND COMMENCE
		addParallel(new IntakeWithLaserSensorCommand());// Spit out the cube for 2
		addSequential(new AutoTurnVisionCommandV2());// Line up with a cube using turn vision
		addSequential(new AutoDriveVisionCommandV2());
		addParallel(new ClampIntakeCommand(true));
		addSequential(new DelayCommand(0.15));
		addSequential(new AutoTurnCommandV2(180));
		addSequential(new AutoDriveCommand(72, 4));
		addSequential(new SetElevatorCommandNew(RobotMap.ELEVATOR_SCALE));
		addSequential(new setElevatorSpeed(0));
		addSequential(new IntakeOutXSecCommand(1));// Spit out the cube for 2

	}

	/**
	 * First cube to left scale second cube to left switch backside [A9]
	 */
	// DONE BY ABBIE//
	public void A9() {
		addSequential(new ResetEncoders());
		addParallel(new ClampIntakeCommand(true));// Clamp the intake
		addParallel(new IntakeXSecCommand(1));// while intaking the cube for a sec
		addParallel(new SetElevatorCommandNew(RobotMap.ELEVATOR_DRIVE));// also while raising the elevator to 1000
		addSequential(new AutoDriveCommandKeepPos(235, 5));// Driving straight towards the scale
		addSequential(new ResetEncoders());
		addSequential(new AutoTurnCommandVKeepPosSecondsPram(45, 1.5, 0.65, 0.8));
		addSequential(new ResetEncoders());
		// addSequential(new AutoDriveCommandToLine(0.6, 3));
		addSequential(new ResetEncoders());
		addSequential(new SetElevatorCommandNew(RobotMap.ELEVATOR_SCALE));// Then, raise
		addSequential(new ResetEncoders());// Settle the robot
		addSequential(new IntakeOutXSecCommand(.5));// Spit out the cube for 2
		addSequential(new ClampIntakeCommand(false));// Clamp the intake
		addSequential(new SetElevatorCommandNewDown(RobotMap.ELEVATOR_HOME));
		addSequential(new ResetEncoders());// Settle the robot
		addSequential(new AutoTurnCommandVKeepPosSeconds(90, 1));
		addParallel(new IntakeWithLaserSensorCommand());
		addSequential(new AutoDriveCommandKeepPos(20, 1.5));
		addSequential(new AutoTurnVisionCommandV2());
		addSequential(new ResetEncoders());// Settle the robot
		addSequential(new AutoDriveVisionCommandV2());
		addSequential(new IntakeXSecCommand(1));
		addSequential(new SetElevatorCommandNew(RobotMap.ELEVATOR_SWITCH));
		addSequential(new AutoDriveCommand(10, 1.5));
		addSequential(new IntakeOutXSecCommand(0.5));
	}

	/**
	 * First cube on the right scale; second cube on the back side of right switch
	 * [A10]
	 */
	// DONE BY ABBIE//
	public void A10() {
		addParallel(new ClampIntakeCommand(true));// Clamp the intake
		addParallel(new IntakeXSecCommand(1));// while intaking the cube for a sec
		addSequential(new SetElevatorCommandNew(RobotMap.ELEVATOR_DRIVE));
		addSequential(new AutoDriveCommandKeepPos(210, 5));// Driving straight towards the hallway
		addSequential(new DelayCommand(0.25));
		addSequential(new ResetEncoders());
		addSequential(new AutoTurnCommandVKeepPos(89));
		addSequential(new ResetEncoders());
		addSequential(new AutoDriveCommandKeepPos(240, 5));// Drive through the hallway
		addSequential(new ResetEncoders());
		addSequential(new AutoTurnCommandVKeepPos(-135));
		addSequential(new ResetEncoders());
		addSequential(new AutoDriveCommandToLine(0.6, 15));
		addSequential(new SetElevatorCommandNew(RobotMap.ELEVATOR_SCALE));
		addSequential(new IntakeOutXSecCommand(.5));// Spit out the cube for 2
		addSequential(new SetElevatorCommandNewDown(RobotMap.ELEVATOR_HOME));
		addSequential(new AutoTurnCommandVKeepPos(-89));
		addSequential(new IntakeWithLaserSensorCommand());
		addSequential(new ResetEncoders());
		addSequential(new AutoDriveCommandKeepPos(20, 3));
		addSequential(new ResetEncoders());
		addSequential(new AutoTurnVisionCommandV2());
		addSequential(new ResetEncoders());
		addSequential(new AutoDriveVisionCommandV2());
		addSequential(new IntakeInCommand(0.5));
	}

	/**
	 * 1 cube right switch from back side [A11]
	 */
	// DONE BY ABBIE//
	public void A11() {
		addParallel(new ClampIntakeCommand(true));// Clamp the intake
		addParallel(new IntakeXSecCommand(1));// while intaking the cube for a sec
		addSequential(new SetElevatorCommandNew(RobotMap.ELEVATOR_DRIVE));
		addSequential(new AutoDriveCommandKeepPos(210, 5));// Driving straight towards the hallway
		addSequential(new DelayCommand(0.25));
		addSequential(new ResetEncoders());
		addSequential(new AutoTurnCommandVKeepPos(89));
		addSequential(new ResetEncoders());
		addSequential(new AutoDriveCommandKeepPos(225, 5));// Drive through the hallway
		addSequential(new ResetEncoders());
		addSequential(new AutoTurnCommandVKeepPos(130));
		addSequential(new ResetEncoders());
		addSequential(new SetElevatorCommandNew(RobotMap.ELEVATOR_SWITCH));
		addSequential(new AutoDriveCommandKeepPos(40, 3));
		addSequential(new DelayCommand(0.25));
		addSequential(new IntakeOutXSecCommand(.5));// Spit out the cube for 2
	}

	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	// THESE ARE ALL THE AUTOMODES FOR POSITION 2
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

	/**
	 * This is bread and butter. Starts in position 2. Puts cube in RIGHT side of
	 * switch.
	 */
	public void breadButterRight() {
		addSequential(new ClampIntakeCommand(true));// clamp the intake
		addParallel(new IntakeXSecCommand(.25));// turn on the intake for a quarter of a sec
		addSequential(new AutoTurnCommandV290(45));// was 45
		addSequential(new ResetEncoders());
		addParallel(new SetElevatorCommandNew(RobotMap.ELEVATOR_SWITCH));// Move the elevator to the switch position
		addSequential(new DelayCommand(0.25));
		addSequential(new AutoDriveCommand(99, 4));// while driving to the switch
		addSequential(new IntakeOutXSecCommand(0.5));// SPIT OUT THE FIRST CUBE
	}

	/**
	 * This is bread and butter with garlic. Starts in position 2. Puts 2 cubes in
	 * RIGHT side of switch.
	 */
	public void breadButterGarlicRight() {
		addSequential(new ClampIntakeCommand(true));// clamp the intake
		addParallel(new IntakeXSecCommand(.25));// turn on the intake for a quarter of a sec
		addSequential(new AutoTurnCommandV290(45));// was 45
		addSequential(new ResetEncoders());
		addParallel(new SetElevatorCommandNew(RobotMap.ELEVATOR_SWITCH));// Move the elevator to the switch position
		addSequential(new DelayCommand(0.25));
		addSequential(new AutoDriveCommand(90, 4));// while driving to the switch
		addSequential(new IntakeOutXSecCommand(0.5));// SPIT OUT THE FIRST CUBE

		// THIS IS THE SECOND PART OF THE BREAD AND BUTTER. THIS IS THE
		// GARLIC.--------------
		addParallel(new ClampIntakeCommand(false));// unclamp the intake
		addParallel(new IntakeWithLaserSensorCommand());// while intaking using the laser
		addParallel(new SetElevatorCommandNewDown(RobotMap.ELEVATOR_HOME));// also while lowering the elevator to 0
		addSequential(new AutoDriveCommand(-40, 2));// and while driving back 2 feet
		addSequential(new ResetEncoders());
		addSequential(new AutoTurnCommandV290(-60));// Turn clockwise 50 degrees
		addSequential(new ResetEncoders());
		// addSequential(new AutoTurnVisionCommandV2());// Line up with a cube using
		// turn vision
		// addSequential(new ResetEncoders());
		addSequential(new AutoDriveVisionCommandV2());// Drive towards cube using vision
		addSequential(new IntakeXSecCommand(0.5));// and intake for the cube for half a second
		addParallel(new ClampIntakeCommand(true));// clamp the cube
		addParallel(new SetElevatorCommandNew(RobotMap.ELEVATOR_SWITCH));// while raising the elevator to switch height
		addSequential(new ResetEncoders());
		addSequential(new AutoDriveCommand(-24, 3));
		addSequential(new ResetEncoders());
		addSequential(new AutoTurnCommandV290(60));// turn 70 degrees counterclockwise
		addSequential(new ResetEncoders());
		addSequential(new AutoDriveCommand(55, 2));// drive forwards a foot
		addSequential(new IntakeOutXSecCommand(0.5));// SPIT OUT THE SECOND CUBE

		// THIS IS THE TRIPLE
		addParallel(new ClampIntakeCommand(false));// unclamp the intake
		addParallel(new IntakeWithLaserSensorCommand());// while intaking using the laser
		addParallel(new SetElevatorCommandNewDown(RobotMap.ELEVATOR_HOME));// also while lowering the elevator to 0
		addSequential(new AutoDriveCommand(-35, 2));// and while driving back 2 feet
		addSequential(new ResetEncoders());
		addSequential(new AutoTurnCommandV290(-58));// Turn clockwise 50 degrees
		addSequential(new ResetEncoders());
		// addSequential(new AutoTurnVisionCommandV2());// Line up with a cube using
		// turn vision
		// addSequential(new ResetEncoders());
		addSequential(new AutoDriveCommandKeepPos(12, 1));
		addSequential(new AutoDriveVisionCommandV2());// Drive towards cube using vision
		addSequential(new IntakeXSecCommand(0.5));// and intake for the cube for half a second
		addParallel(new ClampIntakeCommand(true));// clamp the cube
		addSequential(new AutoDriveCommand(-24, 3));
		addSequential(new ResetEncoders());
		addSequential(new AutoTurnCommandV290(60));// turn 70 degrees counterclockwise
		addParallel(new SetElevatorCommandNew(RobotMap.ELEVATOR_SWITCH));// while raising the elevator to switch height
		addSequential(new ResetEncoders());
		addSequential(new AutoDriveCommand(60, 2));// drive forwards a foot
		addSequential(new IntakeOutXSecCommand(0.5));// SPIT OUT THE THIRD CUBE

	}

	public void breadAndButterRightFastGarlic() {
		addSequential(new ClampIntakeCommand(true));// clamp the intake
		addParallel(new IntakeXSecCommand(.25));// turn on the intake for a quarter of a sec
		addSequential(new AutoTurnCommandVKeepPosSecondsPram(50, 1, 0.75, 1));// was 45
		addSequential(new ResetEncoders());
		addParallel(new SetElevatorCommandNew(RobotMap.ELEVATOR_SWITCH));// Move the elevator to the switch position
		addSequential(new DelayCommand(0.25));
		addSequential(new AutoDriveCommand(90, 4));// while driving to the switch
		addSequential(new IntakeOutXSecCommand(0.5));// SPIT OUT THE FIRST CUBE

		// THIS IS THE SECOND PART OF THE BREAD AND BUTTER. THIS IS THE
		// GARLIC.--------------
		addParallel(new ClampIntakeCommand(false));// unclamp the intake
		addParallel(new IntakeWithLaserSensorCommand());// while intaking using the laser
		addParallel(new SetElevatorCommandNewDown(RobotMap.ELEVATOR_HOME));// also while lowering the elevator to 0
		addSequential(new AutoDriveCommand(-40, 2));// and while driving back 2 feet
		addSequential(new ResetEncoders());
		addSequential(new AutoTurnCommandVKeepPosSecondsPram(-60, 1, 0.85, 1));// Turn clockwise 50 degrees
		addSequential(new ResetEncoders());
		// addSequential(new AutoTurnVisionCommandV2());// Line up with a cube using
		// turn vision
		// addSequential(new ResetEncoders());
		addSequential(new AutoDriveVisionCommandV2());// Drive towards cube using vision
		addSequential(new IntakeXSecCommand(0.5));// and intake for the cube for half a second
		addParallel(new ClampIntakeCommand(true));// clamp the cube
		addParallel(new SetElevatorCommandNew(RobotMap.ELEVATOR_SWITCH));// while raising the elevator to switch height
		addSequential(new ResetEncoders());
		addSequential(new AutoDriveCommand(-24, 3));
		addSequential(new ResetEncoders());
		addSequential(new AutoTurnCommandVKeepPosSecondsPram(60, 1, 0.85, 1));// turn 70 degrees counterclockwise
		addSequential(new ResetEncoders());
		addSequential(new AutoDriveCommand(60, 2));// drive forwards a foot
		addSequential(new IntakeOutXSecCommand(0.5));// SPIT OUT THE SECOND CUBE

		// THIS IS THE TRIPLE
		addParallel(new ClampIntakeCommand(false));// unclamp the intake
		addParallel(new IntakeWithLaserSensorCommand());// while intaking using the laser
		addParallel(new SetElevatorCommandNewDown(RobotMap.ELEVATOR_HOME));// also while lowering the elevator to 0
		addSequential(new AutoDriveCommand(-35, 2));// and while driving back 2 feet
		addSequential(new ResetEncoders());
		addSequential(new AutoTurnCommandVKeepPosSecondsPram(-50, 1, 0.85, 1));// Turn clockwise 50 degrees
		addSequential(new ResetEncoders());
		// addSequential(new AutoTurnVisionCommandV2());// Line up with a cube using
		// turn vision
		// addSequential(new ResetEncoders());
		// addSequential(new AutoDriveVisionCommandV2());// Drive towards cube using
		// vision
		addSequential(new AutoDriveVisionCommandV2());// Drive towards cube using vision
		addSequential(new IntakeXSecCommand(0.5));// and intake for the cube for half a second
		addParallel(new ClampIntakeCommand(true));// clamp the cube
		addSequential(new AutoDriveCommand(-24, 3));
		addSequential(new ResetEncoders());
		addSequential(new AutoTurnCommandVKeepPosSecondsPram(60, 1, 0.85, 1));// turn 70 degrees counterclockwise
		addParallel(new SetElevatorCommandNew(RobotMap.ELEVATOR_SWITCH));// while raising the elevator to switch height
		addSequential(new ResetEncoders());
		addSequential(new AutoDriveCommand(60, 2));// drive forwards a foot
		addSequential(new IntakeOutXSecCommand(0.5));// SPIT OUT THE THIRD CUBE

	}

	/**
	 * This is bread and butter. Starts in position 2. Puts cube in LEFT side of
	 * switch.
	 */
	public void breadButterLeft() {
		addSequential(new ClampIntakeCommand(true));// clamp the intake
		addParallel(new IntakeXSecCommand(.25));// turn on the intake for a quarter of a sec
		addParallel(new SetElevatorCommandNew(RobotMap.ELEVATOR_SWITCH));// Move the elevator to the switch position
		addSequential(new ResetEncoders());
		addSequential(new AutoDriveCommand(99, 4));// while driving to the switch
		addSequential(new ResetEncoders());
		addSequential(new IntakeOutXSecCommand(0.5));// SPIT OUT THE FIRST CUBE
	}

	/**
	 * This is bread and butter with garlic. Starts in position 2. Puts 2 cubes in
	 * LEFT side of switch.
	 */
	public void breadAndButterLeftGarlic() {

		addSequential(new ClampIntakeCommand(true));// clamp the intake
		addParallel(new IntakeXSecCommand(.25));// turn on the intake for a quarter of a sec
		addParallel(new SetElevatorCommandNew(RobotMap.ELEVATOR_SWITCH));// Move the elevator to the switch position
		addSequential(new ResetEncoders());
		addSequential(new AutoDriveCommand(99, 4));// while driving to the switch
		addSequential(new ResetEncoders());
		addSequential(new IntakeOutXSecCommand(0.5));// SPIT OUT THE FIRST CUBE

		// THIS IS THE SECOND PART OF THE BREAD AND BUTTER. THIS IS THE
		// GARLIC.--------------
		addParallel(new ClampIntakeCommand(false));// unclamp the intake
		addParallel(new IntakeWithLaserSensorCommand());// while intaking using the laser
		addParallel(new SetElevatorCommandNewDown(RobotMap.ELEVATOR_HOME));// also while lowering the elevator to 0
		addSequential(new AutoDriveCommand(-48, 2));// and while driving back 2 feet
		addSequential(new ResetEncoders());
		addSequential(new AutoTurnCommandV290(40));// Turn clockwise 50 degrees
		addSequential(new ResetEncoders());
		// addSequential(new AutoTurnVisionCommandV2());// Line up with a cube using
		// turn vision
		// addSequential(new ResetEncoders());
		addSequential(new AutoDriveVisionCommandV2());// Drive towards cube using vision
		addSequential(new IntakeXSecCommand(0.5));// and intake for the cube for half a second
		addParallel(new ClampIntakeCommand(true));// clamp the cube
		addParallel(new SetElevatorCommandNew(RobotMap.ELEVATOR_SWITCH));// while raising the elevator to switch height
		addSequential(new ResetEncoders());
		addSequential(new AutoDriveCommand(-24, 3));
		addSequential(new ResetEncoders());
		addSequential(new AutoTurnCommandV290(-50));// turn 70 degrees counterclockwise
		addSequential(new ResetEncoders());
		addSequential(new AutoDriveCommand(55, 2));// drive forwards a foot
		addSequential(new ResetEncoders());
		addSequential(new IntakeOutXSecCommand(0.5));// SPIT OUT THE SECOND CUBE

		// THIS IS THE TRIPLE
		addParallel(new ClampIntakeCommand(false));// unclamp the intake
		addParallel(new IntakeWithLaserSensorCommand());// while intaking using the laser
		addParallel(new SetElevatorCommandNewDown(RobotMap.ELEVATOR_HOME));// also while lowering the elevator to 0
		addSequential(new AutoDriveCommand(-35, 2));// and while driving back 2 feet
		addSequential(new ResetEncoders());
		addSequential(new AutoTurnCommandV290(38));// Turn clockwise 50 degrees
		addSequential(new ResetEncoders());
		// addSequential(new AutoTurnVisionCommandV2());// Line up with a cube using
		// turn vision
		// addSequential(new ResetEncoders());
		addSequential(new AutoDriveCommandKeepPos(12, 1));
		addSequential(new AutoDriveVisionCommandV2SpeedPram(0.60, 0.80));// Drive towards cube using vision
		addSequential(new IntakeXSecCommand(0.5));// and intake for the cube for half a second
		addParallel(new ClampIntakeCommand(true));// clamp the cube
		addSequential(new AutoDriveCommand(-24, 3));
		addSequential(new ResetEncoders());
		addSequential(new AutoTurnCommandV290(-50));// turn 70 degrees counterclockwise
		addParallel(new SetElevatorCommandNew(RobotMap.ELEVATOR_SWITCH));// while raising the elevator to switch height
		addSequential(new ResetEncoders());
		addSequential(new AutoDriveCommand(55, 2));// drive forwards a foot
		addSequential(new ResetEncoders());
		addSequential(new IntakeOutXSecCommand(0.5));// SPIT OUT THE THIRD CUBE

	}

	public void breadAndButterLeftFastGarlic() {

		addSequential(new ClampIntakeCommand(true));// clamp the intake
		addParallel(new IntakeXSecCommand(.25));// turn on the intake for a quarter of a sec
		addParallel(new SetElevatorCommandNew(RobotMap.ELEVATOR_SWITCH));// Move the elevator to the switch position
		addSequential(new ResetEncoders());
		addSequential(new AutoDriveCommand(99, 4));// while driving to the switch
		addSequential(new ResetEncoders());
		addSequential(new IntakeOutXSecCommand(0.5));// SPIT OUT THE FIRST CUBE

		// THIS IS THE SECOND PART OF THE BREAD AND BUTTER. THIS IS THE
		// GARLIC.--------------
		addParallel(new ClampIntakeCommand(false));// unclamp the intake
		addParallel(new IntakeWithLaserSensorCommand());// while intaking using the laser
		addParallel(new SetElevatorCommandNewDown(RobotMap.ELEVATOR_HOME));// also while lowering the elevator to 0
		addSequential(new AutoDriveCommand(-48, 2));// and while driving back 2 feet
		addSequential(new ResetEncoders());
		addSequential(new AutoTurnCommandVKeepPosSecondsPram(40, 1, 0.85, 1));// Turn clockwise 50 degrees
		addSequential(new ResetEncoders());
		// addSequential(new AutoTurnVisionCommandV2());// Line up with a cube using
		// turn vision
		// addSequential(new ResetEncoders());
		addSequential(new AutoDriveVisionCommandV2());// Drive towards cube using vision
		addSequential(new IntakeXSecCommand(0.5));// and intake for the cube for half a second
		addParallel(new ClampIntakeCommand(true));// clamp the cube
		addSequential(new AutoDriveCommand(-24, 3));
		addSequential(new ResetEncoders());
		addSequential(new AutoTurnCommandVKeepPosSecondsPram(-50, 1, 0.85, 1));// turn 70 degrees counterclockwise
		addParallel(new SetElevatorCommandNew(RobotMap.ELEVATOR_SWITCH));// while raising the elevator to switch height
		addSequential(new ResetEncoders());
		addSequential(new AutoDriveCommand(55, 2));// drive forwards a foot
		addSequential(new ResetEncoders());
		addSequential(new IntakeOutXSecCommand(0.5));// SPIT OUT THE SECOND CUBE

		// THIS IS THE TRIPLE
		addParallel(new ClampIntakeCommand(false));// unclamp the intake
		addParallel(new IntakeWithLaserSensorCommand());// while intaking using the laser
		addParallel(new SetElevatorCommandNewDown(RobotMap.ELEVATOR_HOME));// also while lowering the elevator to 0
		addSequential(new AutoDriveCommand(-35, 2));// and while driving back 2 feet
		addSequential(new ResetEncoders());
		addSequential(new AutoTurnCommandVKeepPosSecondsPram(30, 1, 0.85, 1));// Turn clockwise 50 degrees
		addSequential(new ResetEncoders());
		// addSequential(new AutoTurnVisionCommandV2());// Line up with a cube using
		// turn vision
		// addSequential(new ResetEncoders());
		// addSequential(new AutoDriveVisionCommandV2());// Drive towards cube using
		// vision
		addSequential(new AutoDriveVisionCommandV2());// Drive towards cube using vision
		addSequential(new IntakeXSecCommand(0.5));// and intake for the cube for half a second
		addParallel(new ClampIntakeCommand(true));// clamp the cube
		addSequential(new AutoDriveCommand(-24, 3));
		addSequential(new ResetEncoders());
		addSequential(new AutoTurnCommandVKeepPosSecondsPram(-50, 1, 0.85, 1));// turn 70 degrees counterclockwise
		addParallel(new SetElevatorCommandNew(RobotMap.ELEVATOR_SWITCH));// while raising the elevator to switch height
		addSequential(new ResetEncoders());
		addSequential(new AutoDriveCommand(55, 2));// drive forwards a foot
		addSequential(new ResetEncoders());
		addSequential(new IntakeOutXSecCommand(0.5));// SPIT OUT THE THIRD CUBE
	}

	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	// THESE ARE ALL THE AUTOMODES FOR POSITION 3
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

	/**
	 * Cross the auto line [B1]
	 */
	public void B1() {
		addParallel(new ClampIntakeCommand(true));// Clamp the intake
		addParallel(new IntakeXSecCommand(1));// while intaking the cube for a sec
		addSequential(new SetElevatorCommandNew(RobotMap.ELEVATOR_DRIVE));// also while raising the elevator to 1000
		addSequential(new AutoDriveCommandKeepPos(210, 5));// Driving straight towards the scale
		addSequential(new AutoTurnCommandVKeepPos(-90));
		addSequential(new DelayCommand(0.25));
		addSequential(new AutoDriveCommandKeepPos(80, 3));
	}

	/**
	 * 1 cube right switch from side [B2]
	 */
	public void B2() {
		addParallel(new ClampIntakeCommand(true));// Clamp the intake
		addParallel(new IntakeXSecCommand(1));// while intaking the cube for a sec
		addSequential(new AutoDriveCommandKeepPos(145, 5));// Driving straight towards the scale
		addSequential(new AutoTurnCommandVKeepPos(-90));
		addParallel(new SetElevatorCommandNew(RobotMap.ELEVATOR_SWITCH));// also while raising the elevator to 1000
		addSequential(new AutoDriveCommandKeepPos(20, 3));// Driving straight towards the scale
		addSequential(new IntakeOutXSecCommand(.5));// Spit out the cube for 2
		addSequential(new AutoDriveCommandKeepPos(-20, 3));// Driving straight towards the scale
		addSequential(new AutoTurnCommandVKeepPos(-90));
		addSequential(new AutoDriveCommandKeepPos(-80, 3));// Driving straight towards the scale
		addSequential(new IntakeWithLaserSensorCommand());
		addSequential(new AutoTurnCommandVKeepPos(30));
		addSequential(new AutoTurnVisionCommandV2());
		addSequential(new AutoDriveVisionCommandV2());
		addSequential(new IntakeInCommand(0.5));
	}

	/**
	 * 1 cube right scale from front [B3]
	 */
	public void B3() {
		addParallel(new ClampIntakeCommand(true));// Clamp the intake
		addParallel(new IntakeXSecCommand(1));// while intaking the cube for a sec
		addSequential(new SetElevatorCommandNew(RobotMap.ELEVATOR_DRIVE));// also while raising the elevator to 1000
		addSequential(new AutoDriveCommand(280, 5));// Driving straight towards the scale
		addSequential(new AutoTurnCommandV290(-90));
		addSequential(new DelayCommand(0.25));
		addSequential(new AutoDriveCommand(-20, 2));// Driving straight towards the scale
		addSequential(new SetElevatorCommandNew(RobotMap.ELEVATOR_SCALE));// Then, raise
		addSequential(new DelayCommand(0.25));// Settle the robot
		addSequential(new IntakeOutXSecCommand(.5));// Spit out the cube for 2
	}

	/**
	 * 1 cube to left scale [B4]
	 */
	public void B4() {
		addParallel(new ClampIntakeCommand(true));// Clamp the intake
		addParallel(new IntakeXSecCommand(1));// while intaking the cube for a sec
		addSequential(new SetElevatorCommandNew(RobotMap.ELEVATOR_DRIVE));
		addSequential(new AutoDriveCommandKeepPos(210, 5));// Driving straight towards the hallway
		addSequential(new DelayCommand(0.25));
		addSequential(new ResetEncoders());
		addSequential(new AutoTurnCommandVKeepPosSeconds(-89, 1));
		addSequential(new DelayCommand(0.5));
		addSequential(new ResetEncoders());
		addSequential(new AutoDriveCommandKeepPos(210, 5));// Drive through the hallway
		addSequential(new ResetEncoders());
		addSequential(new AutoTurnCommandVKeepPosSeconds(125, 1));
		addSequential(new ResetEncoders());
		addSequential(new AutoDriveCommandToLine(0.6, 15));
		addSequential(new DelayCommand(0.25));
		addSequential(new AutoDriveCommandKeepPos(-6, 3));
		addSequential(new SetElevatorCommandNew(RobotMap.ELEVATOR_SCALE));
		addSequential(new IntakeOutXSecCommand(.5));// Spit out the cube for 2
		addSequential(new SetElevatorCommandNewDown(RobotMap.ELEVATOR_HOME));
	}

	/**
	 * 2 cubes on the right scale [B5]
	 */
	public void B5() {
		addParallel(new ClampIntakeCommand(true));// Clamp the intake
		addParallel(new IntakeXSecCommand(1));// while intaking the cube for a sec
		addSequential(new SetElevatorCommandNew(RobotMap.ELEVATOR_DRIVE));// also while raising the elevator to 1000
		addSequential(new AutoDriveCommand(262.5, 5));// Driving straight towards the scale
		addSequential(new ResetEncoders());
		addSequential(new AutoTurnCommandV290(-70));
		addSequential(new ResetEncoders());
		addSequential(new SetElevatorCommandNew(RobotMap.ELEVATOR_SCALE));// Then, raise
		addSequential(new ResetEncoders());// Settle the robot
		addSequential(new IntakeOutXSecCommand(.5));// Spit out the cube for 2
		addParallel(new ClampIntakeCommand(false));// Clamp the intake
		addSequential(new SetElevatorCommandNewDown(RobotMap.ELEVATOR_HOME));
		addSequential(new ResetEncoders());// Settle the robot
		addSequential(new AutoTurnCommandV290(-80));
		addParallel(new IntakeWithLaserSensorCommand());
		addSequential(new AutoDriveCommandKeepPos(20, 2));
		addSequential(new AutoTurnVisionCommandV2());
		addSequential(new ResetEncoders());// Settle the robot
		addSequential(new AutoDriveVisionCommandV2());
		addSequential(new IntakeXSecCommand(1));
		addSequential(new AutoDriveCommand(-20, 2));
		addSequential(new AutoTurnCommandV290(80));
		addSequential(new SetElevatorCommandNew(RobotMap.ELEVATOR_SCALE));
		addSequential(new ResetEncoders());// Settle the robot
		addSequential(new IntakeOutXSecCommand(0.5));
	}
	
	/**
	 * 2 cubes on the right scale [B5]
	 */
	public void B5New() {
		addParallel(new ClampIntakeCommand(true));// Clamp the intake
		addParallel(new IntakeXSecCommand(1));// while intaking the cube for a sec
		addParallel(new SetElevatorCommandNew(6600));// also while raising the elevator to 1000
		// addParallel(new SetElevatorCommandNew(RobotMap.ELEVATOR_SCALE));// also while
		// raising the elevator to 1000
		addSequential(new AutoDriveCommandNew(250, 5));// Driving straight towards the scale
		addSequential(new AutoTurnCommandVKeepPosSeconds(-45, 1.5));
		addSequential(new ResetEncoders());
		// addSequential(new AutoTurnCommandVKeepPosSeconds(70, 1));
		// addSequential(new ResetEncoders());
		// addSequential(new SetElevatorCommand(RobotMap.ELEVATOR_SCALE));// Then, raise
		addSequential(new ResetEncoders());// Settle the robot
		addSequential(new IntakeOutXSecCommand(.5));// Spit out the cube for 2
		addParallel(new ClampIntakeCommand(false));// Clamp the intake
		addParallel(new AutoDriveCommandKeepPos(-20, 1.5));
		addSequential(new SetElevatorCommandNewDown(400));
		addSequential(new ResetEncoders());// Settle the robot
		addSequential(new AutoTurnCommandVKeepPosSeconds(-90, 4));
		addParallel(new IntakeWithLaserSensorCommand());
		addSequential(new AutoDriveCommand(20, 1));
		addSequential(new AutoTurnVisionCommandV2());
		addSequential(new ResetEncoders());// Settle the robot
		addSequential(new AutoDriveVisionCommandV2());
		addParallel(new ClampIntakeCommand(true));// Clamp the intake
		addSequential(new IntakeXSecCommand(1.5));
		addSequential(new IntakeXSecCommand(1));
		addSequential(new AutoDriveCommand(-20, 2));
		addSequential(new IntakeXSecCommand(0.5));
		addSequential(new AutoTurnCommandVKeepPosSeconds(120, 3));
		// addSequential(new AutoDriveCommandKeepPos(20, 2.5));
		addParallel(new SetElevatorCommandNew(6600));
		addSequential(new AutoDriveCommand(45, 1));
		addSequential(new ResetEncoders());// Settle the robot
		addSequential(new IntakeOutXSecCommand(0.5));
		addParallel(new ClampIntakeCommand(false));// Clamp the intake
		addParallel(new AutoDriveCommandKeepPos(-20, 1.5));
		addSequential(new SetElevatorCommandNewDown(400));
		addSequential(new ResetEncoders());// Settle the robot
		addSequential(new AutoTurnCommandVKeepPosSeconds(-150, 1));
		addParallel(new IntakeWithLaserSensorCommand());
		addSequential(new AutoDriveCommand(20, 1));
		addSequential(new AutoDriveVisionCommandV2());
		addSequential(new ResetEncoders());// Settle the robot
		addSequential(new AutoDriveVisionCommandV2());
		addParallel(new ClampIntakeCommand(true));// Clamp the intake
		addSequential(new IntakeXSecCommand(1));
		// addSequential(new AutoDriveCommand(-60, 2));
		addSequential(new AutoTurnCommandVKeepPosSeconds(150, 3));
		// addSequential(new AutoDriveCommandKeepPos(20, 2.5));
		addSequential(new SetElevatorCommandNew(6600));
		addSequential(new AutoDriveCommandNew(20, 1));
		addSequential(new ResetEncoders());// Settle the robot
		addSequential(new IntakeOutXSecCommand(0.5));
	}

	/**
	 * 2 cubes on the left scale [B6]
	 */
	public void B6() {
		addParallel(new ClampIntakeCommand(true));// Clamp the intake
		addParallel(new IntakeXSecCommand(1));// while intaking the cube for a sec
		addSequential(new SetElevatorCommandNew(RobotMap.ELEVATOR_DRIVE));
		addSequential(new AutoDriveCommandKeepPos(210, 5));// Driving straight towards the hallway
		addSequential(new DelayCommand(0.25));
		addSequential(new ResetEncoders());
		addSequential(new AutoTurnCommandVKeepPos(-89));
		addSequential(new ResetEncoders());
		addSequential(new AutoDriveCommandKeepPos(220, 5));// Drive through the hallway
		addSequential(new ResetEncoders());
		addSequential(new AutoTurnCommandVKeepPos(125));
		addSequential(new ResetEncoders());
		addSequential(new AutoDriveCommandToLine(0.6, 15));
		addSequential(new SetElevatorCommandNew(RobotMap.ELEVATOR_SCALE));
		addSequential(new IntakeOutXSecCommand(.5));// Spit out the cube for 2
		addSequential(new SetElevatorCommandNewDown(RobotMap.ELEVATOR_HOME));
		addSequential(new AutoTurnCommandVKeepPos(89));
		addSequential(new IntakeWithLaserSensorCommand());
		addSequential(new ResetEncoders());
		addSequential(new AutoDriveCommandKeepPos(20, 3));
		addSequential(new ResetEncoders());
		addSequential(new AutoTurnVisionCommandV2());
		addSequential(new ResetEncoders());
		addSequential(new AutoDriveVisionCommandV2());
		addSequential(new IntakeInCommand(0.5));

	}

	/**
	 * First cube to right switch from side and second cube to right scale [B7]
	 */
	public void B7() {
		addParallel(new ClampIntakeCommand(true));// Clamp the intake
		addParallel(new DelayCommand(0.15));
		addParallel(new IntakeXSecCommand(1));// while intaking the cube for a sec
		addSequential(new AutoDriveCommand(126, 5));// Driving straight towards the scale
		addSequential(new AutoTurnCommandV290(-90));
		addSequential(new SetElevatorCommandNew(RobotMap.ELEVATOR_SWITCH));// also while raising the elevator to 1000
		addParallel(new ClampIntakeCommand(true));// Clamp the intake
		addSequential(new IntakeOutXSecCommand(.5));// Spit out the cube for 2
		addSequential(new SetElevatorCommandNewDown(RobotMap.ELEVATOR_HOME));
		addParallel(new ClampIntakeCommand(false));
		addSequential(new AutoTurnCommandV290(90));
		addSequential(new AutoDriveCommand(60, 2));
		addSequential(new AutoTurnCommandV290(-90));
		addSequential(new DelayCommand(0.15));
		addSequential(new AutoDriveCommand(24, 5));// Trying to go to the cube right next to switch
		addSequential(new AutoTurnCommandV2(-90));// Turn towards the cube
		addSequential(new DelayCommand(0.15));// HUNTER COMMAND COMMENCE
		addParallel(new IntakeWithLaserSensorCommand());// Spit out the cube for 2
		addSequential(new AutoTurnVisionCommandV2());// Line up with a cube using turn vision
		addSequential(new AutoDriveVisionCommandV2());
		addParallel(new ClampIntakeCommand(true));
		addSequential(new DelayCommand(0.15));
		addSequential(new AutoTurnCommandV290(180));
		addSequential(new AutoDriveCommand(72, 4));
		addSequential(new SetElevatorCommandNew(RobotMap.ELEVATOR_SCALE));
		addSequential(new setElevatorSpeed(0));
		addSequential(new IntakeOutXSecCommand(1));// Spit out the cube for 2

		// WHAT MIGHT WORK INSTAED, JUST NOT FINISHED//

		addParallel(new ClampIntakeCommand(true));// Clamp the intake
		addParallel(new IntakeXSecCommand(1));// while intaking the cube for a sec
		addParallel(new SetElevatorCommand(RobotMap.ELEVATOR_SWITCH));// also while raising the elevator to 1000
		addSequential(new AutoDriveCommandKeepPos(145, 5));// Driving straight towards the scale
		addSequential(new AutoTurnCommandVKeepPos(-90));
		addSequential(new AutoDriveCommandKeepPos(10, 2));// Driving straight towards the scale
		addSequential(new IntakeOutXSecCommand(.5));// Spit out the cube for 2
		addSequential(new AutoDriveCommandKeepPos(-10, 2));// Driving straight towards the scale
		addSequential(new AutoTurnCommandVKeepPos(90));

		// HAVE NOT FINISHED THE REST OF THE CODE FOR THIS AUTO//

		// addSequential(new AutoDriveCommand(135, 5));// Driving straight towards the
		// scale
		// addSequential(new AutoTurnCommandV2(-70));
		// addSequential(new DelayCommand(0.25));
		// addSequential(new AutoDriveCommand(-12, 2));// Driving straight towards the
		// scale
		// addSequential(new SetElevatorCommand(RobotMap.ELEVATOR_SCALE));// Then, raise
		// addSequential(new DelayCommand(0.25));// Settle the robot
		// addSequential(new IntakeOutXSecCommand(.5));// Spit out the cube for 2

	}

	/**
	 * First cube to right switch from side and go to left side of the scale [B8]
	 */
	public void B8() {
		addParallel(new ClampIntakeCommand(true));// Clamp the intake

		addParallel(new DelayCommand(0.15));
		addParallel(new IntakeXSecCommand(1));// while intaking the cube for a sec
		addSequential(new AutoDriveCommand(126, 5));// Driving straight towards the scale
		addSequential(new AutoTurnCommandV290(-90));
		addSequential(new SetElevatorCommandNew(RobotMap.ELEVATOR_SWITCH));// also while raising the elevator to 1000
		addParallel(new ClampIntakeCommand(true));// Clamp the intake
		addSequential(new IntakeOutXSecCommand(.5));// Spit out the cube for 2
		addSequential(new SetElevatorCommandNewDown(RobotMap.ELEVATOR_HOME));
		addSequential(new setElevatorSpeed(0));
		addParallel(new ClampIntakeCommand(false));
		addSequential(new AutoTurnCommandV290(90));
		addSequential(new AutoDriveCommand(60, 2));
		addSequential(new AutoTurnCommandV290(-90));
		addSequential(new DelayCommand(0.15));
		addSequential(new AutoDriveCommand(162, 5));
		addSequential(new AutoTurnCommandV290(-90));// Turn towards the cube
		addSequential(new DelayCommand(0.15));// HUNTER COMMAND COMMENCE
		addParallel(new IntakeWithLaserSensorCommand());// Spit out the cube for 2
		addSequential(new AutoTurnVisionCommandV2());// Line up with a cube using turn vision
		addSequential(new AutoDriveVisionCommandV2());
		addParallel(new ClampIntakeCommand(true));
		addSequential(new DelayCommand(0.15));
		addSequential(new AutoTurnCommandV290(180));
		addSequential(new AutoDriveCommand(72, 4));
		addSequential(new SetElevatorCommandNew(RobotMap.ELEVATOR_SCALE));
		addSequential(new setElevatorSpeed(0));
		addSequential(new IntakeOutXSecCommand(1));// Spit out the cube for 2

	}

	/**
	 * First cube to right scale second cube to right switch backside [B9]
	 */
	public void B9() {
		addSequential(new ResetEncoders());
		addParallel(new ClampIntakeCommand(true));// Clamp the intake
		addParallel(new IntakeXSecCommand(1));// while intaking the cube for a sec
		addParallel(new SetElevatorCommandNew(RobotMap.ELEVATOR_DRIVE));// also while raising the elevator to 1000
		addSequential(new AutoDriveCommandKeepPos(235, 5));// Driving straight towards the scale
		addSequential(new ResetEncoders());
		addSequential(new AutoTurnCommandVKeepPosSecondsPram(-40, 1.45, 0.65, 1));
		// addSequential(new ResetEncoders());
		// addSequential(new AutoDriveCommandToLine(0.6, 6));
		addSequential(new ResetEncoders());
		addSequential(new SetElevatorCommandNew(RobotMap.ELEVATOR_SCALE));// Then, raise
		addSequential(new ResetEncoders());// Settle the robot
		addSequential(new IntakeOutXSecCommand(.5));// Spit out the cube for 2
		addSequential(new ClampIntakeCommand(false));// Clamp the intake
		addSequential(new SetElevatorCommandNewDown(RobotMap.ELEVATOR_HOME));
		addSequential(new ResetEncoders());// Settle the robot
		addSequential(new AutoTurnCommandVKeepPosSeconds(-110, 1.3));
		addParallel(new IntakeWithLaserSensorCommand());
		addSequential(new AutoDriveCommandKeepPos(20, 1.25));
		addSequential(new AutoTurnVisionCommandV2());
		addSequential(new ResetEncoders());// Settle the robot
		addSequential(new AutoDriveVisionCommandV2());
		addSequential(new IntakeXSecCommand(1));
		addSequential(new ClampIntakeCommand(true));
		addSequential(new SetElevatorCommandNew(RobotMap.ELEVATOR_SWITCH));
		addSequential(new AutoDriveCommand(10, 1.25));
		addSequential(new IntakeOutXSecCommand(0.5));
	}

	/**
	 * First cube on the left scale; second cube on the back side of left switch
	 * [B10]
	 */
	public void B10() {
		addParallel(new ClampIntakeCommand(true));// Clamp the intake
		addParallel(new IntakeXSecCommand(1));// while intaking the cube for a sec
		addSequential(new SetElevatorCommandNew(RobotMap.ELEVATOR_DRIVE));
		addSequential(new AutoDriveCommandKeepPos(210, 5));// Driving straight towards the hallway
		addSequential(new DelayCommand(0.25));
		addSequential(new ResetEncoders());
		addSequential(new AutoTurnCommandVKeepPos(-89));
		addSequential(new ResetEncoders());
		addSequential(new AutoDriveCommandKeepPos(220, 5));// Drive through the hallway
		addSequential(new ResetEncoders());
		addSequential(new AutoTurnCommandVKeepPos(125));
		addSequential(new ResetEncoders());
		addSequential(new AutoDriveCommandToLine(0.6, 15));
		addSequential(new SetElevatorCommandNew(RobotMap.ELEVATOR_SCALE));
		addSequential(new IntakeOutXSecCommand(.5));// Spit out the cube for 2
		addSequential(new SetElevatorCommandNewDown(RobotMap.ELEVATOR_HOME));
		addSequential(new AutoTurnCommandVKeepPos(89));
		addSequential(new IntakeWithLaserSensorCommand());
		addSequential(new ResetEncoders());
		addSequential(new AutoDriveCommandKeepPos(20, 3));
		addSequential(new ResetEncoders());
		addSequential(new AutoTurnVisionCommandV2());
		addSequential(new ResetEncoders());
		addSequential(new AutoDriveVisionCommandV2());
		addSequential(new IntakeInCommand(0.5));
	}

	/**
	 * 1 cube left switch from back side [B11]
	 */
	public void B11() {
		addParallel(new ClampIntakeCommand(true));// Clamp the intake
		addParallel(new IntakeXSecCommand(1));// while intaking the cube for a sec
		addSequential(new SetElevatorCommandNew(RobotMap.ELEVATOR_DRIVE));
		addSequential(new AutoDriveCommandKeepPos(210, 5));// Driving straight towards the hallway
		addSequential(new DelayCommand(0.25));
		addSequential(new ResetEncoders());
		addSequential(new AutoTurnCommandVKeepPos(-89));
		addSequential(new ResetEncoders());
		addSequential(new AutoDriveCommandKeepPos(225, 5));// Drive through the hallway
		addSequential(new ResetEncoders());
		addSequential(new AutoTurnCommandVKeepPos(-130));
		addSequential(new ResetEncoders());
		addSequential(new SetElevatorCommandNew(RobotMap.ELEVATOR_SWITCH));
		addSequential(new AutoDriveCommandKeepPos(40, 3));
		addSequential(new DelayCommand(0.25));
		addSequential(new IntakeOutXSecCommand(.5));// Spit out the cube for 2
	}

	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	// THESE ARE ALL THE TEST AUTOMODES
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

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
		SmartDashboard.putString("DB/String 4", "Default");

		// addSequential(new AutoDriveCommand(60, 5));
	}

	public void EleTest() {
		// addSequential(new SetElevatorCommand(RobotMap.ELEVATOR_SCALE));
		// addSequential(new DelayCommand(3));
		// addSequential(new SetElevatorCommand(RobotMap.ELEVATOR_HOME));
		// addSequential(new DelayCommand(3));
		// addSequential(new SetElevatorCommand(RobotMap.ELEVATOR_SCALE));
		// addSequential(new DelayCommand(3));
		addSequential(new SetElevatorCommandNew(6600));
		addSequential(new DelayCommand(3));
		addSequential(new SetElevatorCommandNewDown(400));
	}
}
