
package org.firstinspires.ftc.teamcode;




import com.qualcomm.hardware.rev.RevBlinkinLedDriver;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

import java.util.EventListenerProxy;


@TeleOp (name = "Main TeleOp")





public class MainTeleOp extends LinearOpMode {

    public volatile Robot robot;



    float joystickDeadzone = 0.05f;
     auto;


    double flMotorPower;
    double frMotorPower;
    double brMotorPower;
    double blMotorPower;
    double dsMotorPower = -0.52;
    double dsMotorPower2 = -0.72;
    double intakePower = 1;
    double slidePower = 1;
    double joystick1LeftX;
    double joystick1RightX;
    double joystick1LeftY;
    double stopArmServoPos;
    double wobblerMotorPower;
    //
//    double wobblerServoPos;
//    double wobblerPos;
//    double stopServoPos;
//    double autoServoPos;
    double autoLatchServoPos;
    double rampServoPos;
    double wobblerArmServo;

    double beltMotorPower;

    boolean toggleVariableSpeed = false;
    double variableFlyWheelSpeed;
    int target1 = 600;
    int target2 = 245;
    int target3 = 100;
    int targetDown = 20;
//    boolean pressed = false;


//    public class SlideUpThread implements  Runnable {
//        private boolean isRunning = true;
//        private int target;
//        private ElapsedTime runtime;
//        SlideUpThread(ElapsedTime runtime, int target){
//
//            this.runtime = runtime;
//            this.target = target;
//        }
//        public void run() {
//
//
//            if (isRunning) {
//                int new_tSlideTarget;
//                new_tSlideTarget = target;
//                robot.slide.setTargetPosition(new_tSlideTarget);
//                runtime.reset();
//                robot.slide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//
//                robot.slide.setPower(1);
//                //            while (opModeIsActive() &&
//                //                    (runtime.seconds() < 01) &&
//                //                    (robot.slide.isBusy())) {
//                //            }
//                while (opModeIsActive() &&
//                        (robot.slide.isBusy())) {
//                }
//                robot.slide.setPower(0);
//
//                // Turn off RUN_TO_POSITION
//                //                    robot.slide.setPower(0.01);
//                robot.slide.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//                sleep(01);
//            }
//        }
//
//        public void unsetRunning()
//        {
//            this.isRunning = false;
//        }
//        public void setRunning()
//        {
//            this.isRunning = true;
//        }
//
//
//    }


    @Override
    public void runOpMode() throws InterruptedException {

//        robot = new Robot(hardwareMap);
//        robot.stopArmServo.setPosition(0.0);
//
        //      robot.clawArm.setPosition(0.0);
//        robot.clawTilt.setPosition(0.95);
//
        //      robot.claw.setPosition(0.4);
        robot.d1 = hardwareMap.get(DistanceSensor.class, "d1");
        robot.d2 = hardwareMap.get(DistanceSensor.class, "d2");


//        wobblerServoPos = 0.5;
//        wobblerPos = 1;
//        robot.stopServo.setPosition(1);
//        robot.autoServo.setPosition(0.0);
////        autoLatchServoPos = 0.0;
//        robot.rampServo.setPosition(0.04);
//        robot.ringServo.setPosition(1);
//        robot.wobblerArmServo.setPosition(.45);
//        robot.rgbDriver.setPattern(RevBlinkinLedDriver.BlinkinPattern.RAINBOW_PARTY_PALETTE);
       /* robot.wobblerMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.wobblerMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.wobblerMotor.setTargetPosition(0);
        robot.wobblerMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.wobblerMotor.setPower(.5);*/

        //robot.wobblerMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        // robot.wobblerMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);


        waitForStart();

        ElapsedTime runtime = new ElapsedTime();


        //Thread slideUpThreadTarget1 = new Thread(new SlideUpThread(runtime, target1));
//        SlideUpThread slideUpThreadTarget1 = new SlideUpThread(runtime, target1);
//        slideUpThreadTarget1.run();




        while (opModeIsActive()) {
            long time = System.currentTimeMillis();

            controls(runtime);
        }

    }

