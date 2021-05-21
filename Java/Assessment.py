# Given a list of clothing items cost as list and the budget allowed
# Find the total number of combination where we select 1 item from all list that satifies the budget constraint
def shoppingOptions(jeans, shoes, skirts, tops, dollars):
    allList = [jeans, shoes, skirts, tops]
    return recursive(allList, 0, dollars, 0)

def recursive(allList, x, dollars, count):
    if x == len(allList) or dollars < 0: return count
    for i in allList[x]:
        if x == len(allList) - 1:
            if dollars == i:
                count += 1
        else:
            count = recursive(allList, x + 1, dollars - i, count)
    return count


print(shoppingOptions([2, 3], [4], [2, 3], [1, 2], 10)) # 3

