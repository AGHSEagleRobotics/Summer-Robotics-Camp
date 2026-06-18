package frc.robot.subsystems;

import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix6.configs.CANdleConfiguration;
import com.ctre.phoenix6.configs.LEDConfigs;
import com.ctre.phoenix6.controls.EmptyAnimation;
import com.ctre.phoenix6.controls.FireAnimation;
import com.ctre.phoenix6.controls.SolidColor;
import com.ctre.phoenix6.hardware.CANdle;
import com.ctre.phoenix6.signals.AnimationDirectionValue;
import com.ctre.phoenix6.signals.RGBWColor;
import com.ctre.phoenix6.signals.StripTypeValue;

// Imports bring in essential information, such as APIs for objects in our code

public class Subsystem_LED extends SubsystemBase {
  private final CANdle m_candle;

  // private static final int kSlotStart = 1;
  // private static final int kSlotEnd = 2;
  private int ledRange;
  private static final int MIN = 1;
  private static final int MAX = 3;

  public void setNumber(int ledValue) {
    if (ledValue >= MIN && ledValue <= MAX) {
      this.ledRange = ledValue;
    } else {
      System.out.println("Try keeping your LED value between " + MIN + " and " + MAX);
      // throw new IllegalArgumentException("Keep your led value between " + MIN + "
      // and " + MAX);
    }
  }

  // These may only be needed for animations

  CANdleConfiguration configOn;
  CANdleConfiguration configOff;

  public Subsystem_LED(CANdle candle) {
    m_candle = candle;

    configOn = new CANdleConfiguration();
    configOn.withLED(new LEDConfigs().withStripType(StripTypeValue.GRB).withBrightnessScalar(1));

    configOff = new CANdleConfiguration();
    configOff.withLED(new LEDConfigs().withStripType(StripTypeValue.GRB).withBrightnessScalar(0));

    // Set up configs, on and off

  }

  public void clearAnimation() {
    m_candle.setControl(new SolidColor(0, 0));
  }

  public void color1() {
    m_candle.getConfigurator().apply(configOn);
    m_candle.setControl(
        new SolidColor(0, 7)
            .withColor(new RGBWColor(Color.kBlue).scaleBrightness(1)));
    System.out.println("IN COLOR ONE");
  }

  public void color2() {
    m_candle.getConfigurator().apply(configOn);
    m_candle.setControl(
        new SolidColor(0, 7)
            .withColor(new RGBWColor(Color.kYellow).scaleBrightness(1)));
    System.out.println("IN COLOR TWO");
  }

  public void setFireAnimation() {
    // Fire animation
    m_candle.setControl(
        new FireAnimation(MIN, MAX).withSlot(1)
            .withDirection(AnimationDirectionValue.Backward)
            .withCooling(0.2)
            .withSparking(0.6));
    System.out.println("IN FIRE ANIMATION");
  }

  public void turnOffLED() {
    m_candle.getConfigurator().apply(configOff);
    m_candle.setControl(
        new EmptyAnimation(ledRange).withSlot(2));
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
