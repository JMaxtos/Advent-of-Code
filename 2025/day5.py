FILENAME = input("Insert input filename (*.txt): " )
VALUES_FILENAME = input("Insert test values (*.txt): ")

def readFiles():
    fileLines  = []
    fileTestValues =[]
    file = open(FILENAME)
    valuesFile = open(VALUES_FILENAME)
    for line in file:
        interval = line.split('-')
        fileLines.append((interval[0].strip(),interval[1].strip()))
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



print(f"Part One : {partOne()}")
    