    public void controls(ElapsedTime runtime) throws InterruptedException {
//        telemetry.addData("arm",robot.wobblerMotor.getCurrentPosition());
        telemetry.addData("time",time);

        if(time < 75){
            robot.rgbDriver.setPattern(RevBlinkinLedDriver.BlinkinPattern.CP1_LARSON_SCANNER);
        }else if(time > 90){
            robot.rgbDriver.setPattern(RevBlinkinLedDriver.BlinkinPattern.CP1_LARSON_SCANNER);
        } else{
            robot.rgbDriver.setPattern(RevBlinkinLedDriver.BlinkinPattern.STROBE_GOLD);
            if(time > 81 && time < 82){
                gamepad1.rumble(3500);
            }
        }

        if(robot.d2.getDistance(DistanceUnit.MM) < 80){
            robot.rgbDriver.setPattern(RevBlinkinLedDriver.BlinkinPattern.WHITE);
        }
        if(robot.d1.getDistance(DistanceUnit.MM) < 90){

            long t = System.currentTimeMillis();
            while(System.currentTimeMillis() < t + 275){
                if(gamepad1.right_stick_button){
                    break;
                }
            }
            if(robot.d1.getDistance(DistanceUnit.MM) < 90 && robot.d2.getDistance(DistanceUnit.MM) < 85){
                robot.rgbDriver.setPattern(RevBlinkinLedDriver.BlinkinPattern.STROBE_RED);
                telemetry.addLine("2 blok");
                robot.stopArmServo.setPosition(0.15);
                long x = System.currentTimeMillis();
                while(System.currentTimeMillis() < x + 270){
                    if(gamepad1.right_stick_button){
                        break;
                    }
                }
                robot.stopArmServo.setPosition(0);
            }
        }
//
//        if(robot.d1.getDistance(DistanceUnit.MM) < 90 && robot.d2.getDistance(DistanceUnit.MM) < 90){
//
//            telemetry.addLine("2 blok");
//            robot.stopArmServo.setPosition(0.15);
//            long x = System.currentTimeMillis();
//            while(System.currentTimeMillis() < x + 300){
//
//            }
//            robot.stopArmServo.setPosition(0);
//
//
//        } else{
//            telemetry.addLine("on blokc");
//        }




        if (gamepad1.a) {
            joystick1LeftX = -gamepad1.left_stick_x;
            joystick1LeftY = -gamepad1.left_stick_y;
            joystick1RightX =
                    gamepad1.right_stick_x;
        } else {
            joystick1LeftX = gamepad1.left_stick_x;
            joystick1LeftY = gamepad1.left_stick_y;
            joystick1RightX = gamepad1.right_stick_x;
        }

        flMotorPower = joystick1LeftY - joystick1LeftX - joystick1RightX;
        frMotorPower = joystick1LeftY + joystick1LeftX + joystick1RightX;
        brMotorPower = joystick1LeftY - joystick1LeftX + joystick1RightX;
        blMotorPower = joystick1LeftY + joystick1LeftX - joystick1RightX;

//        if (gamepad1.dpad_up) {
//            robot.wobblerArmServo.setPosition(.29);
//            sleep(300);
//        }
//
//        if (gamepad1.dpad_down) {
//            robot.wobblerArmServo.setPosition(.18);
//            sleep(300);
//
//        }

        if(gamepad1.left_trigger > 0){
            if(robot.duckSpinner.getPower() < 0){
                robot.duckSpinner.setPower(dsMotorPower2);
            } else if (robot.duckSpinner.getPower() > 0){
                robot.duckSpinner.setPower(-dsMotorPower2);
            } else{

            }

        }
        if (gamepad1.right_trigger > 0) {
            robot.frontLeft.setPower(flMotorPower);
            robot.frontRight.setPower(frMotorPower);
            robot.rearRight.setPower(brMotorPower);
            robot.rearLeft.setPower(blMotorPower);
        } else {
            robot.frontLeft.setPower(flMotorPower / 2);
            robot.frontRight.setPower(frMotorPower / 2);
            robot.rearRight.setPower(brMotorPower / 2);
            robot.rearLeft.setPower(blMotorPower / 2);

            if(gamepad1.y){
//                pressed = true;
//                globaltime = System.currentTimeMillis();

                //after x milliseconds start increasing the speed to a cap
//                int x = 20;
//                if((System.currentTimeMillis() - time >= x-50) || (System.currentTimeMillis() - time <= x+50)){
//
//                }
                robot.duckSpinner.setPower(dsMotorPower);

            } else if(gamepad1.b){
                robot.duckSpinner.setPower(-dsMotorPower);
            } else{
                robot.duckSpinner.setPower(0);

            }


//
//
//            }
//            if (pressed = true){
//                long t = System.currentTimeMillis();
//
//            }



            if(gamepad1.x){
                robot.stopArmServo.setPosition(0.15);
            }

            if(gamepad1.right_bumper){
                robot.intake.setPower(intakePower);
            } else if (gamepad1.left_bumper){
                robot.intake.setPower(-1 * intakePower);
            } else{
                robot.intake.setPower(0.0);
            }
        }
        if(gamepad1.left_stick_button){
            int new_tSlideTarget;
            new_tSlideTarget = target1;
            robot.slide.setTargetPosition(new_tSlideTarget);
            runtime.reset();
            robot.slide.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            robot.slide.setPower(1);
            //            while (opModeIsActive() &&
            //                    (runtime.seconds() < 01) &&
            //                    (robot.slide.isBusy())) {
            //            }
            while (opModeIsActive() &&
                    (robot.slide.isBusy()) && runtime.seconds() < 1) {
                joystick1LeftX = gamepad1.left_stick_x;
                joystick1LeftY = gamepad1.left_stick_y;
                joystick1RightX = gamepad1.right_stick_x;
                flMotorPower = joystick1LeftY - joystick1LeftX - joystick1RightX;
                frMotorPower = joystick1LeftY + joystick1LeftX + joystick1RightX;
                brMotorPower = joystick1LeftY - joystick1LeftX + joystick1RightX;
                blMotorPower = joystick1LeftY + joystick1LeftX - joystick1RightX;
                robot.frontLeft.setPower(flMotorPower / 2);
                robot.frontRight.setPower(frMotorPower / 2);
                robot.rearRight.setPower(brMotorPower / 2);
                robot.rearLeft.setPower(blMotorPower / 2);
                if(gamepad1.x){
                    robot.stopArmServo.setPosition(0.15);
                }
            }
            robot.slide.setPower(0);

            // Turn off RUN_TO_POSITION
            //                    robot.slide.setPower(0.01);
            robot.slide.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            sleep(01);


        } else{

        }
        if(gamepad1.right_stick_button){
            robot.slide.setPower(0.0);
            robot.stopArmServo.setPosition(0);
            int new_tSlideTarget;
            new_tSlideTarget = targetDown;
            robot.slide.setTargetPosition(new_tSlideTarget);
            runtime.reset();
            robot.slide.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            robot.slide.setPower(0.5);

//            while (opModeIsActive() &&
//                    (runtime.seconds() < 1) &&
//                    (robot.slide.isBusy())) {
//            }
            while (opModeIsActive() &&
                    (runtime.seconds() < 1) &&
                    (robot.slide.isBusy())) {
                joystick1LeftX = gamepad1.left_stick_x;
                joystick1LeftY = gamepad1.left_stick_y;
                joystick1RightX = gamepad1.right_stick_x;
                flMotorPower = joystick1LeftY - joystick1LeftX - joystick1RightX;
                frMotorPower = joystick1LeftY + joystick1LeftX + joystick1RightX;
                brMotorPower = joystick1LeftY - joystick1LeftX + joystick1RightX;
                blMotorPower = joystick1LeftY + joystick1LeftX - joystick1RightX;
                robot.frontLeft.setPower(flMotorPower / 2);
                robot.frontRight.setPower(frMotorPower / 2);
                robot.rearRight.setPower(brMotorPower / 2);
                robot.rearLeft.setPower(blMotorPower / 2);
                if(gamepad1.x){
                    robot.stopArmServo.setPosition(0.15);
                }
            }
            robot.slide.setPower(0);

            // Turn off RUN_TO_POSITION
            robot.slide.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            sleep(1);
        } else{
            robot.slide.setPower(0.0);
        }
        if(gamepad1.dpad_down){
            robot.slide.setPower(0.0);
            robot.stopArmServo.setPosition(0);
            int new_tSlideTarget;
            new_tSlideTarget = targetDown;
            robot.slide.setTargetPosition(new_tSlideTarget);
            runtime.reset();
            robot.slide.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            robot.slide.setPower(0.5);

//            while (opModeIsActive() &&
//                    (runtime.seconds() < 1) &&
//                    (robot.slide.isBusy())) {
//            }
            while (opModeIsActive() &&
                    (runtime.seconds() < 1) &&
                    (robot.slide.isBusy())) {
                joystick1LeftX = gamepad1.left_stick_x;
                joystick1LeftY = gamepad1.left_stick_y;
                joystick1RightX = gamepad1.right_stick_x;
                flMotorPower = joystick1LeftY - joystick1LeftX - joystick1RightX;
                frMotorPower = joystick1LeftY + joystick1LeftX + joystick1RightX;
                brMotorPower = joystick1LeftY - joystick1LeftX + joystick1RightX;
                blMotorPower = joystick1LeftY + joystick1LeftX - joystick1RightX;
                robot.frontLeft.setPower(flMotorPower / 2);
                robot.frontRight.setPower(frMotorPower / 2);
                robot.rearRight.setPower(brMotorPower / 2);
                if(gamepad1.x){
                    robot.stopArmServo.setPosition(0.15);
                }

            }
            robot.slide.setPower(0);

            // Turn off RUN_TO_POSITION
            robot.slide.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            sleep(1);
        } else{
            robot.slide.setPower(0.0);
        }
        if(gamepad1.dpad_left){
            robot.slide.setPower(0.0);
            robot.stopArmServo.setPosition(0);
            int new_tSlideTarget;
            new_tSlideTarget = target3;
            robot.slide.setTargetPosition(new_tSlideTarget);
            runtime.reset();
            robot.slide.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            robot.slide.setPower(0.5);

//            while (opModeIsActive() &&
//                    (runtime.seconds() < 1) &&
//                    (robot.slide.isBusy())) {
//            }
            while (opModeIsActive() &&
                    (runtime.seconds() < 1) &&
                    (robot.slide.isBusy())) {
                joystick1LeftX = gamepad1.left_stick_x;
                joystick1LeftY = gamepad1.left_stick_y;
                joystick1RightX = gamepad1.right_stick_x;
                flMotorPower = joystick1LeftY - joystick1LeftX - joystick1RightX;
                frMotorPower = joystick1LeftY + joystick1LeftX + joystick1RightX;
                brMotorPower = joystick1LeftY - joystick1LeftX + joystick1RightX;
                blMotorPower = joystick1LeftY + joystick1LeftX - joystick1RightX;
                robot.frontLeft.setPower(flMotorPower / 2);
                robot.frontRight.setPower(frMotorPower / 2);
                robot.rearRight.setPower(brMotorPower / 2);
                robot.rearLeft.setPower(blMotorPower / 2);
                if(gamepad1.x){
                    robot.stopArmServo.setPosition(0.15);
                }
            }
            robot.slide.setPower(0);

            // Turn off RUN_TO_POSITION
            robot.slide.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            sleep(1);
        } else{
            robot.slide.setPower(0.0);
        }
        if(gamepad1.dpad_up){
            robot.slide.setPower(0.0);
            robot.stopArmServo.setPosition(0);
            int new_tSlideTarget;
            new_tSlideTarget = target2;
            robot.slide.setTargetPosition(new_tSlideTarget);
            runtime.reset();
            robot.slide.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            robot.slide.setPower(0.5);

//            while (opModeIsActive() &&
//                    (runtime.seconds() < 1) &&
//                    (robot.slide.isBusy())) {
//            }
            while (opModeIsActive() &&
                    (runtime.seconds() < 1) &&
                    (robot.slide.isBusy())) {
                joystick1LeftX = gamepad1.left_stick_x;
                joystick1LeftY = gamepad1.left_stick_y;
                joystick1RightX = gamepad1.right_stick_x;
                flMotorPower = joystick1LeftY - joystick1LeftX - joystick1RightX;
                frMotorPower = joystick1LeftY + joystick1LeftX + joystick1RightX;
                brMotorPower = joystick1LeftY - joystick1LeftX + joystick1RightX;
                blMotorPower = joystick1LeftY + joystick1LeftX - joystick1RightX;
                robot.frontLeft.setPower(flMotorPower / 2);
                robot.frontRight.setPower(frMotorPower / 2);
                robot.rearRight.setPower(brMotorPower / 2);
                robot.rearLeft.setPower(blMotorPower / 2);
                if(gamepad1.x){
                    robot.stopArmServo.setPosition(0.2);
                }


            }
            robot.slide.setPower(0);

            // Turn off RUN_TO_POSITION
            robot.slide.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            sleep(1);
        } else{
            robot.slide.setPower(0.0);
        }
        if(gamepad1.dpad_right){
            robot.slide.setPower(0.0);
            robot.stopArmServo.setPosition(0);
            int new_tSlideTarget;
            new_tSlideTarget = target1;
            robot.slide.setTargetPosition(new_tSlideTarget);
            runtime.reset();
            robot.slide.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            robot.slide.setPower(0.5);

//            while (opModeIsActive() &&
//                    (runtime.seconds() < 1) &&
//                    (robot.slide.isBusy())) {
//            }
            while (opModeIsActive() &&
                    (runtime.seconds() < 1) &&
                    (robot.slide.isBusy())) {
                joystick1LeftX = gamepad1.left_stick_x;
                joystick1LeftY = gamepad1.left_stick_y;
                joystick1RightX = gamepad1.right_stick_x;
                flMotorPower = joystick1LeftY - joystick1LeftX - joystick1RightX;
                frMotorPower = joystick1LeftY + joystick1LeftX + joystick1RightX;
                brMotorPower = joystick1LeftY - joystick1LeftX + joystick1RightX;
                blMotorPower = joystick1LeftY + joystick1LeftX - joystick1RightX;
                robot.frontLeft.setPower(flMotorPower / 2);
                robot.frontRight.setPower(frMotorPower / 2);
                robot.rearRight.setPower(brMotorPower / 2);
                robot.rearLeft.setPower(blMotorPower / 2);
                if(gamepad1.x){
                    robot.stopArmServo.setPosition(0.15);
                }
            }
            robot.slide.setPower(0);

            // Turn off RUN_TO_POSITION
            robot.slide.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            sleep(1);
        } else{
            robot.slide.setPower(0.0);
        }
//The following is gamepad2 inputs for our shipping element arm from Freight Frenzy which we do not use this year
        if (gamepad2.left_bumper) {
            robot.clawArm.setPosition(0.0);
            sleep(500);
            robot.clawTilt.setPosition(0.95);

        }
        if (gamepad2.dpad_down) {
            robot.clawArm.setPosition(0.317);
            robot.clawTilt.setPosition(0.09);
            robot.claw.setPosition(0.4);
        }
        if (gamepad2.dpad_right) {

            robot.claw.setPosition(0.4);
        }
        if (gamepad2.dpad_left) {

            robot.claw.setPosition(0.75);
        }
        if (gamepad2.y) {

            robot.clawArm.setPosition(0.14);
            sleep(750);
            robot.clawTilt.setPosition(0.45);
        }
        if (gamepad2.x) {

            robot.clawTilt.setPosition(0.52);

        }
   //     if (gamepad2.b) {

  //          robot.clawArm.setPosition(0.14);
  //          sleep(750);
  //          robot.clawTilt.setPosition(0.40);
  //      }
  //      if (gamepad2.a) {

//            robot.clawTilt.setPosition(0.47);

//        }

        /*if (gamepad2.y)
            if (beltMotorPower == .85) {
                beltMotorPower = 0.0;
                sleep(200);
            } else {
                beltMotorPower = .85;
                sleep(150);
            }*/

//        if (gamepad1.dpad_right) {
//            robot.wobblerServo.setPosition(.06);
//            sleep(300);
//
//        }
//
//        if (gamepad1.dpad_left) {
//            robot.wobblerServo.setPosition(.4);
//            sleep(300);
//        }

        /*if (gamepad1.dpad_right) {
            if (wobblerPos == 1) {
                wobblerPos++;
                sleep(300);
            } else if (wobblerPos == 0) {
                wobblerPos++;
                sleep(300);
            } else if (wobblerPos == 3) {
                wobblerPos = 2;
                sleep(300);
            }
        }
        if (gamepad1.dpad_left) {
            if (wobblerPos == 1) {
                wobblerPos--;
                sleep(300);
            } else if (wobblerPos == 2) {
                wobblerPos--;
                sleep(300);
            } else if (wobblerPos == -1) {
                wobblerPos = 0;
                sleep(300);
            }
        }*/
//
//        if (wobblerPos == 1) {
//            wobblerServoPos = 0.5;
//        }
//        if (wobblerPos == 0) {
//            wobblerServoPos = 0.5;
//        }
//        if (wobblerPos == 2) {
//            wobblerServoPos = 0.06;
//        }
//
//        if (flyWheelPower == 0) {
//            stopServoPos = 1;
//            robot.rgbDriver.setPattern(RevBlinkinLedDriver.BlinkinPattern.RAINBOW_PARTY_PALETTE);
//        } else {
//            stopServoPos = 0.60;
//            // robot.rgbDriver.setPattern(RevBlinkinLedDriver.BlinkinPattern.SINELON_LAVA_PALETTE);//
//        }
//
//        robot.stopServo.setPosition(stopServoPos);


//        if (gamepad1.left_bumper){
//            beltMotorPower = 0.75;
//        }else if (flyWheelPower == 0){
//            beltMotorPower = -gamepad1.left_trigger;
//        }
//        else if (flyWheelPower > 0){
//            beltMotorPower = (-gamepad1.left_trigger/2);
//        }
//
//        robot.beltMotor.setPower(beltMotorPower);
//
//        if (gamepad1.b){
//            if (flyWheelPower == 0) {
//                flyWheelPower = 1;
//                robot.rgbDriver.setPattern(RevBlinkinLedDriver.BlinkinPattern.RED);
//                sleep(300);
//            } else if (flyWheelPower == .94) {
//                flyWheelPower = 1;
//                robot.rgbDriver.setPattern(RevBlinkinLedDriver.BlinkinPattern.RED);
//                sleep(300);
//            } else if (flyWheelPower == .90) {
//                flyWheelPower = 1;
//                robot.rgbDriver.setPattern(RevBlinkinLedDriver.BlinkinPattern.RED);
//                sleep(300);
//            }    else if (flyWheelPower == 1) {
//                flyWheelPower = 0;
//                sleep(300);
//            }
//        }
//
//        if (gamepad1.y){
//            if (flyWheelPower == 0) {
//                flyWheelPower = .94;
//                robot.rgbDriver.setPattern(RevBlinkinLedDriver.BlinkinPattern.GREEN);
//                sleep(300);
//            } else if (flyWheelPower == 1) {
//                flyWheelPower = .94;
//                robot.rgbDriver.setPattern(RevBlinkinLedDriver.BlinkinPattern.GREEN);
//                sleep(300);
//            } else if (flyWheelPower == .90) {
//                flyWheelPower = .94;
//                robot.rgbDriver.setPattern(RevBlinkinLedDriver.BlinkinPattern.GREEN);
//                sleep(300);
//            }    else if (flyWheelPower == .94) {
//                flyWheelPower = 0;
//                sleep(300);
//
//            }
//        }
//        if (gamepad1.x){
//            if (flyWheelPower == 0) {
//                flyWheelPower = .90;
//                robot.rgbDriver.setPattern(RevBlinkinLedDriver.BlinkinPattern.BLUE);
//                sleep(300);
//            } else if (flyWheelPower == 1) {
//                flyWheelPower = .90;
//                robot.rgbDriver.setPattern(RevBlinkinLedDriver.BlinkinPattern.BLUE);
//                sleep(300);
//            } else if (flyWheelPower == .94) {
//                flyWheelPower = .90;
//                robot.rgbDriver.setPattern(RevBlinkinLedDriver.BlinkinPattern.BLUE);
//                sleep(300);
//            }    else if (flyWheelPower == .90) {
//                flyWheelPower = 0;
//                sleep(300);
//            }
//        }
//
//        robot.flyLeft.setPower(flyWheelPower);
//        robot.flyRight.setPower(flyWheelPower);
//
//        if (gamepad1.right_stick_button) {
//            robot.wobblerArmServo.setPosition(.45);
//        }
//
//        if (gamepad1.left_stick_button) {
//            robot.wobblerArmServo.setPosition(.18);
//        }

       /* if (gamepad1.left_stick_button){
            wobblerMotorPower = (gamepad1.right_stick_y/2);
        } else { wobblerMotorPower = 0.0; }
        if (gamepad2.left_bumper){
           robot.autoLatchServo.setPosition(0.25); ;
        }  else  { robot.autoLatchServo.setPosition(0.0); }
        if (gamepad2.y){
            robot.autoServo.setPosition(0.35);
        }  else  { robot.autoServo.setPosition(0.0); }
        robot.wobblerMotor.setPower(wobblerMotorPower);
        robot.wobblerServo.setPosition(wobblerServoPos);*/


        //toggleVariableSpeed function
        /*if (!gamepad2.right_bumper) {
            //Get flywheel power off right trigger value
            flyWheelPower = gamepad2.right_trigger;
            variableFlyWheelSpeed = 0.0;
            //set fly left and right power to above flywheelpower
            robot.flyLeft.setPower(flyWheelPower);
            robot.flyRight.setPower(flyWheelPower);
        } else {
            if (variableFlyWheelSpeed == 0.0) {
                variableFlyWheelSpeed = 0.8;
            }*/

        //if the gamepad 2 dpad up is pressed
            /*if (gamepad2.dpad_up) {
                //check if variableFlyWheelSpeed is less than 1.0
                if (variableFlyWheelSpeed < 1.0) {
                    //variableFlyWHeelSpeed is less than 1.0, add 0.05 to variable
                    variableFlyWheelSpeed += 0.05;
                    sleep(150);
                } else {
                    variableFlyWheelSpeed = 1.0;
                }
            } else if (gamepad2.dpad_down) {
                //check if variableFlyWHeelSpeed is greater than 0.0
                if (variableFlyWheelSpeed > 0.8) {
                    //variableFlyWheelSpeed is greater than 0.0, remove 0.05 from variable
                    variableFlyWheelSpeed -= 0.05;
                    sleep(150);
                } else {
                    variableFlyWheelSpeed = 0.8;
                }
            }*/

//        //set flywheel motors to new variable increment speed
//        robot.flyLeft.setPower(variableFlyWheelSpeed);
//        robot.flyRight.setPower(variableFlyWheelSpeed);
//
        telemetry.addData("deviceName",robot.d1.getDeviceName() );
        telemetry.addData("deviceName",robot.d2.getDeviceName() );


        telemetry.addData("range1", String.format("%.01f mm", robot.d1.getDistance(DistanceUnit.MM)));
        telemetry.addData("range2", String.format("%.01f mm", robot.d2.getDistance(DistanceUnit.MM)));

        telemetry.addData("clawArm",robot.clawArm.getPosition());
        telemetry.addData("clawTilt",robot.clawTilt.getPosition());
//        telemetry.addData("FlyWheelPower", flyWheelPower);
//        telemetry.addData("VariableFlyWheel Power", variableFlyWheelSpeed);
//        telemetry.addData("belt motor power", beltMotorPower);
//        telemetry.addData("wobblePos",wobblerPos);
        telemetry.update();

    }

}