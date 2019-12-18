/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team772.robot;

//import org.usfirst.frc.team772.lib.Sensors.pulsedLightLIDAR;
import org.usfirst.frc.team772.robot.commandGroup.AutonomousCommand;
import org.usfirst.frc.team772.robot.commands.AnalogManualElevatorCommandDown;
import org.usfirst.frc.team772.robot.commands.AnalogManualElevatorCommandUp;
import org.usfirst.frc.team772.robot.commands.AutoDriveCommand;
import org.usfirst.frc.team772.robot.commands.AutoDriveWithEnc;
import org.usfirst.frc.team772.robot.commands.AutoTurnCommand;
import org.usfirst.frc.team772.robot.commands.AutoTurnCommandV2;
import org.usfirst.frc.team772.robot.commands.ClimberCommand;
//import org.usfirst.frc.team772.robot.commands.DPADAutoTurnCommand;
import org.usfirst.frc.team772.robot.commands.DelayCommand;
import org.usfirst.frc.team772.robot.commands.DriveCommand;
import org.usfirst.frc.team772.robot.commands.IntakeOutXSecCommand;
import org.usfirst.frc.team772.robot.commands.IntakeXSecCommand;
import org.usfirst.frc.team772.robot.commands.TeleGetCube;
import org.usfirst.frc.team772.robot.subsystems.DPadButton;
import org.usfirst.frc.team772.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team772.robot.subsystems.ElevatorSubsystem;
import org.usfirst.frc.team772.robot.subsystems.ExampleSubsystem;
import org.usfirst.frc.team772.robot.subsystems.IntakeSubsystem;
import org.usfirst.frc.team772.robot.subsystems.LifterSubsystem;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	public static final ExampleSubsystem kExampleSubsystem = new ExampleSubsystem();
	public static OI m_oi;

	// THESE ARE ALL OF THE SUBSYSTEM OBJECTS
	// __________________________________________________________________________
	public static final DriveSubsystem driveSubsystem = new DriveSubsystem();
	public static final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
	public static final ElevatorSubsystem elevatorSubsystem = new ElevatorSubsystem();
	public static final LifterSubsystem lifterSubsystem = new LifterSubsystem();

	// THESE ARE ALL OF THE COMMAND OBJECTS
	// _________________________________________________________________________
	public static final DriveCommand driveRobot = new DriveCommand();
	public static final AutoDriveCommand autoDriveCommand = new AutoDriveCommand(72, 5);
	public static final AutoDriveWithEnc autoDrive = new AutoDriveWithEnc(12105);
	// public static final DriveToUltraSonicCommand driveUltra = new
	// DriveToUltraSonicCommand();
	
	public static final AnalogManualElevatorCommandUp analogManualElevatorCommandUp = new AnalogManualElevatorCommandUp();
	public static final AnalogManualElevatorCommandDown analogManualElevatorCommandDown = new AnalogManualElevatorCommandDown();

	public static AutonomousCommand autonomousCommand;

	// OBJECT DECLARATIONS
//	public static final Ultrasonic ultrasonicForward = new Ultrasonic(1, 2);
	Compressor compressor = new Compressor(RobotMap.PCM);
	public static AnalogInput laser;
	public static AnalogInput lightSensorRight;
	public static AnalogInput lightSensorLeft;
	
	public static int joyPovAngle;
	int myCounter = 0;


	// THIS IS A CUSTOM CONTROL FOR THE DRIVER
