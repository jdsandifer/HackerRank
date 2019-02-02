/** Return a list like the given list filtered to only include values less than a specified value. */
def chooseLessThan(delim: Int, arr: List[Int]): List[Int] = arr.filter(_ < delim)


/** Return a new list with elements at odd positions removed. (First index is 1.) */
def withoutOddElements(arr: List[Int]): List[Int] = 
    arr.zipWithIndex.filterNot((t:Tuple2[Int, Int]) => (t._2 % 2 == 0)).unzip._1
