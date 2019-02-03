/** Return a list like the given list filtered to only include values less than a specified value. */
def allLessThan(delim: Int, arr: List[Int]): List[Int] = arr.filter(_ < delim)


/** Return a new list with elements at odd positions removed. (First index is 1.) */
def oddIndexesRemoved(arr: List[Int]): List[Int] = 
    arr.zipWithIndex.filterNot((t:Tuple2[Int, Int]) => (t._2 % 2 == 0)).unzip._1

/** Return the sum of odd elements in a list. */
def sumOfOddElements(numbers: List[Int]):Int = numbers.filter(_ % 2 != 0).foldLeft(0)(_ + _)
