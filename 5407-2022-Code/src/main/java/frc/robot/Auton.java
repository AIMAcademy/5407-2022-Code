/* package frc.robot;

/* Auton Class
	This is custom version of autonomous operation. As you can see it extends the StateMachine class so it will can take
    on all the StateMachine's charactistics. Usign this you can design up to 10 autonomous state machines to do run
    during the autonomous period for the robot.

 


public class Auton extends MyStateMachine {

    // Auton class constructor. We are passing several other classes that we need access to get use their FBW values.
    // We are passing references for these classes.

    String status = "";

    public  Auton() {
        reset();
        timStepTimer.start();       // required as MyStateMachine cannot do this. 
    }

    public void auton1() { // This overrides the auton1 method defined in the state machine class.
        String sAuton = "Auton1";
        //putString("Auton ", sAuton );
        if( bStepFirstPass)                                         // no need to do this in every                                                          
            timStepTimer.reset();                                   // reset the timer on a step change

        switch (iStep) {                            // switch statement.
            // it will look at iStep and find the case where it should run code.
            // if iStep not found, it will go to default section at bottom.

            case 0:                                    // case 0 is where we can set up a bunch of stuff for the state machine.    
                if (bStepFirstPass) {
                }
                status = "Step " + String.valueOf(iStep) + ": ";
                status += "Started";

                iStep++;                            // We are done with step, increment iStep

                break;                            // setup complete, jump out and go around again.

            case 1:
                if (bStepFirstPass) {
                }
                status = "Step " + String.valueOf(iStep) + ": ";

                if( timStepTimer.get() < 1.0){          // while < 1.0 seconds
                    //Turns on/deploys the intake mechanism, the targetting system, and speeds up the shooter wheel
                    //Inputs.shooterFullAutoModeOn = true;
                    Inputs.motIntakePower = 0.75;
                    //Inputs.gamepadOperator.getBButton = 0.75;
                    status += "Intake Comes down.";
                    //Constants.telemetry.saveString("Auton Step Desc", status );
                    //break;

                } else {
                    Inputs.intakeDeploy = false;  //After the intake mechanism is deployed, turn this variable off (Button is no longer being pressed)
                    status += "Targetting still on but, turned off deploy intake. Done!";
                    iStep++; //Increases the variable by 1 so that when we go back to the beginning, the istepp will direct it to the next case
                }
                         
                break;

            case 2:
                if (bStepFirstPass) {
                }
                Inputs.driverIsUsingGamepad = true;

                status = "Step " + String.valueOf(iStep) + ": ";

                //Keep doign this
                Inputs.shooterFullAutoModeOn = true;                 //Turns on/deploys the intake mechanism, the targetting system, and speeds up the shooter wheel

                Inputs.driverTrigger = true; //Pulls in the ball 
                   // Drives backwards for 2 seconds then reduces the speed for 4 seconds.
                if( timStepTimer.get() < Constants.AutoConstants.kAuton1_DriveBackTime){ //May have to change speeds + time
                    Inputs.driverPower = Constants.AutoConstants.kAuton1_DriveBackward;
                    status += "Intake running, backing up to get a second ball.";
                } else if (timStepTimer.get() <  Constants.AutoConstants.kAuton1_DriveBackTime + 2.0) { // Slowly backing, trying to pick up ball
                    Inputs.driverPower = Constants.AutoConstants.kAuton1_DriveBackwardSlow;             // Intake  is still on
                    status += "Intake running, backing up slowly to get a second ball.";
                }
                else {
                    status += "Should have the ball. Done...";
                    iStep ++;
                    iStep ++;
                }
                break;
            case 3:
                if (bStepFirstPass) {
                }
                Inputs.driverIsUsingGamepad = true;

                status = "Step " + String.valueOf(iStep) + ": ";

                //Keep doign this
                Inputs.shooterFullAutoModeOn = true;                 //Turns on/deploys the intake mechanism, the targetting system, and speeds up the shooter wheel

                Inputs.driverTrigger = true; //Pulls in the ball 
                   // Drives backwards for 2 seconds then reduces the speed for 4 seconds.
                if( timStepTimer.get() < 0.75){ //May have to change speeds + time
                    Inputs.turretAdjust = 0.5;
                    status += "Robot turning around";
                } else {
                    status += "Completed turning. Done...";
                    iStep++;
                }
                break;

            case 4:
                if (bStepFirstPass) { //Maybe add photogate chekcs
                }
                status = "Step " + String.valueOf(iStep) + ": ";

                Inputs.shooterFullAutoModeOn = true;                         //Turns on/deploys the intake mechanism, the targetting system, and speeds up the shooter wheel
                if( timStepTimer.get() < Constants.AutoConstants.kAuton1_ShootingTime){  // stay here intil we hit the time.
                    status += "Shooting: ";
                    Inputs.operatorTrigger = true;    //Shoots the ball using the target and steps from case 1
                }else{
                    status += "Shooting done... ";
                    iStep++;
                    
                }
                break;
            
            case 5: //If in the case that it is near the wall, it drives forwards and retracts the intake so we don't have to do that once Telop hits. 
            if (bStepFirstPass) {
                }
                status = "Step " + String.valueOf(iStep) + ": ";
                
                if(timStepTimer.get() < Constants.AutoConstants.kAuton1_DriveFromWallTime){
                    Inputs.driverPower = Constants.AutoConstants.kAuton1_DriveForward;
                    status += "Pulling forward a little to clear the wall.";

                } else if(timStepTimer.get() < Constants.AutoConstants.kAuton1_DriveFromWallTime + 2.0){  // allow 2 sec to retract (change to shorter time?)
                    status += "Retract should be done. Step done...";
                    Inputs.driverPower = 0.0;
                    Inputs.intakeRetract = true; // Intake treacks intake location
                } else {
                    iStep++;
               }
               break;

            default:
                if (bStepFirstPass) {
                    sStepDescription = "Auton Complete";
                  }
                }


        }
} */