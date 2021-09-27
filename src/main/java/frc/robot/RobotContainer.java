// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.XboxController.Button;
import frc.robot.commands.ClimberDownCommand;
import frc.robot.commands.ClimberUpCommand;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.OuttakeCommand;
import frc.robot.commands.ServoExtendCommand;
import frc.robot.commands.ShooterCommand;
import frc.robot.commands.WinchLiftCommand;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ServoSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.ClimberSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveTrainSubsystem driveTrainSubsystem = new DriveTrainSubsystem();
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  private final ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
  private final ClimberSubsystem climberSubsystem = new ClimberSubsystem();
  private final ServoSubsystem servoSubsystem = new ServoSubsystem();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  XboxController m_driverController = new XboxController(Constants.CONTROLLER);

  //JoystickButton a_button = new JoystickButton(m_driverController, 1);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {

    // Configure the button bindings
    configureButtonBindings(); {

      //a_button.whileHeld( new IntakeCommand(intakeSubsystem) );
      new JoystickButton(m_driverController, Button.kB.value)
      .whileHeld(new IntakeCommand(intakeSubsystem));

      new JoystickButton(m_driverController, Button.kY.value)
      .whileHeld(new OuttakeCommand(intakeSubsystem));

      new JoystickButton(m_driverController, Button.kA.value)
      .whileHeld(new ShooterCommand(shooterSubsystem));

      new JoystickButton(m_driverController, Button.kX.value)
      .whileHeld(new ServoExtendCommand(servoSubsystem));

      new JoystickButton(m_driverController, Button.kStart.value)
      .whileHeld(new WinchLiftCommand(climberSubsystem));

      new JoystickButton(m_driverController, Button.kBumperLeft.value)
      .whileHeld(new ClimberDownCommand(climberSubsystem));

      new JoystickButton(m_driverController, Button.kBumperRight.value)
      .whileHeld(new ClimberUpCommand(climberSubsystem));

    }

    driveTrainSubsystem.setDefaultCommand(
      new RunCommand(() -> driveTrainSubsystem.mecanumDrive(getControllerLeftX(), getControllerRightY(), getControllerRightX()), driveTrainSubsystem)
    );

  }

  private double deadZoneMod(double val) {
    if (Math.abs(val) <= Constants.DEADZONE) {
      return 0;
    } else {
      return ((val -0.2) * 1.25) ;
    }
  }

  public double getControllerRightX() {
    if ( m_driverController != null ) {
      return deadZoneMod(m_driverController.getX(Hand.kRight));
    } else {
      return 0;
    }
  }

  public double getControllerLeftX() {
    if (m_driverController != null ) {
      return deadZoneMod(m_driverController.getX(Hand.kLeft));
    } else {
      return 0;
    }
  }

  public double getControllerRightY() {
    if ( m_driverController != null ) {
      return deadZoneMod(m_driverController.getY(Hand.kRight));
    } else {
      return 0;
    }
    
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {}

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
