package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;

public class Constants {
  public static final String[] wheel_names = new String[] {
      "frontRight", "backRight", "backLeft",
      "frontLeft"}; // ordered by right front, right back, left back, left front

  // name of the linear slide motor in config
  public static final String linear_slide_name = "slide";

  // the slide is controlled by a P loop.
  // if the slide isn't moving fast enough, this is probably the reason why
  public static final double linear_slide_p = 1;

  // how much to increase the linear slide target position by when
  // left stick y is moved
  // NOTE: might need to be negative
  // the other reason why slide could be slow
  public static final double linear_slide_controller_multiplier = 3;

  // name of the intake motor in config
  public static final String intake_name = "inmotor";
  // speed to spin the intake
  // NOTE: could be negative
  public static final double intake_power = 0.25;

  // name of outtake servo in config
  public static final String outtake_servo_name = "kick_servo";

  // position of outtake servo when the pixels can't fall out
  public static final double outtake_closed_position = 0;
  // position of outtake servo when the pixels can fall out
  public static final double outtake_open_position = 1;

  public static final String arm_motor_name = "upmotor";
  public static final double arm_up_speed = 0.5;
  public static final double arm_down_speed = -0.5;
}
