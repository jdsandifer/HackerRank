# Hello World 
my_string = "Hello, World!"
print(my_string)


# Read input from STDIN. Print output to STDOUT
input = raw_input()
print(input)


# Print "Weird" or "Not Weird" based on input.
import sys

N = int(raw_input().strip())

if N % 2 == 1:
    print("Weird")
elif N >= 2 and N <= 5:
    print("Not Weird")
elif N >= 6 and N <= 20:
    print("Weird")
elif N > 20:
    print("Not Weird")


# Print addition, subtraction, and multiplication of inputs.
a = int(raw_input())
b = int(raw_input())

print(a + b)
print(a - b)
print(a * b)


# Divide first input by second: first with integer division, then normal.
from __future__ import division

a = int(raw_input())
b = int(raw_input())

print a // b
print a / b


# Use a for loop to print squares of natural numbers up to input. 
n = int(raw_input())
for i in range(0, n):
    print i**2


# Create a function is_leap to determine if a given year is a leap year.
def is_leap(year):
    leap = False
    
    if year % 4 == 0:
        leap = True
    if year % 100 == 0:
        leap = False
    if year % 400 == 0:
        leap = True
        
    return leap


# Print "123...N" where N is the input integer.
from __future__ import print_function
    
map(lambda x: print(x + 1, end=''), range(0, int(raw_input())))