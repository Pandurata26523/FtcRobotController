
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "PANDURATA Tank Drive", group = "PANDURATA")
public class SimpleTeleOP extends LinearOpMode {

    private DcMotor leftMotor;
    private DcMotor rightMotor;

    @Override
    public void runOpMode() {

        leftMotor = hardwareMap.get(DcMotor.class, "leftMotor");
        rightMotor = hardwareMap.get(DcMotor.class, "rightMotor");

        rightMotor.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();

        while (opModeIsActive()) {

            double forward = -gamepad1.left_stick_y;
            double turn = gamepad1.right_stick_x;

            double leftPower = forward + turn;
            double rightPower = forward - turn;

            double maxPower = Math.max(
                    1.0,
                    Math.max(Math.abs(leftPower), Math.abs(rightPower))
            );

            leftPower /= maxPower;
            rightPower /= maxPower;

            leftMotor.setPower(leftPower);
            rightMotor.setPower(rightPower);
        }
    }
}