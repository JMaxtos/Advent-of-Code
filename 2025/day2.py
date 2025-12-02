
FILENAME = input("Insert name File (.txt): ")
file = open(FILENAME)


def partOne(file):
    invalidIDs = 0
    idRanges = []
    for line in file:
        values = line.split(',')
    
   
    for value in values:
        min,max = value.split('-')
        idRanges.append((int(min),int(max)))

    for min,max in idRanges:
        for number in range(min,max+1):
            number = str(number)
            if len(number) % 2 !=0:
                continue
            half = len(number)//2
            
            if number[half:] == number[:half]:
                invalidIDs+=int(number)
    return invalidIDs


            
print(f"Part One Result: {partOne(file)}")