//	public static DPADAutoTurnCommand dPadTurnCommand;
//	public static IntakeXSecCommand intakeXSecCommand;


	Command m_autonomousCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be used
	 * for any initialization code.
	 */
	@Override
	public void robotInit() {
		m_oi = new OI();
		m_chooser.addDefault("Default Auto", new DelayCommand(5));
		SmartDashboard.putData("Auto mode", m_chooser);
//		ultrasonicForward.setEnabled(true);
//		ultrasonicForward.setAutomaticMode(true);
		driveSubsystem.resetEncoders();
		elevatorSubsystem.resetElevatorEncoders();
		laser = new AnalogInput(0);
		lightSensorRight = new AnalogInput(1);
		lightSensorLeft = new AnalogInput(2);

		clearDashboard();

	}

	/**
	 * This function is called once each time the robot enters Disabled mode. You
	 * can use it to reset any subsystem information you want to clear when the
	 * robot is disabled.
	 */
	@Override
	public void disabledInit() {
		SmartDashboard.putNumber("DB/Slider 4", 0);
		driveSubsystem.resetGyro();
		clearDashboard();
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		myCounter ++;
		// print
		// statements~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//		SmartDashboard.putString("DB/String 1", "Enc Ave: " + Math.round(driveSubsystem.getEncAve() * 100.0) / 100.0);
//		SmartDashboard.putString("DB/String 2", "Gyro Ave: " + Math.round(driveSubsystem.getDegrees() * 100.0) / 100.0);
//		SmartDashboard.putString("DB/String 3", "disLeFTToTravel: " + Math.round(autoDriveCommand.distanceLeftToTravel * 100.0) / 100.0);
//		SmartDashboard.putString("DB/String 5", String.format("EleEnc: %.2f", Robot.elevatorSubsystem.getElevatorEnc()));
//		SmartDashboard.putString("DB/String 7", "UltraDist: " + Robot.ultrasonicForward.getRangeInches());
//		SmartDashboard.putString("DB/String 1", "Laser: " + Robot.laser.getValue());
//		SmartDashboard.putString("DB/String 3", "Gyro: " + Robot.driveSubsystem.gyro.getAngle());
		SmartDashboard.putString("DB/String 1", "EleEnc: " + Robot.elevatorSubsystem.getElevatorEnc());
		SmartDashboard.putString("DB/String 12", "LSR: " + lightSensorRight.getVoltage());
		SmartDashboard.putString("DB/String 11", "LSL: " + lightSensorLeft.getVoltage());
		SmartDashboard.putString("DB/String 9", "Counter: " + myCounter);
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

		// this gets the position of the robot from SmartDashboard Slider 0
		RobotMap.robotPosition = SmartDashboard.getNumber("DB/Slider 0", -1);

		// this gets the autonomous preference from the SmartDashboard Slider 1
		RobotMap.preferenceCode = SmartDashboard.getNumber("DB/Slider 1", -1);
		
		

		// This is converting the double variable to an integer
		int i = (int) RobotMap.robotPosition;
		int j = (int) RobotMap.preferenceCode;
		SmartDashboard.putString("DB/String 0" ,  "RobotPos: " + i);
		SmartDashboard.putString("DB/String 2" , "PreferenceCode: " + j);

		
			
		// Robot.elevatorSubsystem.resetElevatorEncoders();

		// KILL ALL VISION VALUES
		SmartDashboard.putNumber("DegreeOffset", 0);
		SmartDashboard.putNumber("TargetX", 0);
		SmartDashboard.putNumber("TargetY", 0);
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable chooser
	 * code works with the Java SmartDashboard. If you prefer the LabVIEW Dashboard,
	 * remove all of the chooser code and uncomment the getString code to get the
	 * auto name from the text box below the Gyro
	 *
	 * <p>
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons to
	 * the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		myCounter ++;

		m_autonomousCommand = m_chooser.getSelected();

		driveRobot.cancel();
		driveSubsystem.setBrakeMode();

		
		clearDashboard();
		Robot.elevatorSubsystem.resetElevatorEncoders();
		Robot.driveSubsystem.resetEncoders();
		Robot.driveSubsystem.resetGyro();
		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
		 * switch(autoSelected) { case "My Auto": autonomousCommand = new
		 * MyAutoCommand(); break; case "Default Auto": default: autonomousCommand = new
		 * ExampleCommand(); break; }
		 */
		SmartDashboard.putString("DB/String 9", "Counter: " + myCounter);


		randomizationResult();
		// schedule the autonomous command (example)
		SmartDashboard.putNumber("DB/Slider 4", 1); //Turn on Recording  
		if (m_autonomousCommand != null) {

			
			// this sets the position in the auto command
			autonomousCommand = new AutonomousCommand((int) RobotMap.robotPosition, (int) RobotMap.preferenceCode);
		
			autonomousCommand.start();
			// autoTurnCommand.start();
			// autoDriveCommand.start();
			
		}

	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		myCounter ++;
		SmartDashboard.putString("DB/String 9", "Counter: " + myCounter);

//		print
//		statements~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//		SmartDashboard.putString("DB/String 1", "Enc Ave: " + Math.round(driveSubsystem.getEncAve() * 100.0) / 100.0);
//		SmartDashboard.putString("DB/String 2", "Gyro Ave: " + Math.round(driveSubsystem.getDegrees() * 100.0) / 100.0);
//		SmartDashboard.putString("DB/String 3", "disleftToTravel: " + Math.round(autoDriveCommand.distanceLeftToTravel * 100.0) / 100.0);
//		SmartDashboard.putString("DB/String 5", String.format("EleEnc: %.2f", Robot.elevatorSubsystem.getElevatorEnc()));
//		SmartDashboard.putString("DB/String 7", "UltraDist: " + Robot.ultrasonicForward.getRangeInches());
//		SmartDashboard.putString("DB/String 1", "Laser: " + Robot.laser.getValue());
		SmartDashboard.putString("DB/String 1", "EleEnc: " + Robot.elevatorSubsystem.getElevatorEnc());
//		SmartDashboard.putString("DB/String 2", "Error: " + Math.round(Robot.elevatorSubsystem.Elevator1Motor.getClosedLoopError(0)));
		SmartDashboard.putString("DB/String 3", "Brake: " + elevatorSubsystem.brakes.get());
//		SmartDashboard.putString("DB/String 4", "MotorOut: " + Math.round(elevatorSubsystem.Elevator1Motor.getMotorOutputPercent()));
		SmartDashboard.putString("DB/String 0" ,  "RobotPos: " + RobotMap.robotPosition);
		SmartDashboard.putString("DB/String 2" , "PreferenceCode: " + RobotMap.preferenceCode);
		SmartDashboard.putString("SET_ELSpeed: ", "Set ELSpeed: " + RobotMap.setElevatorSpeed + "ticks/100ms");
		SmartDashboard.putString("SET_ELTime: ", "Set ELTime: " + RobotMap.setElevatorTime);
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
//		driveRobot.start();//taken out by mahir
		//One of the reasons why 
		driveSubsystem.setBrakeMode();
		turnOffAllMotors();

		SmartDashboard.putNumber("DB/Slider 4", 0);

		// this cancels the auto command
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
		}

		driveSubsystem.resetGyro();

		// this starts the drive and the compressor
		driveRobot.start();// starts drive
		compressor.start();// starts compressor
		clearDashboard();
		
		RobotMap.driveSensitivity = 1;
		
		analogManualElevatorCommandUp.start();
		analogManualElevatorCommandDown.start();

	}

	/**
	 * This function is called periodically during operator control.
	 */

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		// print
		// statements~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//		SmartDashboard.putString("DB/String 0", "Gyro: " + Math.round(driveSubsystem.getDegrees()));
