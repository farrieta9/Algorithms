def bucket_sort(A):
    """
    A bucket is kinda like a 2D array where each row could have a different number of columns
    :param A: type(list)
    :return:
    """

    if not isinstance(A, list):
        return

    bucket = []  # create an empty bucket

    # initialize the bucket
    for i in range(0, len(A)):
        bucket.append([])

    for i in range(0, len(A)):
        index = int(len(A) * A[i])
        bucket[index].append(A[i])

    # Sort individual buckets. This could be replaced with a custom sort function
    for i in range(0, len(A)):
        bucket[i].sort()

    # Transfer bucket back into the array
    index = 0
    for i in range(0, len(A)):
        for j in range(0, len(bucket[i])):
            A[index] = bucket[i][j]
            index += 1

    print bucket
    print A #  <- Final solution

arr = [0.897, 0.565, 0.656, 0.1234, 0.665, 0.3434, 0.1113]
bucket_sort(arr)

