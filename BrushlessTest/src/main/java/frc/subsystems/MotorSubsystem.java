/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.commands.*;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANSparkMax;

/**
 * Add your docs here.
 */
public class MotorSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private CANSparkMax motor;
  // private TalonSRX motor;

  public MotorSubsystem() {
    // motor = new TalonSRX(0);
    motor = new CANSparkMax(1, CANSparkMax.MotorType.kBrushless);
    
  }
  
  public void moveMotor(double power) {
    // motor.set(ControlMode.PercentOutput, power);
    System.out.println(power);
    motor.set(power);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new MoveMotorCommand());
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
