package Models.Units;

import Models.Game.Position;
import Models.Terrain.Tile;

import java.util.ArrayList;


    public class FindWay {
        private ArrayList<Position> moves;
        private Tile destination;
        private static FindWay findWay;

        public static FindWay getInstance(Tile destination){
            if(findWay == null){
                findWay = new FindWay(destination);
            }
            return findWay;
        }

        private FindWay(Tile destination) {
            this.moves = new ArrayList<>();
            this.destination = destination;
        }

        private double calculateDistance(Position a, Position b) {
            double c = Math.pow(a.X - b.X, 2) + Math.pow(a.Y - b.Y, 2);
            double ans = Math.pow(c, 0.5);
            return ans;
        }

        private Position getDirection(Position current, Position destination, int flg) {
            int xAns = 0, yAns = 0;
            ArrayList<Position> directions = new ArrayList<>();
            int x = current.X;
            int y = current.Y;
            directions.add(new Position(x - 1, y));
            directions.add(new Position(x + 1, y));
            directions.add(new Position(x - ((flg + 1) % 2), y + 1));
            directions.add(new Position(x + (flg % 2), y + 1));
            directions.add(new Position(x - ((flg + 1) % 2), y - 1));
            directions.add(new Position(x + (flg % 2), y - 1));
            double distance = 10000;
            for (Position direction : directions) {
                if (direction.X >= 0 && direction.X < 10 && direction.Y >= 0 && direction.Y < 10) {
                    if (distance > calculateDistance(direction, destination)) {
                        distance = calculateDistance(direction, destination);
                        xAns = direction.X;
                        yAns = direction.Y;
                    }
                }
            }
            return new Position(xAns - x, yAns - y);
        }

        public void calculateShortestWay(Position current, Position destination) {
            if (current.X == destination.X && current.Y == destination.Y) {
                return;
            }
            Position direction = getDirection(current, destination, current.Y);
            Position newLocation = new Position(current.X + direction.X, current.Y + direction.Y);
            this.moves.add(newLocation);
            calculateShortestWay(newLocation, destination);

        }

        public ArrayList<Position> getMoves() {
            return moves;
        }
    }
