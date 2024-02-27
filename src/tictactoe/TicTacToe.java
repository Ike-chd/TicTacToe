package tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    private static final String[][] BOARD = new String[3][3];
    public static final Scanner words = new Scanner(System.in);
    public static final Scanner numbers = new Scanner(System.in);
    private String player;
    private String computer;
    private String currentTurn;

    public void printBoard() {
        System.out.println(" ___ ___ ___");
        for (String[] icons : BOARD) {
            System.out.print("|");
            for (String icon : icons) {
                if (icon == null) {
                    System.out.print("___|");
                } else {
                    System.out.print("_" + icon + "_|");
                }
            }
            System.out.println("");
        }
    }

    public boolean hasWon(String icon) {
        for (WinningCombination value : WinningCombination.values()) {
            boolean hasWon = true;
            for (Positions po : value.getPos()) {
                hasWon &= checkIfIconIsInThatPositions(icon, po);
            }
            if (hasWon) {
                return true;
            }
        }
        return false;
    }

    public boolean checkIfIconIsInThatPositions(String icon, Positions pos) {
        return (BOARD[pos.getX()][pos.getY()] != null)
                ? icon.equals(BOARD[pos.getX()][pos.getY()])
                : false;
    }

    public List<Positions> getOpenPositions() {
        List<Positions> pos = new ArrayList<>();
        int x = 0;
        for (String[] BOARD1 : BOARD) {
            for (String BOARD11 : BOARD1) {
                if (BOARD11 == null) {
                    pos.add(Positions.values()[x]);
                }
                x++;
            }
        }
        return pos;
    }

    public void printOpenPositions() {
        int x = 1;
        for (Positions openPosition : getOpenPositions()) {
            System.out.println(x + ". " + openPosition.name());
            x++;
        }
    }
    
    public Positions ifPlayerIsAboutToWin(){
        for (WinningCombination value : WinningCombination.values()) {
            int num = 0;
            for (Positions po : value.getPos()) {
                if (checkIfIconIsInThatPositions(player, po)) {
                    num++;
                }
            }
            if (num == 2) {
                for (Positions po : value.getPos()) {
                    if(!checkIfIconIsInThatPositions(player, po) && checkIfPositionIsEmpty(po)) return po;
                }
            }
        }
        return null;
    }
    
    public Positions ifComputerIsAboutToWin(){
        for (WinningCombination value : WinningCombination.values()) {
            int num = 0;
            for (Positions po : value.getPos()) {
                if (checkIfIconIsInThatPositions(computer, po)) {
                    num++;
                }
            }
            if (num == 2) {
                for (Positions po : value.getPos()) {
                    if(!checkIfIconIsInThatPositions(computer, po) && checkIfPositionIsEmpty(po)) return po;
                }
            }
        }
        return null;
    }
    
    public boolean checkIfPositionIsEmpty(Positions pos){
        return BOARD[pos.getX()][pos.getY()] == null;
    }

    public void enterIcon(String icon, Positions pos) {
        BOARD[pos.getX()][pos.getY()] = icon;
        currentTurn = icon;
    }

    public boolean checkIfThereIsSpaceLeft() {
        for (String[] BOARD1 : BOARD) {
            for (String BOARD11 : BOARD1) {
                if (BOARD11 == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public void run() {
        System.out.println("Welcome to tic tac toe");
        System.out.println("Please choose your character:");
        System.out.println("1. X");
        System.out.println("2. O");
        if (numbers.nextInt() == 1) {
            player = "X";
            computer = "O";
            currentTurn = "O";
        } else {
            player = "O";
            computer = "X";
            currentTurn = "X";
        }
        
        do {
            printBoard();
            if (!currentTurn.equals(player)) {
                System.out.println("Choose where to place your character");
                printOpenPositions();
                enterIcon(player, getOpenPositions().get(numbers.nextInt() - 1));
            } else {
                System.out.println("Computer's Turn");
                computersTurn();
            }
        } while (!hasWon(currentTurn) && checkIfThereIsSpaceLeft());
        
        if (hasWon(currentTurn)) {
            System.out.println((currentTurn.equals(player)) ? "Congrats, you have won" : "Sorry, you have lost");
            printBoard();
        } else {
            System.out.println("It's a tie");
            printBoard();
        }
    }

    public void computersTurn() {
        if(ifComputerIsAboutToWin() != null){
            enterIcon(computer, ifComputerIsAboutToWin());
        } else if(ifPlayerIsAboutToWin() != null){
            enterIcon(computer, ifPlayerIsAboutToWin());
        } else {
            Random r = new Random();
            enterIcon(computer, getOpenPositions().get(r.nextInt(0, getOpenPositions().size())));
        }
    }
}