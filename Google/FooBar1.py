# Solar Doomsday

# Who would've guessed? Doomsday devices take a LOT of power. 
# Commander Lambda wants to supplement the LAMBCHOP's quantum antimatter reactor core with solar arrays, 
# and she's tasked you with setting up the solar panels. 

# Due to the nature of the space station's outer paneling, all of its solar panels must be squares. 
# Fortunately, you have one very large and flat area of solar material, a pair of industrial-strength scissors, 
# and enough MegaCorp Solar Tape(TM) to piece together any excess panel material into more squares. 
# For example, if you had a total area of 12 square yards of solar material, 
# you would be able to make one 3x3 square panel (with a total area of 9). That would leave 3 square yards, 
# so you can turn those into three 1x1 square solar panels.

import math


def solution(area):
    number = int(math.sqrt(area))
    ans = []
    if number > 0:
        ans.append(number)
        ans.extend(solution(area - (number * number)))
    
    return ans

print(solution(15324))
