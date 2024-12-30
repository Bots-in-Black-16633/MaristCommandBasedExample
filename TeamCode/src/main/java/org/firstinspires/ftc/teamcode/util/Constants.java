package org.firstinspires.ftc.teamcode.util;


import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;

import org.opencv.core.Scalar;


public final class Constants {

    public static final class ArmConstants{
        public static final int depositPosition= 300;
        public static final int rest = 0;

    }
    public static final class ClawConstants{
        public static final double open = 0;
        public static final double close = 1;
    }


    public static final class DriveConstants{
        public static final RevHubOrientationOnRobot params = new RevHubOrientationOnRobot(RevHubOrientationOnRobot.LogoFacingDirection.LEFT, RevHubOrientationOnRobot.UsbFacingDirection.UP);
    }

    public static class Util{
        public static double round(double in, int places){
            return ((int)(in * Math.pow(10,places)))/(double)Math.pow(10,places);
        }
        public static Scalar red = new Scalar(.55,.22,.22);
        public static Scalar yellow = new Scalar(.47,.34,.18);
        public static Scalar blue = new Scalar(.25,.33,.48);

    }


}