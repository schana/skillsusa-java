# SkillsUSA Programming Contest - Java edition

This repository houses the code for contestants to build their own Snake AI.

## Game Rules

This game of snake takes place on a fixed game board. The snake can move in any
direction, but will die if it touches a wall or itself. If it touches a piece
of food, its length will increase by one.

Each game is limited to 1000 moves.

## Game Board

Our game board is a 10x10 grid referenced by a (row, column) tuple. This is
represented by the Cell object in the code. Notice the indexing starts at zero in the
upper left corner. The directions the snake can move are in relation to this
board.

|   |   |   |   |   |   |   |   |   |   |
|---|---|---|---|---|---|---|---|---|---|
|(0,0)|(0,1)|(0,2)|(0,3)|(0,4)|(0,5)|(0,6)|(0,7)|(0,8)|(0,9)|
|(1,0)|(1,1)|(1,2)|(1,3)|(1,4)|(1,5)|(1,6)|(1,7)|(1,8)|(1,9)|
|(2,0)|(2,1)|(2,2)|(2,3)|(2,4)|(2,5)|(2,6)|(2,7)|(2,8)|(2,9)|
|(3,0)|(3,1)|(3,2)|(3,3)|(3,4)|(3,5)|(3,6)|(3,7)|(3,8)|(3,9)|
|(4,0)|(4,1)|(4,2)|(4,3)|(4,4)|(4,5)|(4,6)|(4,7)|(4,8)|(4,9)|
|(5,0)|(5,1)|(5,2)|(5,3)|(5,4)|(5,5)|(5,6)|(5,7)|(5,8)|(5,9)|
|(6,0)|(6,1)|(6,2)|(6,3)|(6,4)|(6,5)|(6,6)|(6,7)|(6,8)|(6,9)|
|(7,0)|(7,1)|(7,2)|(7,3)|(7,4)|(7,5)|(7,6)|(7,7)|(7,8)|(7,9)|
|(8,0)|(8,1)|(8,2)|(8,3)|(8,4)|(8,5)|(8,6)|(8,7)|(8,8)|(8,9)|
|(9,0)|(9,1)|(9,2)|(9,3)|(9,4)|(9,5)|(9,6)|(9,7)|(9,8)|(9,9)|

## Scoring

Your snake will be scored on how many pieces of food it eats in the allotted
time. It will be run a million times using randomly generated starting and food
locations. The highest average score will be the winner, with ties decided by
having the lower average age.

## Getting Started

Your goal is to implement the `getNextDirection()` function in MyMover.java.
`MyMover` extends `SnakeMover`, which provides the basic blueprint to follow.
`MyMover` has access to a `Board`, which contains all the relevant state of the
game. The `exmples` package has some completed solvers for inspiration.

## Moving algorithms

There are many different correct approaches you can take to solve the task.
Here are some additional options:

### Hamilton

### Greedy

### A* search
