package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.subsystems.subsubsystems.Functions;

public class LinearSlide extends SubsystemBase {

  private final Telemetry telemetry;
  private final DcMotor motor;

  private double targetPosition;

  public LinearSlide(HardwareMap map, Telemetry telemetry) {
    this.telemetry = telemetry;

    motor = map.get(DcMotor.class, Constants.linear_slide_name);
    targetPosition = motor.getCurrentPosition();
  }

  @Override
  public void periodic() {
    double error = targetPosition - motor.getCurrentPosition();
    telemetry.addData("Linear Slide Position", motor.getCurrentPosition());
    telemetry.addData("Linear Slide Error", error);
    motor.setPower(Functions.normalize_input(error * Constants.linear_slide_p));
  }

  public void changeTargetPosition(double delta) {
    targetPosition += delta;
  }
}
