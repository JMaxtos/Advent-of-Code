FILENAME = input("Insert input filename (*.txt): " )


def partOne():
    file = open(FILENAME)
    totalRolls = 0
    fileContent = {}
    for line,content in enumerate(file):
        fileContent[line]=content
    
    for line_index, line_content in fileContent.items():
        for column_index,char in enumerate(line_content):
            if char == '@':
                if checkAdjacentPositions(line_index,column_index,fileContent):
                    totalRolls +=1
    return totalRolls

def checkAdjacentPositions(line,column,fileContent):
    adjacentRolls = 0
    ADJACENT_POSITIONS = [(-1,-1),(-1,0),(-1,+1),(0,-1),(0,+1),(+1,-1),(+1,0),(+1,+1)]

    for position in ADJACENT_POSITIONS:
        new_line = line + position [0]
        new_column = column + position[1]

        if new_line < 0 or new_line >= len(fileContent):
            continue

        elif new_column < 0 or new_column >= len(fileContent[new_line]):
            continue
        
        if fileContent[new_line][new_column] == '@':
            adjacentRolls +=1
    return adjacentRolls < 4

    
print(f"Part One: {partOne()}")
