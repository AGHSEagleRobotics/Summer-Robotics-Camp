package frc.robot.subsystems;

import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj.util.Color8Bit;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix6.configs.CANdleConfiguration;
import com.ctre.phoenix6.configs.LEDConfigs;
import com.ctre.phoenix6.controls.FireAnimation;
import com.ctre.phoenix6.controls.SolidColor;
import com.ctre.phoenix6.hardware.CANdle;
import com.ctre.phoenix6.signals.AnimationDirectionValue;
import com.ctre.phoenix6.signals.RGBWColor;
import com.ctre.phoenix6.signals.StripTypeValue;
import edu.wpi.first.wpilibj.DriverStation;

public class Subsystem_LED extends SubsystemBase {
private final CANdle m_candle;

private static final int kSlotStart = 1;
private static final int kSlotEnd = 2;
//These may only be needed for animations

CANdleConfiguration configOn;
CANdleConfiguration configOff;

public Subsystem_LED(CANdle candle) {
m_candle = candle;

configOn = new CANdleConfiguration();
configOn.withLED(new LEDConfigs().withStripType(StripTypeValue.GRB).withBrightnessScalar(1));

configOff = new CANdleConfiguration();
configOff.withLED(new LEDConfigs().withStripType(StripTypeValue.GRB).withBrightnessScalar(0));

}

public void Color(){
    m_candle.getConfigurator().apply(configOn);
    m_candle.setControl(
        new SolidColor(1,2)
            .withColor(new RGBWColor(Color.kBisque).scaleBrightness(1))
    );
}

public void turnOffColor(){
    m_candle.getConfigurator().apply(configOff);
}

public void setFireAnimation(){
    // Fire animation
    m_candle.setControl(
        new FireAnimation(kSlotStart, kSlotEnd).withSlot(1)
            .withDirection(AnimationDirectionValue.Backward)
            .withCooling(0.2)
            .withSparking(0.6));
  }

@Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

}
