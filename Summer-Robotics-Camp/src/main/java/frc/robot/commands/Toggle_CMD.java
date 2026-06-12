// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj2.command.Command;

public class Toggle_CMD extends Command {

    private final RobotContainer m_robotContainer;

    public Toggle_CMD(RobotContainer robotContainer) {
        m_robotContainer = robotContainer;
    }

    @Override
    public void initialize() {
       
        m_robotContainer.ledMode++;
        if (m_robotContainer.ledMode > 3) {
            m_robotContainer.ledMode = 0;
        }
         System.out.println("I AM HERE HI HI HI" + m_robotContainer.ledMode);
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}