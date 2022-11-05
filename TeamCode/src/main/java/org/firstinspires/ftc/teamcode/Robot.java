package org.firstinspires.ftc.teamcode;


import com.qualcomm.hardware.rev.RevBlinkinLedDriver;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Robot {

    //Drive Motors
    public DcMotor frontRight;
    public DcMotor frontLeft;
    public DcMotor rearRight;
    public DcMotor rearLeft;
    public DcMotor leftSlideMotor;
    public DcMotor rightSlideMotor;
    public Servo claw;

//   public RevBlinkinLedDriver rgbDriver;

    public Robot(HardwareMap hardwareMap){

        //Drive Motors
        frontLeft = hardwareMap.dcMotor.get("lfWheel");
        frontRight = hardwareMap.dcMotor.get("rfWheel");
        rearLeft = hardwareMap.dcMotor.get("lrWheel");
        rearRight = hardwareMap.dcMotor.get("rrWheel");
        leftSlideMotor = hardwareMap.dcMotor.get("leftSlideMotor");
        rightSlideMotor = hardwareMap.dcMotor.get("rightSlideMotor");
        claw = hardwareMap.servo.get("claw");
        //reverse motors
        frontLeft.setDirection(DcMotor.Direction.REVERSE);
        rearLeft.setDirection(DcMotor.Direction.REVERSE);
        rightSlideMotor.setDirection(DcMotor.Direction.REVERSE);
    }
}