// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.led.CANdle.VBatOutputMode;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
  /** Creates a new intakes. */
  private VictorSPX intakeMotor1;
  private VictorSPX intakeMotor2; 

  private static Intake intakeInstance;
  
  public Intake() {
    intakeMotor1 = new VictorSPX(Constants.IntakeConstants.Motor1ID);
    intakeMotor2 = new VictorSPX(Constants.IntakeConstants.Motor2ID);

    intakeMotor1.setInverted(Constants.IntakeConstants.Motor1IsInverted);
    intakeMotor2.setInverted(Constants.IntakeConstants.Motor2IsInverted);

    SmartDashboard.putNumber("Intake Motors", 0);
    SmartDashboard.putNumber("Convaynce Speed", 0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setIntakeMotors(double speed){
    intakeMotor1.set(VictorSPXControlMode.PercentOutput, speed);
    intakeMotor2.set(VictorSPXControlMode.PercentOutput, speed);
  }

  public void stopMotors(){
    intakeMotor1.set(VictorSPXControlMode.Disabled, 0);
    intakeMotor2.set(VictorSPXControlMode.Disabled, 0);
  }
  
  // public double getCurrent(){
  //   return intakeMotor1.getStatorCurrent().getValueAsDouble();
  // }

  public static Intake getInstance(){
    if (intakeInstance == null){
      intakeInstance = new Intake();
    }
    return intakeInstance;
  }
}
