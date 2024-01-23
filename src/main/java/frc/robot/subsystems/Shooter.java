// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.revrobotics.CANSparkFlex;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
  /** Creates a new Rollers. */
  private TalonFX shooterMotor1;
  private TalonFX shooterMotor2;

  private static Shooter shooterInstance;
  
  public Shooter() {
    shooterMotor1 = new TalonFX(Constants.ShooterConstants.Motor1ID);
    shooterMotor2 = new TalonFX(Constants.ShooterConstants.Motor2ID);

    shooterMotor1.setInverted(Constants.ShooterConstants.Motor1IsInverted);
    shooterMotor2.setInverted(Constants.ShooterConstants.Motor2IsInverted);

    SmartDashboard.putNumber("Roller Motor", 0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setShooterMotors(double speed){
    shooterMotor1.set(speed);
    shooterMotor2.set(speed);
  }

  public void stopMotor(){
    shooterMotor1.disable();
    shooterMotor2.disable();
  }

  public static Shooter getInstance(){
    if (shooterInstance == null){
      shooterInstance = new Shooter();
    } 
    return shooterInstance;
  }
}
