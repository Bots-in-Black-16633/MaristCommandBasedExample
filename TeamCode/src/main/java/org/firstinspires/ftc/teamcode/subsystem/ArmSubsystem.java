package org.firstinspires.ftc.teamcode.subsystem;

import com.arcrobotics.ftclib.command.CommandBase;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.util.ColorfulTelemetry;

import java.util.function.DoubleSupplier;

public class ArmSubsystem extends MaristSubsystemBase{
    DcMotor arm;

    public ArmSubsystem(HardwareMap hwMap){
        arm = hwMap.dcMotor.get("arm");
        //arm.setDirection(DcMotorSimple.Direction.REVERSE);
        arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);

    }

    public void setPower(double power){
        arm.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        arm.setPower(power);
    }

    public void setPosition(int position){
        arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        arm.setTargetPosition(position);
        arm.setPower(1);
    }

    public void resetEncoders(){
        arm.setPower(0);
        arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        arm.setTargetPosition(0);
    }
    public int getPosition(){
        return arm.getCurrentPosition();
    }
    public CommandBase geArmPowerCommand(DoubleSupplier armPower){
        return this.runEnd(
                ()->{
                    setPower(armPower.getAsDouble());
                },
                ()->{
                    setPosition(getPosition());
                }
        );
    }

    @Override
    void printTelemetry(ColorfulTelemetry t) {
        t.addLine("ARM POSITION: " + arm.getCurrentPosition());
        t.addLine("ARM POWER: " + arm.getPower());

    }

    @Override
    public void periodic() {
        super.periodic();
    }
}
