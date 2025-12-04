package frc.robot.commands.Algae;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.Algae;

public class PlopCommand extends Command{
    private final Algae m_AlgaeSubsystem;

    public PlopCommand(Algae m_AlgaeSubsystem){
        this.m_AlgaeSubsystem = m_AlgaeSubsystem;
        addRequirements(m_AlgaeSubsystem);
    }

    @Override
    public void initialize() {
        }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
           
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
