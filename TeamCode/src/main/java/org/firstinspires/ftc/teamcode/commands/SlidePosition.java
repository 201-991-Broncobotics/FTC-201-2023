package org.firstinspires.ftc.teamcode.commands;

import static org.firstinspires.ftc.teamcode.subsystems.subsubsystems.Functions.normalize_joystick;
import static org.firstinspires.ftc.teamcode.subsystems.subsubsystems.Functions.trigger_deadzone;
import static org.firstinspires.ftc.teamcode.subsystems.subsubsystems.Functions.vectorToAngle;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.gamepad.GamepadEx;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.subsystems.LinearSlide;

import java.util.function.DoubleSupplier;

public class SlidePosition extends CommandBase {
    private final LinearSlide slide;
    private final DoubleSupplier position_delta;

    public SlidePosition(LinearSlide slide, GamepadEx operator) {
        this.slide = slide;
        this.position_delta = () -> normalize_joystick(operator.getLeftY()) * Constants.linear_slide_controller_multiplier;
    }

    @Override
    public void initialize() { }

    @Override
    public void execute() {
        slide.changeTargetPosition(position_delta.getAsDouble());
    }

    @Override
    public void end(boolean interrupted) { }

    @Override
    public boolean isFinished() {
        return false;
    }
}
