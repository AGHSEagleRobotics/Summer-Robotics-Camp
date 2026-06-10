package frc.robot.subsystems;

import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj.util.Color8Bit;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix6.configs.CANdleConfiguration;
import com.ctre.phoenix6.configs.LEDConfigs;
import com.ctre.phoenix6.controls.SolidColor;
import com.ctre.phoenix6.hardware.CANdle;
import com.ctre.phoenix6.signals.RGBWColor;
import com.ctre.phoenix6.signals.StripTypeValue;
import edu.wpi.first.wpilibj.DriverStation;

public class LED_Level1 extends SubsystemBase {
private final CANdle m_candle1;

// private static final int kSlotStart = 1;
// private static final int kSlotEnd = 2;
//These may only be needed for animations

CANdleConfiguration configOn;
CANdleConfiguration configOff;

public LED_Level1(CANdle candle1) {
m_candle1 = candle1;

configOn = new CANdleConfiguration();
configOn.withLED(new LEDConfigs().withStripType(StripTypeValue.GRB).withBrightnessScalar(1));

configOff = new CANdleConfiguration();
configOff.withLED(new LEDConfigs().withStripType(StripTypeValue.GRB).withBrightnessScalar(0));

}

public void Color(){
    m_candle1.getConfigurator().apply(configOn);
    m_candle1.setControl(
        new SolidColor(1,2)
            .withColor(new RGBWColor(Color.kBisque).scaleBrightness(1))
    );
}

public void turnOffColor(){
    m_candle1.getConfigurator().apply(configOff);
}

@Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

}
