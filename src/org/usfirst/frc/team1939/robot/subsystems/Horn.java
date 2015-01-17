package org.usfirst.frc.team1939.robot.subsystems;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class Horn extends PIDSubsystem {

	private static final double INCHES_PER_REVOLUTION = 0.4;
	private static final double PULSES_PER_REVOLUTION = 290.704177746;

	private static final double P = -1;
	private static final double I = 0;
	private static final double D = 0;

	private CANTalon motor = new CANTalon(0);
	private Encoder encoder = new Encoder(0, 1);

	// Initialize your subsystem here
	public Horn() {
		// Use these to get going:
		// setSetpoint() - Sets where the PID controller should move the system
		// to
		// enable() - Enables the PID controller.
		super(P, I, D);
		this.setOutputRange(-1, 1);
		this.setAbsoluteTolerance(0.25);
		encoder.setDistancePerPulse(INCHES_PER_REVOLUTION
				/ PULSES_PER_REVOLUTION);

		LiveWindow.addActuator("Horn", "PID", this.getPIDController());
		LiveWindow.addSensor("Horn", "Encoder", encoder);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	protected double returnPIDInput() {
		// Return your input value for the PID loop
		// e.g. a sensor, like a potentiometer:
		// yourPot.getAverageVoltage() / kYourMaxVoltage;
		return encoder.getDistance();
	}

	protected void usePIDOutput(double output) {
		// Use output to drive your system, like a motor
		// e.g. yourMotor.set(output);
		motor.set(output);
	}
}
