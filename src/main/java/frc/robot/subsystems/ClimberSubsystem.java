// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ClimberSubsystem extends SubsystemBase {

  private Spark climberSparkLeft;
  private Spark climberSparkRight;
  private Spark winchSpark;
  DigitalInput toplimitSwitch = new DigitalInput(0);
  DigitalInput bottomlimitSwitch = new DigitalInput(1);

  /** Creates a new Climber. */
  public ClimberSubsystem() {

    climberSparkLeft = new Spark(Constants.CLIMBER_SPARK_LEFT);
    climberSparkRight = new Spark(Constants.CLIMBER_SPARK_RIGHT);
    winchSpark = new Spark(Constants.WINCH_SPARK);
    climberSparkLeft.setInverted(false);
    climberSparkRight.setInverted(false);
    winchSpark.setInverted(false);

  }

  public void climberUp() {

    if (toplimitSwitch.get()) {
      climberSparkLeft.set(0);
      climberSparkRight.set(0);  
    } else {
      climberSparkLeft.set(Constants.CLIMBER_SPEED);
      climberSparkRight.set(Constants.CLIMBER_SPEED);
    }
  }

  public void climberDown() {

    if (bottomlimitSwitch.get()) {
      climberSparkLeft.set(0);
      climberSparkRight.set(0);
    } else {
      climberSparkLeft.set(-Constants.CLIMBER_SPEED);
      climberSparkRight.set(-Constants.CLIMBER_SPEED);
    }

  }

  public void winchLift() {

    winchSpark.set(Constants.WINCH_SPEED);

  }

  /*public void winchRelease() {

    winchSpark.set(-Constants.WINCH_SPEED);

  }*/

  public void climberStop() {

    climberSparkLeft.set(0);
    climberSparkRight.set(0);

  }

  public void winchStop() {

    winchSpark.set(0);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
