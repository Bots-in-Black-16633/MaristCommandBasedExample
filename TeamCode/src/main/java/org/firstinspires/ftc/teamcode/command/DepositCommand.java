package org.firstinspires.ftc.teamcode.command;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;

import org.firstinspires.ftc.teamcode.commnad.ArmRunToCommand;
import org.firstinspires.ftc.teamcode.subsystem.ArmSubsystem;
import org.firstinspires.ftc.teamcode.subsystem.ClawSubsystem;
import org.firstinspires.ftc.teamcode.util.Constants;

public class DepositCommand extends SequentialCommandGroup {

    public DepositCommand(ArmSubsystem arm, ClawSubsystem claw){

        addCommands(new ArmRunToCommand(arm, Constants.ArmConstants.depositPosition), new InstantCommand(claw::open));

        addRequirements(arm, claw);
    }
}
