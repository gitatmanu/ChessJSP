package Chess;

import java.util.Iterator;
import java.util.List;

public abstract class Piece {
    private final Colour colour;
    private final String asciiCode;

    public Piece(Colour colour, String asciiCode) {
        this.colour = colour;
        this.asciiCode = asciiCode;
    }

    public String getAsciiCode() {
        return this.asciiCode;
    }

    public Colour getColour() {
        return this.colour;
    }

    public abstract boolean[][] validMovements(int y, int x, Game game);

    public boolean canAscend(int y, int x) {
        return false;
    }

    public static void iteratePawn(
            int y,
            int x,
            Colour colour,
            List<int[]> absMovements,
            Game game
    ) {
        int yDifferent = colour == Colour.WHITE ? y - 1 : y + 1;
        int exitRow = colour == Colour.WHITE ? 6 : 1;

        Colour colourMainPiece = game.getBoard()[y][x].getColour();

        if (yDifferent <= 7 && yDifferent >= 0) {
            if (x - 1 <= 7 && x - 1 >= 0 &&
                    game.getBoard()[yDifferent][x - 1] != null &&
                    game.getBoard()[yDifferent][x - 1].getColour() != game.getBoard()[y][x].getColour()
            ) {
                absMovements.add(new int[]{yDifferent, x - 1});
            }
            if (x + 1 <= 7 && x + 1 >= 0 &&
                    game.getBoard()[yDifferent][x + 1] != null &&
                    game.getBoard()[yDifferent][x + 1].getColour() != game.getBoard()[y][x].getColour()
            ) {
                absMovements.add(new int[]{yDifferent, x + 1});
            }
        }

        if (exitRow == y) {
            while (
                    yDifferent >= 0 && yDifferent <= 7 &&
                            yDifferent != y - 3 && yDifferent != y + 3
            ) {
                if (game.getBoard()[yDifferent][x] == null) {
                    absMovements.add(new int[]{yDifferent, x});
                } else {
                    break;
                }

                if (yDifferent > y) yDifferent++;
                else if (yDifferent < y) yDifferent--;
            }
        } else {
            if (yDifferent <= 7 && yDifferent >= 0 && x <= 7 && x >= 0 &&
                    game.getBoard()[yDifferent][x] == null
            ) {
                absMovements.add(new int[]{yDifferent, x});
            }
        }
    }

    public static void insertValidMovements(
            boolean[][] board,
            List<int[]> absoluteMovements
    ) {
        for (int[] mov : absoluteMovements) {
            board[mov[0]][mov[1]] = true;
        }
    }

    public static void iterateFixedPositions(
            int y,
            int x,
            List<int[]> absMovements,
            Game game
    ) {
        for (Iterator<int[]> it = absMovements.iterator(); it.hasNext(); ) {
            int[] move = it.next();

            if (move[0] > 7 || move[0] < 0 || move[1] > 7 || move[1] < 0) {
                it.remove();
                continue;
            }

            if (game.getBoard()[move[0]][move[1]] != null) {
                if (game.getBoard()[move[0]][move[1]].getColour() == game.getBoard()[y][x].getColour()) {
                    it.remove();
                }
            }
        }
    }

    public static void iterateDirection(
            int y,
            int x,
            int yDifferent,
            int xDifferent,
            List<int[]> absoluteMovements,
            Game game
    ) {
        while (yDifferent >= 0 && yDifferent <= 7 && xDifferent >= 0 && xDifferent <= 7) {
            if (game.getBoard()[yDifferent][xDifferent] != null) {
                if (game.getBoard()[yDifferent][xDifferent].getColour() != game.getBoard()[y][x].getColour()) {
                    absoluteMovements.add(new int[]{yDifferent, xDifferent});
                }
                break;
            } else {
                absoluteMovements.add(new int[]{yDifferent, xDifferent});
            }

            if (yDifferent > y) yDifferent++;
            else if (yDifferent < y) yDifferent--;

            if (xDifferent > x) xDifferent++;
            else if (xDifferent < x) xDifferent--;
        }
    }
}
