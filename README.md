# memory-game-epsonavy
memory-game-epsonavy created by GitHub Classroom

Author: Pei Lian Liu

RULES of the GAME:

1. The user is shown 20 tiles. Hidden below these tiles are 10 random images (use your own) each repeated twice. 

2. The user can touch on any two tiles. Touching on a tile will show the image.

3. If the two tiles have matching images, they disappear (Use a check or something to indicate it's already matched). The user gets a point. 

4. If the two tiles do NOT have matching images, they flip over to being tiles again (flip animation not required).

5. Hitting the back soft key while playing will take the user back to the first screen (happens automatically). Trying to play should restore the playing activity to the previous state (may need some state handling). That is, if I hit back after matching say 10 tiles, and return to playing, it should show me the remaining 10 cards to match. 

The points on the bottom of the screen is updated after every round. 

BONUS POINTS:

Ask if they want to resume or restart if a play is already in progress. Handle the user response appropriately.
