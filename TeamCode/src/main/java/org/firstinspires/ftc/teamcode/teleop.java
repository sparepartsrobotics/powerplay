package org.firstinspires.ftc.teamcode;


//import com.qualcomm.hardware.rev.RevBlinkinLedDriver;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp (name = "single driver teleop")

public class teleop extends LinearOpMode {

    Robot robot;

    float joystickDeadzone = 0.05f;

    double flMotorPower;
    double frMotorPower;
    double brMotorPower;
    double blMotorPower;
    double joystick1LeftX;
    double joystick1RightX;
    double joystick1LeftY;

    boolean toggleVariableSpeed = false;

    static final double drive_speed =.5;
    static final double turn_speed =.5;

    @Override
    public void runOpMode() throws InterruptedException {

        robot = new Robot(hardwareMap);

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

        robot.frontLeft.setPower(flMotorPower / 2);
        robot.frontRight.setPower(frMotorPower / 2);
        robot.rearRight.setPower(brMotorPower / 2);
        robot.rearLeft.setPower(blMotorPower / 2);

    }
}