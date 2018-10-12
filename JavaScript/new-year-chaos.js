/* People are lined up for a roller coaster and some are bribing the person
 * ahead of them to allow them to move up in line. Assume no one bribes more
 * than two people and people only bribe to swap spots with the person in front of 
 * them. Given an array of numbers representing people's initial positions arranged
 * in their final order, display the minimum number of bribes needed to achieve the
 * current arrangement. Display "Too chaotic" if the arrnangement given is impossible.
 */

// Complete the minimumBribes function below.
function minimumBribes(finalPositions) {
    const impossibleMessage = "Too chaotic"
    
    const minimumBribes = finalPositions.map(minimumBribeFromFinalPosition)
    if (minimumBribes.some(moreThanTwo)) {
        display(impossibleMessage)
    } else {
        const numberOvertakingEach = finalPositions.map(numberOvertaking)
        const totalBribesNeeded = sum(numberOvertakingEach)
        display(totalBribesNeeded)
    }
}

function minimumBribeFromFinalPosition(initialPosition, currentIndex) {
    const currentPosition = currentIndex + 1
    const spacesMovedForward = initialPosition - currentPosition
    const minimumBribes = spacesMovedForward >= 0 ? spacesMovedForward : 0
    return minimumBribes
}

function moreThanTwo(num) {
    return num > 2
}

function numberOvertaking(initialPosition, index, finalPositions) {
    const position = index + 1
    let otherPosition
    // first bribe = original position of overtaken, second bribe = one ahead
    const positionOfFirstPossibleOvertaker = Math.max(initialPosition - 1, 1)
    const indexOfFirstPossibleOvertaker = positionOfFirstPossibleOvertaker - 1
    
    const possibleOvertakers = finalPositions.slice(indexOfFirstPossibleOvertaker, index)
    const didOvertakeCurrent = (otherInitialPosition, otherIndex) => 
            didOvertake(initialPosition, position, otherInitialPosition, otherPosition = otherIndex + 1)
    
    const numberOvertaking = possibleOvertakers.filter(didOvertakeCurrent).length
    return numberOvertaking
}

function didOvertake(initialPosition, position, otherInitialPosition, otherPosition) {
    const wasBehind = otherInitialPosition > initialPosition
    const isAhead = otherPosition < position
    return wasBehind && isAhead
}

function sum(numbers) {
    return numbers.reduce((acc, num) => num + acc, 0)
}

function display(item) {
    console.log(item)
}
