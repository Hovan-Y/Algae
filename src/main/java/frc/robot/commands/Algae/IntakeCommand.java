package frc.robot.commands.Algae;

import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.subsystems.Algae;
import frc.robot.Constants;

public class IntakeCommand extends Command{
    private final Algae m_AlgaeSubsystem;

    public IntakeCommand(Algae m_AlgaeSubsystem){
        this.m_AlgaeSubsystem = m_AlgaeSubsystem;
        addRequirements(m_AlgaeSubsystem);
    }

    @Override
    public void initialize() {
        if (!m_AlgaeSubsystem.hasAlgae){
            m_AlgaeSubsystem.setSpeed(Constants.AlgaeConstants.kIntakeSpeed);
        }
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        System.out.println("Intaking");
        m_AlgaeSubsystem.setMotorToSpeed();
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        if (m_AlgaeSubsystem.getLinebreak()){
            System.out.println("Intake Finish");
            m_AlgaeSubsystem.setSpeed(Constants.AlgaeConstants.kIdleSpeed);
            m_AlgaeSubsystem.setMotorToSpeed();
            m_AlgaeSubsystem.hasAlgae = true;
        }
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return m_AlgaeSubsystem.hasAlgae;
    }
}