//		SmartDashboard.putString("DB/String 1", "REnc: " + Math.round(driveSubsystem.getRightEnc()));
//		SmartDashboard.putString("DB/String 2", "LEnc: " + Math.round(driveSubsystem.getLeftEnc()));
//		SmartDashboard.putString("DB/String 3", "Ultra: " + Math.round(ultrasonicForward.getRangeInches()));
//		SmartDashboard.putString("DB/String 4", "ElEnc: " + Math.round(elevatorSubsystem.getElevatorEnc()));
		// SmartDashboard.putString("DB/String 5",
		// String.format("%d", elevatorSubsystem.Elevator1Motor.getClosedLoopError(0)));
//		SmartDashboard.putString("DB/String 6", "EncAve: " + Math.round(Robot.driveSubsystem.getEncAve()));
		SmartDashboard.putString("DB/String 5", String.format("EleEnc: %.2f", Robot.elevatorSubsystem.getElevatorEnc()));
		
		SmartDashboard.putString("MAN_ELSpeed: ", "Man ELSpeed: " + RobotMap.manualElevatorSpeed + "ticks/100ms");
		SmartDashboard.putString("MAN_ELTime: ", "Man ELTime: " + RobotMap.manualElevatorTime);
		SmartDashboard.putString("SET_ELSpeed: ", "Set ELSpeed: " + RobotMap.setElevatorSpeed + "ticks/100ms");
		SmartDashboard.putString("SET_ELTime: ", "Set ELTime: " + RobotMap.setElevatorTime);
		
