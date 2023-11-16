package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.subsystems.subsubsystems.Functions;

public class Outtake extends SubsystemBase {
  Servo servo;
  Telemetry telemetry;

  public Outtake(HardwareMap map, Telemetry telemetry) {
    this.telemetry = telemetry;

    servo = map.get(Servo.class, Constants.outtake_servo_name);
  }

  public void open() { servo.setPosition(Constants.outtake_open_position); }

  public void close() { servo.setPosition(Constants.outtake_closed_position); }
}
