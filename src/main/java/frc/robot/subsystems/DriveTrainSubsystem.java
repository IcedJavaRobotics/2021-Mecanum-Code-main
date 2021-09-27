// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrainSubsystem extends SubsystemBase {
  /** Creates a new DriveTrainSubsystem. */

  final CANSparkMax frontLeft;
  final CANSparkMax backLeft;
  final CANSparkMax frontRight;
  final CANSparkMax backRight;

  public DriveTrainSubsystem() {

    frontLeft = new CANSparkMax(Constants.FRONT_LEFT_SPARK, MotorType.kBrushless);
    backLeft = new CANSparkMax(Constants.BACK_LEFT_SPARK, MotorType.kBrushless);
    frontRight = new CANSparkMax(Constants.FRONT_RIGHT_SPARK, MotorType.kBrushless);
    backRight = new CANSparkMax(Constants.BACK_RIGHT_SPARK, MotorType.kBrushless);

    frontLeft.setInverted(true);
    backLeft.setInverted(false);
    frontRight.setInverted(true);
    backRight.setInverted(false);

  }

  public void moveMotor( double speed, CANSparkMax spark) {

    spark.set( speed );

  }

  public void mecanumDrive( double R, double Y, double X) {

    moveMotor( X + Y + R, frontLeft );
    moveMotor( X - Y + R, backLeft );
    moveMotor( X - Y - R, frontRight );
    moveMotor( X + Y - R, backRight );

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
