package org.firstinspires.ftc.teamcode;

//import com.qualcomm.hardware.rev.RevBlinkinLedDriver;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp (name = "TeleOp")

public class teleop extends LinearOpMode {

    public volatile Robot robot;

    float joystickDeadzone = 0.05f;

    double flMotorPower;
    double frMotorPower;
    double brMotorPower;
    double blMotorPower;
    double rightSlideMotor;
    double leftSlideMotor;
    double joystick1LeftX;
    double joystick1RightX;
    double joystick1LeftY;

    boolean toggleVariableSpeed = false;

    int highJunction = 750;
    int mediumJunction = 550;
    int lowJunction = 350;
    int groundJunction = 100;
    int neutralPosition = 0;
    int higherConePosition = 150;
    int lowerConePosition = 100;

    @Override
    public void runOpMode() throws InterruptedException {

        robot = new Robot(hardwareMap);

        robot.claw.setPosition(0.5);

        waitForStart();

        while (opModeIsActive()) {

            controls();
        }

    }

    public void controls() throws InterruptedException {

        joystick1LeftX = gamepad1.left_stick_x;
        joystick1LeftY = gamepad1.left_stick_y;
        joystick1RightX = gamepad1.right_stick_x;

        flMotorPower = joystick1LeftY - joystick1LeftX - joystick1RightX;
        frMotorPower = joystick1LeftY + joystick1LeftX + joystick1RightX;
        blMotorPower = joystick1LeftY + joystick1LeftX - joystick1RightX;
        brMotorPower = joystick1LeftY - joystick1LeftX + joystick1RightX;

        if (gamepad1.right_trigger > 0) {
            robot.frontLeft.setPower(flMotorPower / 2);
            robot.frontRight.setPower(frMotorPower / 2);
            robot.rearRight.setPower(brMotorPower / 2);
            robot.rearLeft.setPower(blMotorPower / 2);
        } else {
            robot.frontLeft.setPower(flMotorPower * 0.35);
            robot.frontRight.setPower(frMotorPower * 0.35);
            robot.rearRight.setPower(brMotorPower * 0.35);
            robot.rearLeft.setPower(blMotorPower * 0.35);
        }

        if (gamepad1.right_bumper)
        {
            robot.claw.setPosition(0.5);
        }

        if (gamepad1.left_bumper)
        {
            robot.claw.setPosition(0.25);
        }

        if (gamepad1.dpad_down)
        {
            int slideJunctionTarget;
            slideJunctionTarget = groundJunction;
            robot.leftSlideMotor.setTargetPosition(slideJunctionTarget);
            robot.rightSlideMotor.setTargetPosition(slideJunctionTarget);
            robot.leftSlideMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.rightSlideMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.leftSlideMotor.setPower(1);
            robot.rightSlideMotor.setPower(1);
            while (robot.leftSlideMotor.isBusy() && robot.rightSlideMotor.isBusy())
            {
                joystick1LeftX = gamepad1.left_stick_x;
                joystick1LeftY = gamepad1.left_stick_y;
                joystick1RightX = gamepad1.right_stick_x;

                flMotorPower = joystick1LeftY - joystick1LeftX - joystick1RightX;
                frMotorPower = joystick1LeftY + joystick1LeftX + joystick1RightX;
                brMotorPower = joystick1LeftY - joystick1LeftX + joystick1RightX;
                blMotorPower = joystick1LeftY + joystick1LeftX - joystick1RightX;

                robot.frontLeft.setPower(flMotorPower * 0.35);
                robot.frontRight.setPower(frMotorPower * 0.35);
                robot.rearRight.setPower(brMotorPower * 0.35);
                robot.rearLeft.setPower(blMotorPower * 0.35);
            }
            robot.leftSlideMotor.setPower(0);
            robot.rightSlideMotor.setPower(0);
            robot.leftSlideMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            robot.rightSlideMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        }

        if (gamepad1.dpad_left)
        {
            int slideJunctionTarget;
            slideJunctionTarget = lowJunction;
            robot.leftSlideMotor.setTargetPosition(slideJunctionTarget);
            robot.rightSlideMotor.setTargetPosition(slideJunctionTarget);
            robot.leftSlideMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.rightSlideMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.leftSlideMotor.setPower(1);
            robot.rightSlideMotor.setPower(1);
            while (robot.leftSlideMotor.isBusy() && robot.rightSlideMotor.isBusy())
            {

                joystick1LeftX = gamepad1.left_stick_x;
                joystick1LeftY = gamepad1.left_stick_y;
                joystick1RightX = gamepad1.right_stick_x;

                flMotorPower = joystick1LeftY - joystick1LeftX - joystick1RightX;
                frMotorPower = joystick1LeftY + joystick1LeftX + joystick1RightX;
                brMotorPower = joystick1LeftY - joystick1LeftX + joystick1RightX;
                blMotorPower = joystick1LeftY + joystick1LeftX - joystick1RightX;

                robot.frontLeft.setPower(flMotorPower * 0.35);
                robot.frontRight.setPower(frMotorPower * 0.35);
                robot.rearRight.setPower(brMotorPower * 0.35);
                robot.rearLeft.setPower(blMotorPower * 0.35);
            }
            robot.leftSlideMotor.setPower(0);
            robot.rightSlideMotor.setPower(0);
            robot.leftSlideMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            robot.rightSlideMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        }

        if (gamepad1.dpad_up)
        {
            int slideJunctionTarget;
            slideJunctionTarget = mediumJunction;
            robot.leftSlideMotor.setTargetPosition(slideJunctionTarget);
            robot.rightSlideMotor.setTargetPosition(slideJunctionTarget);
            robot.leftSlideMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.rightSlideMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.leftSlideMotor.setPower(1);
            robot.rightSlideMotor.setPower(1);
            while (robot.leftSlideMotor.isBusy() && robot.rightSlideMotor.isBusy())
            {

                joystick1LeftX = gamepad1.left_stick_x;
                joystick1LeftY = gamepad1.left_stick_y;
                joystick1RightX = gamepad1.right_stick_x;

                flMotorPower = joystick1LeftY - joystick1LeftX - joystick1RightX;
                frMotorPower = joystick1LeftY + joystick1LeftX + joystick1RightX;
                brMotorPower = joystick1LeftY - joystick1LeftX + joystick1RightX;
                blMotorPower = joystick1LeftY + joystick1LeftX - joystick1RightX;

                robot.frontLeft.setPower(flMotorPower * 0.35);
                robot.frontRight.setPower(frMotorPower * 0.35);
                robot.rearRight.setPower(brMotorPower * 0.35);
                robot.rearLeft.setPower(blMotorPower * 0.35);
            }
            robot.leftSlideMotor.setPower(0);
            robot.rightSlideMotor.setPower(0);
            robot.leftSlideMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            robot.rightSlideMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        }

        if (gamepad1.dpad_right)
        {
            int slideJunctionTarget;
            slideJunctionTarget = highJunction;
            robot.leftSlideMotor.setTargetPosition(slideJunctionTarget);
            robot.rightSlideMotor.setTargetPosition(slideJunctionTarget);
            robot.leftSlideMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.rightSlideMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.leftSlideMotor.setPower(1);
            robot.rightSlideMotor.setPower(1);
            while (robot.leftSlideMotor.isBusy() && robot.rightSlideMotor.isBusy())
            {

                joystick1LeftX = gamepad1.left_stick_x;
                joystick1LeftY = gamepad1.left_stick_y;
                joystick1RightX = gamepad1.right_stick_x;

                flMotorPower = joystick1LeftY - joystick1LeftX - joystick1RightX;
                frMotorPower = joystick1LeftY + joystick1LeftX + joystick1RightX;
                brMotorPower = joystick1LeftY - joystick1LeftX + joystick1RightX;
                blMotorPower = joystick1LeftY + joystick1LeftX - joystick1RightX;

                robot.frontLeft.setPower(flMotorPower * 0.35);
                robot.frontRight.setPower(frMotorPower * 0.35);
                robot.rearRight.setPower(brMotorPower * 0.35);
                robot.rearLeft.setPower(blMotorPower * 0.35);
            }
            robot.leftSlideMotor.setPower(0);
            robot.rightSlideMotor.setPower(0);
            robot.leftSlideMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            robot.rightSlideMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        }

        if (gamepad1.left_stick_button)
        {
            int slideJunctionTarget;
            slideJunctionTarget = neutralPosition;
            robot.leftSlideMotor.setTargetPosition(slideJunctionTarget);
            robot.rightSlideMotor.setTargetPosition(slideJunctionTarget);
            robot.claw.setPosition(0.25);
            robot.leftSlideMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.rightSlideMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.leftSlideMotor.setPower(0.75);
            robot.rightSlideMotor.setPower(0.75);
            while (robot.leftSlideMotor.isBusy() && robot.rightSlideMotor.isBusy())
            {

                joystick1LeftX = gamepad1.left_stick_x;
                joystick1LeftY = gamepad1.left_stick_y;
                joystick1RightX = gamepad1.right_stick_x;

                flMotorPower = joystick1LeftY - joystick1LeftX - joystick1RightX;
                frMotorPower = joystick1LeftY + joystick1LeftX + joystick1RightX;
                brMotorPower = joystick1LeftY - joystick1LeftX + joystick1RightX;
                blMotorPower = joystick1LeftY + joystick1LeftX - joystick1RightX;

                robot.frontLeft.setPower(flMotorPower * 0.35);
                robot.frontRight.setPower(frMotorPower * 0.35);
                robot.rearRight.setPower(brMotorPower * 0.35);
                robot.rearLeft.setPower(blMotorPower * 0.35);
            }
            robot.leftSlideMotor.setPower(0);
            robot.rightSlideMotor.setPower(0);
            robot.leftSlideMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            robot.rightSlideMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            robot.claw.setPosition(0.5);
        }

        if (gamepad1.y)
        {
            int slideJunctionTarget;
            slideJunctionTarget = higherConePosition;
            robot.leftSlideMotor.setTargetPosition(slideJunctionTarget);
            robot.rightSlideMotor.setTargetPosition(slideJunctionTarget);
            robot.leftSlideMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.rightSlideMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.leftSlideMotor.setPower(1);
            robot.rightSlideMotor.setPower(1);
            while (robot.leftSlideMotor.isBusy() && robot.rightSlideMotor.isBusy())
            {
                joystick1LeftX = gamepad1.left_stick_x;
                joystick1LeftY = gamepad1.left_stick_y;
                joystick1RightX = gamepad1.right_stick_x;

                flMotorPower = joystick1LeftY - joystick1LeftX - joystick1RightX;
                frMotorPower = joystick1LeftY + joystick1LeftX + joystick1RightX;
                brMotorPower = joystick1LeftY - joystick1LeftX + joystick1RightX;
                blMotorPower = joystick1LeftY + joystick1LeftX - joystick1RightX;

                robot.frontLeft.setPower(flMotorPower * 0.35);
                robot.frontRight.setPower(frMotorPower * 0.35);
                robot.rearRight.setPower(brMotorPower * 0.35);
                robot.rearLeft.setPower(blMotorPower * 0.35);
            }
            robot.leftSlideMotor.setPower(0);
            robot.rightSlideMotor.setPower(0);
            robot.leftSlideMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            robot.rightSlideMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        }

        if (gamepad1.x)
        {
            int slideJunctionTarget;
            slideJunctionTarget = lowerConePosition;
            robot.leftSlideMotor.setTargetPosition(slideJunctionTarget);
            robot.rightSlideMotor.setTargetPosition(slideJunctionTarget);
            robot.leftSlideMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.rightSlideMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.leftSlideMotor.setPower(1);
            robot.rightSlideMotor.setPower(1);
            while (robot.leftSlideMotor.isBusy() && robot.rightSlideMotor.isBusy())
            {
                joystick1LeftX = gamepad1.left_stick_x;
                joystick1LeftY = gamepad1.left_stick_y;
                joystick1RightX = gamepad1.right_stick_x;

                flMotorPower = joystick1LeftY - joystick1LeftX - joystick1RightX;
                frMotorPower = joystick1LeftY + joystick1LeftX + joystick1RightX;
                brMotorPower = joystick1LeftY - joystick1LeftX + joystick1RightX;
                blMotorPower = joystick1LeftY + joystick1LeftX - joystick1RightX;

                robot.frontLeft.setPower(flMotorPower * 0.35);
                robot.frontRight.setPower(frMotorPower * 0.35);
                robot.rearRight.setPower(brMotorPower * 0.35);
                robot.rearLeft.setPower(blMotorPower * 0.35);
            }
            robot.leftSlideMotor.setPower(0);
            robot.rightSlideMotor.setPower(0);
            robot.leftSlideMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            robot.rightSlideMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        }
    }
}
