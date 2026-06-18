// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Subsystem_LED;
import java.util.function.Supplier;
import edu.wpi.first.wpilibj2.command.Command;

public class NewLED_CMD extends Command {
    private final Subsystem_LED m_newLED;
    private final Supplier<Integer> m_ledMode1;
    private final Supplier<Integer> m_ledMode2;
    private final Supplier<Integer> m_ledMode3;
    private final Supplier<Integer> m_ledMode4;

    public NewLED_CMD(Subsystem_LED LED, Supplier<Integer> ledMode1, Supplier<Integer> ledMode2,
            Supplier<Integer> ledMode3, Supplier<Integer> ledMode4) {
        m_newLED = LED;
        m_ledMode1 = ledMode1;
        m_ledMode2 = ledMode2;
        m_ledMode3 = ledMode3;
        m_ledMode4 = ledMode4;

        addRequirements(LED);
    }

    @Override
    public void initialize() {

        // A button
        if (m_ledMode1.get() == 0) {
            m_newLED.turnOffLED();
            m_newLED.color1();
            return;
        }

        // B button
        if (m_ledMode2.get() == 1) {
            m_newLED.turnOffLED();
            m_newLED.color2();
            return;
        }

        // X button
        if (m_ledMode3.get() == 2) {
            m_newLED.turnOffLED();
            m_newLED.setFireAnimation();
            return;
        }

        // Y button
        if (m_ledMode4.get() == 3) {
            m_newLED.turnOffLED();
            return;
        }
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
