package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.subsystems.subsubsystems.Functions;

public class Intake extends SubsystemBase {
  DcMotor motor;

  boolean isOn = false;

  public Intake(HardwareMap map, Telemetry telemetry) {
    this.telemetry = telemetry;

    motor = map.get(DcMotor.class, Constants.intake_name);
  }

  public void on() {
    isOn = true;
    motor.setPower(Constants.intake_power);
  }

  public void off() {
    isOn = false;
    motor.setPower(0);
  }

  @Override
  public void periodic() {
    telemetry.addData("Intake is ", isOn ? "on" : "off");
  }
}
