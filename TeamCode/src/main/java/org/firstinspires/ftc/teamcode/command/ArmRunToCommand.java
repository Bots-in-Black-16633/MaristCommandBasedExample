package org.firstinspires.ftc.teamcode.commnad;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.command.CommandScheduler;

import org.firstinspires.ftc.teamcode.subsystem.ArmSubsystem;


public class ArmRunToCommand extends CommandBase {

    public ArmSubsystem arm;
    int position;
    public ArmRunToCommand(ArmSubsystem arm, int position){
        this.arm=arm;
        this.position=position;
        addRequirements(arm);
    }

    @Override
    public void initialize(){

        arm.setPosition(position);

    }

    @Override
    public void execute(){

    }

    @Override
    public boolean isFinished(){
        return Math.abs(arm.getPosition()-position)<100;
    }

    @Override
    public void end(boolean inter){
        arm.setPosition(position);
    }
}