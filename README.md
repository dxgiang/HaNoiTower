# Ha Noi Tower (Java Swing)

A simple **Java Swing desktop game** When players tries to move boxes from the first column to the third column, they must ensure that the top box is always smaller than the boxes below it.

## How to Play
Click the column button that you want to move the top box. Then click the other column button to move the box. Make sure that the top box is always smaller than the boxes below it.

## Image
<img width="986" height="618" alt="image" src="https://github.com/user-attachments/assets/eac1d2de-a059-4607-9228-fc4664180ffe" />

## Project Structure
```bash
src
   ├── controller
   │            └── HanoiController.java
   ├── logic
   │       └── GameLogic.java
   ├── view
   │      ├── ButtonCustom.java
   │      └── HanoiPanel.java
   └── Main.java
```

## Download game
Download: https://dxgiang.itch.io/hanoi-tower

## Installation & Run
1. Clone or download this repository.
2. Open it in your IDE (Eclipse, IntelliJ, VS Code with Java).
3. Compile and run `Main.java`.

```bash
javac Main.java
java Main