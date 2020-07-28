# Power Hungry

# Commander Lambda's space station is HUGE. And huge space stations take a LOT of power.
# Huge space stations with doomsday devices take even more power. To help meet the station's power needs,
# Commander Lambda has installed solar panels on the station's outer surface. 
# But the station sits in the middle of a quasar quantum flux field, which wreaks havoc on the solar panels.
# You and your team of henchmen have been assigned to repair the solar panels, but you'd rather 
# not take down all of the panels at once if you can help it, since they do help power the space station and all!

# You need to figure out which sets of panels in any given array you can take offline to repair 
# while still maintaining the maximum amount of power output per array, and to do THAT, 
# you'll first need to figure out what the maximum output of each array actually is. 
# Write a function solution(xs) that takes a list of integers representing the power output 
# levels of each panel in an array, and returns the maximum product of some non-empty subset of those numbers. 
# So for example, if an array contained panels with power output levels of [2, -3, 1, 0, -5], 
# then the maximum product would be found by taking the subset: xs[0] = 2, xs[1] = -3, xs[4] = -5,
#  giving the product 2*(-3)*(-5) = 30.  So solution([2,-3,1,0,-5]) will be "30".


# def solution(xs):
#     ans = 1
#     minNeg = -1000 # Since it is given this is the maximum absolute value
#     for i in xs:
#         if i != 0:
#             ans *= i
#             if minNeg < i and i < 0:
#                 minNeg = i

#     if ans < 0:
#         ans /= minNeg

#     return str(int(ans))

def solution(xs):
    if len(xs) == 0:
        return 0
    max_so_far = xs[0]
    min_so_far = xs[0]
    result = max_so_far
    for i in range(1, len(xs)):
        curr = xs[i]
        temp_max = max(curr, max_so_far * curr, min_so_far * curr, max_so_far)
        min_so_far = min(curr, max_so_far * curr, min_so_far * curr, min_so_far)
        max_so_far = temp_max
        result = max(max_so_far, result)
    return result

print(solution([-2, -3, 4, -5]))
