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

	// $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	// CONSTANT VARIABLES
	// $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

	// Change. The variables were changed into final constants

	public static final double AUTO_TURN_TOLERANCEV2 = 0.3;
	public static final double AUTO_TURN_MAX_SPEEDV2 = 1;
	public static final double AUTO_TURN_MIN_SPEEDV2 = 0.55;

	// This conversion factor turns encoder ticks to meters
	public static final double DRIVE_CONVERTION_FACTOR = 322.983;

	public static final int elevatorHome = 0;
	public static final int elevatorDrive = 600;
	public static final int elevatorSwitch = 3000;
	public static final int elevatorScale = 7400;// 7900
	public static final int elevatorMax = 7800;
	public static final int elevatorSpeed = 400;// was 500
	public static final int elevatorAccel = elevatorSpeed * 3;

	public static final int laserIntakeTrue = 1000;

	// $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	// PNEUMATICS
	// $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	public static int PCM = 25;
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
	public static int autonomousPreference;
	
	public static int teleTurnDegrees;//Degrees to turn using DPAD


	// $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	// DRIVE SUBSYSTEM VARIABLES
	// $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

	// this states whether the motors are inverted or not
	public static boolean frontRightMotorInverted = false;
	public static boolean backRightMotorInverted = false;
	public static boolean frontLeftMotorInverted = false;
	public static boolean backLeftMotorInverted = false;

	public static int LaserLocation = 0;

}
