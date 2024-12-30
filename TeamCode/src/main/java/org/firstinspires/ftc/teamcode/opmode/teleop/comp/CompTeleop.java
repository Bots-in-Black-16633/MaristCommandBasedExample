package org.firstinspires.ftc.teamcode.opmode.teleop.comp;

import com.arcrobotics.ftclib.command.button.Trigger;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.command.DepositCommand;
import org.firstinspires.ftc.teamcode.util.SampleCommandBaseRobotTeleop;

@TeleOp
public class CompTeleop extends SampleCommandBaseRobotTeleop {
    @Override
    public void onInit() {
        new Trigger(()->Math.abs(g2.getTrigger(GamepadKeys.Trigger.RIGHT_TRIGGER)-g2.getTrigger(GamepadKeys.Trigger.LEFT_TRIGGER))>.05)
                .whileActiveOnce(robot.arm.geArmPowerCommand(
                        ()->g2.getTrigger(GamepadKeys.Trigger.RIGHT_TRIGGER)-g2.getTrigger(GamepadKeys.Trigger.LEFT_TRIGGER)));
        g1.getGamepadButton(GamepadKeys.Button.A).toggleWhenPressed(robot.claw::open, robot.claw::close);
        g1.getGamepadButton(GamepadKeys.Button.B).whenActive(new DepositCommand(robot.arm, robot.claw));

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onLoop() {

    }

    @Override
    public void onStop() {

    }
}
