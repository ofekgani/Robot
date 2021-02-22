// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import frc.robot.commands.TankDrive;

public class DriverTrain extends SubsystemBase {

  private TalonSRX motorLeft1 = null;
  private TalonSRX motorLeft2 = null;
  private TalonSRX motorRight1 = null;
  private TalonSRX motorRight2 = null;

  SpeedControllerGroup leftMotors = null;
  SpeedControllerGroup rightMotors = null;

  DifferentialDrive differentialDrive = null;

  /** Creates a new DriverTrain. */
  public DriverTrain() {
    motorLeft1 = new TalonSRX(RobotMap.MOTOR_LEFT_1_ID);
    motorLeft2 = new TalonSRX(RobotMap.MOTOR_LEFT_2_ID);
    motorRight1 = new TalonSRX(RobotMap.MOTOR_RIGHT_1_ID);
    motorRight2 = new TalonSRX(RobotMap.MOTOR_RIGHT_2_ID);

  }
  @Override
  public void periodic() {
    setDefaultCommand(new TankDrive());
  }

  public void rotateRight(double speed){
    motorLeft1.set(ControlMode.PercentOutput, speed);
    motorLeft2.set(ControlMode.PercentOutput, speed);
  }

  public void rotateLeft(double speed){
    motorLeft1.set(ControlMode.PercentOutput, speed);
    motorLeft2.set(ControlMode.PercentOutput, speed);
  }

  public void movement(double speed)
  {
    motorLeft1.set(ControlMode.PercentOutput, -speed);
    motorLeft2.set(ControlMode.PercentOutput, -speed);
    motorRight1.set(ControlMode.PercentOutput, speed);
    motorRight2.set(ControlMode.PercentOutput, speed);
  

  }
}
