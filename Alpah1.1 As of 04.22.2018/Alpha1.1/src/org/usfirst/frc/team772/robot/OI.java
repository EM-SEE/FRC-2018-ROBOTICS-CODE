/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team772.robot;

import org.usfirst.frc.team772.robot.commands.AutoTurnCommandV2;
import org.usfirst.frc.team772.robot.commands.ClampIntakeCommand;
import org.usfirst.frc.team772.robot.commands.ClimberCommand;
import org.usfirst.frc.team772.robot.commands.GearShifterCommand;
import org.usfirst.frc.team772.robot.commands.HookCommand;
import org.usfirst.frc.team772.robot.commands.IntakeOutCommand;
import org.usfirst.frc.team772.robot.commands.IntakeWithLaserSensorCommandTele;
import org.usfirst.frc.team772.robot.commands.IntakeXSecCommand;
import org.usfirst.frc.team772.robot.commands.ManualElevatorCommand;
import org.usfirst.frc.team772.robot.commands.ManualElevatorCommandNoBreak;
import org.usfirst.frc.team772.robot.commands.IntakeInCommand;
import org.usfirst.frc.team772.robot.commands.IntakeInCommandSteve;
import org.usfirst.frc.team772.robot.commands.SetElevatorCommand;
import org.usfirst.frc.team772.robot.commands.TeleGetCube;
import org.usfirst.frc.team772.robot.subsystems.JoystickAnalogButton;
import org.usfirst.frc.team772.robot.triggers.GetDPad;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public Joystick driverController = new Joystick(0);
	Button a = new JoystickButton(driverController, 1);
	Button b = new JoystickButton(driverController, 2);
	Button x = new JoystickButton(driverController, 3);
	Button y = new JoystickButton(driverController, 4);
	Button RB = new JoystickButton(driverController, 6);
	Button LB = new JoystickButton(driverController, 5);
	Button back = new JoystickButton(driverController, 7);
	Button start = new JoystickButton(driverController, 8);
	Button toggle1 = new JoystickButton(driverController, 9);
	Button toggle2 = new JoystickButton(driverController, 10);
	JoystickAnalogButton TriggerL = new JoystickAnalogButton(driverController, 2);
	JoystickAnalogButton TriggerR = new JoystickAnalogButton(driverController, 3);
	// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	Joystick operatorController = new Joystick(1);
	Button a2 = new JoystickButton(operatorController, 1);
	Button b2 = new JoystickButton(operatorController, 2);
	Button x2 = new JoystickButton(operatorController, 3);
	Button y2 = new JoystickButton(operatorController, 4);
	Button RB2 = new JoystickButton(operatorController, 6);
	Button LB2 = new JoystickButton(operatorController, 5);
	Button back2 = new JoystickButton(operatorController, 7);
	Button start2 = new JoystickButton(operatorController, 8);
	Button toggle1two = new JoystickButton(operatorController, 9);
	Button toggle2two = new JoystickButton(operatorController, 10);
	JoystickAnalogButton TriggerL2 = new JoystickAnalogButton(operatorController, 2);
	JoystickAnalogButton TriggerR2 = new JoystickAnalogButton(operatorController, 3);
	// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

