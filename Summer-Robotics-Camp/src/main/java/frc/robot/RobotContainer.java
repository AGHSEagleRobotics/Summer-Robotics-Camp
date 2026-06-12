// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.LEDConstants;
import frc.robot.commands.LED_CMD;
import frc.robot.commands.Toggle_CMD;
import frc.robot.subsystems.Subsystem_LED;

import com.ctre.phoenix6.hardware.CANdle;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.Motors;
import frc.robot.commands.Motor_CMD;

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
  private final Motors m_motors;
  private final Motor_CMD m_motorCommand;

  private final CANdle m_CANdle = new CANdle(LEDConstants.CANdleID);

  // Replace with CommandPS4Controller or CommandJoystick if needed
  public int ledMode = 0;
  private final Subsystem_LED m_LED = new Subsystem_LED(m_CANdle);

  private final XboxController driverController = new XboxController(0);

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    m_motors = new Motors();
    m_motorCommand = new Motor_CMD(
        m_motors,
        driverController::getLeftY,
        driverController::getRightY);

    m_motors.setDefaultCommand(m_motorCommand);

    // Configure the trigger bindings
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be
   * created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with
   * an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for
   * {@link
   * CommandXboxController
   * Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or
   * {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {

    JoystickButton ledButton = new JoystickButton(driverController, XboxController.Button.kA.value);

    // First command: cycle the mode
    ledButton.onTrue(new Toggle_CMD(this));

    // Second command: apply the LED state
    ledButton.onTrue(activateLED());
  }

  private Command activateLED() {
    return new LED_CMD(
        m_LED,
        this::getLEDMode

    );

  }

  public void setLEDMode(int val) {
    this.ledMode = val;

  }

  public int getLEDMode() {
    return this.ledMode;
  }

  // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
  // // new Trigger(m_exampleSubsystem::exampleCondition)
  // .onTrue(new ExampleCommand(m_exampleSubsystem));

  // // Schedule `exampleMethodCommand` when the Xbox controller's B button is
  // pressed,
  // // cancelling on release.
  // m_driverController.b().whileTrue(m_exampleSubsystem.exampleMethodCommand());
}
