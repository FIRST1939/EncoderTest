package org.usfirst.frc.team1939.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class HornAutonomous extends CommandGroup {

	public HornAutonomous() {
		this.addSequential(new SetHornPosition(10));
		this.addSequential(new SetHornPosition(2));
		this.addSequential(new SetHornPosition(8));
		this.addSequential(new SetHornPosition(7));
		this.addSequential(new SetHornPosition(5));
		this.addSequential(new SetHornPosition(12));
		this.addSequential(new SetHornPosition(0));
	}
}
