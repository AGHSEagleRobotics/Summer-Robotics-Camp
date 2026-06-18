// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.Supplier;
import frc.robot.subsystems.Motors;
import edu.wpi.first.wpilibj2.command.Command;

public class Motor_CMD extends Command {

  private Motors m_motors;

  private Supplier<Double> m_speed;
  // Supplier refers to controlling using values from joysticks in this case

  public Motor_CMD(Motors motors, Supplier<Double> speed) {
    m_motors = motors;

    m_speed = speed;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_motors);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double volts = m_speed.get() * 12.0; // full range: -12 to +12
    m_motors.setVoltage(volts);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_motors.setVoltage(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}