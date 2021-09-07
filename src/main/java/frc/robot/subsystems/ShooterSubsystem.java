// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterSubsystem extends SubsystemBase {
  
  private Spark shooterSparkA;
  private Spark shooterSparkB;

  /** Creates a new ShooterSubsystem. */

  public ShooterSubsystem() {

    shooterSparkA = new Spark(Constants.SHOOTER_SPARK_A);
    shooterSparkB = new Spark(Constants.SHOOTER_SPARK_B);
    shooterSparkA.setInverted(false);
    shooterSparkB.setInverted(true);

  }

  public void ballShoot() {

    shooterSparkA.set(Constants.SHOOTER_SPEED);
    shooterSparkB.set(Constants.SHOOTER_SPEED);

  }

  public void shootStop() {

    shooterSparkA.set(0);
    shooterSparkB.set(0);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
