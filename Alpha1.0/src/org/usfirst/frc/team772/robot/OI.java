/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team772.robot;

import org.usfirst.frc.team772.robot.commands.ClampIntakeCommand;
import org.usfirst.frc.team772.robot.commands.ClimberCommand;
import org.usfirst.frc.team772.robot.commands.GearShifterCommand;
import org.usfirst.frc.team772.robot.commands.HookCommand;
import org.usfirst.frc.team772.robot.commands.IntakeOutCommand;
import org.usfirst.frc.team772.robot.commands.ManualElevatorCommand;
import org.usfirst.frc.team772.robot.commands.IntakeInCommand;
import org.usfirst.frc.team772.robot.commands.SetElevatorCommand;
import org.usfirst.frc.team772.robot.commands.TeleGetCube;
import org.usfirst.frc.team772.robot.subsystems.JoystickAnalogButton;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	Joystick driverController = new Joystick(0);
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

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	Joystick programmerController = new Joystick(2);

	Button a3 = new JoystickButton(programmerController, 1);
	Button b3 = new JoystickButton(programmerController, 2);
	// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	public OI() {

		// This method sets up the robot so it can turn as soon as the robot turns on
		// Robot.driveSubsystem.setTurnValues(0.1, 90, 2);

		// Driver+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		a.whenPressed(new SetElevatorCommand(0));// HOME POSITION FOR ELEVATOR
		b.whenPressed(new TeleGetCube());// HUNTER CODE FOR THE CUBE
		x.whenPressed(new SetElevatorCommand(0));// SWITCH POSITION FOR ELEVATOR
		y.whenPressed(new SetElevatorCommand(0));// SCALE POSITION FOR ELEVATOR
		RB.whileHeld(new IntakeInCommand(1));// INTAKE IN
		LB.whileHeld(new IntakeOutCommand(-1));// INTAKE OUT
		TriggerL.whenPressed(new GearShifterCommand(true));// HIGH GEAR
		TriggerR.whenPressed(new GearShifterCommand(false));// LOW GEAR
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

		// Operator+++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		a2.whenPressed(new ClampIntakeCommand(true));// INTAKE CLAMP CLOSE
		b2.whenPressed(new ClampIntakeCommand(false));// INTAKE CLAMP OPEN
		x2.whileHeld(new IntakeOutCommand(-.25));// SLOW INTAKE OUT
		RB2.whileHeld(new HookCommand(true));// HOOK UP
		LB2.whileHeld(new HookCommand(false));// HOOK DOWN
		start2.whileHeld(new ClimberCommand(true));// CLIMBER UP
		TriggerR2.whileHeld(new ManualElevatorCommand(1));// ELEVATOR UP MANUAL CONTROL
		TriggerL2.whileHeld(new ManualElevatorCommand(-.25));// ELEVATOR DOWN MANUAL CONTROL //This was 100%
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

		// Programmers++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		a3.whileHeld(new ManualElevatorCommand(.5));
		b3.whileHeld(new ManualElevatorCommand(-.5));
		// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
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
