// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;

public class Shoot extends Command {
  /** Creates a new Collection. */
  Shooter shooter = Shooter.getInstance();
  Intake intake = Intake.getInstance();
  int timer;

  public Shoot() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(shooter);
    addRequirements(intake);

    timer = 0;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    shooter.setShooterMotors(SmartDashboard.getNumber("Shooter Motors", 0));
    Timer.delay(0.5);
    intake.setIntakeMotors(SmartDashboard.getNumber("Conveyance Speed", 0));
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    timer++;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    shooter.stopMotor();
    intake.stopMotors();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (timer > 150);
   }
}
