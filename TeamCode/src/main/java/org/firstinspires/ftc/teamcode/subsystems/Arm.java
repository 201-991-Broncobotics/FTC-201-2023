package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Constants;

public class Arm extends SubsystemBase {
    DcMotor motor;
    Telemetry telemetry;

    public Arm(HardwareMap map, Telemetry t) {
        telemetry = t;
        motor = map.get(DcMotor.class, Constants.arm_motor_name);

        motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motor.setDirection(DcMotor.Direction.FORWARD);
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
    }
    public void up() {
        motor.setPower(Constants.arm_up_speed);
    }
    public void down() {
        motor.setPower(Constants.arm_down_speed);
    }
    public void setPower(double p) {
        motor.setPower(p);
    }
    @Override
    public void periodic() {
        telemetry.addData("arm power", motor.getPower());
    }

}
