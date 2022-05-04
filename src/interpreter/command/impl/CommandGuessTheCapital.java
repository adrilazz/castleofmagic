package interpreter.command.impl;

import world.Player;

import java.util.Scanner;

public class CommandGuessTheCapital extends AbstractCommand{

    private String[][] _questionAnswer = new String[][]{{"What is the Capital of Spain?", "Madrid"},
            {"What is the Capital of France?", "Paris"},
            {"What is the Capital of England?", "London"}};

    private String _answerPlayer;
    private Player _player;

    private int count = 0;

    public CommandGuessTheCapital(Player player, String answer) {
        this._player = player;
        this._answerPlayer = answer;
    }

    @Override
    public void execute() {

    }

    public boolean run() {
        for(int i = 0; i < _questionAnswer.length; i++){
            _player.sendToPlayer(_questionAnswer[i][0]);

            if(_questionAnswer[i][1] == _answerPlayer){
                _player.sendToPlayer("That's Correct!");
                count++;
                while(count < 2){
                    _player.sendToPlayer("Next question !");
                }
            } else {
                _player.sendToPlayer("Wrong ! Try Again!");
            }
        }
        if(count == 3){
            return true;
        }
        return false;
    }

    public String toString() {
        return "The Capital Game";
    }

}
