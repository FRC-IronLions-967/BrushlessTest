/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.SerialPort;
/**
 * Add your docs here.
 */
public class AngleSensorThread extends Thread {
    @Override
    public void run() {
        try {
            SerialPort sensor = new SerialPort(9600, SerialPort.Port.kMXP);
            System.out.println("Serial port opened on navX MXP");
            for(;;) {
                sensor.write(new byte[]{58, 48, 48}, 3);
                byte angleData[] = sensor.read(7);
                long angle = 0;
                System.out.println(angleData[6]);
                System.out.println("Length of array: " + angleData.length);
                for(int i = 1; (i <= 4) && (angleData.length > 0); i++) {
                    angle <<= 4;
                    angle += (angleData[i] <= 57) ? angleData[i] - 48 : angleData[i] - 65 + 10;

                }
                System.out.println("Angle: " + angle);
                Thread.sleep(40);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
