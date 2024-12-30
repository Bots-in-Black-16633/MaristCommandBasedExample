package org.firstinspires.ftc.teamcode.subsystem;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.util.ColorfulTelemetry;
import org.firstinspires.ftc.teamcode.util.Constants;

public class ClawSubsystem extends MaristSubsystemBase{
    public Servo claw;


    public ClawSubsystem(HardwareMap hwMap){
        claw = hwMap.servo.get("claw");
    }

    public void open(){
        claw.setPosition(Constants.ClawConstants.open);
    }
    public void close(){
        claw.setPosition(Constants.ClawConstants.close);
    }
    @Override
    void printTelemetry(ColorfulTelemetry t) {
        t.addLine("CLAW POSITION " + claw.getPosition());

    }
}