//		SmartDashboard.putString("DB/String 11", "FRM" + Robot.driveSubsystem.frontRightMotor.getOutputCurrent());
//		SmartDashboard.putString("DB/String 10", "FRM" + Robot.driveSubsystem.frontRightMotor.getOutputCurrent());
//		SmartDashboard.putString("DB/String 10", "FLM" + Robot.driveSubsystem.frontLeftMotor.getOutputCurrent());
//		SmartDashboard.putString("DB/String 10", "BRM" + Robot.driveSubsystem.backRightMotor.getOutputCurrent());
//		SmartDashboard.putString("DB/String 10", "BLM" + Robot.driveSubsystem.BackLeftMotor.getOutputCurrent());
		SmartDashboard.putString("DB/String 12", "LSR: " + lightSensorRight.getVoltage());
//		SmartDashboard.putString("DB/String 11", "LSL: " + lightSensorLeft.getVoltage());
//		SmartDashboard.putString("DB/String 11", )
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

//		RobotMap.teleTurnDegrees = m_oi.getDegreesToTurn();
		
		// This code will periodically look to see if the dPad is being used. And then
		// it will turn based on the degrees it reads.
//		if ((RobotMap.teleTurnDegrees != -1)) {
//			dPadTurnCommand = new DPADAutoTurnCommand(RobotMap.teleTurnDegrees, 2);
////			intakeXSecCommand = new IntakeXSecCommand(5);
////			driveRobot.cancel();
//			dPadTurnCommand.start();
//		} 
		
		if(Robot.m_oi.driverController.getPOV() == 0) {
			RobotMap.driveSensitivity = 1;
		}else if (Robot.m_oi.driverController.getPOV() == 180) {
			RobotMap.driveSensitivity = -.8;
		}
		
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}

	/**
	 * This method clears all the values in SmartDashboard.
	 */
	public void clearDashboard() {
		// this creates 'clear Dashboard' which clears the dashboard
//		SmartDashboard.putString("DB/String 0", "");
//		SmartDashboard.putString("DB/String 1", "");
//		SmartDashboard.putString("DB/String 2", "");
//		SmartDashboard.putString("DB/String 3", "");
//		SmartDashboard.putString("DB/String 4", "");
//		SmartDashboard.putString("DB/String 5", "");
//		SmartDashboard.putString("DB/String 6", "");
//		SmartDashboard.putString("DB/String 7", "");
//		SmartDashboard.putString("DB/String 8", "");
//		SmartDashboard.putString("DB/String 9", "");

	}

	public void turnOffAllMotors() {
		driveSubsystem.auto(0, 0);
		elevatorSubsystem.elevatorSpeed(0);
		intakeSubsystem.intakeSpeed(0);
		lifterSubsystem.moveClimber(0);
		lifterSubsystem.moveHook(0);
	}
	
	String gameData;
	/**
	 * This is the randomization method that is used to set the position of where
	 * the switch and scale is.
	 */
	public void randomizationResult() {

		boolean GotGameData = false;

		while (!GotGameData) {
			SmartDashboard.putString("DB/String 8", "No Game Data");
			Timer.delay(0.1);
			gameData = DriverStation.getInstance().getGameSpecificMessage();

			if (gameData.length() == 3) {
				SmartDashboard.putString("DB/String 8", "Got Game Data");
				SmartDashboard.putString("GAME DATA", "*"+gameData.charAt(1)+"*");
				
				SmartDashboard.putNumber("DB/Slider 4", 1); //Turn on Recording 

				GotGameData = true;

				if (gameData.charAt(0) == 'L') {
					// Put left auto code here
					RobotMap.ourSwitchSideOnLeft = true;
				} else {
					// Put right auto code here
					RobotMap.ourSwitchSideOnLeft = false;
				}
 
				if (gameData.charAt(1) == 'L') {
					// Put left auto code here
					RobotMap.ourScaleSideOnLeft = true;
				} else {
					// Put right auto code here
					RobotMap.ourScaleSideOnLeft = false;
				}

				if (gameData.charAt(2) == 'L') {
					// Put left auto code here
					RobotMap.enemySwitchSideOnLeft = true;
				} else {
					// Put right auto code here
					RobotMap.enemySwitchSideOnLeft = false;
				}

			}

		}
	}

}
