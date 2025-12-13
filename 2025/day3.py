FILENAME = input("Insert input filename (*.txt): " )
file = open(FILENAME)

def partOne(file):
    jolts = []
    
    for line in file:
        max = float("-inf")
        maxJolts=[]
        for i in range(len(line)):
            for j in range(i+1,len(line)):
                maxJoltTry= line[i]+line[j]
                if float(maxJoltTry) > float(max):
                    max = maxJoltTry
            maxJolts.append(max)
            maxJolts.sort(reverse=True)
        
        for i in maxJolts:
            if i in jolts:
                continue
            else:
                jolts.append(int(i))
                break
    return sum(jolts)
        
print(f"Part1: {partOne(file)}")

file = open(FILENAME)
def partTwo(file):
    MAXBATTERIES = 12
    total = 0
    for line in file:
        missingBatteries = MAXBATTERIES
        sequencePosition = 0
        batteries = [int(i)for i in line.strip()]
        maxJolts =[]
        
        while missingBatteries > 0:
            limitOfBatteriesToCheck = len(batteries) - missingBatteries
    
            if limitOfBatteriesToCheck < sequencePosition:
                limitOfBatteriesToCheck = sequencePosition

            max = -1
            indexMaxBattery = sequencePosition

            for i in range(sequencePosition,limitOfBatteriesToCheck + 1):
                if batteries[i] > max:
                    max = batteries[i]
                    indexMaxBattery = i

            maxJolts.append(max)

            sequencePosition = indexMaxBattery +1
            missingBatteries -=1
        num_final = int(''.join(str(d) for d in maxJolts))
        total +=num_final
    return total

print(f"Part2: {partTwo(file)}")
            
            
                 


    