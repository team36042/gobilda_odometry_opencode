package org.firstinspires.ftc.teamcode.sensors;

import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "goBILDA Pinpoint Sensing", group = "Sensors")
public class GoBildaPinpointSensing extends LinearOpMode {
    private GoBildaPinpointDriver pinpoint;

    // Tune these values for your physical pod placement.
    private static final double X_OFFSET_MM = -84.0;
    private static final double Y_OFFSET_MM = -168.0;

    @Override
    public void runOpMode() throws InterruptedException {
        pinpoint = hardwareMap.get(GoBildaPinpointDriver.class, "pinpoint");
        pinpoint.setOffsets(X_OFFSET_MM, Y_OFFSET_MM);
        pinpoint.setEncoderResolution(GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_4_BAR_POD);
        pinpoint.setEncoderDirections(
                GoBildaPinpointDriver.EncoderDirection.FORWARD,
                GoBildaPinpointDriver.EncoderDirection.REVERSED);
        pinpoint.resetPosAndIMU();

        telemetry.addLine("goBILDA Pinpoint ready");
        telemetry.addLine("Change X/Y offsets and encoder directions before competition");
        telemetry.update();
        waitForStart();

        while (opModeIsActive()) {
            pinpoint.update();
            GoBildaPinpointDriver.PositionData position = pinpoint.getPosition();

            telemetry.addData("Status", pinpoint.getDeviceStatus());
            telemetry.addData("X", "%.1f mm", position.getX());
            telemetry.addData("Y", "%.1f mm", position.getY());
            telemetry.addData("Heading", "%.2f deg", Math.toDegrees(position.getHeading()));
            telemetry.addData("X velocity", "%.1f mm/s", pinpoint.getVelX());
            telemetry.addData("Y velocity", "%.1f mm/s", pinpoint.getVelY());
            telemetry.addData("Heading velocity", "%.2f deg/s", Math.toDegrees(pinpoint.getHeadingVelocity()));
            telemetry.update();
        }
    }
}
