// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;

  }

  public static class LEDConstants {
    public static final int CANdleID = 42;
  }

  public static class DriveTrainConstants {
    public static final int kVictorID = 4; // Victor SPX
    public static final int kTalonID = 9; // "intake arm motor" (CTRE)
  }
  //This is where we store unchanging data that gets called from multiple classes. They are usaully CAN IDs.
}