//	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//	Joystick programmerController = new Joystick(2);
//
//	Button a3 = new JoystickButton(programmerController, 1);
//	Button b3 = new JoystickButton(programmerController, 2);
//	Button x3 = new JoystickButton(programmerController, 3);
//	Button y3 = new JoystickButton(programmerController, 4);
//	Button start3 = new JoystickButton(programmerController, 8);
//	Button back3 = new JoystickButton(programmerController, 7);
//	// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	/**
	 * @author Mahir Chowdhury team 772
	 */
	public OI() {

		// Driver+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		b.whileHeld(new ManualElevatorCommand(1));// ELEVATOR UP MANUAL CONTROL
		a.whileHeld(new ManualElevatorCommand(-0.85));// ELEVATOR DOWN MANUAL CONTROL //This was 100%
//		a.whenPressed(new SetElevatorCommand(RobotMap.ELEVATOR_HOME));// HOME POSITION FOR ELEVATOR
//		b.whenPressed(new SetElevatorCommand(RobotMap.ELEVATOR_DRIVE));// 2 INCHES ABOVE HOME ELEVATOR
//		x.whenPressed(new SetElevatorCommand(RobotMap.ELEVATOR_SWITCH));// SWITCH POSITION FOR ELEVATOR
//		y.whenPressed(new SetElevatorCommand(RobotMap.ELEVATOR_SCALE));// SCALE POSITION FOR ELEVATOR
		start.whileHeld(new TeleGetCube());
		RB.whileHeld(new IntakeWithLaserSensorCommandTele());// INTAKE IN
		LB.whileHeld(new IntakeOutCommand(-0.8));// INTAKE OUT
		TriggerR.whileHeld(new IntakeInCommandSteve(1));
//		TriggerL.whenPressed(command);
		x.whenPressed(new GearShifterCommand(true));// LOW GEAR
		y.whenPressed(new GearShifterCommand(false));// High GEAR
//		new GetDPad (driverController, 0).whenActive(new TeleGetCube());
//		new GetDPad (driverController, 90).whenActive(new AutoTurnCommandV2(90));
//		new GetDPad (driverController, 270).whenActive(new AutoTurnCommandV2(-90));
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

		// Operator+++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		a2.whileHeld(new IntakeOutCommand(-0.3));
		x2.whenPressed(new ClampIntakeCommand(true));// INTAKE CLAMP CLOSE
		b2.whenPressed(new ClampIntakeCommand(false));// INTAKE CLAMP OPEN
		y2.whileHeld(new IntakeOutCommand(-.40));// SLOW INTAKE OUT
//		x2.whenPressed(new SetElevatorCommand(RobotMap.PORTAL_HIGHT));// HOME POSITION FOR ELEVATOR
//		x2.whileHeld(new IntakeInCommand(1));
		LB2.whileHeld(new HookCommand(true));// HOOK UP
		RB2.whileHeld(new HookCommand(false));// HOOK DOWN
		start2.whileHeld(new ClimberCommand(true));// CLIMBER UP
//		TriggerR2.whileHeld(new ManualElevatorCommand(1));// ELEVATOR UP MANUAL CONTROL
//		TriggerL2.whileHeld(new ManualElevatorCommand(-0.85));// ELEVATOR DOWN MANUAL CONTROL //This was 100%
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

//		// Programmers++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//		a3.whileHeld(new ManualElevatorCommand(.5));
//		b3.whileHeld(new ManualElevatorCommand(-.5));
//		a.whileHeld(new ManualElevatorCommand(-.65));// ELEVATOR DOWN MANUAL CONTROL //This was 100%
//		a3.whenPressed(new SetElevatorCommand(RobotMap.ELEVATOR_HOME));// HOME POSITION FOR ELEVATOR
//		b3.whenPressed(new SetElevatorCommand(RobotMap.ELEVATOR_DRIVE));// 2 INCHES ABOVE HOME ELEVATOR
//		x3.whenPressed(new SetElevatorCommand(RobotMap.ELEVATOR_SWITCH));// SWITCH POSITION FOR ELEVATOR
//		y3.whenPressed(new SetElevatorCommand(RobotMap.ELEVATOR_SCALE));// SCALE POSITION FOR ELEVATOR
//		start3.whileHeld(new ManualElevatorCommand(1));
//		back3.whileHeld(new ManualElevatorCommand(-0.65));
//	
//		// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	}

	/**
	 * @return Driver Controller object
	 */
	public Joystick DriverStick() {
		return driverController;
	}

	/**
	 * @return Operator Controller object
	 */
	public Joystick OperatorStick() {
		return operatorController;
	}
	
}
