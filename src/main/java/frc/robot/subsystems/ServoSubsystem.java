// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpiutil.math.MathUtil;

public class ServoSubsystem extends Servo {
  double m_speed;
  double m_length;

  double setPos;
  double curPos;

  Servo exampleServo = new Servo(1);
  
  /** Creates a new ServoSubsystem. */
  public ServoSubsystem(int channel, int length, int speed) {
    super(6);
    setBounds(2.0, 1.8, 1.5, 1.2, 1.0);
    m_length = length;
    m_speed = speed;
  }

  public void setPosition(double setpoint){
    setPos = MathUtil.clamp(setpoint, 0, m_length);
    setSpeed( (setPos/m_length *2)-1);
  }

  double lastTime = 0;

  public void updateCurPos(){
  double dt = Timer.getFPGATimestamp() - lastTime;
    if (curPos > setPos + m_speed *dt){
    curPos -= m_speed *dt;
    } else if(curPos < setPos - m_speed *dt){
    curPos += m_speed *dt;
    }else{
    curPos = setPos;}
    }
    public double getPosition(){
    return curPos;
    }

  public boolean isFinished(){
    return curPos == setPos;
  }

  @Override

}
