package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel;
import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;
import frc.robot.commands.Algae.IntakeCommand;
import frc.robot.commands.Algae.OuttakeCommand;
import frc.robot.commands.Algae.PlopCommand;

public class Algae extends SubsystemBase{
    public SparkMax Motor1;
    public SparkMax Motor2;

    public DigitalInput Linebeak;

    public boolean hasAlgae;

    public static Algae mInstance = null;

    public static Algae getInstance(){
        if (mInstance == null){
            mInstance = new Algae();
        }

        return mInstance;
    }

    public Algae(){
        Motor1 = new SparkMax(Constants.AlgaeConstants.kMotor1Port, SparkLowLevel.MotorType.kBrushless);
        Motor2 = new SparkMax(Constants.AlgaeConstants.kMotor2Port, SparkLowLevel.MotorType.kBrushless);

        Linebeak = new DigitalInput(Constants.AlgaeConstants.kLinebreakPort);
    }

    public boolean getLinebreak(){
        return Linebeak.get();
    }

    public void setSpeed(double speed){
        Motor1.set(speed);
        Motor2.set(-speed);
    }

    public Command intake(){
        return new IntakeCommand(this);
    }

    public Command outtake(){
        return new OuttakeCommand(this);
    }

    public Command plop(){
        return new PlopCommand(this);
    }

    public Command test() {
        if (hasAlgae){
            return intake();
        } 
        else if (!hasAlgae) {
            return outtake();
        }
        else {
            return plop();
        }
    }
}
