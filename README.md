# Final-Project
Super Rectangle Adventure (name in-progress and subject to change)
Goeun Youn and William Gadd

Description:
	
A long time ago (or perhaps far in the future) a small tribe of rectangles lived in a village full of peace and harmony. However, this beautiful picture of tranquillity came at a price. Many years ago the village was not the sight it was today. It was plagued with criminal rectangles, ugly rectangles, stupid rectangles, and useless lazy millennial rectangles. One fateful day, the smartest and most beautiful rectangles of the all gathered to decide what to do about the state of the village, and at that moment, after much debate, a solution was decided upon. Only the strongest, bravest, smartest, and most handsome of all the rectangles were to remain in the village after they came of age (12 minutes old), but if somehow a rectangle failed to meet these high standards, they could take part in a ritual to prove themselves as worthy of living in the village. All of the stupid and ugly rectangles of the past have failed this trial, and to this day none have been successful. You play a small ugly rectangle named [INSERT NAME HERE] who is about to turn 12 minutes old. The rectangle has trained its entire life for this moment, and is determined to be the first ugly rectangle to complete the trial and prove its worth. So basically this is a 2D semi-randomly generated platformer with deep lore. 

Instructions:

When the game launched players will have the option of viewing the controls (Shown on keyboard and gamepad in case using joytokey), and beginning the trial. On the left hand side of the screen there is a box with the rectangle character in it, and on the right another box. The middle of the screen is a platforming level with maze-like qualities that is randomly selected from a list of pre-made levels. The player must get to the other side before time runs out, while utilising wall jumps, crouching, and avoiding spikes. If the player reaches the other side of the screen, a new middle section is randomly selected from the list of pre made levels, and the time limit is decreased. The levels are made so that they can be solved from right to left or from left to right. The goal is to make it through as many levels as possible, and the player fails once a level isn’t completed within the time limit. Hitting spikes will send the player back to the side they started on. It is designed to be endless, so no wonder no one has ever beaten it.

Features list:
Must-Haves:

-Player character must have solid physics and collision detection, and be able to
-jump
-crouch(move slower but is shorter, changes collision detection)
-Wall jump(If jumps while not touching ground and touching  wall, send at set angle and 
momentum away from wall)
-Sprint(increase movement speed and speed in the air)
-Must have a solid number of pre made levels that can be completed from both directions
-Must be able to randomly select pre-made level.
-must be a timer that gets progressively more demanding
-score counter(how many levels you’ve completed)
-Touching spikes must send player back to the side they started on

Reach:

-player character can “attack”(Puts out hit box in front of player that destroys enemies)
-moving enemy rectangles that have the same effect as spikes but can be destroyed by 
player attack
-Different tiers of pre made levels (easy, medium, and hard levels)
-levels get progressively more challenging as player completes more levels
-high score screen that can be saved between games
-player rectangle wears a sweet bandana 


Class list:

-Main: contains main method, creates a new game
-GamePanel: holds all panels within the game (Extends JFrame)
-MovingImage: superclass for Player and Enemy
-Level: creates a new “middle part”
-LevelList: creates an arraylist of levels in a random order.
-SafeSquare: creates a square that can be either the endpoint or starting point
-ScoreCounter: keeps track of the score.
-Player: creates the player character with collision detection and physics and extends 
MovingImage.
-Spikes: creates a spike that can be placed on walls, ceilings, and floors
-Timer: player fails when it reaches 0 and the time gets shorter for every level player completed.
-(REACH) Enemy: creates enemy object

Responsibilities list:
William : Level, Player, Spikes, SafeSquare, Enemy.
Goeun : Main, GamePanel, MovingImage, LevelList(might not need), ScoreCounter, drawing surface


