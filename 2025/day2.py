

def partOne(file):
    invalidIDs = 0
    idRanges = []
    values = []
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


            


def partTwo(file):
    invalidIDs = 0
    idRanges = []
    values = []
    for line in file:
        values = line.split(',')

    for value in values:
        min,max = value.split('-')
        idRanges.append((int(min),int(max)))
        
    
    for min,max in idRanges:
        for number in range(min,max+1):
            numberString = str(number)
            for size in range(1,len(numberString)):
                if len(numberString)%size != 0:
                    continue
                numSequenceRepeats = len(numberString)//size
                if numSequenceRepeats < 2:
                    continue
                sequenceBaseNumber = numberString[:size]
                if sequenceBaseNumber * numSequenceRepeats == numberString:
                    invalidIDs += number
                    break

           
    return invalidIDs

FILENAME = input("Insert name File (.txt): ")
file = open(FILENAME)

print(f"Part One Result: {partOne(file)}")
file = open(FILENAME)
print(f"Part Two Result: {partTwo(file)}")