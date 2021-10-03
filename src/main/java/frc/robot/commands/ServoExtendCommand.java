// // Copyright (c) FIRST and other WPILib contributors.
// // Open Source Software; you can modify and/or share it under the terms of
// // the WPILib BSD license file in the root directory of this project.

// package frc.robot.commands;

// import edu.wpi.first.wpilibj2.command.CommandBase;
// import frc.robot.subsystems.ServoSubsystem;

// public class ServoExtendCommand extends CommandBase {
//   /** Creates a new ServoExtendCommand. */

//   private final ServoSubsystem servoSubsystem; 

//   public ServoExtendCommand(ServoSubsystem subsystem) {
//     servoSubsystem = subsystem;

//     addRequirements(servoSubsystem);
//     // Use addRequirements() here to declare subsystem dependencies.
//   }

//   // Called when the command is initially scheduled.
//   @Override
//   public void initialize() {    
    
//     servoSubsystem.RetractServo();
//     System.out.println("servo initialize");
//   }

//   // Called every time the scheduler runs while the command is scheduled.
//   @Override
//   public void execute() {
//     System.out.println("servo execute");
//   }

//   // Called once the command ends or is interrupted.
//   @Override
//   public void end(boolean interrupted) {
//     servoSubsystem.ExtendServo();
    
//     System.out.println("servo end");
//   }

//   // Returns true when the command should end.
//   @Override
//   public boolean isFinished() {
//     return false;
//   }
// }
