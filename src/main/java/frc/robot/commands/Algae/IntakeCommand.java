package frc.robot.commands.Algae;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.subsystems.Algae;
import frc.robot.Constants;

public class IntakeCommand extends Command{
    private final Algae m_AlgaeSubsystem;

    Timer launchTimer = new Timer();

    public IntakeCommand(Algae m_AlgaeSubsystem){
        this.m_AlgaeSubsystem = m_AlgaeSubsystem;
        addRequirements(m_AlgaeSubsystem);
    }

    @Override
    public void initialize() {
        launchTimer.reset();
        launchTimer.restart();

        if (m_AlgaeSubsystem.hasAlgae){
            m_AlgaeSubsystem.setSpeed(Constants.AlgaeConstants.kIntakeSpeed);
        }
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        if (launchTimer.hasElapsed(10)){//TODO : Place Seconds in constants
            m_AlgaeSubsystem.setSpeed(Constants.AlgaeConstants.kIdleSpeed);
            m_AlgaeSubsystem.hasAlgae = !m_AlgaeSubsystem.hasAlgae;
        }
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        m_AlgaeSubsystem.setSpeed(Constants.AlgaeConstants.kIdleSpeed);
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return !m_AlgaeSubsystem.hasAlgae;
    }
}
