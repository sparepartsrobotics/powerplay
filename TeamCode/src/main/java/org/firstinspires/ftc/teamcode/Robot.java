package org.firstinspires.ftc.teamcode;


import com.qualcomm.hardware.rev.RevBlinkinLedDriver;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DistanceSensor;

public class Robot {

    //Drive Motors
    public DcMotor frontRight;
    public DcMotor frontLeft;
    public DcMotor rearRight;
    public DcMotor rearLeft;
    public DcMotor leftSlideMotor;
    public DcMotor rightSlideMotor;
    public Servo claw;
//    public DcMotor duckSpinner;
//    public DcMotor intake;
//    public DcMotor slide;
//    public Servo stopArmServo;
//    public Servo clawArm;
//    public Servo claw;
//    public Servo clawTilt;
//    public DistanceSensor d1;
//    public DistanceSensor d2;
//    public DcMotor flyLeft;
//    public DcMotor flyRight;
//    public DcMotor beltMotor;
//    public DcMotor wobblerMotor;
//
//   public RevBlinkinLedDriver rgbDriver;
//
//    public Servo wobblerServo;
//    public Servo stopServo;
//    public Servo autoServo;
//    public Servo autoLatchServo;
//    public Servo rampServo;
//    public Servo ringServo;
//    public Servo wobblerArmServo;


    public Robot(HardwareMap hardwareMap){


        //Drive Motors
        frontLeft = hardwareMap.dcMotor.get("lfWheel");
        frontRight = hardwareMap.dcMotor.get("rfWheel");
        rearLeft = hardwareMap.dcMotor.get("lrWheel");
        rearRight = hardwareMap.dcMotor.get("rrWheel");
        leftSlideMotor = hardwareMap.dcMotor.get("leftSlideMotor");
        rightSlideMotor = hardwareMap.dcMotor.get("rightSlideMotor");
        claw = hardwareMap.servo.get("claw");
  //      stopArmServo = hardwareMap.servo.get("stopArmServo");
  //      duckSpinner = hardwareMap.dcMotor.get("dSpin");
  //      intake = hardwareMap.dcMotor.get("intake");
  //      slide = hardwareMap.dcMotor.get("slide");
  //      clawArm = hardwareMap.servo.get("cA");
  //      claw = hardwareMap.servo.get("claw");
  //      clawTilt = hardwareMap.servo.get("cT");
  //      d1 = hardwareMap.get(DistanceSensor.class, "d1");
  //      d2 = hardwareMap.get(DistanceSensor.class, "d2");
//        flyLeft = hardwareMap.dcMotor.get("flyLeft");
//        flyRight = hardwareMap.dcMotor.get("flyRight");
//        beltMotor = hardwareMap.dcMotor.get("beltMotor");
//        wobblerMotor = hardwareMap.dcMotor.get("wobblerMotor");
//        //Servos
//        wobblerServo = hardwareMap.servo.get("wobblerServo");
//        stopServo = hardwareMap.servo.get("StopServo");
//        autoServo = hardwareMap.servo.get("autoServo");
//        autoLatchServo = hardwareMap.servo.get("autoLatchServo");
//        rampServo = hardwareMap.servo.get("rampServo");
//        ringServo = hardwareMap.servo.get("ringServo");
//        wobblerArmServo = hardwareMap.servo.get("wobblerArmServo");
//        rgbDriver = hardwareMap.get(RevBlinkinLedDriver.class,"ledDriver");

        frontLeft.setDirection(DcMotor.Direction.REVERSE);
        rearLeft.setDirection(DcMotor.Direction.REVERSE);
        rightSlideMotor.setDirection(DcMotor.Direction.REVERSE);
//        slide.setDirection(DcMotorSimple.Direction.REVERSE);
//        flyRight.setDirection(DcMotor.Direction.REVERSE);
//        beltMotor.setDirection(DcMotorSimple.Direction.REVERSE);


    }




}