"""
Given an array of integers. find the equilibrium index of the array.
An equilibrium index is an index within the array such that the sum of elements of lower
indices is the same as the sum of the elements in the higher indicies.
Example:
    Given [-1, 3, -4, 5, 1, -6, 2, 1]
    equilibrium index = 1, 3, 7
    A[0] = A[2] + A[3] + A[4] + A[5] + A[6] + A[7] = -1
    A[0] + A[1] + A[2] = A[4] + A[5] + A[6] + A[7] = -2
"""


def solution(A):
    for i in range(len(A)):
        leftSum = 0
        rightSum = 0

        for j in range(0, i):  # Calculate left sum
            leftSum += A[j]

        for j in range(i + 1, len(A)):  # Calculate right sum
            rightSum += A[j]

        if leftSum == rightSum:
            print i


A = [-1, 3, -4, 5, 1, -6, 2, 1]
solution(A)
