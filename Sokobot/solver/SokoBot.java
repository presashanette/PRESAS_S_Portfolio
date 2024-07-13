package solver;

import java.util.*;

public class SokoBot {

  public String solveSokobanPuzzle(int width, int height, char[][] mapData, char[][] itemsData) {
    /*
     * YOU NEED TO REWRITE THE IMPLEMENTATION OF THIS METHOD TO MAKE THE BOT SMARTER
     */
    PriorityQueue<State> frontier = new PriorityQueue<>(Comparator.comparing(State::getPrioVal));
    Set<String> exploredStr = new HashSet<>();
    //max time
    int maxtimeout = 14900;
    long startTime = System.currentTimeMillis();

    // Create the initial state
    completeMap(width, height, mapData, itemsData);
    State initialState = new State(width, height, itemsData);
    frontier.add(initialState);
    State currentState = initialState;

    while (!frontier.isEmpty()) {
      // pop lowest cost
      currentState = frontier.poll();
      String currentStateStr = currentState.getStrMap().toString();

      // Check for time limit
      long currentTime = System.currentTimeMillis();
      // Return dumb solution
      if (currentTime - startTime >= maxtimeout) {
        return currentState.getMoves();
      }

      // Check if all crates are on targets (goal state)
      if (areCratesOnTargets(width, height, currentState.getCharMap(), mapData)) {
        return currentState.getMoves();
      }

      List<State> nextStates = findNextStates(currentState, mapData, width, height);

      if (!exploredStr.contains(currentStateStr)){
        for (State nextState : nextStates) {
          String nextStateStr = currentState.getStrMap().toString();
          // if not yet explored
          if (!exploredStr.contains(nextStateStr))
            frontier.add(nextState);
        }
        exploredStr.add(currentState.getStrMap().toString());
      }
    }

    return currentState.getMoves();
  }

  private void completeMap (int width, int height, char[][] mapData, char[][] itemsData) {
    for (int i=0; i<height; i++) {
      for (int j=0; j<width; j++) {
        if (mapData[i][j] == '#')
          itemsData[i][j] = '#';
      }
    }
  }

