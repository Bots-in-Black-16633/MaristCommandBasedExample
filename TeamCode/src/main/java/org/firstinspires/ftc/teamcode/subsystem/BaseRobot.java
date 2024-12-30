package org.firstinspires.ftc.teamcode.subsystem;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.util.ColorfulTelemetry;
import org.firstinspires.ftc.teamcode.util.Constants;

public class BaseRobot extends MaristSubsystemBase {
    LoopTimeSubsystem loop;

    public BaseRobot(HardwareMap hwMap, Pose2d startPos){

        loop  = new LoopTimeSubsystem();
    }


    @Override
    public void printTelemetry(ColorfulTelemetry t) {
        loop.printTelemetry(t);

    }

    @Override
    public void periodic() {
        loop.periodic();



    }

}