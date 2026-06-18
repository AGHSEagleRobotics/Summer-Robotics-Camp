// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.LEDConstants;
import frc.robot.subsystems.Subsystem_LED;
import com.ctre.phoenix6.hardware.CANdle;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.Motors;
import frc.robot.commands.Motor_CMD;
import frc.robot.commands.NewLED_CMD;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  private final Motors m_motors = new Motors();

  private final CANdle m_CANdle = new CANdle(LEDConstants.CANdleID);

  private final Subsystem_LED m_newLED = new Subsystem_LED(m_CANdle);

  private final XboxController driverController = new XboxController(0);

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {

    m_motors.setDefaultCommand(
        new Motor_CMD(m_motors, () -> -driverController.getLeftY()));

    configureBindings();
  }

  private void configureBindings() {

    JoystickButton ledButtonA = new JoystickButton(driverController, XboxController.Button.kA.value);
    JoystickButton ledButtonB = new JoystickButton(driverController, XboxController.Button.kB.value);
    JoystickButton ledButtonX = new JoystickButton(driverController, XboxController.Button.kX.value);
    JoystickButton ledButtonY = new JoystickButton(driverController, XboxController.Button.kY.value);

    ledButtonA.onTrue(new NewLED_CMD(m_newLED, () -> 0, () -> 1, () -> 2, () -> 3));
    ledButtonB.onTrue(new NewLED_CMD(m_newLED, () -> 1, () -> 0, () -> 2, () -> 3));
    ledButtonX.onTrue(new NewLED_CMD(m_newLED, () -> 2, () -> 0, () -> 1, () -> 3));
    ledButtonY.onTrue(new NewLED_CMD(m_newLED, () -> 3, () -> 0, () -> 1, () -> 2));

  }
}
