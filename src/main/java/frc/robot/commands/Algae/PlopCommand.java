package frc.robot.commands.Algae;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.AlgaeConstants;
import frc.robot.subsystems.Algae;

public class PlopCommand extends Command{
    private final Algae m_AlgaeSubsystem;

    public PlopCommand(Algae m_AlgaeSubsystem){
        this.m_AlgaeSubsystem = m_AlgaeSubsystem;
        addRequirements(m_AlgaeSubsystem);
    }

    @Override
    public void initialize() {
        System.out.println("Plop");
        if(!m_AlgaeSubsystem.getLinebreak()){
            m_AlgaeSubsystem.setSpeed(AlgaeConstants.kPlopSpeed);
        }
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        if(m_AlgaeSubsystem.getLinebreak()){
            m_AlgaeSubsystem.setSpeed(AlgaeConstants.kIdleSpeed);
            m_AlgaeSubsystem.hasAlgae = !m_AlgaeSubsystem.hasAlgae;
        }
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        m_AlgaeSubsystem.setSpeed(AlgaeConstants.kIdleSpeed);
        m_AlgaeSubsystem.hasAlgae = !m_AlgaeSubsystem.hasAlgae;
    }

    public boolean isFinished(){
        return m_AlgaeSubsystem.hasAlgae;
    }
}
