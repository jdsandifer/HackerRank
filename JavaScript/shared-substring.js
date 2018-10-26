// This challenge required comparing two strings to see if
// they share any substrings. Because substrings can be
// single letters in this challenge, it was simply a task of
// figuring out if they share any letters in a performant manner.

// I created an object with properties that are letters from the 
// first string and then visited each letter in the second string to
// see if any of those matched. The object functions like a hashmap
// (specific implementation varies by browser vendor and size of string) 
// to allow checks for matching letters to be O(1). This makes total time 
// complexity O(n + m) where n is the length of the first string and m
// is the length of the second. Space complexity is O(n) and could be
// further optimized by comparing the length of the strings first and
// using the shortest string to create the map object.


function twoStrings(first, second) {
    // Create an object with properties of letters in the first string
    const firstLetters = first.split('')
    let firstLettersMap = {}
    for (let l of firstLetters) {
        firstLettersMap[l] = true
    }

    // See if any letters in second string are in the letter map object
    // If one is, the strings share a substring (of one letter)
    const shareSubstringMsg = 'YES'
    for (let l of second) {
        if (firstLettersMap[l]) {
            return shareSubstringMsg
        }
    }
    
    // If they don't share any letters, they don't have a shared substring
    const dontShareSubstringMsg = 'NO'
    return dontShareSubstringMsg
}
