// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ServoSubsystem extends SubsystemBase {

  private Servo shooterServo;

  public ServoSubsystem() {

     shooterServo = new Servo(Constants.SERVO);

  }
  
  public void ExtendServo() {

      shooterServo.set(Constants.SERVO_EXTEND);
      System.out.println("servo subsystem");

  }

  public void RetractServo() {

      shooterServo.set(Constants.SERVO_RETRACT);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
