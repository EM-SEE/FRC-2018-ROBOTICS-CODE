/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team772.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	public static boolean ourSwitchSideOnLeft;
	public static boolean ourScaleSideOnLeft;
	public static boolean enemySwitchSideOnLeft;

	// $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	// CONSTANT VARIABLES
	// $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

	// Change. The variables were changed into final constants

	public static final double AUTO_TURN_TOLERANCEV2 = 0.3;//was 0.3
	public static final double AUTO_TURN_MAX_SPEEDV2 = 0.80;
	public static final double AUTO_TURN_MIN_SPEEDV2 = 0.60;
	public static final double AUTO_TURN_MAX_SPEEDV290 = 0.90;// was 0.75
	public static final double AUTO_TURN_MIN_SPEEDV290 = 0.75;

	// This conversion factor turns encoder ticks to meters
	public static final double DRIVE_CONVERTION_FACTOR = 322.983;

	public static final int ELEVATOR_HOME = 0;//
	public static final int ELEVATOR_DRIVE = 600;
	public static final int ELEVATOR_SWITCH = 2260;//was 4000
	public static final int ELEVATOR_SCALE =6800;// was 10900
	public static final int ELEVATOR_MAX = 7369;

	public static final int ELEVATOR_SPEED = 300;// was 550
	public static final int ELEVATOR_ACCEL = 600;//was 2400
	// ELEVATOR_SPEED * 3;

	public static final int LASER_INTAKE_TRUE = 1000;
//	public static final String PORTAL_HIGHT = ;
	public static double AUTO_TURN_MIN_SPEEDVTURBO = 1;
	public static double AUTO_TURN_MAX_SPEEDVTURBO = 0.65;
	public static final double MaxIntakeVoltageAllowed = 10.0;

	// $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	// PNEUMATICS
	// $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	public static int PCM = 0 ;//was 25
	public static int shotPinForward = 1;
	public static int shotPinReverse = 0;
	public static int elevatorBrakeOn = 5;
	public static int elevatorBrakeOff = 4;
	public static int intakeOpen = 2;
	public static int intakeClose = 3;

	// $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	// FLAG/DYNAMIC VARIABLES
	// $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

	// This variable holds the position of the robot in autonomous
	public static double robotPosition;
	public static double preferenceCode;
	public static boolean ClimberUp = true;
	public static boolean Climberdown = true;

	public static int teleTurnDegrees;// Degrees to turn using DPAD

	// $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	// DRIVE SUBSYSTEM VARIABLES
	// $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

	// this states whether the motors are inverted or not
	public static boolean frontRightMotorInverted = false;
	public static boolean backRightMotorInverted = false;
	public static boolean frontLeftMotorInverted = false;
	public static boolean backLeftMotorInverted = false;

	public static int LaserLocation = 0;
	public static double lowVoltLeft = 0;
	public static double highVoltLeft = 1.6;
	public static double lowVoltRight = 0;
	public static double highVoltRight = 1.6;
	
	public static double driveSensitivity = 1;
	
	public static double manualElevatorTime;
	public static double manualElevatorSpeed;
	
	public static double setElevatorTime;
	public static double setElevatorSpeed;

}