  public List<State> findNextStates(State current, char[][] mapData, int width, int height) {
    /*
    # - wall
    @ - player
    $ - box
    . - target
    + - player on goal
    * - box on goal
     */

    List<State> nextStates = new ArrayList<>();
    char[][] currentMap = current.getCharMap();
    int x = 0;
    int y = 0;

    // find player
    boolean found = false;
    for (y=0; y<height; y++) {
      for (x=0; x<width; x++) {
        if (currentMap[y][x] == '@') {
          found = true;
          break;
        }
      }
      if (found)
        break;
    }

    //down
    if (y+1 <= height) {
      if (currentMap[y+1][x] == ' ') {
        currentMap[y][x]=' ';
        currentMap[y+1][x] = '@';
        State potential = new State(width, height, current.getMovesSB(), current.getCharMap(), mapData);
        potential.addMoves('d'); //string
        nextStates.add(potential);
        currentMap[y][x]='@';
        currentMap[y+1][x] = ' ';
      }

      else {
        boolean pushCrate = false;
        if (currentMap[y+1][x] == '$' && y+2 <= height)
          if (currentMap[y+2][x] == ' ') {
            if (mapData[y+2][x] == '.') {
              pushCrate = true;
            }
            else if (y+3 <= height)
              if (!(currentMap[y+3][x] == '#' && (currentMap[y+2][x+1] == '#' || currentMap[y+2][x-1] == '#'))) {
                pushCrate = true;
              }
          }

        if (pushCrate) {
          currentMap[y][x]=' ';
          currentMap[y+1][x] = '@';
          currentMap[y+2][x] = '$';
          State potential = new State(width, height, current.getMovesSB(), current.getCharMap(), mapData);
          potential.addMoves('d'); //string
          nextStates.add(potential);
          currentMap[y][x]='@';
          currentMap[y+1][x] = '$';
          currentMap[y+2][x] = ' ';
        }
      }
    }

    //up
    if (y-1>=0) {
      if (currentMap[y-1][x] == ' ') {
        currentMap[y][x]=' ';
        currentMap[y-1][x] = '@';
        State potential = new State(width, height, current.getMovesSB(), current.getCharMap(), mapData);
        potential.addMoves('u'); //string
        nextStates.add(potential);
        currentMap[y][x]='@';
        currentMap[y-1][x] = ' ';
      }

      else {
        boolean pushCrate = false;
        if (currentMap[y-1][x] == '$'  && y-2 >= 0)
          if (currentMap[y-2][x] == ' ') {
            if (mapData[y-2][x] == '.') {
              pushCrate = true;
            }
            else if (y-3 >= 0)
              if (!(currentMap[y-3][x] == '#' && (currentMap[y-2][x+1] == '#' || currentMap[y-2][x-1] == '#'))) {
                pushCrate = true;
              }
          }

        if (pushCrate) {
          currentMap[y][x]=' ';
          currentMap[y-1][x] = '@';
          currentMap[y-2][x] = '$';
          State potential = new State(width, height, current.getMovesSB(), current.getCharMap(), mapData);
          potential.addMoves('u'); //string
          nextStates.add(potential);
          currentMap[y][x]='@';
          currentMap[y-1][x] = '$';
          currentMap[y-2][x] = ' ';
        }
      }
    }

    //left
    if (x-1>=0) {
      if (currentMap[y][x-1] == ' ') {
        currentMap[y][x]=' ';
        currentMap[y][x-1] = '@';
        State potential = new State(width, height, current.getMovesSB(), current.getCharMap(), mapData);
        potential.addMoves('l'); //string
        nextStates.add(potential);
        currentMap[y][x]='@';
        currentMap[y][x-1] = ' ';
      }

      else {
        boolean pushCrate = false;
        if (currentMap[y][x-1] == '$'  && x-2 >= 0)
          if (currentMap[y][x-2] == ' ') {
            if (mapData[y][x-2] == '.') {
              pushCrate = true;
            }
            else if (x-3 >= 0)
              if (!(currentMap[y][x-3] == '#' && (currentMap[y+1][x-2] == '#' || currentMap[y-1][x-2] == '#'))) {
                pushCrate = true;
              }
          }

        if (pushCrate) {
          currentMap[y][x]=' ';
          currentMap[y][x-1] = '@';
          currentMap[y][x-2] = '$';
          State potential = new State(width, height, current.getMovesSB(), current.getCharMap(), mapData);
          potential.addMoves('l'); //string
          nextStates.add(potential);
          currentMap[y][x]='@';
          currentMap[y][x-1] = '$';
          currentMap[y][x-2] = ' ';
        }
      }
    }

    //right
    if (x+1 <= width) {
      if (currentMap[y][x+1] == ' ') {
        currentMap[y][x]=' ';
        currentMap[y][x+1] = '@';
        State potential = new State(width, height, current.getMovesSB(), current.getCharMap(), mapData);
        potential.addMoves('r'); //string
        nextStates.add(potential);
        currentMap[y][x]='@';
        currentMap[y][x+1] = ' ';
      }

      else {
        boolean pushCrate = false;
        if (currentMap[y][x+1] == '$'  && x+2 <= width)
          if (currentMap[y][x+2] == ' ') {
            if (mapData[y][x+2] == '.') {
              pushCrate = true;
            }
            else if (x+3 <= width)
              if (!(currentMap[y][x+3] == '#' && (currentMap[y+1][x+2] == '#' || currentMap[y-1][x+2] == '#'))) {
                pushCrate = true;
              }
          }

        if (pushCrate) {
          currentMap[y][x]=' ';
          currentMap[y][x+1] = '@';
          currentMap[y][x+2] = '$';
          State potential = new State(width, height, current.getMovesSB(), current.getCharMap(), mapData);
          potential.addMoves('r'); //string
          nextStates.add(potential);
          currentMap[y][x]='@';
          currentMap[y][x+1] = '$';
          currentMap[y][x+2] = ' ';
        }
      }
    }

    return nextStates;
  }


  public boolean areCratesOnTargets(int width, int height, char[][] itemsData, char[][] mapData){
    for (int i=0; i<height; i++) {
      for (int j=0; j<width; j++) {
        if (mapData[i][j] == '.')
          if (itemsData[i][j] != '$')
            return false;
      }
    }

    return true;
  }

}