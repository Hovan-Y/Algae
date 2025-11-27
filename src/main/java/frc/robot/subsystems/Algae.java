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

    public double speed;

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

    public void setMotorToSpeed(){
        Motor1.set(speed);
        Motor2.set(-speed);
    }

    public void setSpeed(double speed){
        this.speed = speed;
    }

    public Command intake(){
        return new IntakeCommand(this);
    }

    public Command outtake(){
        return new OuttakeCommand();
    }

    public Command plop(){
        return new PlopCommand();
    }

    public Command test() {
        if (getLinebreak()){
            return intake();
        } 
        else if (!getLinebreak()) {
            return outtake();
        }
        else {
            return intake();
        }
    }
}
