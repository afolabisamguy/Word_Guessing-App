# Word_Guessing-App

**Guess the Word** is a fun and interactive Android game where users are presented with a shuffled word that represents a day of the week. The player's task is to guess the correct day by unscrambling the word.

## Features
- **Word Scrambling**: The app scrambles the letters of a randomly chosen day (Sunday to Saturday), which the player must guess. **(Note: You can add more words if you wish)**
- **User Input**: The player enters their guess in a text box.
- **Feedback System**: 
  - If the guess is correct, a dialog is shown with a congratulatory message.
  - If the guess is incorrect, a toast message informs the player.
- **Show Answer Option**: The player can reveal the correct answer by pressing a button.
- **Next Word**: The player can skip to the next scrambled word at any time.
  
## How the Game Works
1. A random day of the week is selected from an array.
2. The letters of the day are shuffled and displayed on the screen.
3. The player inputs their guess for what the scrambled word represents.
4. Upon submitting their guess:
   - If correct, a dialog appears confirming their success, and a new word is displayed.
   - If incorrect, a toast message tells them they guessed wrong.
5. The player can choose to reveal the correct answer using the "Show" button or skip to the next word with the "Next" button.

## Code Overview
The `MainActivity.kt` file contains the core logic of the app:
- **Random Word Selection**: A random day is selected using the `Random` class.
- **Word Scrambling**: The `mixWords` function shuffles the characters in the selected word.
- **Event Listeners**: Three buttons handle different actions:
  - **Check Button**: Verifies if the player’s guess matches the original word.
  - **Next Button**: Displays a new scrambled word.
  - **Show Button**: Reveals the correct answer to the player.
  
## How to Run the App
1. Clone the project repository and open it in Android Studio.
2. Build and run the app on an Android device or emulator.
3. The game starts immediately, displaying a scrambled day of the week.
