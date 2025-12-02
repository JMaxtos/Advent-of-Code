INITIAL_POITING = 50
MAX_POINTING = 99
MIN_POITING = 0



FILENAME = input("Insert input filename (*.txt): " )
file = open(FILENAME)

def partOne(file):
    password = 0
    currentPoiting=INITIAL_POITING

    for line in file:
        direction = line[0]
        numRotations = int(line[1:])

        if direction == 'L':
            currentPoiting = (currentPoiting - numRotations) % 100
        
        if direction == 'R':
            currentPoiting = (currentPoiting + numRotations)%100
        
        if currentPoiting == MIN_POITING :
            password+=1

    print(f"Password:{password}")

#partOne(file)


def partTwo(file):
    password = 0

    currentPoiting=INITIAL_POITING

    for line in file:
        direction = line[0]
        numRotations = int(line[1:])
        
        for _ in range(numRotations):
            if direction == 'L':
                currentPoiting = (currentPoiting-1) % 100
            elif direction == 'R':
                currentPoiting = (currentPoiting + 1) % 100

            if currentPoiting == MIN_POITING:
                password+=1
    print(f"Password:{password}")

     

partTwo(file)