// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import frc.robot.subsystems.Subsystem_LED;
import java.util.function.Supplier;
import edu.wpi.first.wpilibj2.command.Command;

public class LED_CMD extends Command {
  // What is the class name?
  @SuppressWarnings("PMD.UnusedPrivateField")
  private final Subsystem_LED m_LED;
  private Supplier<Integer> m_ledMode;
  //Create class variables/fields

  public LED_CMD(Subsystem_LED LED, Supplier<Integer> ledMode) {
    m_LED = LED;
    m_ledMode = ledMode;
  // Assign variables inside constructor

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(LED);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // Print a line as a sanity check for whther code is working
    // System.out.println("INSIDE LED COMMAND");
    startLEDToggle();
  }

  private void startLEDToggle() {

    m_LED.clearAnimation();

    if (m_ledMode.get().equals(0)) {
      m_LED.turnOffLED();
      return;
    }

    if (m_ledMode.get().equals(1)) {
      m_LED.color1();
      return;
    }

    if (m_ledMode.get().equals(2)) {
      m_LED.color2();
      return;
    }

    if (m_ledMode.get().equals(3)) {
      m_LED.setFireAnimation();
      return;
    }
    // Write a series of booleans that check the current LED condition to start a toggle
  }

  // Called every time the scheduler runs while the command is scheduled.
  // @Override
  // public void execute() {}

  // // Called once the command ends or is interrupted.
  // @Override
  // public void end(boolean interrupted) {}

  // // Returns true when the command should end.
  // @Override
  public boolean isFinished() {
    return true;
  }
}
