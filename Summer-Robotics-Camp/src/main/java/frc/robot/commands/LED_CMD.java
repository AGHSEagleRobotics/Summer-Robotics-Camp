// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Subsystem_LED;

import edu.wpi.first.wpilibj2.command.Command;

/** An example command that uses an example subsystem. */
public class LED_CMD extends Command {
  @SuppressWarnings("PMD.UnusedPrivateField")
  private final Subsystem_LED m_LED;

  private boolean m_configOff;
  private boolean m_color1;
  private boolean m_color2;
  private boolean m_setFireAnimation;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public LED_CMD(Subsystem_LED LED, boolean configOff, boolean color1, boolean color2, boolean setFireAnimation) {
    m_LED = LED;
    m_configOff = configOff;
    m_color1 = color1;
    m_color2 = color2;
    m_setFireAnimation = setFireAnimation;


    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(LED);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    startLEDToggle();
  }

  private void startLEDToggle(){

    if(m_configOff) {
        m_LED.turnOffLED();
        return;
    }

    if (m_color1) {
        m_LED.color2();
        return;
    }

    if (m_color2) {
        m_LED.color2();
        return;
    }

    if (m_setFireAnimation) {
        m_LED.setFireAnimation();
        return;
    }
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

