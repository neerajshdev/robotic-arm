# Arduino Robotic Arm

A fully-functional robotic arm powered by Arduino UNO, featuring both hardware control and desktop software for precise manipulation.

## Video Demonstration

A video demonstration of the robotic arm in action is available in the project root:
[Watch Video Demo](VID-20210805-WA0000.mp4)

## Overview

This project implements a 6-DOF (Degrees of Freedom) robotic arm controlled by an Arduino UNO microcontroller. The arm consists of 5 servo motors that control different joints: base, shoulder, elbow, wrist, gripper. The system can be operated in three ways:
- Manual control using potentiometers
- Computer control via a desktop application
- Bluetooth control via a mobile app

## Features

- **5-DOF Robotic Arm**: Full range of motion with base rotation, shoulder, elbow, wrist articulation, and gripper control
- **OLED Display**: Real-time feedback of servo positions and system status
- **Desktop Interface**: User-friendly Processing-based application for precise control
- **Programmable Positions**: Save and recall positions for automated sequences
- **Serial Communication**: Reliable data transfer between Arduino and computer

## Hardware Components

- Arduino UNO
- 6× Servo Motors
- 6× Potentiometers
- SSD1306 OLED Display (128×64)
- Jumper Wires
- Power Supply
- Mechanical Arm Assembly

## Software Components

### Arduino Firmware
- Located in `/Arduino UNO/Robot_arm/Robot_arm.ino`
- Manages servo control, reads potentiometer values
- Handles serial communication with desktop application
- Controls OLED display

### Desktop Application
- Located in `/desktop_soft/Robot_arm/Robot_arm.pde`
- Built with Processing
- Provides visual interface for controlling the arm
- Allows saving and recalling positions
- Offers sequential movement programming
- Real-time monitoring of arm position

## Setup and Installation

### Hardware Setup
1. Assemble the robotic arm according to your specific model
2. Connect servos to the designated Arduino pins:
   - Base: Pin 9
   - Shoulder: Pin 6
   - Elbow: Pin 5
   - Wrist: Pin 3
   - Gripper: Pin 11
3. Connect potentiometers to analog pins:
   - Potentiometer 1: A0
   - Potentiometer 2: A1
   - Potentiometer 3: A2
   - Potentiometer 4: A3
   - Potentiometer 5: A6
4. Connect the OLED display to I2C pins (A4/SDA, A5/SCL)

### Software Installation
1. **Arduino Firmware**:
   - Open `Robot_arm.ino` in the Arduino IDE
   - Install required libraries: Servo, SoftwareSerial, Adafruit_SSD1306, Adafruit_GFX, and Wire
   - Upload the sketch to your Arduino UNO

2. **Desktop Application**:
   - Install Processing from [processing.org](https://processing.org/)
   - Open `Robot_arm.pde` in Processing
   - Install required libraries: controlP5, processing.serial
   - Run the application

## Usage

### Manual Control (with potentiometers)
1. Power on the system
2. Use the five potentiometers to control each joint of the arm
3. The OLED display will show the current position of each servo

### Computer Control
1. Connect Arduino to your computer via USB
2. Launch the desktop application
3. Click "Connect" to establish serial communication
4. Use the interface controls to manipulate the arm
5. Save positions using memory buttons for later recall
6. Create sequences of movements for automation

## Developer Information

This project was developed by Neeraj Sharma at IIMT College of Engineering, Greater Noida, UP, India.

## License

This project is open-source and free to use for educational and personal projects.

