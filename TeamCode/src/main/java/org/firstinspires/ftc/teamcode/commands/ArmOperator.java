package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.gamepad.GamepadEx;

import org.firstinspires.ftc.teamcode.subsystems.Arm;

import java.util.function.DoubleSupplier;

public class ArmOperator extends CommandBase {
    private Arm arm;
    private DoubleSupplier armSupplier;

    public ArmOperator(Arm arm, GamepadEx operator) {
        this.arm = arm;
        addRequirements(arm);
        this.armSupplier = () -> operator.getRightY();
    }

    @Override
    public void execute() {
        arm.setPower(armSupplier.getAsDouble());
    }
}
