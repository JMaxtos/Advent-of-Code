FILENAME = input("Insert input filename (*.txt): " )
VALUES_FILENAME = input("Insert test values (*.txt): ")

def readFiles():
    fileLines  = []
    fileTestValues =[]
    file = open(FILENAME)
    valuesFile = open(VALUES_FILENAME)
    for line in file:
        interval = line.split('-')
        fileLines.append((int(interval[0]),int(interval[1].strip())))
    for line in valuesFile:
        fileTestValues.append(line.strip())
    return fileLines, fileTestValues

def partOne():
    fileLines, fileTestValues = readFiles()
    freshIDs = 0
    for value in fileTestValues:
        for interval in fileLines: 
            if isFresh(interval[0],interval[1],value):
                freshIDs +=1
                break
    return freshIDs
def isFresh(min,max,value):
    return int(min) <=  int(value) <= int(max) 

def partTwo():
    fileLines, _ = readFiles()
    fileLines.sort(key=lambda x: x[0])

    merged = []
    for interval in fileLines:
        if not merged:
            merged.append([interval[0],interval[1]])
        else:
            last_min,last_max = merged[-1]
            if interval[0] <= last_max +1:
                merged[-1][1]= max(last_max,interval[1])
            else:
                merged.append([interval[0],interval[1]])
    freshIds =sum(max-min + 1 for min,max in merged )
    return freshIds
    



print(f"Part One : {partOne()}")
print(f"Part Two : {partTwo()}")
    
