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


# Read a tuple with n elements (integers) from STDIN.
# Print the hash for the tuple to STDOUT.
n = int(raw_input()) # n is not actually needed...

inputList = map(int, raw_input().split())
inputTuple = tuple(inputList)
print(hash(inputTuple))


# Read xMax, yMax, zMax, and n from STDIN.
# Print all possible values of x, y, and z (from 0 to *Max) 
# where there sum is not n to STDOUT.
xMax = int(raw_input())
yMax = int(raw_input())
zMax = int(raw_input())
n = int(raw_input())

print [[x, y, z] for x in range(0, xMax+1) 
                 for y in range(0, yMax+1) 
                 for z in range(0, zMax+1) 
                 if x + y + z != n]


# Read n followed by n integers from input from STDIN.
# Print the value of the second largest number to STDOUT
n = int(raw_input())
numbers = map(int, raw_input().split())

numbers.sort()
numbers.reverse()
print max([num for num in numbers if num != numbers[0]])


# Read n student names and their grades from STDIN.
# Print then name(s) of the student(s) with the second lowest grade to STDOUT.
from __future__ import print_function

n = int(raw_input())
students_and_grades = []

for i in range(0,n):
    student = raw_input(), float(raw_input())
    students_and_grades.append(student)
    
grades = [g for s, g in students_and_grades]
grades.sort()
second_lowest_grade = min([g for g in grades if g != grades[0]])

secound_lowest_students = [s for s, g in students_and_grades 
                             if g == second_lowest_grade]
secound_lowest_students.sort()

map(print, secound_lowest_students)


