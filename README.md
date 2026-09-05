OPEN SOURCE ODOMETRY CODE

Configurable X and Y pod offsets.

4-Bar odometry pod resolution selection.

Configurable encoder directions.

Position and IMU reset at initialization.

X-position telemetry in millimeters.

Y-position telemetry in millimeters.

Heading telemetry in degrees.

X and Y velocity telemetry.

Heading velocity telemetry.

Pinpoint device-status telemetry.

Hardware configuration
Configure the Pinpoint with this exact name:

text
pinpoint
Setup and tuning
Install the goBILDA Pinpoint FTC driver integration.

Add the Pinpoint to the robot configuration.

Name it pinpoint.

Measure the pod offsets from the robot reference point.

Update X_OFFSET_MM and Y_OFFSET_MM in the Java file.

Verify the encoder directions.

Deploy and run goBILDA Pinpoint Sensing.

Example configuration values in the source:

java
private static final double X_OFFSET_MM = -84.0;
private static final double Y_OFFSET_MM = -168.0;
These values are examples only and must be tuned for the actual robot.

Important notes
Confirm the Pinpoint driver API matches the version installed in your FTC project.

Verify that the X and Y axes increase in the expected directions.

Test encoder directions before using this localization in autonomous.

This file reports localization data but does not automatically drive the robot.
