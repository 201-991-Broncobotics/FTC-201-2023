package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;

public class Constants {

  /* 202 Constants */

  public static final String[] wheel_names = new String[] {
      "rightFront", "rightBack", "leftBack",
      "leftFront"}; // ordered by right front, right back, left back, left front
  public static final String linear_slide_name = "slide";
  public static final double linear_slide_p = 1;
  public static final double linear_slide_controller_multiplier = 3;

  public static final RevHubOrientationOnRobot
      .LogoFacingDirection logo_direction_202 =
      RevHubOrientationOnRobot.LogoFacingDirection.FORWARD;
  public static final RevHubOrientationOnRobot
      .UsbFacingDirection usb_direction_202 =
      RevHubOrientationOnRobot.UsbFacingDirection.UP;

  /* 23737 Constants */
}
