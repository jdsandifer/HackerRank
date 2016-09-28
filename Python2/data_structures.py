# Read list commands from STDIN and perform them on a list.
n = int(raw_input())
command = []
theList = []

for i in range(0, n):
    command = raw_input().split()
    if command[0] == "insert":
        theList.insert(int(command[1]), int(command[2]))
    elif command[0] == "print":
        print(theList)
    elif command[0] == "remove":
        theList.remove(int(command[1]))
    elif command[0] == "append":
        theList.append(int(command[1]))
    elif command[0] == "sort":
        theList.sort()
    elif command[0] == "pop":
        theList.pop()
    elif command[0] == "reverse":
        theList.reverse()