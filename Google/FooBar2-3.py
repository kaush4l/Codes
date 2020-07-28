# def solution(pegs):
#     # Your code here
#     num_pegs = len(pegs)
#     a = 0
#     b = 0
#     for i in range(num_pegs):
#         if (i % 2) == 0:
#             currCalc = -pegs[i]
#         else:
#             currCalc = pegs[i]
#         if i == 0 or i == num_pegs - 1:
#             a += currCalc
#         else:
#             a += 2 * currCalc
#     if num_pegs % 2 == 0:
#         b = 3
#     else:
#         b = 1
#     if (2*a) / b < 1:
#         return [-1,-1]
#     elif (2*a) % b == 0:
#         return[(2*a) / b, 1]
#     else:
#         return [2*a, b]
from fractions import Fraction


def solution(pegs):
    arrLength = len(pegs)
    if ((not pegs) or arrLength == 1):
        return [-1,-1]

    even = True if (arrLength % 2 == 0) else False
    sum = (- pegs[0] + pegs[arrLength - 1]) if even else (- pegs[0] - pegs[arrLength -1])

    if (arrLength > 2):
        for index in range(1, arrLength-1):
            sum += 2 * (-1)**(index+1) * pegs[index]

    FirstGearRadius = Fraction(2 * (float(sum)/3 if even else sum)).limit_denominator()

    if FirstGearRadius < 2:
        return [-1,-1]

    currentRadius = FirstGearRadius
    for index in range(0, arrLength-2):
        CenterDistance = pegs[index+1] - pegs[index]
        NextRadius = CenterDistance - currentRadius
        if (currentRadius < 1 or NextRadius < 1):
            return [-1,-1]
        else:
            currentRadius = NextRadius

    return [FirstGearRadius.numerator, FirstGearRadius.denominator]

print(solution([4, 30, 50]))
