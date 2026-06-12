// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class Motors extends SubsystemBase {
  private final Talon m_motor1 = new Talon(DriveTrainConstants.kmotor1);
  // private final Talon m_driveTrainLeftRear = new Talon(DriveTrainConstants.kLeftRearChannel);
  private final Talon m_motor2 = new Talon(DriveTrainConstants.kmotor2);
  // private final Talon m_driveTrainRightRear = new Talon(DriveTrainConstants.kRightRearChannel);
  private final DifferentialDrive m_motors; 
  
  /** Creates a new ExampleSubsystem. */
  public Motors() {
    m_motor1.addFollower(m_motor2);

m_motor2.setInverted(true);
// <-- Use in case motors move in opposite directions

    m_motors = new DifferentialDrive(m_motor1, m_motor2);
  }
    public void tankDrive(double leftSpeed, double rightSpeed){
      m_motors.tankDrive(leftSpeed, rightSpeed);
    }

     public static class DriveTrainConstants {
    public static final int kmotor1 = 0;
    public static final int kmotor2 = 1;
    
  }
  
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
  }