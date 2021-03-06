// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.networktables.LogMessage;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.subsystems.GaniPower;

public class TankDrive extends CommandBase {
  /** Creates a new TankDrive. */
  public TankDrive() {
    addRequirements(Robot.driverTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double xAxis = Robot.m_oi.GetDriverRawAxis(RobotMap.STICK_Y);
    double yAxis = Robot.m_oi.GetDriverRawAxis(RobotMap.STICK_X);
    Robot.m_oi.GetButton();


    Robot.driverTrain.ArcadeDrive(-xAxis,yAxis,true);
      
    //   if(yAxis > 0 || yAxis < 0){
    //     Robot.driverTrain.movement(yAxis);  
    //   }else{
    //   Robot.driverTrain.rotate(xAxis);
    // }
    

    // Robot.driverTrain.movement(xAxis);
    // if(Robot.m_oi.getJoystick().getX() != 0)
    // {
    //     Robot.driverTrain.rotate(xAxis);
    // }
    // else
    // {
    //   Robot.driverTrain.m(yAxis);
    // }

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.driverTrain.ArcadeDrive(0,0,false);


  }

  public void shoot() {
      
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}