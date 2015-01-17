package org.usfirst.frc.team1939.robot.commands;

import org.usfirst.frc.team1939.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class SetHornPosition extends Command {

	private double position;

	public SetHornPosition(double position) {
		requires(Robot.horn);
		this.position = position;
	}

	protected void initialize() {
		Robot.horn.setSetpoint(position);
		Robot.horn.enable();
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return Math.abs(Robot.horn.getPosition() - position) < 0.1;
	}

	protected void end() {
		Robot.horn.disable();
	}

	protected void interrupted() {
		Robot.horn.disable();
	}
}
