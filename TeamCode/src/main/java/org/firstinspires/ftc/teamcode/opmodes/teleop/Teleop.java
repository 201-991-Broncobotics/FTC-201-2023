package org.firstinspires.ftc.teamcode.opmodes.teleop;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.RunCommand;
import com.arcrobotics.ftclib.command.button.Trigger;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Variables;
import org.firstinspires.ftc.teamcode.commands.SlidePosition;
import org.firstinspires.ftc.teamcode.commands.defaultcommands.TeleOpDrive;
import org.firstinspires.ftc.teamcode.subsystems.Intake;
import org.firstinspires.ftc.teamcode.subsystems.LinearSlide;
import org.firstinspires.ftc.teamcode.subsystems.Mecanum;

@TeleOp(name = "TeleOp")
public class Teleop extends CommandOpMode {

  @Override
  public void initialize() {

    // initialize variables

    Variables.teleOp = true;

    // initialize hardware

    Mecanum driveTrain =
        new Mecanum(hardwareMap, telemetry, Constants.wheel_names,
                    new boolean[] {false, false, false, false}, 0, 0, 0, false,
                    RevHubOrientationOnRobot.LogoFacingDirection.UP,
                    RevHubOrientationOnRobot.UsbFacingDirection.FORWARD);
    LinearSlide slide = new LinearSlide(hardwareMap, telemetry);
    Intake intake = new Intake(hardwareMap, telemetry);

    GamepadEx driver = new GamepadEx(gamepad1);
    GamepadEx operator = new GamepadEx(gamepad2);

    Trigger switch_mode =
        new Trigger(() -> driver.getButton(GamepadKeys.Button.Y));

    Trigger reset_gyro =
        new Trigger(() -> driver.getButton(GamepadKeys.Button.START));

    Trigger up =
        new Trigger(() -> driver.getButton(GamepadKeys.Button.DPAD_UP));
    Trigger down =
        new Trigger(() -> driver.getButton(GamepadKeys.Button.DPAD_DOWN));
    Trigger left =
        new Trigger(() -> driver.getButton(GamepadKeys.Button.DPAD_LEFT));
    Trigger right =
        new Trigger(() -> driver.getButton(GamepadKeys.Button.DPAD_RIGHT));

    Trigger intake_on =
        new Trigger(() -> operator.getButton(GamepadKeys.Button.A));
    Trigger intake_off =
        new Trigger(() -> operator.getButton(GamepadKeys.Button.B));

    // register subsystems

    register(driveTrain, slide);

    // default commands

    driveTrain.setDefaultCommand(
        new TeleOpDrive(driveTrain, driver, 1, 1, false));

    slide.setDefaultCommand(new SlidePosition(slide, operator));

    // non default commands

    reset_gyro.whenActive(new InstantCommand(() -> driveTrain.resetHeading(0)));

    switch_mode.whenActive(new InstantCommand(driveTrain::toggleDriveMode));

    up.whenActive(new InstantCommand(() -> driveTrain.setTargetHeading(0)));
    down.whenActive(new InstantCommand(() -> driveTrain.setTargetHeading(180)));
    left.whenActive(new InstantCommand(() -> driveTrain.setTargetHeading(-90)));
    right.whenActive(new InstantCommand(() -> driveTrain.setTargetHeading(90)));

    intake_on.whenActive(new InstantCommand(intake::on));
    intake_off.whenActive(new InstantCommand(intake::off));

    schedule(new RunCommand(() -> { telemetry.update(); }));
  }
}
