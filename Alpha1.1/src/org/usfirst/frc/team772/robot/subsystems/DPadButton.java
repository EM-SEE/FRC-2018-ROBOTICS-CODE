package org.usfirst.frc.team772.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;

public class DPadButton extends Button{
	
	Joystick joystick;

	/**
	 * This is the DPad class for an xbox controller
	 * @param joystick The xbox controller object that is being used
	 */
	public DPadButton(Joystick joystick) {
		this.joystick = joystick;
	}

	public int getDegreesToTurn() {
		int degree = joystick.getPOV(0);
		
		if(degree == 0) {
			degree = 0;
		}else if(degree == 45) {
			degree = 45;
		}else if(degree == 90) {
			degree = 90;
		}else if(degree == 135) {
			degree = 135;
		}else if(degree == 180) {
			degree = 180;
		}else if(degree == 225) {//This is the negative
			degree = -135;
		}else if(degree == 270) {
			degree = -90;
		}else if(degree == 315) {
			degree = -45;
		}else {
			degree = 0;
		}
		
		return degree;	
	}

	@Override
	public boolean get() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	

	
}