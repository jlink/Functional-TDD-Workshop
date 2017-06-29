# pure-java-scoreboard

## Scoreboard

The example code implements a simple scoreboard to display the score of any
point-based game between two teams/players (e.g. Basketball).

The MVP consists of a simple command line UI using the following commands:
- `a` and `b` for team selection
- '+' and '-' to increase or decrease the score of the selected team
- 'r' to reset the score to 000:000
- 'x' to exit the game
- Every command must be followed by pressing `Return`
- Unknown commands are ignored

Forked from https://github.com/jlink/functional-tdd

### State

* selected team (a,b)
* score of team a (int)
* score of team b (int)
* cancellation

### I/O

* read line from console
  * read character (+,-,a,b,r,x)
  * read return (enter)
* write line to console
  * "Scoreboard started"
  * "Scoreboard ended"
  * "Team A selected"
  * "Team B selected"
  * "001:003" (%03d:%03d)

