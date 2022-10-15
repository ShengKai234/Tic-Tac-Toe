package com.s_kai;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[][] grid = {{' ',' ',' '},
                {' ',' ',' '},
                {' ',' ',' '}};
        Scanner scanner = new Scanner(System.in);

        printGrid(grid);

        while(true) {
            playerTurn(grid, scanner);
            if (isGameFinished(grid)) {
                break;
            }
            printGrid(grid);
            computerTurn(grid);
            if (isGameFinished(grid)) {
                break;
            }
            printGrid(grid);
        }
        // printGrid(grid);

//        scanner.close();
    }

    private static boolean isGameFinished(char[][] grid) {
        if (hasContestantWon(grid, 'X')) {
            printGrid(grid);
            System.out.println("Player win!");
            return true;
        }
        if (hasContestantWon(grid, 'O')) {
            printGrid(grid);
            System.out.println("Computer win!");
            return true;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == ' ') {
                    return false;
                }
            }
        }
        printGrid(grid);
        System.out.println("no one win, it's tie!");
        return true;
    }

    private static boolean hasContestantWon(char[][] grid, char symbol) {
        if (grid[0][0] == symbol && grid[0][1] == symbol && grid[0][2] == symbol ||
            grid[1][0] == symbol && grid[1][1] == symbol && grid[1][2] == symbol ||
            grid[2][0] == symbol && grid[2][1] == symbol && grid[2][2] == symbol ||

            grid[0][0] == symbol && grid[1][0] == symbol && grid[2][0] == symbol ||
            grid[0][1] == symbol && grid[1][1] == symbol && grid[2][1] == symbol ||
            grid[0][2] == symbol && grid[1][2] == symbol && grid[2][2] == symbol ||

            grid[0][0] == symbol && grid[1][1] == symbol && grid[2][2] == symbol ||
            grid[0][2] == symbol && grid[1][1] == symbol && grid[2][0] == symbol) {
            return true;
        }
        return false;
    }

    private static void computerTurn(char[][] grid) {
        Random rand = new Random();

        int computerPlay;
        while (true) {
            computerPlay = rand.nextInt(9) + 1;
            if (isValidMove(grid, Integer.toString(computerPlay))) {
                break;
            }
        }
        System.out.println("Computer choice " + computerPlay);
        placeMove(grid, Integer.toString(computerPlay), 'O');
    }

    private static boolean isValidMove(char[][] grid, String position) {
        switch(position) {
            case "1":
                return (grid[0][0] == ' ');
            case "2":
                return (grid[0][1] == ' ');
            case "3":
                return (grid[0][2] == ' ');
            case "4":
                return (grid[1][0] == ' ');
            case "5":
                return (grid[1][1] == ' ');
            case "6":
                return (grid[1][2] == ' ');
            case "7":
                return (grid[2][0] == ' ');
            case "8":
                return (grid[2][1] == ' ');
            case "9":
                return (grid[2][2] == ' ');
            default:
                return false;
        }
    }

    private static void playerTurn(char[][] grid, Scanner scanner) {
        String userIntput;
        while (true) {
            System.out.println("Where would you like to play? (1-9)");
            userIntput = scanner.nextLine();
            if (isValidMove(grid, userIntput)) {
                break;
            } else {
                System.out.println(userIntput + " is not valid move!");
            }

        }
        placeMove(grid, userIntput, 'X');

//        scanner.close();
    }

    private static void placeMove(char[][] grid, String position, char symbol) {
        switch(position) {
            case "1":
                grid[0][0] = symbol;
                break;
            case "2":
                grid[0][1] = symbol;
                break;
            case "3":
                grid[0][2] = symbol;
                break;
            case "4":
                grid[1][0] = symbol;
                break;
            case "5":
                grid[1][1] = symbol;
                break;
            case "6":
                grid[1][2] = symbol;
                break;
            case "7":
                grid[2][0] = symbol;
                break;
            case "8":
                grid[2][1] = symbol;
                break;
            case "9":
                grid[2][2] = symbol;
                break;
        }
    }

    private static void printGrid(char[][] grid) {
        System.out.println(grid[0][0] + "|" + grid[0][1] + "|" + grid[0][2]);
        System.out.println("-+-+-");
        System.out.println(grid[1][0] + "|" + grid[1][1] + "|" + grid[1][2]);
        System.out.println("-+-+-");
        System.out.println(grid[2][0] + "|" + grid[2][1] + "|" + grid[2][2]);
    }
}