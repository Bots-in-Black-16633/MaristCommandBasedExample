package org.firstinspires.ftc.teamcode.util;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.roadrunner.Pose2d;
import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.subsystem.BaseRobot;


public abstract class SampleCommandBaseRobotTeleop extends LinearOpMode {
    public volatile ColorfulTelemetry pen;
    public GamepadEx g1;
    public GamepadEx g2;
    public BaseRobot robot;
    @Override
    public void runOpMode() throws InterruptedException {
        CommandScheduler.getInstance().enable();

        g1 = new GamepadEx(gamepad1);
        g2 = new GamepadEx(gamepad2);
        pen = new ColorfulTelemetry(telemetry, FtcDashboard.getInstance());
        robot = new BaseRobot(hardwareMap, new Pose2d(0,0,0));
        onInit();
        waitForStart();
        onStart();
        while(opModeIsActive() && !isStopRequested()){
            onLoop();
            g1.readButtons();
            g2.readButtons();
            CommandScheduler.getInstance().run();

            telemetry();
        }
        onStop();
        CommandScheduler.getInstance().disable();
    }

    /**
     * This method is run once upon the initialization of the Teleop
     */
    public abstract void onInit();

    /**
     * This method is run once upon start of the Teleop
     */
    public abstract void onStart();

    /**
     * This method is repeated as long as the Teleop is active
     */
    public abstract void onLoop();

    /**
     * This method is run if the Teleop is manually stopped
     */
    public abstract void onStop();
    private void telemetry(){
        robot.printTelemetry(pen);
        pen.update();
    }



}